/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de las acciones. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

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


import com.softtek.acceleo.demo.catalogo.bean.AccionBean;
import com.softtek.acceleo.demo.domain.Accion;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.AccionService;

/**
 * Clase AccionController.
 * @author PSG.
 *
 */
@Controller
public class AccionController {
	private static final Logger logger = Logger.getLogger(AccionController.class);
	
	@Autowired
	private AccionService accionService;
	
	/**
	 * Obtiene informacion de las acciones.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Accion>.
	 */
	@RequestMapping(value = "/accion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Accion> getAccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		Accion accion = new Accion();

       	String query=requestParams.get("q");
		int page = requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		

		List<Accion> listAccion = null;

		if (query==null && page == 0 ) {
       		listAccion = accionService.listAccionss(accion);
			rows = accionService.getTotalRows();
		}/** else if (query!= null){
			
		}**/ else /**if (page != 0)**/{
			listAccion = accionService.listAccionsPagination(accion, page, 10);
			rows = accionService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listAccion;
	}
	
	/**
	 * Obtiene informacion de la accion cuyo id sea igual al valor que se pasa como parametro.
	 * @param id.
	 * @return Accion.
	 */
	@RequestMapping(value = "/accion/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Accion getAccion(@PathVariable("id") int id) {
	        
	        Accion accion = null;
	        accion = accionService.getAccion(id);
			return accion;
	 }

	/**
	 * Genera una nueva accion.
	 * @param accion.
	 * @param ucBuilder.
	 * @return ResponseEntity.
	 */
	 @RequestMapping(value = "/accion", method = RequestMethod.POST)
	    public ResponseEntity<Void> createAccion(@RequestBody Accion accion,    UriComponentsBuilder ucBuilder) {
	   
	        accionService.addAccion(accion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/accion/{id}").buildAndExpand(accion.getIdAccion()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 /**
	  * Actualiza informacion de una accion.
	  * @param id.
	  * @param accion.
	  * @return ResponseEntity<Accion>.
	  */
	 @RequestMapping(value = "/accion/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Accion> actualizarAccion(@PathVariable("id") int id, @RequestBody Accion accion) {
	        
	        
	        Accion accionFound = accionService.getAccion(id);
	         
	        if (accionFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				accionFound.setIdAccion(accion.getIdAccion());
				accionFound.setAccion(accion.getAccion());
				accionFound.setEstatus(accion.getEstatus());
				accionFound.setFechaCreacion(accion.getFechaCreacion());
				accionFound.setFechaModificacion(accion.getFechaModificacion());
			
	        accionService.editAccion(accionFound);
	        return new ResponseEntity<>(accionFound, HttpStatus.OK);
	  } 	
	
		
	 /**
	  * Elimina una accion.
	  * @param id.
	  * @return ResponseEntity<Accion>.
	  */
	 @RequestMapping(value = "/accion/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Accion> deleteAccion(@PathVariable("id") int id) {
	    	 logger.info("Fetching & Deleting User with id " + id);
	    	 	  
	         try {
		         Accion accion = accionService.getAccion(id);
		         if (accion == null) {
		        	 logger.info("Unable to delete. Cuenta with id " + id + " not found");
		             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		         }
	        	 
				 accionService.deleteAccion(accion);				 
				 return new ResponseEntity<>(HttpStatus.OK);
	         }catch(GenericException e) {
	        	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
	         }
		}


	 /**
	  * Guarda informacion de una accion.
	  * @param accionBean.
	  * @return String.
	  */
	@RequestMapping(value = "/saveAccion", method = RequestMethod.POST)
	public @ResponseBody String saveAccion(
			@ModelAttribute("command") AccionBean accionBean) {


		Accion accion = prepareModel(accionBean);
		accionService.addAccion(accion);

		return "SUCCESS";
	}
	
	/**
	 * Modifica la informacion de una accion.
	 * @param accionBean.
	 * @return String.
	 */
	@RequestMapping(value = "/editAccion", method = RequestMethod.POST)
	public @ResponseBody String editAccion(
			@ModelAttribute("command") AccionBean accionBean) {


		Accion accion = prepareModel(accionBean);
		accionService.editAccion(accion);
		return "SUCCESS";
	}

	/**
	 * Agrega una accion.
	 * @param accionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/searchAccion", method = RequestMethod.GET)
	public ModelAndView addAccion(
			@ModelAttribute("command") AccionBean accionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		Accion accion = null;
		if (accionBean != null)
			accion = prepareModel(accionBean);
		model.put("accions",
				prepareListofBean(accionService.listAccionss(accion)));
		return new ModelAndView("searchAccion", model);
	}

	/**
	 * 
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/entryAccion", method = RequestMethod.GET)
	public ModelAndView entryAccion() {
		return new ModelAndView("redirect:/searchAccion");
	}

	/**
	 * Convierte un objeto de tipo AccionBean a un objeto de tipo Accion.
	 * @param accionBean.
	 * @return Accion.
	 */
	private Accion prepareModel(AccionBean accionBean) {
		Accion accion = new Accion();

		accion.setIdAccion(accionBean.getIdAccion());
		accion.setAccion(accionBean.getAccion());
		accion.setEstatus(accionBean.getEstatus());
		accion.setFechaCreacion(accionBean.getFechaCreacion());
		accion.setFechaModificacion(accionBean.getFechaModificacion());
		return accion;
	}

	/**
	 * Convierte una lista de objetos de tipo Accion, a una lista de objetos de tipo ActionBean.
	 * @param accions.
	 * @return List<AccionBean>.
	 */
	private List<AccionBean> prepareListofBean(List<Accion> accions) {
		List<AccionBean> beans = null;
		if (accions != null && !accions.isEmpty()) {
			beans = new ArrayList<>();
			AccionBean bean = null;
			for (Accion accion : accions) {
				bean = new AccionBean();

                bean.setIdAccion(accion.getIdAccion());
                bean.setAccion(accion.getAccion());
                bean.setEstatus(accion.getEstatus());
                bean.setFechaCreacion(accion.getFechaCreacion());
                bean.setFechaModificacion(accion.getFechaModificacion());
				beans.add(bean);
			}
		}
		return beans;
	}

}


