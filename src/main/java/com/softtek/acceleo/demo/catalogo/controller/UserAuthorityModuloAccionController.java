/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los UserAuthorityModuloAccion. 
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


import com.softtek.acceleo.demo.catalogo.bean.UserAuthorityModuloAccionBean;
import com.softtek.acceleo.demo.domain.UserAuthorityModuloAccion;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.UserAuthorityModuloAccionService;

/**
 * Clase UserAuthorityModuloAccionController.
 * @author PSG.
 *
 */
@Controller
public class UserAuthorityModuloAccionController {
	private static final Logger logger = Logger.getLogger(UserAuthorityModuloAccionController.class);
	
	@Autowired
	private UserAuthorityModuloAccionService userauthoritymoduloaccionService;

	@RequestMapping(value = "/userauthoritymoduloaccion", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<UserAuthorityModuloAccion> getUserAuthorityModuloAccions(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		UserAuthorityModuloAccion userauthoritymoduloaccion = new UserAuthorityModuloAccion();
		
       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		

		List<UserAuthorityModuloAccion> listUserAuthorityModuloAccion = null;

		if (query==null && page == 0 ) {
       		listUserAuthorityModuloAccion = userauthoritymoduloaccionService.listUserAuthorityModuloAccionss(userauthoritymoduloaccion);
			rows = userauthoritymoduloaccionService.getTotalRows();
		} /**else if (query!= null){
			
		}**/ else /**if (page != 0)**/{
			listUserAuthorityModuloAccion = userauthoritymoduloaccionService.listUserAuthorityModuloAccionsPagination(userauthoritymoduloaccion, page, 10);
			rows = userauthoritymoduloaccionService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listUserAuthorityModuloAccion;
	}
	
	@RequestMapping(value = "/userauthoritymoduloaccion/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  UserAuthorityModuloAccion getUserAuthorityModuloAccion(@PathVariable("id") int id) {
	        UserAuthorityModuloAccion userauthoritymoduloaccion = null;
	        userauthoritymoduloaccion = userauthoritymoduloaccionService.getUserAuthorityModuloAccion(id);
			return userauthoritymoduloaccion;
	 }



	 @RequestMapping(value = "/userauthoritymoduloaccion", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUserAuthorityModuloAccion(@RequestBody UserAuthorityModuloAccion userauthoritymoduloaccion,    UriComponentsBuilder ucBuilder) {
	   
	        userauthoritymoduloaccionService.addUserAuthorityModuloAccion(userauthoritymoduloaccion);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/userauthoritymoduloaccion/{id}").buildAndExpand(userauthoritymoduloaccion.getId()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/userauthoritymoduloaccion/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<UserAuthorityModuloAccion> actualizarUserAuthorityModuloAccion(@PathVariable("id") int id, @RequestBody UserAuthorityModuloAccion userauthoritymoduloaccion) {
	        
	        
	        UserAuthorityModuloAccion userauthoritymoduloaccionFound = userauthoritymoduloaccionService.getUserAuthorityModuloAccion(id);
	         
	        if (userauthoritymoduloaccionFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				userauthoritymoduloaccionFound.setIdUserAuthorityModuloAccion(userauthoritymoduloaccion.getIdUserAuthorityModuloAccion());
				userauthoritymoduloaccionFound.setIdUserAuthority(userauthoritymoduloaccion.getIdUserAuthority());
				userauthoritymoduloaccionFound.setIdModuloAccion(userauthoritymoduloaccion.getIdModuloAccion());
				userauthoritymoduloaccionFound.setEstatus(userauthoritymoduloaccion.getEstatus());
				userauthoritymoduloaccionFound.setFechaCreacion(userauthoritymoduloaccion.getFechaCreacion());
				userauthoritymoduloaccionFound.setFechaModificacion(userauthoritymoduloaccion.getFechaModificacion());
			userauthoritymoduloaccion.setId(null);
	        
	        userauthoritymoduloaccionService.editUserAuthorityModuloAccion(userauthoritymoduloaccionFound);
	        return new ResponseEntity<>(userauthoritymoduloaccionFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/userauthoritymoduloaccion/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<UserAuthorityModuloAccion> deleteUserAuthorityModuloAccion(@PathVariable("id") int id) {
	    	 logger.info("Fetching & Deleting User with id " + id);
	    	 
             try{
    	         UserAuthorityModuloAccion userauthoritymoduloaccion = userauthoritymoduloaccionService.getUserAuthorityModuloAccion(id);
    	         if (userauthoritymoduloaccion == null) {
    	             logger.info("Unable to delete. Cuenta with id " + id + " not found");
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             userauthoritymoduloaccionService.deleteUserAuthorityModuloAccion(userauthoritymoduloaccion);
            	 return new ResponseEntity<>(HttpStatus.OK);
             } catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveUserAuthorityModuloAccion", method = RequestMethod.POST)
	public @ResponseBody String saveUserAuthorityModuloAccion(
			@ModelAttribute("command") UserAuthorityModuloAccionBean userauthoritymoduloaccionBean) {


		UserAuthorityModuloAccion userauthoritymoduloaccion = prepareModel(userauthoritymoduloaccionBean);
		userauthoritymoduloaccionService.addUserAuthorityModuloAccion(userauthoritymoduloaccion);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editUserAuthorityModuloAccion", method = RequestMethod.POST)
	public @ResponseBody String editUserAuthorityModuloAccion(
			@ModelAttribute("command") UserAuthorityModuloAccionBean userauthoritymoduloaccionBean) {


		UserAuthorityModuloAccion userauthoritymoduloaccion = prepareModel(userauthoritymoduloaccionBean);
		userauthoritymoduloaccionService.editUserAuthorityModuloAccion(userauthoritymoduloaccion);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchUserAuthorityModuloAccion", method = RequestMethod.GET)
	public ModelAndView addUserAuthorityModuloAccion(
			@ModelAttribute("command") UserAuthorityModuloAccionBean userauthoritymoduloaccionBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		UserAuthorityModuloAccion userauthoritymoduloaccion = null;
		if (userauthoritymoduloaccionBean != null)
			userauthoritymoduloaccion = prepareModel(userauthoritymoduloaccionBean);
		model.put("userauthoritymoduloaccions",
				prepareListofBean(userauthoritymoduloaccionService.listUserAuthorityModuloAccionss(userauthoritymoduloaccion)));
		return new ModelAndView("searchUserAuthorityModuloAccion", model);
	}

	@RequestMapping(value = "/entryUserAuthorityModuloAccion", method = RequestMethod.GET)
	public ModelAndView entryUserAuthorityModuloAccion() {
		return new ModelAndView("redirect:/searchUserAuthorityModuloAccion");
	}

	private UserAuthorityModuloAccion prepareModel(UserAuthorityModuloAccionBean userauthoritymoduloaccionBean) {
		UserAuthorityModuloAccion userauthoritymoduloaccion = new UserAuthorityModuloAccion();

		userauthoritymoduloaccion.setIdUserAuthorityModuloAccion(userauthoritymoduloaccionBean.getId());
		userauthoritymoduloaccion.setIdUserAuthority(userauthoritymoduloaccionBean.getIdUserAuthority());
		userauthoritymoduloaccion.setIdModuloAccion(userauthoritymoduloaccionBean.getIdModuloAccion());
		userauthoritymoduloaccion.setEstatus(userauthoritymoduloaccionBean.getEstatus());
		userauthoritymoduloaccion.setFechaCreacion(userauthoritymoduloaccionBean.getFechaCreacion());
		userauthoritymoduloaccion.setFechaModificacion(userauthoritymoduloaccionBean.getFechaModificacion());
		userauthoritymoduloaccion.setId(userauthoritymoduloaccionBean.getId());
		userauthoritymoduloaccionBean.setId(null);
		return userauthoritymoduloaccion;
	}

	private List<UserAuthorityModuloAccionBean> prepareListofBean(List<UserAuthorityModuloAccion> userauthoritymoduloaccions) {
		List<UserAuthorityModuloAccionBean> beans = null;
		if (userauthoritymoduloaccions != null && !userauthoritymoduloaccions.isEmpty()) {
			beans = new ArrayList<>();
			UserAuthorityModuloAccionBean bean = null;
			for (UserAuthorityModuloAccion userauthoritymoduloaccion : userauthoritymoduloaccions) {
				bean = new UserAuthorityModuloAccionBean();

                bean.setId(userauthoritymoduloaccion.getIdUserAuthorityModuloAccion());
                bean.setIdUserAuthority(userauthoritymoduloaccion.getIdUserAuthority());
                bean.setIdModuloAccion(userauthoritymoduloaccion.getIdModuloAccion());
                bean.setEstatus(userauthoritymoduloaccion.getEstatus());
                bean.setFechaCreacion(userauthoritymoduloaccion.getFechaCreacion());
                bean.setFechaModificacion(userauthoritymoduloaccion.getFechaModificacion());
				bean.setId(userauthoritymoduloaccion.getId());
				beans.add(bean);
			}
		}
		return beans;
	}

}


