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
import com.softtek.acceleo.demo.service.AccionService;

/**
 * Clase AccionController.
 * @author PSG.
 *
 */
@Controller
public class AccionController {

	@Autowired
	private AccionService accionService;
	
	Accion accion = new Accion();

	/**
	 * Obtiene informacion de las acciones.
	 * @param requestParams.
	 * @param request.
	 * @param response.
	 * @return List<Accion>.
	 */
	@RequestMapping(value = "/accion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Accion> getAccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<Accion> listAccion = null;

		if (query==null && _page == 0 ) {
       		listAccion = accionService.listAccionss(accion);
			rows = accionService.getTotalRows();
		} else if (query!= null){
			
		} else if (_page != 0){
			listAccion = accionService.listAccionsPagination(accion, _page, 10);
			rows = accionService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAccion;
	}
	
	/**
	 * Obtiene informacion de la accion cuyo id sea igual al valor que se pasa como parametro.
	 * @param id.
	 * @return Accion.
	 */
	@RequestMapping(value = "/accion/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Accion getAccion(@PathVariable("id") int id) {
	        
	        accion.setId(id);
	        
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
	        headers.setLocation(ucBuilder.path("/accion/{id}").buildAndExpand(accion.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Accion>(HttpStatus.NOT_FOUND);
	        }
	 
				accionFound.setIdAccion(accion.getIdAccion());
				accionFound.setAccion(accion.getAccion());
				accionFound.setEstatus(accion.getEstatus());
				accionFound.setFechaCreacion(accion.getFechaCreacion());
				accionFound.setFechaModificacion(accion.getFechaModificacion());
			accion.setId(null);
	        
	        accionService.editAccion(accionFound);
	        return new ResponseEntity<Accion>(accionFound, HttpStatus.OK);
	  } 	
	
		
	 /**
	  * Elimina una accion.
	  * @param id.
	  * @return ResponseEntity<Accion>.
	  */
	 @RequestMapping(value = "/accion/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Accion> deleteAccion(@PathVariable("id") int id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 long rows = 0;	
	    	 
	         Accion accion = accionService.getAccion(id);
	         if (accion == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<Accion>(HttpStatus.NOT_FOUND);
	         }
	  
             

             if (rows==0){
	             accionService.deleteAccion(accion);
            	 return new ResponseEntity<Accion>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<Accion>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	 /**
	  * Guarda informacion de una accion.
	  * @param accionBean.
	  * @return String. (SUCCESS -> Si todo se ejecuta exitosamente)
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
	 * @return String. (SUCCESS -> Si todo se ejecuta exitosamente)
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

		Map<String, Object> model = new HashMap<String, Object>();
		Accion accion = null;
		if (accionBean != null)
			accion = prepareModel(accionBean);
		model.put("accions",
				prepareListofBean(accionService.listAccionss(accion)));
		return new ModelAndView("searchAccion", model);
	}

	/**
	 * Elimina una accion.
	 * @param accionBean.
	 * @param result.
	 * @return ModelAndView.
	 */
	@RequestMapping(value = "/deleteAccion", method = RequestMethod.POST)
	public ModelAndView deleteAccion(
			@ModelAttribute("command") AccionBean accionBean,
			BindingResult result) {
		System.out.println("delete " + accionBean.getId());
		accionService.deleteAccion(prepareModel(accionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("accion", null);
		model.put("accions",
				prepareListofBean(accionService.listAccionss(null)));
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

		accion.setIdAccion(accionBean.getId());
		accion.setAccion(accionBean.getAccion());
		accion.setEstatus(accionBean.getEstatus());
		accion.setFechaCreacion(accionBean.getFechaCreacion());
		accion.setFechaModificacion(accionBean.getFechaModificacion());
		accion.setId(accionBean.getId());
		accionBean.setId(null);
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
			beans = new ArrayList<AccionBean>();
			AccionBean bean = null;
			for (Accion accion : accions) {
				bean = new AccionBean();

                bean.setId(accion.getIdAccion());
                bean.setAccion(accion.getAccion());
                bean.setEstatus(accion.getEstatus());
                bean.setFechaCreacion(accion.getFechaCreacion());
                bean.setFechaModificacion(accion.getFechaModificacion());
				bean.setId(accion.getId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


