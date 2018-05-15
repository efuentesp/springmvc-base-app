

package com.softtek.acceleo.demo.wizard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.wizard.repository.AfiliadoRepository;
import com.softtek.acceleo.demo.wizard.domain.Afiliado;
import com.softtek.acceleo.demo.wizard.service.AfiliadoService;

@Service("afiliadoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AfiliadoServiceImpl implements AfiliadoService {

	@Autowired
	private AfiliadoRepository afiliadoRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAfiliado(Afiliado afiliado) {
		
		afiliadoRepository.addAfiliado(afiliado);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAfiliado(Afiliado afiliado) {
		
		afiliadoRepository.editAfiliado(afiliado);
	}
	
	
	public List<Afiliado> listAfiliados(Afiliado afiliado) {

		return afiliadoRepository.listAfiliados(afiliado);
	}

	public Afiliado getAfiliado(int empid) {

		return afiliadoRepository.getAfiliado(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAfiliado(Afiliado afiliado) {
		System.out.println("Entrando al deleteAfiliado");

		 afiliadoRepository.deleteAfiliado(afiliado);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size) {

		return afiliadoRepository.listAfiliadosPagination(afiliado, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return afiliadoRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return afiliadoRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return afiliadoRepository.getTotalRows();
	}

	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size) {
		// TODO Auto-generated method stub
		return afiliadoRepository.listAfiliadosQuery(afiliado, query, page, size);
	}

}

