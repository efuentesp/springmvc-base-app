package com.softtek.spring.seguridad;

import java.util.List;

import com.softtek.acceleo.demo.domain.User;

public interface UserBusiness {
	
	List<User> consultarInformacionUser(String userName);
}
