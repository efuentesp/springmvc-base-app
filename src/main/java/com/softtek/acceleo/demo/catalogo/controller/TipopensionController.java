package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.catalogo.bean.TipopensionBean;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.service.TipopensionService;

@Controller
public class TipopensionController {

	@Autowired
	private TipopensionService tipopensionService;
	
	Tipopension tipopension = new Tipopension();

	@RequestMapping(value = "/tipopension", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Tipopension> getTipopensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Tipopension> listTipopension = null;

		if (query==null && _page == 0) {
       		listTipopension = tipopensionService.listTipopensions(tipopension);
			rows = tipopensionService.getTotalRows();
		} else if (query!= null){
			listTipopension = tipopensionService.listTipopensionsQuery(tipopension, query, _page, 10);
			rows = tipopensionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listTipopension = tipopensionService.listTipopensionsPagination(tipopension, _page, 10);
			rows = tipopensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listTipopension;
	}
	
	@RequestMapping(value = "/tipopension/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Tipopension getTipopension(@PathVariable("id") int id) {
	        
	        tipopension.setTipopensionId(id);
	        
	        Tipopension tipopension = null;
	        tipopension = tipopensionService.getTipopension(id);
			return tipopension;
	 }



	 @RequestMapping(value = "/tipopension", method = RequestMethod.POST)
	    public ResponseEntity<Void> createTipopension(@RequestBody Tipopension tipopension,    UriComponentsBuilder ucBuilder) {
	   
	        tipopensionService.addTipopension(tipopension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/tipopension/{id}").buildAndExpand(tipopension.getTipopensionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/tipopension/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Tipopension> actualizarTipopension(
				@PathVariable("id") int id, 
				@RequestBody Tipopension tipopension) {
	        
	        Tipopension tipopensionFound = tipopensionService.getTipopension(id);
	         
	        if (tipopensionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Tipopension>(HttpStatus.NOT_FOUND);
	        }
	 
			
				tipopensionFound.setClave(tipopension.getClave());
				tipopensionFound.setNombre(tipopension.getNombre());
			
			tipopensionFound.setTipopensionId(tipopension.getTipopensionId());

		    tipopensionService.editTipopension(tipopensionFound);
	        return new ResponseEntity<Tipopension>(tipopensionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/tipopension/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Tipopension> deleteTipopension(@PathVariable("id") int id) {
			 long rows = 0;	
	    	 
	         Tipopension tipopension = tipopensionService.getTipopension(id);
	         if (tipopension == null) {
	             return new ResponseEntity<Tipopension>(HttpStatus.NOT_FOUND);
	         }
	  
             if (rows==0){
	             tipopensionService.deleteTipopension(tipopension);
            	 return new ResponseEntity<Tipopension>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<Tipopension>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveTipopension", method = RequestMethod.POST)
	public @ResponseBody String saveTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {

		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.addTipopension(tipopension);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editTipopension", method = RequestMethod.POST)
	public @ResponseBody String editTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean) {


		Tipopension tipopension = prepareModel(tipopensionBean);
		tipopensionService.editTipopension(tipopension);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchTipopension", method = RequestMethod.GET)
	public ModelAndView addTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Tipopension tipopension = null;
		if (tipopensionBean != null)
			tipopension = prepareModel(tipopensionBean);
		model.put("tipopensions",
				prepareListofBean(tipopensionService.listTipopensions(tipopension)));
		return new ModelAndView("searchTipopension", model);
	}

	@RequestMapping(value = "/deleteTipopension", method = RequestMethod.POST)
	public ModelAndView deleteTipopension(
			@ModelAttribute("command") TipopensionBean tipopensionBean,
			BindingResult result) {
		System.out.println("delete " + tipopensionBean.getTipopensionId());
		tipopensionService.deleteTipopension(prepareModel(tipopensionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tipopension", null);
		model.put("tipopensions",
				prepareListofBean(tipopensionService.listTipopensions(null)));
		return new ModelAndView("searchTipopension", model);
	}

	@RequestMapping(value = "/entryTipopension", method = RequestMethod.GET)
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
			beans = new ArrayList<TipopensionBean>();
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


