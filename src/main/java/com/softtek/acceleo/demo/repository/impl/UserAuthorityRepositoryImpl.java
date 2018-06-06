
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.UserAuthorityRepository;

@Repository("userauthorityRepository")
public class UserAuthorityRepositoryImpl implements UserAuthorityRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUserAuthority(UserAuthority userauthority) {
		sessionFactory.getCurrentSession().persist(userauthority);
	}

	public void editUserAuthority(UserAuthority userauthority) {
		sessionFactory.getCurrentSession().update(userauthority);

	}

	@SuppressWarnings({ "unchecked" })
	public List<UserAuthority> listUserAuthorityss(UserAuthority userauthority) {

		if (userauthority != null) {

			UserAuthority userauthorityProxy = new UserAuthority();








			return (List<UserAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(UserAuthority.class)
					.add(Example.create(userauthorityProxy)).list();

		}

		return (List<UserAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(UserAuthority.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<UserAuthority> listUserAuthorityssQuery(UserAuthority userauthority, String query, int page, int size) {

			return (List<UserAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(UserAuthority.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("iduserauthority", "%" + query +"%"),Restrictions.like("iduser", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("idrol", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<UserAuthority> listUserAuthoritysPagination(UserAuthority userauthority, int page, int size) {

			return (List<UserAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(UserAuthority.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthority.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthority.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("iduserauthority", "%" + query +"%"),Restrictions.like("iduser", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("idrol", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthority.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public UserAuthority getUserAuthority(int empid) {
		return (UserAuthority) sessionFactory.getCurrentSession().get(
				UserAuthority.class, empid);
	}

	public void deleteUserAuthority(UserAuthority userauthority) throws GenericException {
		sessionFactory.getCurrentSession().delete(userauthority);
	}


	
	
	
}
