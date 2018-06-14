
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.AuthorityRepository;

@Repository("authorityRepository")
public class AuthorityRepositoryImpl implements AuthorityRepository {

	static final String ROL = "rol";
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addAuthority(Authority authority) {
		sessionFactory.getCurrentSession().persist(authority);
	}

	public void editAuthority(Authority authority) {
		sessionFactory.getCurrentSession().update(authority);

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
			return (List<Authority>) sessionFactory.getCurrentSession()
					.createCriteria(Authority.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechamodificacion", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("idrol", "%" + query +"%")),Restrictions.like("rol", "%" + query +"%"))	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Authority> listAuthoritysPagination(Authority authority, int page, int size) {
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
	
	public List<Authority> getAuthorityByRol(String rol) {
		
		Session session = sessionFactory.getCurrentSession();
		session.clear();		
		Criteria criteria = session.createCriteria(Authority.class);
		criteria.add(Restrictions.eq(ROL, rol)).list();
		List<Authority> authorityList = null;

		authorityList = (List<Authority>) criteria.list();
		
		return authorityList;
		
		
	}
	
	
	public void deleteAuthority(Authority authority) throws GenericException {
		sessionFactory.getCurrentSession().delete(authority);
	}


	
	
	
}
