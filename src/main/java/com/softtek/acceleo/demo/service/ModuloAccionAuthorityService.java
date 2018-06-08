package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.exception.GenericException;

import java.util.List;

public interface ModuloAccionAuthorityService {

	public void addModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority) throws GenericException;

	public void editModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority);
	
	public List<ModuloAccionAuthority> listModuloAccionAuthorityss(ModuloAccionAuthority moduloaaccionauthority);

	public ModuloAccionAuthority getModuloAccionAuthority(int empid);
	
	public void deleteModuloAccionAuthority(ModuloAccionAuthority moduloaaccionauthority);
	
	public List<ModuloAccionAuthority> listModuloAccionAuthorityssQuery(ModuloAccionAuthority moduloaaccionauthority, String query, int page, int size);

	public List<ModuloAccionAuthority> listModuloAccionAuthoritysPagination(ModuloAccionAuthority moduloaaccionauthority, int page, int size);
	

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);
	
	public List<ModuloAccionAuthority> listModuloAccionAuthority(int idModuloAccion, int idAuthority);

	

	
}

