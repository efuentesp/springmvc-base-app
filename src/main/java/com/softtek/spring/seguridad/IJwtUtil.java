package com.softtek.spring.seguridad;

import com.softtek.spring.seguridad.entity.User;

public interface IJwtUtil {
	
    public User parseToken(String token);
    public String generateToken(User u, String password);
    
}
