/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los Solicitudpension. 
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

import com.softtek.acceleo.demo.catalogo.bean.SolicitudpensionBean;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.SolicitudpensionService;

/**
 * Clase SolicitudpensionController.
 * @author PSG.
 *
 */
@RestController
public class SolicitudpensionController {
	private static final Logger logger = Logger.getLogger(SolicitudpensionController.class);
	
	@Autowired
	private SolicitudpensionService solicitudpensionService;
	
	
	@RequestMapping(value = "/solicitudpension", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody  List<Solicitudpension> getSolicitudpensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		Solicitudpension solicitudpension = new Solicitudpension();

       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		List<Solicitudpension> listSolicitudpension = null;

		if (query==null && page == 0) {
       		listSolicitudpension = solicitudpensionService.listSolicitudpensions(solicitudpension);
			rows = solicitudpensionService.getTotalRows();
		} else if (query!= null){
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsQuery(solicitudpension, query, page, 10);
			rows = solicitudpensionService.getTotalRowsSearch(query);
		} else /**if (page != 0)**/{
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsPagination(solicitudpension, page, 10);
			rows = solicitudpensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listSolicitudpension;
	}
	
	@RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.GET, produces = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	    public @ResponseBody  Solicitudpension getSolicitudpension(@PathVariable("id") int id) {

			Solicitudpension solicitudpension = null;
	        solicitudpension = solicitudpensionService.getSolicitudpension(id);
			return solicitudpension;
	 }



	 @RequestMapping(value = "/solicitudpension", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Void> createSolicitudpension(@RequestBody Solicitudpension solicitudpension,    UriComponentsBuilder ucBuilder) {
	   
	        solicitudpensionService.addSolicitudpension(solicitudpension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/solicitudpension/{id}").buildAndExpand(solicitudpension.getSolicitudpensionId()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Solicitudpension> actualizarSolicitudpension(
				@PathVariable("id") int id, 
				@RequestBody Solicitudpension solicitudpension) {
	        
	        Solicitudpension solicitudpensionFound = solicitudpensionService.getSolicitudpension(id);
	         
	        if (solicitudpensionFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				solicitudpensionFound.setAfiliadoId(solicitudpension.getAfiliadoId());
				solicitudpensionFound.setTipopensionId(solicitudpension.getTipopensionId());
			
				solicitudpensionFound.setNumero(solicitudpension.getNumero());
				solicitudpensionFound.setFecha_solicitud(solicitudpension.getFecha_solicitud());
				solicitudpensionFound.setObservaciones(solicitudpension.getObservaciones());
			
			solicitudpensionFound.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());

		    solicitudpensionService.editSolicitudpension(solicitudpensionFound);
	        return new ResponseEntity<>(solicitudpensionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Solicitudpension> deleteSolicitudpension(@PathVariable("id") int id) {
	  
             try{
    	         Solicitudpension solicitudpension = solicitudpensionService.getSolicitudpension(id);
    	         if (solicitudpension == null) {
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             solicitudpensionService.deleteSolicitudpension(solicitudpension);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveSolicitudpension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String saveSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {

		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.addSolicitudpension(solicitudpension);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editSolicitudpension", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String editSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {


		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.editSolicitudpension(solicitudpension);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchSolicitudpension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView addSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		Solicitudpension solicitudpension = null;
		if (solicitudpensionBean != null)
			solicitudpension = prepareModel(solicitudpensionBean);
		model.put("solicitudpensions",
				prepareListofBean(solicitudpensionService.listSolicitudpensions(solicitudpension)));
		return new ModelAndView("searchSolicitudpension", model);
	}

	@RequestMapping(value = "/entrySolicitudpension", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView entrySolicitudpension() {
		return new ModelAndView("redirect:/searchSolicitudpension");
	}

	private Solicitudpension prepareModel(SolicitudpensionBean solicitudpensionBean) {
		Solicitudpension solicitudpension = new Solicitudpension();

		solicitudpension.setAfiliadoId(solicitudpensionBean.getAfiliadoId());
		solicitudpension.setTipopensionId(solicitudpensionBean.getTipopensionId());
		solicitudpension.setNumero(solicitudpensionBean.getNumero());
		solicitudpension.setFecha_solicitud(solicitudpensionBean.getFechaSolicitud());
		solicitudpension.setObservaciones(solicitudpensionBean.getObservaciones());
		solicitudpension.setSolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		solicitudpensionBean.setSolicitudpensionId(null);

		return solicitudpension;
	}

	private List<SolicitudpensionBean> prepareListofBean(List<Solicitudpension> solicitudpensions) {
		List<SolicitudpensionBean> beans = null;
		if (solicitudpensions != null && !solicitudpensions.isEmpty()) {
			beans = new ArrayList<>();
			SolicitudpensionBean bean = null;
			for (Solicitudpension solicitudpension : solicitudpensions) {
				bean = new SolicitudpensionBean();

				bean.setAfiliadoId(solicitudpension.getAfiliadoId());
				bean.setTipopensionId(solicitudpension.getTipopensionId());
				bean.setNumero(solicitudpension.getNumero());
				bean.setFechaSolicitud(solicitudpension.getFecha_solicitud());
				bean.setObservaciones(solicitudpension.getObservaciones());
				bean.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


