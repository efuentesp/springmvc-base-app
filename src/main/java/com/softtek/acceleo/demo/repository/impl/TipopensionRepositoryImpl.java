
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.repository.TipopensionRepository;

@Repository("tipopensionRepository")
public class TipopensionRepositoryImpl implements TipopensionRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().persist(tipopension);
	}

	public void editTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().update(tipopension);

	}

	@SuppressWarnings({ "unchecked" })
	public List<Tipopension> listTipopensions(Tipopension tipopension) {

		if (tipopension != null) {
			Tipopension tipopensionProxy = new Tipopension();
			return (List<Tipopension>) sessionFactory.getCurrentSession()
					.createCriteria(Tipopension.class)
					.add(Example.create(tipopensionProxy)).list();
		}

		return (List<Tipopension>) sessionFactory.getCurrentSession()
				.createCriteria(Tipopension.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Tipopension> listTipopensionsQuery(Tipopension tipopension, String query, int page, int size) {
		
		return (List<Tipopension>) sessionFactory.getCurrentSession()
			.createCriteria(Tipopension.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(	
Restrictions.like("nombre", "%" + query +"%"),
Restrictions.like("clave", "%" + query +"%")),
Restrictions.like("id", "%" + query +"%"))
					
					
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Tipopension> listTipopensionsPagination(Tipopension tipopension, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Tipopension>) sessionFactory.getCurrentSession()
				.createCriteria(Tipopension.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(	
						Restrictions.like("nombre", "%" + query +"%"),Restrictions.like("clave", "%" + query +"%")),Restrictions.like("id", "%" + query +"%"))	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Tipopension.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Tipopension getTipopension(int empid) {
		return (Tipopension) sessionFactory.getCurrentSession().get(
				Tipopension.class, empid);
	}

	public void deleteTipopension(Tipopension tipopension) {
		sessionFactory.getCurrentSession().delete(tipopension);
	}

}
