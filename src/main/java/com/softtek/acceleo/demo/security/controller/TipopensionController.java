/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Tipopension. 
 */
package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.catalogo.bean.TipopensionBean;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.TipopensionService;

/**
 * Clase TipopensionController
 * @author PSG.
 *
 */
@RestController
public class TipopensionController {
	private static final Logger logger = Logger.getLogger(TipopensionController.class);
	
	@Autowired
	private TipopensionService tipopensionService;

	@RequestMapping(value = "/tipopension", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	public @ResponseBody  List<Tipopension> getTipopensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		Tipopension tipopension = new Tipopension();
		
       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		List<Tipopension> listTipopension = null;

		if (query==null && page == 0) {
       		listTipopension = tipopensionService.listTipopensions(tipopension);
			rows = tipopensionService.getTotalRows();
		} else if (query!= null){
			listTipopension = tipopensionService.listTipopensionsQuery(tipopension, query, page, 10);
			rows = tipopensionService.getTotalRowsSearch(query);
		} else /**if (page != 0)**/{
			listTipopension = tipopensionService.listTipopensionsPagination(tipopension, page, 10);
			rows = tipopensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listTipopension;
	}
	
	@RequestMapping(value = "/tipopension/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	    public @ResponseBody  Tipopension getTipopension(@PathVariable("id") int id) {
	        
	        Tipopension tipopension = null;
	        tipopension = tipopensionService.getTipopension(id);
			return tipopension;
	 }



	 @RequestMapping(value = "/tipopension", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	    public ResponseEntity<Void> createTipopension(@RequestBody Tipopension tipopension,    UriComponentsBuilder ucBuilder) {
	   
	        tipopensionService.addTipopension(tipopension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/tipopension/{id}").buildAndExpand(tipopension.getTipopensionId()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/tipopension/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	    public ResponseEntity<Tipopension> actualizarTipopension(
				@PathVariable("id") int id, 
				@RequestBody Tipopension tipopension) {
	        
	        Tipopension tipopensionFound = tipopensionService.getTipopension(id);
	         
	        if (tipopensionFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
			
				tipopensionFound.setClave(tipopension.getClave());
				tipopensionFound.setNombre(tipopension.getNombre());
			
			tipopensionFound.setTipopensionId(tipopension.getTipopensionId());

		    tipopensionService.editTipopension(tipopensionFound);
	        return new ResponseEntity<>(tipopensionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/tipopension/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	    public ResponseEntity<Tipopension> deleteTipopension(@PathVariable("id") int id) {
	    	 	  
             try{
    	         Tipopension tipopension = tipopensionService.getTipopension(id);
    	         if (tipopension == null) {
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             tipopensionService.deleteTipopension(tipopension);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveTipopension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	public @ResponseBody String saveTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {

		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.addTipopension(tipopension);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editTipopension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	public @ResponseBody String editTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {


		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.editTipopension(tipopension);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchTipopension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	public ModelAndView addTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		Tipopension tipopension = null;
		if (tipopensionBean != null)
			tipopension = prepareModel(tipopensionBean);
		model.put("tipopensions",
				prepareListofBean(tipopensionService.listTipopensions(tipopension)));
		return new ModelAndView("searchTipopension", model);
	}

	@RequestMapping(value = "/entryTipopension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_TIPOPENSIONSEARCH')")
	public ModelAndView entryTipopension() {
		return new ModelAndView("redirect:/searchTipopension");
	}

	private Tipopension prepareModel(TipopensionBean tipopensionBean) {
		Tipopension tipopension = new Tipopension();

		tipopension.setClave(tipopensionBean.getClave());
		tipopension.setNombre(tipopensionBean.getNombre());
		tipopension.setTipopensionId(tipopensionBean.getTipopensionId());
		tipopensionBean.setTipopensionId(null);

		return tipopension;
	}

	private List<TipopensionBean> prepareListofBean(List<Tipopension> tipopensions) {
		List<TipopensionBean> beans = null;
		if (tipopensions != null && !tipopensions.isEmpty()) {
			beans = new ArrayList<>();
			TipopensionBean bean = null;
			for (Tipopension tipopension : tipopensions) {
				bean = new TipopensionBean();

				bean.setClave(tipopension.getClave());
				bean.setNombre(tipopension.getNombre());
				bean.setTipopensionId(tipopension.getTipopensionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


