package com.softtek.spring.seguridad.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4022408732638433319L;
	
	private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
