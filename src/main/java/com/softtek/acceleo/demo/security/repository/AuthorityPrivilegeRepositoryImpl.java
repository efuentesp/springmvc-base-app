package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;


@Repository("authorityPrivilegeRepository")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthorityPrivilegeRepositoryImpl implements AuthorityPrivilegeRepository{
	private static final Logger logger = Logger.getLogger(AuthorityPrivilegeRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
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
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.flush();
			session.update(authorityPrivilege);
		}catch(HibernateException e) {
			logger.info("Error ---->> ", e);
		}catch(Exception e) {
			logger.info("Error ---->> ", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insertAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.flush();
			session.persist(authorityPrivilege);
		}catch(Exception e) {
			logger.error("Error ---->> ", e);
		}
	}

	@Override
	public AuthorityPrivilege getAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		AuthorityPrivilege autPriv = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(AuthorityPrivilege.class);
			criteria.add(Restrictions.and(Restrictions.eq("idAuthority", authorityPrivilege.getIdAuthority()) , 
					                      Restrictions.eq("idPrivilege", authorityPrivilege.getIdPrivilege())));
			
			List<AuthorityPrivilege> lstAuthorityPrivilege = (List<AuthorityPrivilege>) criteria.list();
			
			if( lstAuthorityPrivilege != null && !lstAuthorityPrivilege.isEmpty() ) {
				autPriv = lstAuthorityPrivilege.get(0); 
			}
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return autPriv;
	}
	
	@Override
	public void deleteAuthority(AuthorityPrivilege authorityPrivilege) {
		sessionFactory.getCurrentSession().delete(authorityPrivilege);
	}
	
	@Override
	public void deleteAuthorities(Authority authority) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from AuthorityPrivilege where idAuthority.idAuthority = :idAuthority";
		Query query = null;
		
	    query = session.createQuery(hql);
	    query.setLong("idAuthority", authority.getIdAuthority());
	    query.executeUpdate(); 			
	}

	@Override
	public List<AuthorityPrivilege> getAuthorityPrivilegePorIdAuthority(Authority authority) {
		List<AuthorityPrivilege> lstAuthorityPrivilege = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(AuthorityPrivilege.class);
			criteria.add(Restrictions.eq("idAuthority.idAuthority", authority.getIdAuthority()));
			
			lstAuthorityPrivilege = (List<AuthorityPrivilege>) criteria.list();			
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstAuthorityPrivilege;
	}
	
	

}
