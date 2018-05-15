
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.repository.SolicitudpensionRepository;

@Repository("solicitudpensionRepository")
public class SolicitudpensionRepositoryImpl implements SolicitudpensionRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().persist(solicitudpension);
	}

	public void editSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().update(solicitudpension);

	}

	@SuppressWarnings({ "unchecked" })
	public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension) {

		if (solicitudpension != null) {
			Solicitudpension solicitudpensionProxy = new Solicitudpension();
			return (List<Solicitudpension>) sessionFactory.getCurrentSession()
					.createCriteria(Solicitudpension.class)
					.add(Example.create(solicitudpensionProxy)).list();
		}

		return (List<Solicitudpension>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitudpension.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size) {
		
		return (List<Solicitudpension>) sessionFactory.getCurrentSession()
			.createCriteria(Solicitudpension.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("observaciones", "%" + query +"%"),
Restrictions.like("id", "%" + query +"%")),
Restrictions.like("afiliado", "%" + query +"%")),
Restrictions.like("tipopension", "%" + query +"%")),
Restrictions.like("numero", "%" + query +"%")),
Restrictions.like("fecha_solicitud", "%" + query +"%"))
					
					
					
					
					
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Solicitudpension>) sessionFactory.getCurrentSession()
				.createCriteria(Solicitudpension.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("observaciones", "%" + query +"%"),Restrictions.like("id", "%" + query +"%")),Restrictions.like("afiliado", "%" + query +"%")),Restrictions.like("tipopension", "%" + query +"%")),Restrictions.like("numero", "%" + query +"%")),Restrictions.like("fecha_solicitud", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Solicitudpension.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Solicitudpension getSolicitudpension(int empid) {
		return (Solicitudpension) sessionFactory.getCurrentSession().get(
				Solicitudpension.class, empid);
	}

	public void deleteSolicitudpension(Solicitudpension solicitudpension) {
		sessionFactory.getCurrentSession().delete(solicitudpension);
	}

}
