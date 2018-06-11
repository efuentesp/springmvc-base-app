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

import com.softtek.acceleo.demo.catalogo.bean.ModuloAccionAuthorityBean;
import com.softtek.acceleo.demo.domain.ModuloAccion;
import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.ModuloAccionAuthorityService;
import com.softtek.acceleo.demo.service.ModuloAccionService;

@Controller
public class ModuloAccionAuthorityController {
	private static final Logger logger = Logger.getLogger(ModuloAccionAuthorityController.class);

	@Autowired
	private ModuloAccionAuthorityService moduloAccionAuthorityService;
	
	@Autowired
	private ModuloAccionService moduloAccionService;
	
	
	ModuloAccionAuthority ModuloAccionAuthority = new ModuloAccionAuthority();

	@RequestMapping(value = "/moduloaccionauthority", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ModuloAccionAuthority> getModuloAccionAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<ModuloAccionAuthority> listModuloAccionAuthority = null;

		if (query==null && _page == 0 ) {
       		listModuloAccionAuthority = moduloAccionAuthorityService.listModuloAccionAuthorityss(ModuloAccionAuthority);
			rows = moduloAccionAuthorityService.getTotalRows();
		} else if (query!= null){
			
		} else if (_page != 0){
			listModuloAccionAuthority = moduloAccionAuthorityService.listModuloAccionAuthoritysPagination(ModuloAccionAuthority, _page, 10);
			rows = moduloAccionAuthorityService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listModuloAccionAuthority;
	}
	
	@RequestMapping(value = "/moduloaccionauthority/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  ModuloAccionAuthority getModuloAccionAuthority(@PathVariable("id") int id) {
	        
	        ModuloAccionAuthority.setIdmoduloaccionauthority(id);
	        
	        ModuloAccionAuthority ModuloAccionAuthority = null;
	        ModuloAccionAuthority = moduloAccionAuthorityService.getModuloAccionAuthority(id);
			return ModuloAccionAuthority;
	 }



	 @RequestMapping(value = "/moduloaccionauthority", method = RequestMethod.POST)
	 public ResponseEntity<Void> createModuloAccionAuthority(@RequestBody ModuloAccionAuthority ModuloAccionAuthority,    UriComponentsBuilder ucBuilder) {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/moduloAccionAuthority/{id}").buildAndExpand(ModuloAccionAuthority.getIdmoduloaccionauthority()).toUri());

		try { 	
			moduloAccionAuthorityService.addModuloAccionAuthority(ModuloAccionAuthority);
		 
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}catch(GenericException e) {
			logger.error("Error - " + e);
			
			return new ResponseEntity<Void>(headers, HttpStatus.NOT_IMPLEMENTED);
		}
	 }
		
	 @RequestMapping(value = "/moduloaccionauthority/{idModulo}/{idAccion}/{idAuthority}/{estatus}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody ModuloAccionAuthority createModuloAccionAuthorityParams(@PathVariable("idModulo") int idModulo, @PathVariable("idAccion") int idAccion, @PathVariable("idAuthority") int idAuthority, @PathVariable("estatus") boolean estatus) {
	   
		 /**
		  * Valida que este dada de alta la relacion "modulo-accion", si la relacion no existe, entonces se da de alta.
		  */
		 List<ModuloAccion> lstModuloAccion = moduloAccionService.listModuloAccion(idModulo, idAccion);
		 if( lstModuloAccion == null || lstModuloAccion.isEmpty() ) {
			 ModuloAccion moduloAccion = new ModuloAccion();
			 /** moduloAccion.setId(); **/
			 moduloAccion.setIdModulo(idModulo);
			 moduloAccion.setIdAccion(idAccion);
			 moduloAccion.setEstatus(estatus);
			 moduloAccion.setFechaCreacion(new Date());

			 try {
				 moduloAccionService.addModuloAccion(moduloAccion);
				 /** Obtiene informacion de la relacion "Modulo - Accion" persistida, la informacion se utiliza para persistir el registro ModuloAccionAuthority **/
				 lstModuloAccion = moduloAccionService.listModuloAccion(idModulo, idAccion);
			 }catch(GenericException e) {
				 logger.error("Error - " + e);
				 lstModuloAccion = null;
			 }
		 }
		 
		 if( lstModuloAccion == null || lstModuloAccion.isEmpty() ) {
			 return null;
		 }else {
			 int idModuloAccion = lstModuloAccion.get(0).getId();
			 
			 ModuloAccionAuthority moduloAccionAuthority = new ModuloAccionAuthority();
			 /**moduloAccionAuthority.setIdmoduloaccionauthority();**/
			 moduloAccionAuthority.setIdModuloAccion(idModuloAccion);
			 moduloAccionAuthority.setIdAuthority(idAuthority);
			 moduloAccionAuthority.setEstatus(estatus);
			 moduloAccionAuthority.setFechaCreacion(new Date());
			 
			 try {
				 moduloAccionAuthorityService.addModuloAccionAuthority(moduloAccionAuthority);
				 
				 List<ModuloAccionAuthority> lstModuloAccionAuthority = moduloAccionAuthorityService.listModuloAccionAuthority(idModuloAccion, idAuthority);
				 if( lstModuloAccionAuthority == null || lstModuloAccionAuthority.isEmpty() ) {
					 return null;
				 }else {
					 return lstModuloAccionAuthority.get(0);
				 }
			 }catch(GenericException e) {
				 logger.error("El registro con (idModuloAccion = " + idModuloAccion + ", idAuthority = " + idAuthority + ") ya existe, unicamente se actualizara el estatus");
				 if( e.getCause().getCause().getMessage().contains("Duplicate entry") ) {
					 moduloAccionAuthorityService.editModuloAccionAuthority(moduloAccionAuthority);
					 
					 return moduloAccionAuthority;
				 }else {
					 return null;
				 }
			 }
		 }
	 }
	 
	 
	 @RequestMapping(value = "/moduloaccionauthority/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<ModuloAccionAuthority> actualizarModuloAccionAuthority(@PathVariable("id") int id, @RequestBody ModuloAccionAuthority ModuloAccionAuthority) {
	        
	        
	        ModuloAccionAuthority ModuloAccionAuthorityFound = moduloAccionAuthorityService.getModuloAccionAuthority(id);
	         
	        if (ModuloAccionAuthorityFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<ModuloAccionAuthority>(HttpStatus.NOT_FOUND);
	        }
	 
				ModuloAccionAuthorityFound.setIdmoduloaccionauthority(ModuloAccionAuthority.getIdmoduloaccionauthority());
				ModuloAccionAuthorityFound.setIdModuloAccion(ModuloAccionAuthority.getIdModuloAccion());
				ModuloAccionAuthorityFound.setIdAuthority(ModuloAccionAuthority.getIdAuthority());
				ModuloAccionAuthorityFound.setEstatus(ModuloAccionAuthority.getEstatus());
				ModuloAccionAuthorityFound.setFechaCreacion(ModuloAccionAuthority.getFechaCreacion());
				ModuloAccionAuthorityFound.setFechaModificacion(ModuloAccionAuthority.getFechaModificacion());
	        
				moduloAccionAuthorityService.editModuloAccionAuthority(ModuloAccionAuthorityFound);
	        return new ResponseEntity<ModuloAccionAuthority>(ModuloAccionAuthorityFound, HttpStatus.OK);
	  } 	
	
	 
	 @RequestMapping(value = "/moduloaccionauthorityid/{idmoduloaccion}/{idauthority}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody ModuloAccionAuthority searchByIdModuloAccion(@PathVariable("idmoduloaccion") int idmoduloaccion, @PathVariable("idauthority") int idauthority) {
			List<ModuloAccionAuthority> lstModuloAccionAuthority = moduloAccionAuthorityService.listModuloAccionAuthority(idmoduloaccion, idauthority);
			
			if( lstModuloAccionAuthority == null || lstModuloAccionAuthority.isEmpty()  ) {
				return null;
			}else {
				return lstModuloAccionAuthority.get(0);
			}
	 }

	 @RequestMapping(value = "/moduloaccionauthorityid/{idModulo}/{idAccion}/{idAuthority}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody ModuloAccionAuthority searchByIdModuloIdAccionIdAuthority(@PathVariable("idModulo") int idModulo, @PathVariable("idAccion") int idAccion, @PathVariable("idAuthority") int idAuthority) {
		 
		 List<ModuloAccion> lstModuloAccion = moduloAccionService.listModuloAccion(idModulo, idAccion);
		 
		 if( lstModuloAccion == null || lstModuloAccion.isEmpty() ) {
			 return null;
		 }else {
			 ModuloAccion moduloAccion = lstModuloAccion.get(0);
			 List<ModuloAccionAuthority> lstModuloAccionAuthority = moduloAccionAuthorityService.listModuloAccionAuthority(moduloAccion.getId(), idAuthority);
			 
			 if( lstModuloAccionAuthority == null || lstModuloAccionAuthority.isEmpty() ) {
				 return null;
			 }else {
				 return lstModuloAccionAuthority.get(0);
			 }
		 }
	 }
	 
	 
		@RequestMapping(value = "/moduloaccionauthority/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<ModuloAccionAuthority> deleteModuloAccionAuthority(@PathVariable("id") int id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 long rows = 0;	
	    	 
	         ModuloAccionAuthority ModuloAccionAuthority = moduloAccionAuthorityService.getModuloAccionAuthority(id);
	         if (ModuloAccionAuthority == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<ModuloAccionAuthority>(HttpStatus.NOT_FOUND);
	         }
	  
             

             if (rows==0){
            	 moduloAccionAuthorityService.deleteModuloAccionAuthority(ModuloAccionAuthority);
            	 return new ResponseEntity<ModuloAccionAuthority>(HttpStatus.OK);
             } else {
            	 return new ResponseEntity<ModuloAccionAuthority>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveModuloAccionAuthority", method = RequestMethod.POST)
	public @ResponseBody String saveModuloAccionAuthority(
			@ModelAttribute("command") ModuloAccionAuthorityBean ModuloAccionAuthorityBean) {


		ModuloAccionAuthority ModuloAccionAuthority = prepareModel(ModuloAccionAuthorityBean);
		
		try {
			moduloAccionAuthorityService.addModuloAccionAuthority(ModuloAccionAuthority);
			
			return "SUCCESS";
		}catch(GenericException e) {
			return "ERROR";
		}

		
	}
	
	@RequestMapping(value = "/editModuloAccionAuthority", method = RequestMethod.POST)
	public @ResponseBody String editModuloAccionAuthority(
			@ModelAttribute("command") ModuloAccionAuthorityBean ModuloAccionAuthorityBean) {


		ModuloAccionAuthority ModuloAccionAuthority = prepareModel(ModuloAccionAuthorityBean);
		moduloAccionAuthorityService.editModuloAccionAuthority(ModuloAccionAuthority);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchModuloAccionAuthority", method = RequestMethod.GET)
	public ModelAndView addModuloAccionAuthority(
			@ModelAttribute("command") ModuloAccionAuthorityBean ModuloAccionAuthorityBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		ModuloAccionAuthority ModuloAccionAuthority = null;
		if (ModuloAccionAuthorityBean != null)
			ModuloAccionAuthority = prepareModel(ModuloAccionAuthorityBean);
		model.put("ModuloAccionAuthoritys",
				prepareListofBean(moduloAccionAuthorityService.listModuloAccionAuthorityss(ModuloAccionAuthority)));
		return new ModelAndView("searchModuloAccionAuthority", model);
	}

	@RequestMapping(value = "/deleteModuloAccionAuthority", method = RequestMethod.POST)
	public ModelAndView deleteModuloAccionAuthority(
			@ModelAttribute("command") ModuloAccionAuthorityBean ModuloAccionAuthorityBean,
			BindingResult result) {
		System.out.println("delete " + ModuloAccionAuthorityBean.getIdmoduloaccionauthority());
		moduloAccionAuthorityService.deleteModuloAccionAuthority(prepareModel(ModuloAccionAuthorityBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ModuloAccionAuthority", null);
		model.put("ModuloAccionAuthoritys",
				prepareListofBean(moduloAccionAuthorityService.listModuloAccionAuthorityss(null)));
		return new ModelAndView("searchModuloAccionAuthority", model);
	}

	@RequestMapping(value = "/entryModuloAccionAuthority", method = RequestMethod.GET)
	public ModelAndView entryModuloAccionAuthority() {
		return new ModelAndView("redirect:/searchModuloAccionAuthority");
	}

	private ModuloAccionAuthority prepareModel(ModuloAccionAuthorityBean ModuloAccionAuthorityBean) {
		ModuloAccionAuthority ModuloAccionAuthority = new ModuloAccionAuthority();

		ModuloAccionAuthority.setIdmoduloaccionauthority(ModuloAccionAuthorityBean.getIdmoduloaccionauthority());
		ModuloAccionAuthority.setIdModuloAccion(ModuloAccionAuthorityBean.getIdModuloAccion());
		ModuloAccionAuthority.setIdAuthority(ModuloAccionAuthorityBean.getIdAuthority());
		ModuloAccionAuthority.setEstatus(ModuloAccionAuthorityBean.getEstatus());
		ModuloAccionAuthority.setFechaCreacion(ModuloAccionAuthorityBean.getFechaCreacion());
		ModuloAccionAuthority.setFechaModificacion(ModuloAccionAuthorityBean.getFechaModificacion());
		ModuloAccionAuthorityBean.setIdmoduloaccionauthority(null);
		return ModuloAccionAuthority;
	}

	private List<ModuloAccionAuthorityBean> prepareListofBean(List<ModuloAccionAuthority> ModuloAccionAuthoritys) {
		List<ModuloAccionAuthorityBean> beans = null;
		if (ModuloAccionAuthoritys != null && !ModuloAccionAuthoritys.isEmpty()) {
			beans = new ArrayList<ModuloAccionAuthorityBean>();
			ModuloAccionAuthorityBean bean = null;
			for (ModuloAccionAuthority ModuloAccionAuthority : ModuloAccionAuthoritys) {
				bean = new ModuloAccionAuthorityBean();

                bean.setIdmoduloaccionauthority(ModuloAccionAuthority.getIdmoduloaccionauthority());
                bean.setIdModuloAccion(ModuloAccionAuthority.getIdModuloAccion());
                bean.setIdAuthority(ModuloAccionAuthority.getIdAuthority());
                bean.setEstatus(ModuloAccionAuthority.getEstatus());
                bean.setFechaCreacion(ModuloAccionAuthority.getFechaCreacion());
                bean.setFechaModificacion(ModuloAccionAuthority.getFechaModificacion());
				beans.add(bean);
			}
		}
		return beans;
	}

}


