package com.softtek.spring.seguridad.impl;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.spring.seguridad.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtilImpl implements JwtUtil {
	private static final Logger logger = Logger.getLogger(JwtUtilImpl.class);
	
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
        	
        	Claims body = Jwts.parser()
        					.setSigningKey(secret.getBytes("UTF-8"))
        					.parseClaimsJws(token)
        					.getBody();

            User user = new User();
            user.setUserName(body.getSubject());
            user.setIdUser(Integer.parseInt((String) body.get("userId")));
            user.setRol((String) body.get("role"));            
            logger.info("Finalizando parseToken(...)");
            
            return user;

        } catch (JwtException | ClassCastException | UnsupportedEncodingException e) {
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
    public String generateToken(User user) throws UnsupportedEncodingException {
        Claims claims = Jwts.claims().setSubject(user.getUserName());
        claims.put("userId", user.getIdUser() + "");
        claims.put("role", user.getRol());
        
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, user.getPassword().getBytes("UTF-8"))
                .compact();
    }
	
	/**
	 * Genera un JWT token, con base al user, password, y el algoritmo que se pasan como paramentros.
	 * @param user - Contiene la información del usuario.
	 * @param sgntrAlgrtm - Algoritmo con el cual se genera el token.
	 * @return token.
	 * @throws UnsupportedEncodingException para manejar las posibles exceptions.
	 */
	@Override
	public String generarToken(User user, SignatureAlgorithm sgntrAlgrtm) throws UnsupportedEncodingException {
        Claims claims = Jwts.claims().setSubject(user.getUserName());
        claims.put("userId", user.getIdUser() + "");
        claims.put("role", user.getRol());
        
        return Jwts.builder()
                .setClaims(claims)
                .signWith(sgntrAlgrtm, user.getPassword().getBytes("UTF-8"))
                .compact();
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
	/**
	private String generateToken(int id, String login, int role) {
		long EXPIRATION_TIME = 60000;
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);


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
	/**/
	
	
}
