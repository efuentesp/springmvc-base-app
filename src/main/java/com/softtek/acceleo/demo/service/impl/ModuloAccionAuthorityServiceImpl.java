

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.ModuloAccionAuthorityRepository;
import com.softtek.acceleo.demo.domain.ModuloAccion;
import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.service.ModuloAccionAuthorityService;

@Service("ModuloAccionAuthorityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModuloAccionAuthorityServiceImpl implements ModuloAccionAuthorityService {

	@Autowired
	private ModuloAccionAuthorityRepository ModuloAccionAuthorityRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority) {
		
		ModuloAccionAuthorityRepository.addModuloAccionAuthority(ModuloAccionAuthority);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority) {
		
		ModuloAccionAuthorityRepository.editModuloAccionAuthority(ModuloAccionAuthority);
	}
	
	
	public List<ModuloAccionAuthority> listModuloAccionAuthorityss(ModuloAccionAuthority ModuloAccionAuthority) {

		return ModuloAccionAuthorityRepository.listModuloAccionAuthorityss(ModuloAccionAuthority);
	}

	public ModuloAccionAuthority getModuloAccionAuthority(int empid) {

		return ModuloAccionAuthorityRepository.getModuloAccionAuthority(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority) {
		System.out.println("Entrando al deleteModuloAccionAuthority");

		 ModuloAccionAuthorityRepository.deleteModuloAccionAuthority(ModuloAccionAuthority);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<ModuloAccionAuthority> listModuloAccionAuthoritysPagination(ModuloAccionAuthority ModuloAccionAuthority, int page, int size) {

		return ModuloAccionAuthorityRepository.listModuloAccionAuthoritysPagination(ModuloAccionAuthority, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return ModuloAccionAuthorityRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return ModuloAccionAuthorityRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return ModuloAccionAuthorityRepository.getTotalRows();
	}

	


	public List<ModuloAccionAuthority> listModuloAccionAuthorityssQuery(ModuloAccionAuthority ModuloAccionAuthority, String query, int page, int size) {
		// TODO Auto-generated method stub
		return ModuloAccionAuthorityRepository.listModuloAccionAuthorityssQuery(ModuloAccionAuthority, query, page, size);
	}


	@Override
	public List<ModuloAccionAuthority> listModuloAccionAuthority(int idModuloAccion, int idAuthority) {
		return ModuloAccionAuthorityRepository.listModuloAccionAuthority(idModuloAccion, idAuthority);
	}

	

}

