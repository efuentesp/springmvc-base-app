
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.ModuloAccion;
import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.ModuloAccionAuthorityRepository;

@Repository("moduloaaccionauthorityRepository")
public class ModuloAccionAuthorityRepositoryImpl implements ModuloAccionAuthorityRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	static final String ID_AUTHORITY = "idauthority";
	static final String ID_MODULOACCION = "idmoduloaccion";

	public void addModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority) throws GenericException {
		try {
			sessionFactory.getCurrentSession().persist(moduloaaccionauthority);
		}catch(HibernateException e) {
			throw new GenericException("Error", e);
		}
	}

	public void editModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority) {
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.update(moduloaaccionauthority);

	}

	@SuppressWarnings({ "unchecked" })
	public List<ModuloAccionAuthority> listModuloAccionAuthorityss(ModuloAccionAuthority moduloaaccionauthority) {

		if (moduloaaccionauthority != null) {

			ModuloAccionAuthority moduloaaccionauthorityProxy = new ModuloAccionAuthority();








			return (List<ModuloAccionAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloAccionAuthority.class)
					.add(Example.create(moduloaaccionauthorityProxy)).list();

		}

		return (List<ModuloAccionAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloAccionAuthority.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<ModuloAccionAuthority> listModuloAccionAuthorityssQuery(ModuloAccionAuthority moduloaaccionauthority, String query, int page, int size) {
			//moduloaaccionauthorityProxy.set#columnsGrid(moduloaaccionauthority.get#columnsGrid());
			return (List<ModuloAccionAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloAccionAuthority.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idauthority", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("idmoduloaccion", "%" + query +"%")),Restrictions.like("idmoduloaccionauthority", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<ModuloAccionAuthority> listModuloAccionAuthoritysPagination(ModuloAccionAuthority moduloaaccionauthority, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<ModuloAccionAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloAccionAuthority.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccionAuthority.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccionAuthority.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idauthority", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("idmoduloaccion", "%" + query +"%")),Restrictions.like("idmoduloaccionauthority", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccionAuthority.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	public ModuloAccionAuthority getModuloAccionAuthority(int empid) {
		return (ModuloAccionAuthority) sessionFactory.getCurrentSession().get(
				ModuloAccionAuthority.class, empid);
	}
	
	public void deleteModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority) {
		sessionFactory.getCurrentSession().delete(moduloaaccionauthority);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuloAccionAuthority> listModuloAccionAuthority(int idModuloAccion, int idAuthority){
		Session session = sessionFactory.getCurrentSession();
		session.clear();		
		Criteria criteria = session.createCriteria(ModuloAccionAuthority.class);
		criteria.add(Restrictions.and(Restrictions.eq(ID_MODULOACCION, idModuloAccion), Restrictions.eq(ID_AUTHORITY, idAuthority))).list();
		List<ModuloAccionAuthority> lstModuloAccionAuthority = null;

		lstModuloAccionAuthority = (List<ModuloAccionAuthority>) criteria.list();
		
		return lstModuloAccionAuthority;
	}


}
