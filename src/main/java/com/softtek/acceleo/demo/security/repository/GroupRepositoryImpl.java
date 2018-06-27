package com.softtek.acceleo.demo.security.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.acceleo.demo.domain.Grupo;

public class GroupRepositoryImpl implements GroupRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Grupo getGroup(int groupId) {
		return (Grupo) sessionFactory.getCurrentSession().get(Grupo.class, groupId);
	}

}
