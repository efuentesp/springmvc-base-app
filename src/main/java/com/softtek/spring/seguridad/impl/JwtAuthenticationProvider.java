package com.softtek.spring.seguridad.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.spring.seguridad.IJwtAuthenticationProvider;
import com.softtek.spring.seguridad.entity.User;

@Component
//@Service("jwtAuthenticationProvider")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements IJwtAuthenticationProvider {
	private static final Logger logger = Logger.getLogger(JwtAuthenticationProvider.class);
	
    @Autowired
    private JwtUtil jwtUtil;

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
            throw new JwtTokenMalformedException("<<<****** JWT token is not valid ******>>>");
        }else {
        	logger.info("<<<****** JWT token is valid ******>>>");
        }
        
        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());        
        
        return new AuthenticatedUser(parsedUser.getId(), parsedUser.getUsername(), jwtUtil.getSecret(), token, authorityList);
    }
    
	@Override
	public String generateToken(User user, String password) {
		return jwtUtil.generateToken(user, password);
	}
    
	@Override
	public UserDetails validarAutenticacionUser(String password, String userName) throws AuthenticationException {
		jwtUtil.setSecret(password);//Se pasa como parametro, el password capturado en pantalla, mismo que se debe autenticar.
		
		//Este password se debe obtener de la base de datos. (En base al userName)
		String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.n5g85bI6-q7ElL5nh8wV-W4oVdUcbPKQQxal7G3O_OUbnIZzYa8ZTEmljgFh0V4rB9BC9Nkuxqr1yVUaowkJgA";//user01
		//String passwordToken = makerToken(userName, password);//No borrar esta linea, se ocupa para generar token de pruebas JUnit.
		
		JwtAuthenticationToken jwtat = new JwtAuthenticationToken(passwordToken);
    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** password: " + password);        	
    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** passwordToken: " + passwordToken);		
		
    	return this.retrieveUser(userName, jwtat);
	}
	
	/**
	 * Metodo implementado en fase de pruebas JUnit, para generar Tokens, de los password proporcionados.
	 * @param password Password proporcionado por el usuario que intenta autenticarse.
	 * @return Token del password proporcionado.
	 */
	private String makerToken(String userName, String password) {
    	User user = new User();
    	user.setId(1L);
    	user.setUsername(userName);
    	user.setRole("Administrador"); 
		
    	String token = jwtUtil.generateToken(user, password);//El password que se pasa como parametro, es el capturado en pantalla.
    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Id: " + user.getId());
    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Username: " + user.getUsername());
    	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** user.Role: " + user.getRole());    	

		return token;
	}
}
