package com.softtek.spring.seguridad.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;
import com.softtek.spring.seguridad.UserBusiness;

@Component
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    UserService userService;
    
	@Override
	public List<User> consultarInformacionUser(String userName) {
		return userService.consultarUser(userName);
	}

}
