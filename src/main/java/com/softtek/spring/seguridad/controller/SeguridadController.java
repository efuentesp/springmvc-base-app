package com.softtek.spring.seguridad.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.spring.seguridad.IJwtAuthenticationProvider;
import com.softtek.spring.seguridad.impl.AuthenticatedUser;

@Controller
public class SeguridadController {
	private static final Logger logger = Logger.getLogger(SeguridadController.class);


	@Autowired
	IJwtAuthenticationProvider jwtap;
	
	UserDetails userDetails;
	
	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> autenticarUser(@RequestBody User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		UserDetails userDetails = null;
		
		try {
			userDetails = jwtap.validarAutenticacionUser(password, userName);
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Exito: Autenticación de usuario OK. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");        
	        
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		}catch(AuthenticationException ae) {
			userDetails = new AuthenticatedUser();
			logger.error("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Error: " + ae + " -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.NOT_FOUND);
		}
	}
	
}
