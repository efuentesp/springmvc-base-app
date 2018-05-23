package com.softtek.spring.seguridad.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component("authenticatedUser")//JPB
public class AuthenticatedUser implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6690681491291701161L;
	
	private final Long id;
    private final String username;
    private final String password;
    private final String token;
    //private final Collection<? extends GrantedAuthority> authorities;
    private final Collection<GrantedAuthority> authorities;
    
    public AuthenticatedUser() {
    	this.id = null;
    	this.username = null;
    	this.token = null;
    	this.password = null;
    	this.authorities = null;
    }

    public AuthenticatedUser(Long id, String username, String password, String token, Collection</*? extends */GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
    	if( this.token != null && !this.token.isEmpty() ) {
    		return true;
    	}else {
    		return false;
    	}
    }

    public String getToken() {
        return token;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
    	return authorities;
    }

    
    @Override
    public String getPassword() {
        return this.password;
    }



}
