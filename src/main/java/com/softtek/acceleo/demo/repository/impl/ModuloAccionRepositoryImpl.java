
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

import com.softtek.acceleo.demo.domain.ModuloAccion;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.ModuloAccionRepository;

@Repository("moduloaccionRepository")
public class ModuloAccionRepositoryImpl implements ModuloAccionRepository {
	static final String ID_ACCION = "idaccion";
	static final String ID_MODULO = "idmodulo";

	@Autowired
	private SessionFactory sessionFactory;

	public void addModuloAccion(ModuloAccion moduloaccion) {
		sessionFactory.getCurrentSession().persist(moduloaccion);
	}

	public void editModuloAccion(ModuloAccion moduloaccion) {
		sessionFactory.getCurrentSession().update(moduloaccion);

	}

	@SuppressWarnings({ "unchecked" })
	public List<ModuloAccion> listModuloAccionss(ModuloAccion moduloaccion) {

		if (moduloaccion != null) {

			ModuloAccion moduloaccionProxy = new ModuloAccion();








			return (List<ModuloAccion>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloAccion.class)
					.add(Example.create(moduloaccionProxy)).list();

		}

		return (List<ModuloAccion>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloAccion.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<ModuloAccion> listModuloAccionssQuery(ModuloAccion moduloaccion, String query, int page, int size) {

			return (List<ModuloAccion>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloAccion.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like(ID_ACCION, "%" + query +"%"),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like(ID_MODULO, "%" + query +"%")),Restrictions.like("idmoduloaccion", "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<ModuloAccion> listModuloAccionsPagination(ModuloAccion moduloaccion, int page, int size) {

			return (List<ModuloAccion>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloAccion.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like(ID_ACCION, "%" + query +"%"),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like(ID_MODULO, "%" + query +"%")),Restrictions.like("idmoduloaccion", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloAccion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public ModuloAccion getModuloAccion(int empid) {
		return (ModuloAccion) sessionFactory.getCurrentSession().get(
				ModuloAccion.class, empid);
	}

	public void deleteModuloAccion(ModuloAccion moduloaccion) throws GenericException {
		sessionFactory.getCurrentSession().delete(moduloaccion);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ModuloAccion> listModuloAccion(int idModulo, int idAccion) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ModuloAccion.class);
		criteria.add(Restrictions.and(Restrictions.eq(ID_MODULO, idModulo), Restrictions.eq(ID_ACCION, idAccion))).list();
		List<ModuloAccion> lstModuloAccion = null;

		lstModuloAccion = (List<ModuloAccion>) criteria.list();
		
		return lstModuloAccion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuloAccion> listModuloAccion(int idModulo) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ModuloAccion.class);
		criteria.add(Restrictions.eq(ID_MODULO, idModulo)).list();
		List<ModuloAccion> lstModuloAccion = null;

		lstModuloAccion = (List<ModuloAccion>) criteria.list();
		
		return lstModuloAccion;
	}


	
	
	
}
