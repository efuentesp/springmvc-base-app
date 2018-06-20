package com.softtek.acceleo.demo.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Profile;
import com.softtek.acceleo.demo.repository.ProfileRepository;

@Repository("profileRepository")
public class ProfileRepositoryImpl implements ProfileRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Profile getProfileByToken(String token) {
		return (Profile) sessionFactory.getCurrentSession().get(Profile.class, token);
	}

}
