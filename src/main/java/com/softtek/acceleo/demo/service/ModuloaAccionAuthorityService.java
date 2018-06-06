package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.ModuloaAccionAuthority;
import java.util.List;

public interface ModuloaAccionAuthorityService {

	public void addModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority);

	public void editModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority);
	
	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityss(ModuloaAccionAuthority moduloaaccionauthority);

	public ModuloaAccionAuthority getModuloaAccionAuthority(int empid);

	public void deleteModuloaAccionAuthority(ModuloaAccionAuthority moduloaaccionauthority);
	
	public List<ModuloaAccionAuthority> listModuloaAccionAuthorityssQuery(ModuloaAccionAuthority moduloaaccionauthority, String query, int page, int size);

	public List<ModuloaAccionAuthority> listModuloaAccionAuthoritysPagination(ModuloaAccionAuthority moduloaaccionauthority, int page, int size);
	

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

	

	

	
}

