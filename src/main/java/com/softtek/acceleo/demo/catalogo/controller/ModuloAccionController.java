/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los ModuloAccion. 
 */
package com.softtek.acceleo.demo.catalogo.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.softtek.acceleo.demo.catalogo.bean.ModuloAccionBean;
import com.softtek.acceleo.demo.domain.ModuloAccion;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.ModuloAccionService;

/**
 * Clase ModuloAccionController.
 * @author PSG.
 *
 */
@Controller
public class ModuloAccionController {
	private static final Logger logger = Logger.getLogger(ModuloAccionController.class);
	
	@Autowired
	private ModuloAccionService moduloaccionService;
	

	@RequestMapping(value = "/moduloaccion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ModuloAccion> getModuloAccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		ModuloAccion moduloaccion = new ModuloAccion();
		
       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		

		List<ModuloAccion> listModuloAccion = null;

		if (query==null && page == 0 ) {
       		listModuloAccion = moduloaccionService.listModuloAccionss(moduloaccion);
			rows = moduloaccionService.getTotalRows();
		} /**else if (query!= null){
			
		}**/ else /**if (page != 0)**/{
			listModuloAccion = moduloaccionService.listModuloAccionsPagination(moduloaccion, page, 10);
			rows = moduloaccionService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listModuloAccion;
	}
	
	 @RequestMapping(value = "/moduloaccion/{idmodulo}/{idaccion}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody ModuloAccion createModuloAccion(@PathVariable("idmodulo") int idmodulo, @PathVariable("idaccion") int idaccion) {
	   
			ModuloAccion moduloAccion = new ModuloAccion();
			moduloAccion.setId(null);
			moduloAccion.setIdModulo(idmodulo);
			moduloAccion.setIdAccion(idaccion);
			moduloAccion.setEstatus(true);
			moduloAccion.setFechaCreacion(new Date());
			moduloAccion.setFechaModificacion(null);
		 
			try {
			 	//Se almacena la informacion del user, con un password temporal al cual no se le genero un token.
				moduloaccionService.addModuloAccion(moduloAccion);
	
				List<ModuloAccion> lstModuloAccion = moduloaccionService.listModuloAccion(idmodulo, idaccion);
				if( lstModuloAccion == null || lstModuloAccion.isEmpty()  ) {
					return null;
				}else {
					return lstModuloAccion.get(0);
				}
			}catch(GenericException e) {
				logger.error("Error ModuloAccion - " + e);				
				if( e.getCause().getCause().getMessage().contains("Duplicate entry") ) {
					List<ModuloAccion> lstModuloAccion = moduloaccionService.listModuloAccion(idmodulo, idaccion);
					
					if( lstModuloAccion == null || lstModuloAccion.isEmpty()  ) {
						return null;
					}else {
						return lstModuloAccion.get(0);
					}
				}
				
				return null;
			}
	 }
	 
	 @RequestMapping(value = "/moduloaccionid/{idmodulo}/{idaccion}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody ModuloAccion searchByIdModuloAccion(@PathVariable("idmodulo") int idmodulo, @PathVariable("idaccion") int idaccion) {
	   
			List<ModuloAccion> lstModuloAccion = moduloaccionService.listModuloAccion(idmodulo, idaccion);
			if( lstModuloAccion == null || lstModuloAccion.isEmpty()  ) {
				return null;
			}else {
				return lstModuloAccion.get(0);
			}
			
	 }
	 
	 	
	@RequestMapping(value = "/moduloaccion/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  ModuloAccion getModuloAccion(@PathVariable("id") int id) {
	        
	        ModuloAccion moduloaccion = null;
	        moduloaccion = moduloaccionService.getModuloAccion(id);
	        
			return moduloaccion;
	 }

	@RequestMapping(value = "/moduloaccion/{idModulo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  List<ModuloAccion> getModuloAccionPorIdModulo(@PathVariable("idModulo") int idModulo) {
        
		return moduloaccionService.getModuloAccionPorIdModulo(idModulo);
	}

	 @RequestMapping(value = "/moduloaccion", method = RequestMethod.POST)
	    public ResponseEntity<Void> createModuloAccion(@RequestBody ModuloAccion moduloaccion,    UriComponentsBuilder ucBuilder) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/moduloaccion/{id}").buildAndExpand(moduloaccion.getId()).toUri());
	   
		 	try {
		        moduloaccionService.addModuloAccion(moduloaccion);
		 
		        return new ResponseEntity<>(headers, HttpStatus.CREATED);
		 	}catch(GenericException e){
		 		logger.error("Error: " + e);
		 		return new ResponseEntity<>(headers, HttpStatus.CONFLICT);
		 	}
	 }
		
