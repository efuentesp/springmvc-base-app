package com.softtek.spring.seguridad;

import java.io.UnsupportedEncodingException;

import com.softtek.acceleo.demo.domain.User;

import io.jsonwebtoken.SignatureAlgorithm;

public interface JwtUtil {
	
    public User parseToken(String token);
    public String generateToken(User user) throws UnsupportedEncodingException;
    public String generarToken(User user, SignatureAlgorithm sgntrAlgrtm) throws UnsupportedEncodingException;
    
}
