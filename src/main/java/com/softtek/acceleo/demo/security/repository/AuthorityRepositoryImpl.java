package com.softtek.acceleo.demo.security.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.acceleo.demo.security.model.Authority;

public class AuthorityRepositoryImpl implements AuthorityRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Authority getAuthority(int authoritoryId) {
		return (Authority) sessionFactory.getCurrentSession().get(Authority.class, authoritoryId);
	}

}
