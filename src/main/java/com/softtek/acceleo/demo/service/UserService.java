package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.User;
import java.util.List;

import org.hibernate.HibernateException;

public interface UserService {

	public void addUser(User user) throws HibernateException;

	public void editUser(User user);
	
	public List<User> listUserss();

	public User getUser(Long empid);

	public void deleteUser(User user);
	
	public List<User> listUserssQuery(User user, String query, int page, int size);

	public List<User> listUsersPagination(User user, int page, int size);
	

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

	
	public List<User> consultarUser(User user);
	public List<User> consultarUser(String userName);

	

	
}

