
package com.softtek.acceleo.demo.wizard.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.wizard.domain.Afiliado;
import com.softtek.acceleo.demo.wizard.repository.AfiliadoRepository;

@Repository("afiliadoRepository")
public class AfiliadoRepositoryImpl implements AfiliadoRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().persist(afiliado);
	}

	public void editAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().update(afiliado);

	}

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


	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size) {
			//afiliadoProxy.set#columnsGrid(afiliado.get#columnsGrid());
			return (List<Afiliado>) sessionFactory.getCurrentSession()
					.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("apellido_materno", "%" + query +"%"),Restrictions.like("fecha_afiliacion", "%" + query +"%")),Restrictions.like("email", "%" + query +"%")),Restrictions.like("genero", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("semanas_cotizadas", "%" + query +"%")),Restrictions.like("acta_nacimiento", "%" + query +"%")),Restrictions.like("decimal", "%" + query +"%")),Restrictions.like("foto", "%" + query +"%")),Restrictions.like("apellido_paterno", "%" + query +"%")),Restrictions.like("observaciones", "%" + query +"%")),Restrictions.like("monto_pension", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("nss", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Afiliado>) sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("apellido_materno", "%" + query +"%"),Restrictions.like("fecha_afiliacion", "%" + query +"%")),Restrictions.like("email", "%" + query +"%")),Restrictions.like("genero", "%" + query +"%")),Restrictions.like("beneficiario", "%" + query +"%")),Restrictions.like("semanas_cotizadas", "%" + query +"%")),Restrictions.like("acta_nacimiento", "%" + query +"%")),Restrictions.like("decimal", "%" + query +"%")),Restrictions.like("foto", "%" + query +"%")),Restrictions.like("apellido_paterno", "%" + query +"%")),Restrictions.like("observaciones", "%" + query +"%")),Restrictions.like("monto_pension", "%" + query +"%")),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("nss", "%" + query +"%"))	
	
	
	
	
	
	
	
	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Afiliado.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Afiliado getAfiliado(int empid) {
		return (Afiliado) sessionFactory.getCurrentSession().get(
				Afiliado.class, empid);
	}

	public void deleteAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().delete(afiliado);
	}

}
