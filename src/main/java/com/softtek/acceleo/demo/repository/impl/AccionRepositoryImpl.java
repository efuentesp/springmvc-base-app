/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de las acciones. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Accion;
import com.softtek.acceleo.demo.repository.AccionRepository;

@Repository("accionRepository")
public class AccionRepositoryImpl implements AccionRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Agrega una accion.
	 */
	public void addAccion(Accion accion) {
		sessionFactory.getCurrentSession().persist(accion);
	}

	/**
	 * Edita una accion.
	 */
	public void editAccion(Accion accion) {
		sessionFactory.getCurrentSession().update(accion);

	}

	/**
	 * Consulta informacion de acciones.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Accion> listAccionss(Accion accion) {

		if (accion != null) {

			Accion accionProxy = new Accion();







			return (List<Accion>) sessionFactory.getCurrentSession()
					.createCriteria(Accion.class)
					.add(Example.create(accionProxy)).list();

		}

		return (List<Accion>) sessionFactory.getCurrentSession()
				.createCriteria(Accion.class).list();

	}


	/**
	 * Consulta informacion de acciones.
	 */
	@SuppressWarnings("unchecked")
	public List<Accion> listAccionssQuery(Accion accion, String query, int page, int size) {
			//accionProxy.set#columnsGrid(accion.get#columnsGrid());
			return (List<Accion>) sessionFactory.getCurrentSession()
					.createCriteria(Accion.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechacreacion", "%" + query +"%"),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("accion", "%" + query +"%")),Restrictions.like("idaccion", "%" + query +"%"))	
	
	
	
	
).list();
	}

	/**
	 * Consulta informacion de acciones, y pagina la informacion obtenida.
	 */
	@SuppressWarnings("unchecked")
	public List<Accion> listAccionsPagination(Accion accion, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Accion>) sessionFactory.getCurrentSession()
				.createCriteria(Accion.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de acciones consultadas.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accion.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de acciones consultadas.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accion.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fechacreacion", "%" + query +"%"),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("accion", "%" + query +"%")),Restrictions.like("idaccion", "%" + query +"%"))	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}

	/**
	 * Obtiene el numero de acciones consultadas.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Accion.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	
	/**
	 * Obtiene informacion de una accion.
	 */
	public Accion getAccion(int empid) {
		return (Accion) sessionFactory.getCurrentSession().get(
				Accion.class, empid);
	}

	/**
	 * Elimina una accion.
	 */
	public void deleteAccion(Accion accion) {
		sessionFactory.getCurrentSession().delete(accion);
	}


	
	
	
}
