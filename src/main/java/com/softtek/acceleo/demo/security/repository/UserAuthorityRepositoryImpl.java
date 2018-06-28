package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.domain.UserAuthority;

@Repository("userAuthorityRepository")
public class UserAuthorityRepositoryImpl implements UserAuthorityRepository{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<UserAuthority> findByUsername(User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserAuthority.class);
        //criteria.add(Restrictions.eq("idUser", user)).list();
		List<UserAuthority> userAuthority = (List<UserAuthority>) criteria.list();
		
		return userAuthority;
	}

	
}
