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

import com.softtek.acceleo.demo.catalogo.bean.SolicitudpensionBean;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.service.SolicitudpensionService;

@Controller
public class SolicitudpensionController {

	@Autowired
	private SolicitudpensionService solicitudpensionService;
	
	Solicitudpension solicitudpension = new Solicitudpension();

	@RequestMapping(value = "/solicitudpension", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Solicitudpension> getSolicitudpensions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Solicitudpension> listSolicitudpension = null;

		if (query==null && _page == 0) {
       		listSolicitudpension = solicitudpensionService.listSolicitudpensions(solicitudpension);
			rows = solicitudpensionService.getTotalRows();
		} else if (query!= null){
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsQuery(solicitudpension, query, _page, 10);
			rows = solicitudpensionService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listSolicitudpension = solicitudpensionService.listSolicitudpensionsPagination(solicitudpension, _page, 10);
			rows = solicitudpensionService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listSolicitudpension;
	}
	
	@RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Solicitudpension getSolicitudpension(@PathVariable("id") int id) {
	        
	        solicitudpension.setSolicitudpensionId(id);
	        
	        Solicitudpension solicitudpension = null;
	        solicitudpension = solicitudpensionService.getSolicitudpension(id);
			return solicitudpension;
	 }



	 @RequestMapping(value = "/solicitudpension", method = RequestMethod.POST)
	    public ResponseEntity<Void> createSolicitudpension(@RequestBody Solicitudpension solicitudpension,    UriComponentsBuilder ucBuilder) {
	   
	        solicitudpensionService.addSolicitudpension(solicitudpension);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/solicitudpension/{id}").buildAndExpand(solicitudpension.getSolicitudpensionId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Solicitudpension> actualizarSolicitudpension(
				@PathVariable("id") int id, 
				@RequestBody Solicitudpension solicitudpension) {
	        
	        Solicitudpension solicitudpensionFound = solicitudpensionService.getSolicitudpension(id);
	         
	        if (solicitudpensionFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Solicitudpension>(HttpStatus.NOT_FOUND);
	        }
	 
				solicitudpensionFound.setAfiliadoId(solicitudpension.getAfiliadoId());
				solicitudpensionFound.setTipopensionId(solicitudpension.getTipopensionId());
			
				solicitudpensionFound.setNumero(solicitudpension.getNumero());
				solicitudpensionFound.setFecha_solicitud(solicitudpension.getFecha_solicitud());
				solicitudpensionFound.setObservaciones(solicitudpension.getObservaciones());
			
			solicitudpensionFound.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());

		    solicitudpensionService.editSolicitudpension(solicitudpensionFound);
	        return new ResponseEntity<Solicitudpension>(solicitudpensionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/solicitudpension/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Solicitudpension> deleteSolicitudpension(@PathVariable("id") int id) {
			 long rows = 0;	
	    	 
	         Solicitudpension solicitudpension = solicitudpensionService.getSolicitudpension(id);
	         if (solicitudpension == null) {
	             return new ResponseEntity<Solicitudpension>(HttpStatus.NOT_FOUND);
	         }
	  
             if (rows==0){
	             solicitudpensionService.deleteSolicitudpension(solicitudpension);
            	 return new ResponseEntity<Solicitudpension>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<Solicitudpension>(HttpStatus.PRECONDITION_FAILED);
             }
		}


	@RequestMapping(value = "/saveSolicitudpension", method = RequestMethod.POST)
	public @ResponseBody String saveSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {

		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.addSolicitudpension(solicitudpension);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editSolicitudpension", method = RequestMethod.POST)
	public @ResponseBody String editSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean) {


		Solicitudpension solicitudpension = prepareModel(solicitudpensionBean);
		solicitudpensionService.editSolicitudpension(solicitudpension);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchSolicitudpension", method = RequestMethod.GET)
	public ModelAndView addSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		Solicitudpension solicitudpension = null;
		if (solicitudpensionBean != null)
			solicitudpension = prepareModel(solicitudpensionBean);
		model.put("solicitudpensions",
				prepareListofBean(solicitudpensionService.listSolicitudpensions(solicitudpension)));
		return new ModelAndView("searchSolicitudpension", model);
	}

	@RequestMapping(value = "/deleteSolicitudpension", method = RequestMethod.POST)
	public ModelAndView deleteSolicitudpension(
			@ModelAttribute("command") SolicitudpensionBean solicitudpensionBean,
			BindingResult result) {
		System.out.println("delete " + solicitudpensionBean.getSolicitudpensionId());
		solicitudpensionService.deleteSolicitudpension(prepareModel(solicitudpensionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("solicitudpension", null);
		model.put("solicitudpensions",
				prepareListofBean(solicitudpensionService.listSolicitudpensions(null)));
		return new ModelAndView("searchSolicitudpension", model);
	}

	@RequestMapping(value = "/entrySolicitudpension", method = RequestMethod.GET)
	public ModelAndView entrySolicitudpension() {
		return new ModelAndView("redirect:/searchSolicitudpension");
	}

	private Solicitudpension prepareModel(SolicitudpensionBean solicitudpensionBean) {
		Solicitudpension solicitudpension = new Solicitudpension();

		solicitudpension.setAfiliadoId(solicitudpensionBean.getAfiliadoId());
		solicitudpension.setTipopensionId(solicitudpensionBean.getTipopensionId());
		solicitudpension.setNumero(solicitudpensionBean.getNumero());
		solicitudpension.setFecha_solicitud(solicitudpensionBean.getFecha_solicitud());
		solicitudpension.setObservaciones(solicitudpensionBean.getObservaciones());
		solicitudpension.setSolicitudpensionId(solicitudpensionBean.getSolicitudpensionId());
		solicitudpensionBean.setSolicitudpensionId(null);

		return solicitudpension;
	}

	private List<SolicitudpensionBean> prepareListofBean(List<Solicitudpension> solicitudpensions) {
		List<SolicitudpensionBean> beans = null;
		if (solicitudpensions != null && !solicitudpensions.isEmpty()) {
			beans = new ArrayList<SolicitudpensionBean>();
			SolicitudpensionBean bean = null;
			for (Solicitudpension solicitudpension : solicitudpensions) {
				bean = new SolicitudpensionBean();

				bean.setAfiliadoId(solicitudpension.getAfiliadoId());
				bean.setTipopensionId(solicitudpension.getTipopensionId());
				bean.setNumero(solicitudpension.getNumero());
				bean.setFecha_solicitud(solicitudpension.getFecha_solicitud());
				bean.setObservaciones(solicitudpension.getObservaciones());
				bean.setSolicitudpensionId(solicitudpension.getSolicitudpensionId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


