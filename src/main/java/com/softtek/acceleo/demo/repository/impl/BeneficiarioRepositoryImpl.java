
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.repository.BeneficiarioRepository;

@Repository("beneficiarioRepository")
public class BeneficiarioRepositoryImpl implements BeneficiarioRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().persist(beneficiario);
	}

	public void editBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().update(beneficiario);

	}

	@SuppressWarnings({ "unchecked" })
	public List<Beneficiario> listBeneficiarios(Beneficiario beneficiario) {

		if (beneficiario != null) {
			Beneficiario beneficiarioProxy = new Beneficiario();
			return (List<Beneficiario>) sessionFactory.getCurrentSession()
					.createCriteria(Beneficiario.class)
					.add(Example.create(beneficiarioProxy)).list();
		}

		return (List<Beneficiario>) sessionFactory.getCurrentSession()
				.createCriteria(Beneficiario.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Beneficiario> listBeneficiariosQuery(Beneficiario beneficiario, String query, int page, int size) {
		
		return (List<Beneficiario>) sessionFactory.getCurrentSession()
			.createCriteria(Beneficiario.class).setFirstResult((page - 1) * size)
			.add(					
					Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
Restrictions.like("fecha_nacimiento", "%" + query +"%"),
Restrictions.like("nombre", "%" + query +"%")),
Restrictions.like("apellido_paterno", "%" + query +"%")),
Restrictions.like("parentesco", "%" + query +"%")),
Restrictions.like("curp", "%" + query +"%")),
Restrictions.like("apellido_materno", "%" + query +"%"))
					
					
					
					
					
).list();
	}


	@SuppressWarnings("unchecked")
	public List<Beneficiario> listBeneficiariosPagination(Beneficiario beneficiario, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<Beneficiario>) sessionFactory.getCurrentSession()
				.createCriteria(Beneficiario.class).setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("fecha_nacimiento", "%" + query +"%"),Restrictions.like("nombre", "%" + query +"%")),Restrictions.like("apellido_paterno", "%" + query +"%")),Restrictions.like("parentesco", "%" + query +"%")),Restrictions.like("curp", "%" + query +"%")),Restrictions.like("apellido_materno", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(Beneficiario.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public Beneficiario getBeneficiario(int empid) {
		return (Beneficiario) sessionFactory.getCurrentSession().get(
				Beneficiario.class, empid);
	}

	public void deleteBeneficiario(Beneficiario beneficiario) {
		sessionFactory.getCurrentSession().delete(beneficiario);
	}

}
