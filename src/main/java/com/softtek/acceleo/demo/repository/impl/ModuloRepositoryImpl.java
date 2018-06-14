
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Modulo;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.ModuloRepository;

@Repository("moduloRepository")
public class ModuloRepositoryImpl implements ModuloRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addModulo(Modulo modulo) {
		sessionFactory.getCurrentSession().persist(modulo);
	}

	public void editModulo(Modulo modulo) {
		sessionFactory.getCurrentSession().update(modulo);

	}

	@SuppressWarnings({ "unchecked" })
	public List<Modulo> listModuloss(Modulo modulo) {

		if (modulo != null) {

			Modulo moduloProxy = new Modulo();







			return (List<Modulo>) sessionFactory.getCurrentSession()
					.createCriteria(Modulo.class)
					.add(Example.create(moduloProxy)).list();

		}

		return (List<Modulo>) sessionFactory.getCurrentSession()
				.createCriteria(Modulo.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<Modulo> listModulossQuery(Modulo modulo, String query, int page, int size) {

			return (List<Modulo>) sessionFactory.getCurrentSession()
					.createCriteria(Modulo.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idmodulo", "%" + query +"%"),Restrictions.like("modulo", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%"))	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Modulo> listModulosPagination(Modulo modulo, int page, int size) {

			return (List<Modulo>) sessionFactory.getCurrentSession()
				.createCriteria(Modulo.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Modulo.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Modulo.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idmodulo", "%" + query +"%"),Restrictions.like("modulo", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%"))	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Modulo.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Modulo getModulo(int empid) {
		return (Modulo) sessionFactory.getCurrentSession().get(
				Modulo.class, empid);
	}

	public void deleteModulo(Modulo modulo) throws GenericException {
		sessionFactory.getCurrentSession().delete(modulo);
	}

//	@Override
//	public List<Modulo> getModuloByUsername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	
	
}
