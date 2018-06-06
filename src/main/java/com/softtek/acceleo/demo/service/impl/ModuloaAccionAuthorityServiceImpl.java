

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ModuloaAccionAuthorityRepository;
import com.softtek.acceleo.demo.domain.ModuloaAccionAuthority;
import com.softtek.acceleo.demo.service.ModuloaAccionAuthorityService;

@Service("moduloaaccionauthorityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModuloaAccionAuthorityServiceImpl implements ModuloaAccionAuthorityService {

	@Autowired
	private ModuloaAccionAuthorityRepository moduloaaccionauthorityRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		
		moduloaaccionauthorityRepository.addModuloaAccionAuthority(moduloaaccionauthority);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		
		moduloaaccionauthorityRepository.editModuloaAccionAuthority(moduloaaccionauthority);
	}
	
	
	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityss(ModuloaAccionAuthority moduloaaccionauthority) {

		return moduloaaccionauthorityRepository.listModuloaAccionAuthorityss(moduloaaccionauthority);
	}

	public ModuloaAccionAuthority getModuloaAccionAuthority(int empid) {

		return moduloaaccionauthorityRepository.getModuloaAccionAuthority(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority) {
		System.out.println("Entrando al deleteModuloaAccionAuthority");

		 moduloaaccionauthorityRepository.deleteModuloaAccionAuthority(moduloaaccionauthority);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<ModuloaAccionAuthority> listModuloaAccionAuthoritysPagination(ModuloaAccionAuthority moduloaaccionauthority, int page, int size) {

		return moduloaaccionauthorityRepository.listModuloaAccionAuthoritysPagination(moduloaaccionauthority, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return moduloaaccionauthorityRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return moduloaaccionauthorityRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return moduloaaccionauthorityRepository.getTotalRows();
	}

	


	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityssQuery(ModuloaAccionAuthority moduloaaccionauthority, String query, int page, int size) {
		// TODO Auto-generated method stub
		return moduloaaccionauthorityRepository.listModuloaAccionAuthorityssQuery(moduloaaccionauthority, query, page, size);
	}


	

	

}

