
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.ModuloaAccionAuthority;
import com.softtek.acceleo.demo.repository.ModuloaAccionAuthorityRepository;

@Repository("moduloaaccionauthorityRepository")
public class ModuloaAccionAuthorityRepositoryImpl implements ModuloaAccionAuthorityRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		sessionFactory.getCurrentSession().persist(moduloaaccionauthority);
	}

	public void editModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		sessionFactory.getCurrentSession().update(moduloaaccionauthority);

	}

	@SuppressWarnings({ "unchecked" })
	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityss(ModuloaAccionAuthority moduloaaccionauthority) {

		if (moduloaaccionauthority != null) {

			ModuloaAccionAuthority moduloaaccionauthorityProxy = new ModuloaAccionAuthority();








			return (List<ModuloaAccionAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloaAccionAuthority.class)
					.add(Example.create(moduloaaccionauthorityProxy)).list();

		}

		return (List<ModuloaAccionAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloaAccionAuthority.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityssQuery(ModuloaAccionAuthority moduloaaccionauthority, String query, int page, int size) {
			//moduloaaccionauthorityProxy.set#columnsGrid(moduloaaccionauthority.get#columnsGrid());
			return (List<ModuloaAccionAuthority>) sessionFactory.getCurrentSession()
					.createCriteria(ModuloaAccionAuthority.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("idauthority", "%" + query +"%"),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("idmoduloaccion", "%" + query +"%")),Restrictions.like("idmoduloaccionauthority", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<ModuloaAccionAuthority> listModuloaAccionAuthoritysPagination(ModuloaAccionAuthority moduloaaccionauthority, int page, int size) {
			//cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
			return (List<ModuloaAccionAuthority>) sessionFactory.getCurrentSession()
				.createCriteria(ModuloaAccionAuthority.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloaAccionAuthority.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(ModuloaAccionAuthority.class).setProjection(Projections.rowCount())
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
		.createCriteria(ModuloaAccionAuthority.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public ModuloaAccionAuthority getModuloaAccionAuthority(int empid) {
		return (ModuloaAccionAuthority) sessionFactory.getCurrentSession().get(
				ModuloaAccionAuthority.class, empid);
	}

	public void deleteModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		sessionFactory.getCurrentSession().delete(moduloaaccionauthority);
	}


	
	
	
}
