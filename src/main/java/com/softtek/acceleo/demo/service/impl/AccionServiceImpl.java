/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de las acciones. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AccionRepository;
import com.softtek.acceleo.demo.domain.Accion;
import com.softtek.acceleo.demo.service.AccionService;

/**
 * Clase AccionServiceImpl.
 * @author PSG.
 *
 */
@Service("accionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccionServiceImpl implements AccionService {

	@Autowired
	private AccionRepository accionRepository;

	/**
	 * Agrega una accion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAccion(Accion accion) {
		
		accionRepository.addAccion(accion);
	}

	/**
	 * Edita la informacion de una accion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAccion(Accion accion) {
		
		accionRepository.editAccion(accion);
	}
	
	/**
	 * Consulta informacion de las acciones.
	 */
	public List<Accion> listAccionss(Accion accion) {

		return accionRepository.listAccionss(accion);
	}

	/**
	 * Obtiene informacion de una accion.
	 */
	public Accion getAccion(int empid) {
		return accionRepository.getAccion(empid);
	}

	/**
	 * Elimina una accion.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAccion(Accion accion) {
		System.out.println("Entrando al deleteAccion");

		 accionRepository.deleteAccion(accion);
	}

	/**
	 * Obtine informacion de las acciones y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Accion> listAccionsPagination(Accion accion, int page, int size) {

		return accionRepository.listAccionsPagination(accion, page, size);
	}

	/**
	 * Contabiliza el numero de acciones encontradas.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return accionRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Contabiliza el numero de acciones encontradas.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return accionRepository.getTotalRows(query);
	}

	/**
	 * Contabiliza el numero de acciones encontradas.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return accionRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de las acciones.
	 */
	public List<Accion> listAccionssQuery(Accion accion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return accionRepository.listAccionssQuery(accion, query, page, size);
	}

}

