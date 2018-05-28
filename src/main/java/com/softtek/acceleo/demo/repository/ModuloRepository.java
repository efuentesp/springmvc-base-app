
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Modulo;

public interface ModuloRepository {

	
	 public void addModulo(Modulo modulo);   
	 
	 public void editModulo(Modulo modulo);
	   
	 public List<Modulo> listModuloss(Modulo modulo);   
	    
	 public Modulo getModulo(int empid);   
	    
	 public void deleteModulo(Modulo modulo); 

	 public List<Modulo> listModulossQuery(Modulo modulo, String query, int page, int size);

	 public List<Modulo> listModulosPagination(Modulo modulo, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

	

 			

	
}

