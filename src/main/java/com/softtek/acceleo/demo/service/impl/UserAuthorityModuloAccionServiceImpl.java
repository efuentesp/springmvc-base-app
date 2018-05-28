

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.UserAuthorityModuloAccionRepository;
import com.softtek.acceleo.demo.domain.UserAuthorityModuloAccion;
import com.softtek.acceleo.demo.service.UserAuthorityModuloAccionService;

@Service("userauthoritymoduloaccionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserAuthorityModuloAccionServiceImpl implements UserAuthorityModuloAccionService {

	@Autowired
	private UserAuthorityModuloAccionRepository userauthoritymoduloaccionRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		
		userauthoritymoduloaccionRepository.addUserAuthorityModuloAccion(userauthoritymoduloaccion);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		
		userauthoritymoduloaccionRepository.editUserAuthorityModuloAccion(userauthoritymoduloaccion);
	}
	
	
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionss(UserAuthorityModuloAccion userauthoritymoduloaccion) {

		return userauthoritymoduloaccionRepository.listUserAuthorityModuloAccionss(userauthoritymoduloaccion);
	}

	public UserAuthorityModuloAccion getUserAuthorityModuloAccion(int empid) {

		return userauthoritymoduloaccionRepository.getUserAuthorityModuloAccion(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) {
		System.out.println("Entrando al deleteUserAuthorityModuloAccion");

		 userauthoritymoduloaccionRepository.deleteUserAuthorityModuloAccion(userauthoritymoduloaccion);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionsPagination(UserAuthorityModuloAccion userauthoritymoduloaccion, int page, int size) {

		return userauthoritymoduloaccionRepository.listUserAuthorityModuloAccionsPagination(userauthoritymoduloaccion, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return userauthoritymoduloaccionRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return userauthoritymoduloaccionRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return userauthoritymoduloaccionRepository.getTotalRows();
	}

	


	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionssQuery(UserAuthorityModuloAccion userauthoritymoduloaccion, String query, int page, int size) {
		// TODO Auto-generated method stub
		return userauthoritymoduloaccionRepository.listUserAuthorityModuloAccionssQuery(userauthoritymoduloaccion, query, page, size);
	}


	

	

}

