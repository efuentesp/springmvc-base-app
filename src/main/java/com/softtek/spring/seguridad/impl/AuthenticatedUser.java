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
	
	private final String id;
    private final String username;
    private final String password;
    private final String token;
    //private final Collection<? extends GrantedAuthority> authorities;
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
    public AuthenticatedUser(String id, String username, String password, String token, Collection</*? extends */GrantedAuthority> authorities) {
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
    public String getId() {
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
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Determina si la cuenta esta bloqueada.
     * @return boolean. (true -> no bloqueada, false -> bloqueada)
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Determina si la cuenta ha expirado.
     * @return boolean. (true -> no expirada, false -> expirada)
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Determina si el token esta habilitado.
     * @return boolean. (true -> habilitado, false -> deshabilitado)
     */
    @Override
    @JsonIgnore
    public boolean isEnabled() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Obtiene el token del usuario.
     * @return String.
     */
    protected String getToken() {
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