	 @RequestMapping(value = "/moduloaccion/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<ModuloAccion> actualizarModuloAccion(@PathVariable("id") int id, @RequestBody ModuloAccion moduloaccion) {
	        
	        
	        ModuloAccion moduloaccionFound = moduloaccionService.getModuloAccion(id);
	         
	        if (moduloaccionFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				moduloaccionFound.setId(moduloaccion.getId());
				moduloaccionFound.setIdModulo(moduloaccion.getIdModulo());
				moduloaccionFound.setIdAccion(moduloaccion.getIdAccion());
				moduloaccionFound.setEstatus(moduloaccion.getEstatus());
				moduloaccionFound.setFechaCreacion(moduloaccion.getFechaCreacion());
				moduloaccionFound.setFechaModificacion(moduloaccion.getFechaModificacion());
			moduloaccion.setId(null);
	        
	        moduloaccionService.editModuloAccion(moduloaccionFound);
	        return new ResponseEntity<>(moduloaccionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/moduloaccion/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<ModuloAccion> deleteModuloAccion(@PathVariable("id") int id) {
	    	 logger.info("Fetching & Deleting User with id " + id);
	    	 
             try{
    	         ModuloAccion moduloaccion = moduloaccionService.getModuloAccion(id);
    	         if (moduloaccion == null) {
    	             logger.info("Unable to delete. Cuenta with id " + id + " not found");
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             moduloaccionService.deleteModuloAccion(moduloaccion);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveModuloAccion", method = RequestMethod.POST)
	public @ResponseBody String saveModuloAccion(
			@ModelAttribute("command") ModuloAccionBean moduloaccionBean) {

		try {
			ModuloAccion moduloaccion = prepareModel(moduloaccionBean);
			moduloaccionService.addModuloAccion(moduloaccion);
			
			return "SUCCESS";
		}catch(GenericException e) {
			logger.error("Error - " + e);
			return "";
		}
	}
	
	@RequestMapping(value = "/editModuloAccion", method = RequestMethod.POST)
	public @ResponseBody String editModuloAccion(
			@ModelAttribute("command") ModuloAccionBean moduloaccionBean) {


		ModuloAccion moduloaccion = prepareModel(moduloaccionBean);
		moduloaccionService.editModuloAccion(moduloaccion);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchModuloAccion", method = RequestMethod.GET)
	public ModelAndView addModuloAccion(
			@ModelAttribute("command") ModuloAccionBean moduloaccionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		ModuloAccion moduloaccion = null;
		if (moduloaccionBean != null)
			moduloaccion = prepareModel(moduloaccionBean);
		model.put("moduloaccions",
				prepareListofBean(moduloaccionService.listModuloAccionss(moduloaccion)));
		return new ModelAndView("searchModuloAccion", model);
	}

	@RequestMapping(value = "/entryModuloAccion", method = RequestMethod.GET)
	public ModelAndView entryModuloAccion() {
		return new ModelAndView("redirect:/searchModuloAccion");
	}

	private ModuloAccion prepareModel(ModuloAccionBean moduloaccionBean) {
		ModuloAccion moduloaccion = new ModuloAccion();

		moduloaccion.setId(moduloaccionBean.getId());
		moduloaccion.setIdModulo(moduloaccionBean.getIdModulo());
		moduloaccion.setIdAccion(moduloaccionBean.getIdAccion());
		moduloaccion.setEstatus(moduloaccionBean.getEstatus());
		moduloaccion.setFechaCreacion(moduloaccionBean.getFechaCreacion());
		moduloaccion.setFechaModificacion(moduloaccionBean.getFechaModificacion());
		moduloaccion.setId(moduloaccionBean.getId());
		moduloaccionBean.setId(null);
		return moduloaccion;
	}

	private List<ModuloAccionBean> prepareListofBean(List<ModuloAccion> moduloaccions) {
		List<ModuloAccionBean> beans = null;
		if (moduloaccions != null && !moduloaccions.isEmpty()) {
			beans = new ArrayList<>();
			ModuloAccionBean bean = null;
			for (ModuloAccion moduloaccion : moduloaccions) {
				bean = new ModuloAccionBean();

                bean.setId(moduloaccion.getId());
                bean.setIdModulo(moduloaccion.getIdModulo());
                bean.setIdAccion(moduloaccion.getIdAccion());
                bean.setEstatus(moduloaccion.getEstatus());
                bean.setFechaCreacion(moduloaccion.getFechaCreacion());
                bean.setFechaModificacion(moduloaccion.getFechaModificacion());
				bean.setId(moduloaccion.getId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


