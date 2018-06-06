/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para invocar servicios del modulo de seguridad. 
 */
package com.softtek.spring.seguridad.controller;

import java.util.List;

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
import com.softtek.spring.seguridad.JwtAuthenticationProvider;
import com.softtek.spring.seguridad.UserBusiness;
import com.softtek.spring.seguridad.impl.AuthenticatedUser;

/**
 * Clase SeguridadController.
 * @author PSG.
 *
 */
@Controller
public class SeguridadController {
	private static final Logger logger = Logger.getLogger(SeguridadController.class);


	@Autowired
	JwtAuthenticationProvider jwtap;
	
	@Autowired
	UserBusiness userBsnss;
	
	/**
	 * Valida informacion del usuario es correcta, si la informacion es correcta, entonces se le deja autenticar exitosamente, 
	 * de lo contrario no se le permite la autenticacion.
	 * @param user.
	 * @return ResponseEntity<UserDetails>.
	 */
	@RequestMapping(value = "/api/authenticate", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> autenticarUser(@RequestBody User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		UserDetails userDetails = null;
		
		try {			
			userDetails = jwtap.validarAutenticacionUser(password, userName);
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Exito: Autenticación de usuario OK. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");        
	        
			return new ResponseEntity<>(userDetails, HttpStatus.OK);
		}catch(AuthenticationException ae) {
			userDetails = new AuthenticatedUser();
			logger.error("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Error: " + ae + " -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<>(userDetails, HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Consulta informacion del usuario.
	 * @param user.
	 * @return ResponseEntity<User>.
	 */
	@RequestMapping(value = "/api/users", method = RequestMethod.POST)
	public ResponseEntity<User> consultarInformacionUser(@RequestBody User user) {
		String userName = user.getUserName();
		
		List<User> lstUser = userBsnss.consultarInformacionUser(userName);
		if( lstUser == null || lstUser.isEmpty() ) {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ La informacion del usuario NO SE PUDO OBTENER. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
		}else {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ La informacion del usuario se obtuvo EXITOSAMENTE. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<>(lstUser.get(0), HttpStatus.OK);
		}
	}	
}
