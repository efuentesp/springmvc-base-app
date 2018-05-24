package com.softtek.spring.seguridad.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.spring.seguridad.UserRepository;
import com.softtek.spring.seguridad.UserService;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> consultarUser(User user) {		
		return userRepository.consultarInformacionPorUsuario(user);
	}

}
