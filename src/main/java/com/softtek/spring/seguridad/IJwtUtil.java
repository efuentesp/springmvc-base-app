package com.softtek.spring.seguridad;

import java.io.UnsupportedEncodingException;

import com.softtek.acceleo.demo.domain.User;

public interface IJwtUtil {
	
    public User parseToken(String token);
    public String generateToken(User u, String password) throws UnsupportedEncodingException;
    
}
