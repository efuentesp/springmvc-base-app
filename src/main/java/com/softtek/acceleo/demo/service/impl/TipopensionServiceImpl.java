

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.TipopensionRepository;
import com.softtek.acceleo.demo.domain.Tipopension;
import com.softtek.acceleo.demo.service.TipopensionService;

@Service("tipopensionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TipopensionServiceImpl implements TipopensionService {

	@Autowired
	private TipopensionRepository tipopensionRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTipopension(Tipopension tipopension) {
		
		tipopensionRepository.addTipopension(tipopension);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editTipopension(Tipopension tipopension) {
		
		tipopensionRepository.editTipopension(tipopension);
	}
	
	
	public List<Tipopension> listTipopensions(Tipopension tipopension) {

		return tipopensionRepository.listTipopensions(tipopension);
	}

	public Tipopension getTipopension(int empid) {

		return tipopensionRepository.getTipopension(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTipopension(Tipopension tipopension) {
		System.out.println("Entrando al deleteTipopension");

		 tipopensionRepository.deleteTipopension(tipopension);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Tipopension> listTipopensionsPagination(Tipopension tipopension, int page, int size) {

		return tipopensionRepository.listTipopensionsPagination(tipopension, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return tipopensionRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return tipopensionRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return tipopensionRepository.getTotalRows();
	}

	public List<Tipopension> listTipopensionsQuery(Tipopension tipopension, String query, int page, int size) {
		// TODO Auto-generated method stub
		return tipopensionRepository.listTipopensionsQuery(tipopension, query, page, size);
	}

}

