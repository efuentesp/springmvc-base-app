package com.softtek.spring.seguridad.impl;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.softtek.spring.seguridad.IJwtUtil;
import com.softtek.spring.seguridad.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component//JPB
public class JwtUtil implements IJwtUtil {
	private static final Logger logger = Logger.getLogger(JwtUtil.class);
	
	@Value("${jwt.secret}")
    private String secret;

    /**
     * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     * 
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
	@Override
    public User parseToken(String token) {
        try {
        	logger.info("Iniciando parseToken(...)");
        	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** password: " + this.secret);
        	logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_****** token: " + token);
        	
        	Claims body = null; 
        	try {
        		body = Jwts.parser()
        				.setSigningKey(secret.getBytes("UTF-8"))
        				.parseClaimsJws(token)
        				.getBody();
            
        		logger.info("body: " + body);
        	}catch(ExpiredJwtException e) {
        		logger.error("**** ExpiredJwtException JPB: " + e);
        	}catch(MalformedJwtException e) {
        		logger.error("**** MalformedJwtException JPB: " + e);
        	}catch(SignatureException e) {
        		logger.error("**** SignatureException JPB: " + e);
        	}catch(UnsupportedEncodingException e) {
        		logger.error("**** UnsupportedEncodingException JPB: " + e);
        	}

            User user = new User();
            user.setUsername(body.getSubject());
            user.setId(Long.parseLong((String) body.get("userId")));
            user.setRole((String) body.get("role"));            
            logger.info("Finalizando parseToken(...)");
            
            return user;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     * 
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
	@Override
    public String generateToken(User user, String password) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("userId", user.getId() + "");
        claims.put("role", user.getRole());
        
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
    }

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	/*
	private String generateToken(int id, String login, int role) {
		long EXPIRATION_TIME = 60000;
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);

	    //TODO generate key (or retrieve it from file/database?)
	    Key key;

	    String jwtToken = Jwts.builder()
	            .setSubject(login)
	            .setIssuer("my_company")
	            .setIssuedAt(now)
	            .setExpiration(new Date(nowMillis + EXPIRATION_TIME))
	            .claim("role", role)
	            .signWith(SignatureAlgorithm.HS512, key)
	            .compact();
	    return jwtToken;
	    }
	*/
	
	
}
