

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AccionRepository;
import com.softtek.acceleo.demo.domain.Accion;
import com.softtek.acceleo.demo.service.AccionService;

@Service("accionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccionServiceImpl implements AccionService {

	@Autowired
	private AccionRepository accionRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAccion(Accion accion) {
		
		accionRepository.addAccion(accion);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAccion(Accion accion) {
		
		accionRepository.editAccion(accion);
	}
	
	
	public List<Accion> listAccionss(Accion accion) {

		return accionRepository.listAccionss(accion);
	}

	public Accion getAccion(int empid) {

		return accionRepository.getAccion(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAccion(Accion accion) {
		System.out.println("Entrando al deleteAccion");

		 accionRepository.deleteAccion(accion);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Accion> listAccionsPagination(Accion accion, int page, int size) {

		return accionRepository.listAccionsPagination(accion, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return accionRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return accionRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return accionRepository.getTotalRows();
	}

	


	public List<Accion> listAccionssQuery(Accion accion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return accionRepository.listAccionssQuery(accion, query, page, size);
	}


	

	

}

