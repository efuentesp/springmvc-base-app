package com.softtek.spring.seguridad.impl;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 876174314876345573L;

	public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
