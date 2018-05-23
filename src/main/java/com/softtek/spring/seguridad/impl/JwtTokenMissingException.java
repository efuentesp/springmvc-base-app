package com.softtek.spring.seguridad.impl;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component//JPB
public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
