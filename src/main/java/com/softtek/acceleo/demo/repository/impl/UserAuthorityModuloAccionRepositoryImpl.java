
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.UserAuthorityModuloAccion;
import com.softtek.acceleo.demo.repository.UserAuthorityModuloAccionRepository;

@Repository("userauthoritymoduloaccionRepository")
public class UserAuthorityModuloAccionRepositoryImpl implements UserAuthorityModuloAccionRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		sessionFactory.getCurrentSession().persist(userauthoritymoduloaccion);
	}

	public void editUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		sessionFactory.getCurrentSession().update(userauthoritymoduloaccion);

	}

	@SuppressWarnings({ "unchecked" })
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionss(UserAuthorityModuloAccion userauthoritymoduloaccion) {

		if (userauthoritymoduloaccion != null) {

			UserAuthorityModuloAccion userauthoritymoduloaccionProxy = new UserAuthorityModuloAccion();








			return (List<UserAuthorityModuloAccion>) sessionFactory.getCurrentSession()
					.createCriteria(UserAuthorityModuloAccion.class)
					.add(Example.create(userauthoritymoduloaccionProxy)).list();

		}

		return (List<UserAuthorityModuloAccion>) sessionFactory.getCurrentSession()
				.createCriteria(UserAuthorityModuloAccion.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionssQuery(UserAuthorityModuloAccion userauthoritymoduloaccion, String query, int page, int size) {
			//userauthoritymoduloaccionProxy.set#columnsGrid(userauthoritymoduloaccion.get#columnsGrid());
			return (List<UserAuthorityModuloAccion>) sessionFactory.getCurrentSession()
					.createCriteria(UserAuthorityModuloAccion.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idmoduloaccion", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("iduserauthority", "%" + query +"%")),Restrictions.like("iduserauthoritymoduloaccion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionsPagination(UserAuthorityModuloAccion userauthoritymoduloaccion, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<UserAuthorityModuloAccion>) sessionFactory.getCurrentSession()
				.createCriteria(UserAuthorityModuloAccion.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthorityModuloAccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthorityModuloAccion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idmoduloaccion", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("iduserauthority", "%" + query +"%")),Restrictions.like("iduserauthoritymoduloaccion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(UserAuthorityModuloAccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public UserAuthorityModuloAccion getUserAuthorityModuloAccion(int empid) {
		return (UserAuthorityModuloAccion) sessionFactory.getCurrentSession().get(
				UserAuthorityModuloAccion.class, empid);
	}

	public void deleteUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		sessionFactory.getCurrentSession().delete(userauthoritymoduloaccion);
	}


	
	
	
}
