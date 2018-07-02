package com.softtek.acceleo.demo.security.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.security.JwtUserFactory;
import com.softtek.acceleo.demo.security.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	
    	logger.info("loadUSerByUsername"+username);
    	
        User user = userRepository.findByUsername(username);

        if (user == null) {
        	logger.info("Throw UsernameNotFoundException");
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        	logger.info("Create user");
            return JwtUserFactory.create(user);
        }
    }
}
