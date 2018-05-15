package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Solicitudpension;
import java.util.List;

public interface SolicitudpensionService {

	public void addSolicitudpension(Solicitudpension solicitudpension);

	public void editSolicitudpension(Solicitudpension solicitudpension);
	
	public List<Solicitudpension> listSolicitudpensions(Solicitudpension solicitudpension);

	public Solicitudpension getSolicitudpension(int empid);

	public void deleteSolicitudpension(Solicitudpension solicitudpension);
	
	public List<Solicitudpension> listSolicitudpensionsQuery(Solicitudpension solicitudpension, String query, int page, int size);

	public List<Solicitudpension> listSolicitudpensionsPagination(Solicitudpension solicitudpension, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

