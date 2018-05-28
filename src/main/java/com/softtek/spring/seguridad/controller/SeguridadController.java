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

@Controller
public class SeguridadController {
	private static final Logger logger = Logger.getLogger(SeguridadController.class);


	@Autowired
	JwtAuthenticationProvider jwtap;
	
	@Autowired
	UserBusiness userBsnss;
	
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
	
	@RequestMapping(value = "/api/users", method = RequestMethod.POST)
	public ResponseEntity<User> consultarInformacionUser(@RequestBody User user) {
		String userName = user.getUserName();
		
		List<User> lstUser = userBsnss.consultarInformacionUser(userName);
		if( lstUser == null || lstUser.isEmpty() ) {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ La informacion del usuario NO SE PUDO OBTENER. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
		}else {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ La informacion del usuario se obtuvo EXITOSAMENTE. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			
			return new ResponseEntity<User>(lstUser.get(0), HttpStatus.OK);
		}
	}
	
	
/**
 * @RequestMapping(value = "/afiliado", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<Afiliado> getAfiliados(@RequestParam Map<String,String> requestParams, HttpServletRequest request, HttpServletResponse response) {

       	String query=requestParams.get("q");
		int _page= requestParams.get("_page")==null?0:new Integer(requestParams.get("_page")).intValue();
		long rows = 0;

		List<Afiliado> listAfiliado = null;

		if (query==null && _page == 0) {
       		listAfiliado = afiliadoService.listAfiliados(afiliado);
			rows = afiliadoService.getTotalRows();
		} else if (query!= null){
			listAfiliado = afiliadoService.listAfiliadosQuery(afiliado, query, _page, 10);
			rows = afiliadoService.getTotalRowsSearch(query);
		} else if (_page != 0){
			listAfiliado = afiliadoService.listAfiliadosPagination(afiliado, _page, 10);
			rows = afiliadoService.getTotalRows();
		}

		response.setHeader("Access-Control-Expose-Headers", "x-total-count");
		response.setHeader("x-total-count", String.valueOf(rows).toString());	

		return listAfiliado;
	}
	
 */
}
