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
import com.softtek.acceleo.demo.service.TipopensionService;
import com.softtek.spring.seguridad.IJwtAuthenticationProvider;
import com.softtek.spring.seguridad.UserService;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements IJwtAuthenticationProvider {
	private static final Logger logger = Logger.getLogger(JwtAuthenticationProvider.class);
	
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    UserService userService;
    
    @Autowired
    TipopensionService tipopensionService;

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
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
	public String generateToken(User user, String password) throws UnsupportedEncodingException {
		return jwtUtil.generateToken(user, password);
	}
    
	@Override
	public UserDetails validarAutenticacionUser(String password, String userName) throws AuthenticationException {
		jwtUtil.setSecret(password);//Se pasa como parametro, el password capturado en pantalla, mismo que se debe autenticar.
		
		//Este password se debe obtener de la base de datos. (En base al userName)
		//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDEiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.NFc5EVE_N0BeuEDgkq7EBe5uDkkJg3UZSZ3naV-jUfYG-3veyz3n_zye6g4vb058AwlCTVD_r5vdDFarpNF5-w";//user01
		//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDIiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.lCVVfVgFlMq7FIRUHZs9adC2YrmgOJ5MdcDbvdjQh9FD53AC8mLqgFr_PND5uvGWBUU7nPGhYsu46GB1sxJwMw";//user02
		//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDMiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.Yx78P6YRQcJkiA04ldaWqUjtxTyiZOPztBpbVkoUKabiC_A2U7jKT0IAE1FigKYy1jrUCjsnooEqwkWp6SO4BQ";//user03		
		//String passwordToken = makerToken(userName, password);//No borrar estas lineas, se ocupan para generar token de pruebas JUnit cuando no se conoce el token del password.
		String passwordToken = this.consultarTokenForUserName(userName);//Se obtiene de base de datos el token del usuario, la informacion se obtine al userName proporcionado.
						
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
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Numero de usuarios obtenido: " + lstUser.size() + " -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		
		if( lstUser != null && !lstUser.isEmpty() ) {
			token = lstUser.get(0).getPassword();
		}
		
		return token; 
	}
	
	/**
	 * Metodo implementado en fase de pruebas JUnit, para generar Tokens, de los password proporcionados.
	 * @param password Password proporcionado por el usuario que intenta autenticarse.
	 * @return Token del password proporcionado.
	 */
	@Override
	public String makerToken(String userName, String password) {
		String token = null;
		
    	User user = new User();
    	user.setIdUser("1");
    	user.setUserName(userName);
    	user.setRol("Administrador");
		
    	try {
	    	token = jwtUtil.generateToken(user, password);//El password que se pasa como parametro, es el capturado en pantalla.
	    	
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Id: " + user.getIdUser());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Username: " + user.getUserName());
	    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Role: " + user.getRol());
    	}catch(UnsupportedEncodingException e) {
    		logger.error("Error: " + e);
    	}

		return token;
	}
}
