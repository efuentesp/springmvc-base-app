package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.repository.AfiliadoRepository;
import com.softtek.acceleo.demo.service.AfiliadoService;


@Repository("authorityPrivilegeRepository")
@Rollback(false)
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Transactional
public class AuthorityPrivilegeRepositoryImpl implements AuthorityPrivilegeRepository{
	private static final Logger logger = Logger.getLogger(AuthorityPrivilegeRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
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
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.flush();
			session.update(authorityPrivilege);
		}catch(Exception e) {
			logger.info("Error ---->> ", e);
		}
	}

	@Override
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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

}