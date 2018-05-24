package com.softtek.spring.seguridad;

import java.util.List;

import com.softtek.acceleo.demo.domain.User;

public interface UserService {
	public List<User> consultarUser(User user);
}
