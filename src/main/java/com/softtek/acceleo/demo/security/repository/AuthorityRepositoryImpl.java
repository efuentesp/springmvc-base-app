package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
			Session session = sessionFactory.getCurrentSession();
			
			authority = (Authority) session.get(Authority.class, authoritoryId);
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
			criteria.add(Restrictions.eq("enabled", Boolean.TRUE)).addOrder(Order.asc("name")).list();
			
			lstAuthority = (List<Authority>) criteria.list();
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstAuthority;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Authority> listAuthorityss(Authority authority) {

		if (authority != null) {

			Authority authorityProxy = new Authority();







			return (List<Authority>) sessionFactory.getCurrentSession()
					.createCriteria(Authority.class)
					.add(Example.create(authorityProxy)).list();

		}

		return (List<Authority>) sessionFactory.getCurrentSession()
				.createCriteria(Authority.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<Authority> listAuthorityssQuery(Authority authority, String query, int page, int size) {
			//authorityProxy.set#columnsGrid(authority.get#columnsGrid());
			return (List<Authority>) sessionFactory.getCurrentSession()
					.createCriteria(Authority.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechamodificacion", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("idrol", "%" + query +"%")),Restrictions.like("rol", "%" + query +"%"))	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Authority> listAuthoritysPagination(Authority authority, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Authority>) sessionFactory.getCurrentSession()
				.createCriteria(Authority.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Authority.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Authority.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechamodificacion", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("idrol", "%" + query +"%")),Restrictions.like("rol", "%" + query +"%"))	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Authority.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Authority getAuthority(int empid) {
		return (Authority) sessionFactory.getCurrentSession().get(
				Authority.class, empid);
	}

	public void deleteAuthority(Authority authority) {
		sessionFactory.getCurrentSession().delete(authority);
	}

	@Override
	public void addAuthority(Authority authority) {
		sessionFactory.getCurrentSession().persist(authority);
		
	}

	@Override
	public void editAuthority(Authority authority) {
		sessionFactory.getCurrentSession().update(authority);
		
	}

}
