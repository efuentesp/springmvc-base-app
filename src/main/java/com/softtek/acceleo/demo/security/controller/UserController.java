package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;



@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
		@Autowired
		private UserService userService;
		
		@Autowired
	    public PasswordEncoder passwordEncoder;
		@PreAuthorize("hasRole('MANAGESEARCH')")
	   @RequestMapping(value = "/usersList", method = RequestMethod.GET, produces = "application/json")
	    public @ResponseBody  List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {

			List<User> listUser = null;
	       	listUser = userService.listUserss();
	       	
//	       	Set<User> hs = new HashSet<User>();
//	       	hs.addAll(listUser);
//	       	listUser.clear();
//	       	listUser.addAll(hs);
	       	
	       	for (User u:listUser){	
	       		// Hay que decodificar el password
	       	}
	       	
	       	
			System.out.print("Conttroller - Cantidad" + listUser.size());
			System.out.print("Fin Conttroller - userList ");
			return listUser;
		}
	    
	    
	    /**
	    * Crea un nuevo usuario.
	    * @param afiliado.
	    * @param ucBuilder.
	    * @return ResponseEntity.
	    */

	    
	    @RequestMapping(value = "/users/{username}/{privileges}", method = RequestMethod.POST)
	    @PreAuthorize("hasRole('MANAGESEARCH')")
	        public ResponseEntity<Void> createAfiliado(@RequestBody User user, @PathVariable("username") String userName,  @PathVariable("privileges") String privileges, UriComponentsBuilder ucBuilder) {
	    	HttpStatus httpStatus = null;
	    	
	            user.setCreationDate(new Date()); 
	            user.setPassword(passwordEncoder.encode(user.getPassword()));
	            user.setUserName(userName);
	            user.setLastPasswordResetDate(new Date());
	            
	            List<Authority> auths = new ArrayList<>();
	            Authority auth = new Authority();
	            auth.setIdAuthority(new Long(privileges));
	            auths.add(auth);
	            
	            user.setAuthorities(auths);
	                
	            
	            try {
	            	userService.addUser(user);
	            	
	            	httpStatus = HttpStatus.CREATED;
	            }catch(HibernateException e) {
	            	logger.error("---->>> Error: ", e);
	            	httpStatus = HttpStatus.NOT_ACCEPTABLE;
	            }catch(Exception e) {
	            	logger.error("---->>> Error: ", e);
	            	httpStatus = HttpStatus.NOT_ACCEPTABLE;
	            }	            
	     
	            HttpHeaders headers = new HttpHeaders();
	            headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getIdUser()).toUri());
	            return new ResponseEntity<Void>(headers, httpStatus);
	    }
	    
		
		@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
		@PreAuthorize("hasRole('USERDELETE')")
	    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
			 
	         User user = userService.getUser(new Long(id));
	         if (user == null) {
	             return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	         }
	  
	         try {
	        	 userService.deleteUser(user);
            	 return new ResponseEntity<User>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<User>(HttpStatus.PRECONDITION_FAILED);
			}
			
		}
		
		 @RequestMapping(value = "/users/{id}/{username}/{privileges}/{flag}", method = RequestMethod.PUT)
		 @PreAuthorize("hasRole('MANAGESEARCH')")
		    public ResponseEntity<User> actualizarUser( @RequestBody User user, @PathVariable("id") int id, @PathVariable("username") String username,  
		    		@PathVariable("privileges") String privileges, @PathVariable("flag") Boolean flag) {
		        
		        User userFound = userService.getUser(new Long(id));
		         
		        if (userFound==null) {
		            System.out.println("User with id " + id + " not found");
		            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		        }

		        if (flag){
		        	String pass = passwordEncoder.encode(user.getPassword());
		        	user.setPassword(pass);
		        }
		       
		        try {
			        List<Authority> auths = new ArrayList<>();
	                Authority auth = new Authority();
	                auth.setIdAuthority(new Long(privileges));
	                auths.add(auth);
			        
			        userFound.setAuthorities(auths);
			        userFound.setCreationDate(new Date());
			        userFound.setEmail(user.getEmail());
			        userFound.setEnabled(user.getEnabled());
			        userFound.setFirstname(user.getFirstname());
			        userFound.setLastname(user.getLastname());
			        userFound.setLastPasswordResetDate(new Date());
			        userFound.setModifiedDate(new Date());
			        userFound.setUserName(username);
			        userFound.setIdUser(new Long(user.getIdUser()));
			        userFound.setPassword(user.getPassword());
			        
			        userService.editUser(userFound);
			        
			        return new ResponseEntity<User>(userFound, HttpStatus.OK);
		        }catch(Exception e) {
		        	return new ResponseEntity<User>(userFound, HttpStatus.NOT_ACCEPTABLE);
		        }
		  } 	
}
