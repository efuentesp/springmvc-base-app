package com.softtek.acceleo.demo.security.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.service.AuthorityService;
import com.softtek.acceleo.demo.service.UserService;

@RestController
public class AuthorityController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private AuthorityPrivilegeRepository authorityPrivilegeRepository;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;
	
	Authority authority = new Authority();
	
	@PreAuthorize("hasRole('AUTHORITYSEARCH')")
	@RequestMapping(value = "/authority", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Authority> getAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Authority> listAuthority = null;

		if (query==null && _page == 0 ) {
       		//listAuthority = authorityService.listAuthorityss(authority);
			listAuthority = authorityService.listAuthoritys();
			rows = authorityService.getTotalRows();
		} else if (query!= null){
				listAuthority = authorityService.listAuthorityssQuery(authority, query, _page, 10);
				rows = authorityService.getTotalRowsSearch(query);
			
		} else if (_page != 0){
			listAuthority = authorityService.listAuthoritysPagination(authority, _page, 10);
			rows = authorityService.getTotalRows();
		} 	

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAuthority;
	}
	
	@PreAuthorize("hasRole('AUTHORITYSEARCH')")
	@RequestMapping(value = "/authority/catalog", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Authority> getAuthoritysCatalog(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	
		List<Authority> listAuthority = null;

       	listAuthority = authorityService.listAuthorityss(authority);	

		return listAuthority;
	}
	
	
	
	@RequestMapping(value = "/authority/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Authority getAuthority(@PathVariable("id") Long id) {
	        
	        authority.setIdAuthority(id);
	        
	        Authority authority = null;
	        authority = authorityService.getAuthority(id);
			return authority;
	 }



	 @RequestMapping(value = "/authority", method = RequestMethod.POST)
	 @PreAuthorize("hasRole('AUTHORITYSEARCH')")
	    public ResponseEntity<Void> createAuthority(@RequestBody Authority authority,    UriComponentsBuilder ucBuilder) {
	   
		 	authority.setCreationDate(new Date());
	        authorityService.addAuthority(authority);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/authority/{id}").buildAndExpand(authority.getIdAuthority()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/authority/{id}", method = RequestMethod.PUT)
	 @PreAuthorize("hasRole('AUTHORITYUPDATE')")
	    public ResponseEntity<Authority> actualizarAuthority(@PathVariable("id") Long id, @RequestBody Authority authority) {
	        
	        
	        Authority authorityFound = authorityService.getAuthority(id);
	         
	        if (authorityFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
	        }

	        
        	authorityFound.setIdAuthority(authority.getIdAuthority());
        	authorityFound.setName(authority.getName());
        	authorityFound.setEnabled(authority.getEnabled());
        	authorityFound.setCreationDate(new Date());
        	authorityFound.setModifiedDate(new Date());
	        
	        authorityService.editAuthority(authorityFound);	        
	        return new ResponseEntity<Authority>(authorityFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/authority/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('AUTHORITYDELETE')")
	    public ResponseEntity<Authority> deleteAuthority(@PathVariable("id") Long id) {
			 
	         Authority authority = authorityService.getAuthority(id);
	         if (authority == null) {
	             return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
	         }else {
		         try {
		        	 /**Antes de borrar un authority, se debe validar que no este asociado a usuarios. **/
		        	 List<UserAuthority> lstUserAuthority = userAuthorityRepository.findUserAuthorityByIdAuthority(authority);
		        	 
		        	 if( lstUserAuthority == null || lstUserAuthority.isEmpty() ) {
			        	 authorityPrivilegeRepository.deleteAuthorities(authority);
			        	 
			        	 authorityService.deleteAuthority(authority);
		            	 return new ResponseEntity<Authority>(HttpStatus.OK);		        		 
		        	 }else {
						logger.error("Error: El Authority no se puede eliminar debido a que esta asociado con usuarios.");
						throw new Exception("El Authority no se puede eliminar debido a que esta asociado con usuarios");
		        	 }
				} catch (Exception e) {
					logger.error("Error: ", e);
					return new ResponseEntity<Authority>(HttpStatus.PRECONDITION_FAILED);
				}
	         }			
		}
}


