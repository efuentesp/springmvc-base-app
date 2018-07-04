package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.service.AuthorityService;

@Controller
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	Authority authority = new Authority();

	@RequestMapping(value = "/authority", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Authority> getAuthoritys(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		

		List<Authority> listAuthority = null;

		if (query==null && _page == 0 ) {
       		listAuthority = authorityService.listAuthorityss(authority);
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
	
	@RequestMapping(value = "/authority/{id}", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  Authority getAuthority(@PathVariable("id") Long id) {
	        
	        authority.setIdAuthority(id);
	        
	        Authority authority = null;
	        authority = authorityService.getAuthority(id);
			return authority;
	 }



	 @RequestMapping(value = "/authority", method = RequestMethod.POST)
	    public ResponseEntity<Void> createAuthority(@RequestBody Authority authority,    UriComponentsBuilder ucBuilder) {
	   
		 	System.out.println("Valor:"+ authority.getName());
		 	System.out.println("Valor:"+ authority.getIdAuthority());
		 	System.out.println("Valor:"+ authority.getEnabled());
		 	authority.setCreationDate(new Date());
	        authorityService.addAuthority(authority);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/authority/{id}").buildAndExpand(authority.getIdAuthority()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
		
	 @RequestMapping(value = "/authority/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Authority> actualizarAuthority(@PathVariable("id") Long id, @RequestBody Authority authority) {
	        
	        
	        Authority authorityFound = authorityService.getAuthority(id);
	         
	        if (authorityFound==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
	        }

	        //****
        	authorityFound.setIdAuthority(authority.getIdAuthority());
        	authorityFound.setName(authority.getName());
        	authorityFound.setEnabled(authority.getEnabled());
        	authorityFound.setCreationDate(authority.getCreationDate());
        	authorityFound.setModifiedDate(authority.getModifiedDate());
	        
	        authorityService.editAuthority(authorityFound);	        
	        return new ResponseEntity<Authority>(authorityFound, HttpStatus.OK);
	  } 	
	
		
		@RequestMapping(value = "/authority/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Authority> deleteAuthority(@PathVariable("id") Long id) {
	    	 System.out.println("Fetching & Deleting User with id " + id);
			 
	         Authority authority = authorityService.getAuthority(id);
	         if (authority == null) {
	             System.out.println("Unable to delete. Cuenta with id " + id + " not found");
	             return new ResponseEntity<Authority>(HttpStatus.NOT_FOUND);
	         }
	  

	         try {
	        	 authorityService.deleteAuthority(authority);
            	 return new ResponseEntity<Authority>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Authority>(HttpStatus.PRECONDITION_FAILED);
			}
			
		}
}


