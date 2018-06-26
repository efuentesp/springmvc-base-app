package com.softtek.acceleo.demo.security.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.acceleo.demo.domain.Group;

public class GroupRepositoryImpl implements GroupRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Group getGroup(int groupId) {
		return (Group) sessionFactory.getCurrentSession().get(Group.class, groupId);
	}

}
