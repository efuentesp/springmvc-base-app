package com.softtek.spring.seguridad;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.AuthenticationException;

import com.softtek.spring.seguridad.entity.User;

public interface IJwtAuthenticationProvider {
	
    public boolean supports(Class<?> authentication);
    
    public String generateToken(User user, String password);
    
    public UserDetails validarAutenticacionUser(String password, String userName) throws AuthenticationException;
}
