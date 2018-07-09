

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.service.UserService;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private com.softtek.acceleo.demo.security.repository.UserRepository userRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) throws HibernateException {
		userRepository.addUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editUser(User user) {
		
		userRepository.editUser(user);
	}
	
	
	public List<User> listUserss() {
		System.out.print("listUserss Service");
		return userRepository.listUserss();
	}

	public User getUser(Long empid) {

		return userRepository.getUser(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUser(User user) {
		System.out.println("Entrando al deleteUser");

		 userRepository.deleteUser(user);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<User> listUsersPagination(User user, int page, int size) {

		return userRepository.listUsersPagination(user, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return userRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return userRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return userRepository.getTotalRows();
	}

	


	public List<User> listUserssQuery(User user, String query, int page, int size) {
		// TODO Auto-generated method stub
		return userRepository.listUserssQuery(user, query, page, size);
	}


	@Override
	public List<User> consultarUser(User user) {		
		return userRepository.consultarInformacionPorUsuario(user);
	}

	@Override
	public List<User> consultarUser(String userName) {
		return userRepository.consultarInformacionPorUsuario(userName);
	}
	

	

}

