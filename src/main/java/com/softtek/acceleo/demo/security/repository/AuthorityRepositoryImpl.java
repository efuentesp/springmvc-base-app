package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.User;

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

	@Override
	public List<Authority> getAuthority() {
		List<Authority> lstAuthority = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Authority.class);
			criteria.add(Restrictions.eq("enabled", Boolean.TRUE)).list();
			
			lstAuthority = (List<Authority>) criteria.list();			
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstAuthority;
	}

}
