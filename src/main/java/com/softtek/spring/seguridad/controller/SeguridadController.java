package com.softtek.spring.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.spring.seguridad.IJwtAuthenticationProvider;
import com.softtek.spring.seguridad.entity.User;
import com.softtek.spring.seguridad.impl.AuthenticatedUser;
import com.softtek.spring.seguridad.impl.JwtAuthenticationProvider;

@Controller
public class SeguridadController {

	@Autowired
	IJwtAuthenticationProvider jwtap;
	
	UserDetails userDetails;
	
	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> autenticarUser(@RequestBody User user) {
		System.out.println("Inicio Rest");
		
		String userName = user.getUsername();
		String password = user.getPassword();
		UserDetails userDetails = null;
		
		try {
			userDetails = jwtap.validarAutenticacionUser(password, userName);
			
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		}catch(AuthenticationException ae) {
			userDetails = new AuthenticatedUser();
			
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.NOT_FOUND);
		}
	}
	
}
