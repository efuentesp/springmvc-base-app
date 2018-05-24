package com.softtek.spring.seguridad;

import java.util.List;

import com.softtek.acceleo.demo.domain.User;

public interface UserRepository {
	public List<User> consultarInformacionPorUsuario(User user);
	
	public List<User> consultarInformacionPorUsuario2(User user);
}
