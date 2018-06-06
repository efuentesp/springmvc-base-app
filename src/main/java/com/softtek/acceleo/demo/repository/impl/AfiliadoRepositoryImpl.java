/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar consultas de los afiliados. 
 */
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.AfiliadoRepository;

/**
 * Clase AfiliadoRepositoryImpl.
 * @author PSG.
 *
 */
@Repository("afiliadoRepository")
public class AfiliadoRepositoryImpl implements AfiliadoRepository {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Agrega un afiliado.
	 */
	public void addAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().persist(afiliado);
	}

	/**
	 * Edita un afiliado.
	 */
	public void editAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().update(afiliado);

	}

	/**
	 * Consulta informacion de afiliados.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Afiliado> listAfiliados(Afiliado afiliado) {

		if (afiliado != null) {
			Afiliado afiliadoProxy = new Afiliado();
			return (List<Afiliado>) sessionFactory.getCurrentSession()
					.createCriteria(Afiliado.class)
					.add(Example.create(afiliadoProxy)).list();
		}

		return (List<Afiliado>) sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class).list();
	}

	/**
	 * Consulta informacion de afiliados y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size) {
		
		return (List<Afiliado>) sessionFactory.getCurrentSession()
			.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("genero", "%" + query +"%"),
Restrictions.like("apellido_paterno", "%" + query +"%")),
Restrictions.like("nss", "%" + query +"%")),
Restrictions.like("acta_nacimiento", "%" + query +"%")),
Restrictions.like("apellido_materno", "%" + query +"%")),
Restrictions.like("foto", "%" + query +"%")),
Restrictions.like("semanas_cotizadas", "%" + query +"%")),
Restrictions.like("fecha_afiliacion", "%" + query +"%")),
Restrictions.like("beneficiario", "%" + query +"%")),
Restrictions.like("correo", "%" + query +"%")),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("observaciones", "%" + query +"%")),
Restrictions.like("monto_pension", "%" + query +"%"))
					
					
					
					
					
					
					
					
					
					
					
					
).list();
	}


	/**
	 * Consulta informacion de afiliados y la pagina.
	 */
	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size) {
			return (List<Afiliado>) sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("genero", "%" + query +"%"),Restrictions.like("apellido_paterno", "%" + query +"%")),Restrictions.like("nss", "%" + query +"%")),Restrictions.like("acta_nacimiento", "%" + query +"%")),Restrictions.like("apellido_materno", "%" + query +"%")),Restrictions.like("foto", "%" + query +"%")),Restrictions.like("semanas_cotizadas", "%" + query +"%")),Restrictions.like("fecha_afiliacion", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("correo", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("observaciones", "%" + query +"%")),Restrictions.like("monto_pension", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	/**
	 * Consulta informacion de un afiliado.
	 */
	public Afiliado getAfiliado(int empid) {
		return (Afiliado) sessionFactory.getCurrentSession().get(
				Afiliado.class, empid);
	}

	/**
	 * Elimina un afiliado.
	 */
	public void deleteAfiliado(Afiliado afiliado)  throws GenericException {
		sessionFactory.getCurrentSession().delete(afiliado);
	}

}
