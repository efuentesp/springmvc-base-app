/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1
 * Clase para encapsular informacion de AuthenticatedUser. 
 */
package com.softtek.spring.seguridad.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase AuthenticatedUser.
 * @author PSG.
 *
 */
@Component("authenticatedUser")
public class AuthenticatedUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6690681491291701161L;
	
	private final Integer id;
    private final String username;
    private final String password;
    private final String token;
    private final Collection<GrantedAuthority> authorities;
    
    /**
     * Constructor por default de la clase AuthenticatedUser.
     */
    public AuthenticatedUser() {
    	this.id = null;
    	this.username = null;
    	this.token = null;
    	this.password = null;
    	this.authorities = null;
    }

    /**
     * Constructor con parametros de la clase AuthenticatedUser.
     * @param id.
     * @param username.
     * @param password.
     * @param token.
     * @param authorities.
     */
    public AuthenticatedUser(Integer id, String username, String password, String token, Collection</*? extends */GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.authorities = authorities;
    }

    /**
     * Obtiene el id del user autenticado.
     * @return String.
     */
    @JsonIgnore
    public Integer getId() {
        return id;
    }

    /**
     * Asigna el id del user autenticado.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Determina si la cuenta esta expirada.
     * @return boolean. (true -> no expirada, false -> expirada)
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
    	boolean nonExpired = true;
    	
    	if( this.token == null || this.token.isEmpty() ) {
    		nonExpired = false;
    	}

    	return nonExpired;
    }

    /**
     * Determina si la cuenta esta bloqueada.
     * @return boolean. (true -> no bloqueada, false -> bloqueada)
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
    	boolean nonLocked = true;
    	
    	if( this.token == null || this.token.isEmpty() ) {
    		nonLocked = false;
    	}

    	return nonLocked;
    }

    /**
     * Determina si la cuenta ha expirado.
     * @return boolean. (true -> no expirada, false -> expirada)
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
    	boolean credentialsNonExpired = true;
    	
    	if( this.token == null || this.token.isEmpty() ) {
    		credentialsNonExpired = false;
    	}

    	return credentialsNonExpired;
    }

    /**
     * Determina si el token esta habilitado.
     * @return boolean. (true -> habilitado, false -> deshabilitado)
     */
    @Override
    @JsonIgnore
    public boolean isEnabled() {
    	boolean enabled = true;
    	
    	if( this.token == null || this.token.isEmpty() ) {
    		enabled = false;
    	}

    	return enabled;
    }

    /**
     * Obtiene el token del usuario.
     * @return String.
     */
    public String getToken() {
        return token;
    }

    /**
     * Obtiene los roles relacionados al usuario autenticado.
     * @return Collection<GrantedAuthority>.  
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
    	return authorities;
    }

    /**
     * Obtiene el password del usuario autenticado.
     * @return String.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

}
