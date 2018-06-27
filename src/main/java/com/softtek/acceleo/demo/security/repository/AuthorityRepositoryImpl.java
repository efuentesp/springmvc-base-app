package com.softtek.acceleo.demo.security.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Authority;

@Repository("authorityRepository")
public class AuthorityRepositoryImpl implements AuthorityRepository{
	private static final Logger logger = Logger.getLogger(AuthorityRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Authority getAuthority(long authoritoryId) {
		Authority authority = null;
		
		try {
			authority = (Authority) sessionFactory.getCurrentSession().get(Authority.class, authoritoryId);
		}catch(Exception e) {
			logger.error("---->> Error: ", e);
		}
		
		return authority;
	}

}
