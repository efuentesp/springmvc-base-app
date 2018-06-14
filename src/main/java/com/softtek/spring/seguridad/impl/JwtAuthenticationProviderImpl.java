package com.softtek.spring.seguridad.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;
import com.softtek.spring.seguridad.JwtAuthenticationProvider;

@Component("jwtAuthenticationProvider")
public class JwtAuthenticationProviderImpl extends AbstractUserDetailsAuthenticationProvider implements JwtAuthenticationProvider {
	private static final Logger logger = Logger.getLogger(JwtAuthenticationProviderImpl.class);
	
    @Autowired
    private JwtUtilImpl jwtUtil;
    
    @Autowired
    UserService userService;
    
    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    	logger.info("Construyendo contenido del metodo...");
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    	
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();
        
        User parsedUser = jwtUtil.parseToken(token); 
        
        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid.");
        }
                
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRol());
        
        return new AuthenticatedUser(parsedUser.getIdUser(), parsedUser.getUserName(), jwtUtil.getSecret(), token, authorityList);
    }
    
	@Override
	public UserDetails validarAutenticacionUser(String password, String userName) throws AuthenticationException {
		jwtUtil.setSecret(password);//Password capturado en pantalla.
		
		String passwordToken = this.consultarTokenForUserName(userName);//El token se obtiene de base de datos.
						
		if( passwordToken != null ) {
			JwtAuthenticationToken jwtat = new JwtAuthenticationToken(passwordToken);
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** password: " + password);        	
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** passwordToken: " + passwordToken);		
		
	    	return this.retrieveUser(userName, jwtat);
		}else {			
			throw new AuthenticationCredentialsNotFoundException("JWT token don't exist.");
		}
	}
	
	/**
	 * Con base al nombre de usuario proporcionado, se obtine el token (password) del usuario.
	 * @param userName nombre del usuario.
	 * @return token.
	 */
	private String consultarTokenForUserName(String userName) {
		String token = null;
		
		User user = new User();
		user.setUserName(userName);
		
		List<User> lstUser = userService.consultarUser(user);
		
		if( lstUser != null && !lstUser.isEmpty() ) {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Numero de usuarios obtenido: " + lstUser.size() + " -_-_-_-_-_-_-_-_-_-_-_-_-_-_");

			token = lstUser.get(0).getPassword();
		}else {
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ No se obtuvo informacion para autenticar al usuario -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		}
		
		return token; 
	}
	
	/**
	 * Metodo para generar Tokens con base a la informacion del , de los password proporcionados.
	 * @param password Password proporcionado por el usuario que intenta autenticarse.
	 * @return Token del password proporcionado.
	 */
	@Override
	public String makerToken(String userName, String password, String rol) {
		String token = null;
		
    	User user = new User();
    	/**user.setIdUser(1);**/
    	user.setUserName(userName);
    	user.setPassword(password);
    	user.setRol(rol);
		
    	try {
	    	token = jwtUtil.generateToken(user);
	    	
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Id: " + user.getIdUser());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Username: " + user.getUserName());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Role: " + user.getRol());
    	}catch(UnsupportedEncodingException e) {
    		logger.error("Error: " + e);
    	}

		return token;
	}
	
	/**
	 * Metodo para generar tokens con base a la informacion del usuario. 
	 * @param user contiene informacion del usuario.
	 * @return Token del password proporcionado.
	 */
	@Override
	public String makerToken(User user) {
		String token = null;
				
    	try {
	    	token = jwtUtil.generateToken(user);
	    	
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Id: " + user.getIdUser());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Username: " + user.getUserName());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Role: " + user.getRol());
    	}catch(UnsupportedEncodingException e) {
    		logger.error("Error: " + e);
    	}

		return token;
	}
	
}
