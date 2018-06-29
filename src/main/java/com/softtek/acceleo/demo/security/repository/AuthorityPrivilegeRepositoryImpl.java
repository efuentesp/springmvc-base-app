package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;

@Repository("authorityPrivilegeRepository")
public class AuthorityPrivilegeRepositoryImpl implements AuthorityPrivilegeRepository{
	private static final Logger logger = Logger.getLogger(AuthorityPrivilegeRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AuthorityPrivilege> getAuthorityPrivilege() {
		List<AuthorityPrivilege> lstAuthorityPrivilege = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(AuthorityPrivilege.class);
			lstAuthorityPrivilege = (List<AuthorityPrivilege>) criteria.list();
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstAuthorityPrivilege;
	}

	@Override
	public void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		sessionFactory.getCurrentSession().update(authorityPrivilege);
		
	}

	@Override
	public void insertAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		try {
			sessionFactory.getCurrentSession().persist(authorityPrivilege);
		}catch(Exception e) {
			logger.error("Error ---->> ", e);
		}
	}

}