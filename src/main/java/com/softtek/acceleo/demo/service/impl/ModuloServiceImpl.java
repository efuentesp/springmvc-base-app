

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ModuloRepository;
import com.softtek.acceleo.demo.domain.Modulo;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.service.ModuloService;

@Service("moduloService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModuloServiceImpl implements ModuloService {
	private static final Logger logger = Logger.getLogger(ModuloServiceImpl.class);
	
	@Autowired
	private ModuloRepository moduloRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addModulo(Modulo modulo) {
		
		moduloRepository.addModulo(modulo);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editModulo(Modulo modulo) {
		
		moduloRepository.editModulo(modulo);
	}
	
	
	public List<Modulo> listModuloss(Modulo modulo) {

		return moduloRepository.listModuloss(modulo);
	}

	public Modulo getModulo(int empid) {

		return moduloRepository.getModulo(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteModulo(Modulo modulo) throws GenericException {
		logger.info("Entrando al deleteModulo");

		 moduloRepository.deleteModulo(modulo);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Modulo> listModulosPagination(Modulo modulo, int page, int size) {

		return moduloRepository.listModulosPagination(modulo, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return moduloRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return moduloRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return moduloRepository.getTotalRows();
	}

	


	public List<Modulo> listModulossQuery(Modulo modulo, String query, int page, int size) {

		return moduloRepository.listModulossQuery(modulo, query, page, size);
	}


	

	

}

