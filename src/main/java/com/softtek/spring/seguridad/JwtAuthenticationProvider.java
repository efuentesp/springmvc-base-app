package com.softtek.spring.seguridad;

import org.springframework.security.core.userdetails.UserDetails;

import com.softtek.acceleo.demo.domain.User;

import java.io.UnsupportedEncodingException;

import org.springframework.security.core.AuthenticationException;

public interface JwtAuthenticationProvider {
	
    public boolean supports(Class<?> authentication);
    
    public UserDetails validarAutenticacionUser(String password, String userName) throws AuthenticationException;
    
    public String makerToken(String userName, String password);
}
