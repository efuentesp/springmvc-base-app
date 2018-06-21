/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los afiliados. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.AfiliadoRepository;
import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.service.AfiliadoService;

/**
 * Clase AfiliadoServiceImpl.
 * @author PSG.
 *
 */
@Service("afiliadoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AfiliadoServiceImpl implements AfiliadoService {

	@Autowired
	private AfiliadoRepository afiliadoRepository;

	/**
	 * Agrega un afiliado.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAfiliado(Afiliado afiliado) {
		
		afiliadoRepository.addAfiliado(afiliado);
	}

	/**
	 * Edita un afiliado.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAfiliado(Afiliado afiliado) {
		
		afiliadoRepository.editAfiliado(afiliado);
	}
	
	/**
	 * Consulta informacion de afiliados.
	 */
	public List<Afiliado> listAfiliados(Afiliado afiliado) {

		return afiliadoRepository.listAfiliados(afiliado);
	}

	/**
	 * Obtiene informacion de un afiliado.
	 */
	public Afiliado getAfiliado(int empid) {

		return afiliadoRepository.getAfiliado(empid);
	}

	/**
	 * Elimina un afiliado.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAfiliado(Afiliado afiliado) {
		System.out.println("Entrando al deleteAfiliado");

		 afiliadoRepository.deleteAfiliado(afiliado);
	}

	/**
	 * Consulta informacion de afiliados y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size) {

		return afiliadoRepository.listAfiliadosPagination(afiliado, page, size);
	}

	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return afiliadoRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return afiliadoRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de afiliados consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return afiliadoRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los afiliados y la pagina.
	 */
	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size) {
		// TODO Auto-generated method stub
		return afiliadoRepository.listAfiliadosQuery(afiliado, query, page, size);
	}

}

