package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.UserAuthorityModuloAccion;
import com.softtek.acceleo.demo.exception.GenericException;

import java.util.List;

public interface UserAuthorityModuloAccionService {

	public void addUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion);

	public void editUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion);
	
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionss(UserAuthorityModuloAccion userauthoritymoduloaccion);

	public UserAuthorityModuloAccion getUserAuthorityModuloAccion(int empid);

	public void deleteUserAuthorityModuloAccion(UserAuthorityModuloAccion userauthoritymoduloaccion) throws GenericException;
	
	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionssQuery(UserAuthorityModuloAccion userauthoritymoduloaccion, String query, int page, int size);

	public List<UserAuthorityModuloAccion> listUserAuthorityModuloAccionsPagination(UserAuthorityModuloAccion userauthoritymoduloaccion, int page, int size);
	

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

	

	

	
}

