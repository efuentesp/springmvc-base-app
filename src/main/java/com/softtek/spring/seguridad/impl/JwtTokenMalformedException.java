package com.softtek.spring.seguridad.impl;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component//JPB
public class JwtTokenMalformedException extends AuthenticationException {
    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
