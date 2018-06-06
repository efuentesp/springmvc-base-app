/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios de los authority. 
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


import com.softtek.acceleo.demo.catalogo.bean.AuthorityBean;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.AuthorityService;

/**
 * Clase AuthorityController.
 * @author PSG.
 *
 */
@Controller
public class AuthorityController {
	private static final Logger logger = Logger.getLogger(AuthorityController.class);
	
	@Autowired
	private AuthorityService authorityService;
	
		@RequestMapping(value = "/authority", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Authority> getAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {
		Authority authority = new Authority();
			
       	String query=requestParams.get("q");
		int page= requestParams.get("_page")==null?0:Integer.parseInt(requestParams.get("_page"));
		long rows = 0;

		

		List<Authority> listAuthority = null;

		if (query==null && page == 0 ) {
       		listAuthority = authorityService.listAuthorityss(authority);
			rows = authorityService.getTotalRows();
		} else if (query!= null){
				listAuthority = authorityService.listAuthorityssQuery(authority, query, page, 10);
				rows = authorityService.getTotalRowsSearch(query);
			
		} else /**if (page != 0)**/{
			listAuthority = authorityService.listAuthoritysPagination(authority, page, 10);
			rows = authorityService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows));	

		return listAuthority;
	}
	
	@RequestMapping(value = "/authority/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Authority getAuthority(@PathVariable("id") int id) {
	        Authority authority = null;
	        
	        authority = authorityService.getAuthority(id);
			return authority;
	 }



	 @RequestMapping(value = "/authority", method = RequestMethod.POST)
	    public ResponseEntity<Void> createAuthority(@RequestBody Authority authority,    UriComponentsBuilder ucBuilder) {
	   
	        authorityService.addAuthority(authority);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/authority/{id}").buildAndExpand(authority.getIdRol()).toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/authority/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Authority> actualizarAuthority(@PathVariable("id") int id, @RequestBody Authority authority) {
	        
	        
	        Authority authorityFound = authorityService.getAuthority(id);
	         
	        if (authorityFound==null) {
	            logger.info("User with id " + id + " not found");
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	 
				authorityFound.setIdRol(authority.getIdRol());
				authorityFound.setRol(authority.getRol());
				authorityFound.setEstatus(authority.getEstatus());
				authorityFound.setFechaCreacion(authority.getFechaCreacion());
				authorityFound.setFechaModificacion(authority.getFechaModificacion());
	        
	        authorityService.editAuthority(authorityFound);
	        return new ResponseEntity<>(authorityFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/authority/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Authority> deleteAuthority(@PathVariable("id") int id) {
	    	 logger.info("Fetching & Deleting User with id " + id);
	    	 
             try {
    	         Authority authority = authorityService.getAuthority(id);
    	         if (authority == null) {
    	             logger.info("Unable to delete. Cuenta with id " + id + " not found");
    	             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	         }
            	 
	             authorityService.deleteAuthority(authority);
            	 return new ResponseEntity<>(HttpStatus.OK);
             }catch(GenericException e) {
            	 return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
             }
			
		}


	@RequestMapping(value = "/saveAuthority", method = RequestMethod.POST)
	public @ResponseBody String saveAuthority(
			@ModelAttribute("command") AuthorityBean authorityBean) {


		Authority authority = prepareModel(authorityBean);
		authorityService.addAuthority(authority);

		return "SUCCESS";
	}
	
	@RequestMapping(value = "/editAuthority", method = RequestMethod.POST)
	public @ResponseBody String editAuthority(
			@ModelAttribute("command") AuthorityBean authorityBean) {


		Authority authority = prepareModel(authorityBean);
		authorityService.editAuthority(authority);
		return "SUCCESS";
	}

	@RequestMapping(value = "/searchAuthority", method = RequestMethod.GET)
	public ModelAndView addAuthority(
			@ModelAttribute("command") AuthorityBean authorityBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<>();
		Authority authority = null;
		if (authorityBean != null)
			authority = prepareModel(authorityBean);
		model.put("authoritys",
				prepareListofBean(authorityService.listAuthorityss(authority)));
		return new ModelAndView("searchAuthority", model);
	}

	@RequestMapping(value = "/entryAuthority", method = RequestMethod.GET)
	public ModelAndView entryAuthority() {
		return new ModelAndView("redirect:/searchAuthority");
	}

	private Authority prepareModel(AuthorityBean authorityBean) {
		Authority authority = new Authority();

		authority.setIdRol(authorityBean.getIdrol());
		authority.setRol(authorityBean.getRol());
		authority.setEstatus(authorityBean.getEstatus());
		authority.setFechaCreacion(authorityBean.getFechaCreacion());
		authority.setFechaModificacion(authorityBean.getFechaModificacion());
		return authority;
	}

	private List<AuthorityBean> prepareListofBean(List<Authority> authoritys) {
		List<AuthorityBean> beans = null;
		if (authoritys != null && !authoritys.isEmpty()) {
			beans = new ArrayList<>();
			AuthorityBean bean = null;
			for (Authority authority : authoritys) {
				bean = new AuthorityBean();

                bean.setIdrol(authority.getIdRol());
                bean.setRol(authority.getRol());
                bean.setEstatus(authority.getEstatus());
                bean.setFechaCreacion(authority.getFechaCreacion());
                bean.setFechaModificacion(authority.getFechaModificacion());
				beans.add(bean);
			}
		}
		return beans;
	}

}


