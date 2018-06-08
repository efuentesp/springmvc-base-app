
package com.softtek.acceleo.demo.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.ModuloAccionAuthority;
import com.softtek.acceleo.demo.exception.GenericException;

public interface ModuloAccionAuthorityRepository {

	
	 public void addModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority);   
	 
	 public void editModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority);
	   
	 public List<ModuloAccionAuthority> listModuloAccionAuthorityss(ModuloAccionAuthority ModuloAccionAuthority);   
	    
	 public ModuloAccionAuthority getModuloAccionAuthority(int empid);   
	    
	 public void deleteModuloAccionAuthority(ModuloAccionAuthority ModuloAccionAuthority); 

	 public List<ModuloAccionAuthority> listModuloAccionAuthorityssQuery(ModuloAccionAuthority ModuloAccionAuthority, String query, int page, int size);

	 public List<ModuloAccionAuthority> listModuloAccionAuthoritysPagination(ModuloAccionAuthority ModuloAccionAuthority, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

     public List<ModuloAccionAuthority> listModuloAccionAuthority(int idModuloAccion, int idAuthority);

 			

	
}

