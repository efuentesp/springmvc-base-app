
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Solicitudpension;
import com.softtek.acceleo.demo.exception.GenericException;

public interface SolicitudpensionRepository {

	
	 public void addSolicitudpension(Solicitudpension solicitudpension);   
	 
	 public void editSolicitudpension(Solicitudpension solicitudpension);
	   
	 public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension);   
	    
	 public Solicitudpension getSolicitudpension(int empid);   
	    
	 public void deleteSolicitudpension(Solicitudpension solicitudpension) throws GenericException; 

	 public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size);

	 public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

}

