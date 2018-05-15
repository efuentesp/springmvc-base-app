

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.SolicitudpensionRepository;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.service.SolicitudpensionService;

@Service("solicitudpensionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SolicitudpensionServiceImpl implements SolicitudpensionService {

	@Autowired
	private SolicitudpensionRepository solicitudpensionRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSolicitudpension(Solicitudpension solicitudpension) {
		
		solicitudpensionRepository.addSolicitudpension(solicitudpension);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editSolicitudpension(Solicitudpension solicitudpension) {
		
		solicitudpensionRepository.editSolicitudpension(solicitudpension);
	}
	
	
	public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension) {

		return solicitudpensionRepository.listSolicitudpensions(solicitudpension);
	}

	public Solicitudpension getSolicitudpension(int empid) {

		return solicitudpensionRepository.getSolicitudpension(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteSolicitudpension(Solicitudpension solicitudpension) {
		System.out.println("Entrando al deleteSolicitudpension");

		 solicitudpensionRepository.deleteSolicitudpension(solicitudpension);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size) {

		return solicitudpensionRepository.listSolicitudpensionsPagination(solicitudpension, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return solicitudpensionRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return solicitudpensionRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return solicitudpensionRepository.getTotalRows();
	}

	public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size) {
		// TODO Auto-generated method stub
		return solicitudpensionRepository.listSolicitudpensionsQuery(solicitudpension, query, page, size);
	}

}

