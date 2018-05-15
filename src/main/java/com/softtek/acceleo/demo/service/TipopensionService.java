package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Tipopension;
import java.util.List;

public interface TipopensionService {

	public void addTipopension(Tipopension tipopension);

	public void editTipopension(Tipopension tipopension);
	
	public List<Tipopension> listTipopensions(Tipopension tipopension);

	public Tipopension getTipopension(int empid);

	public void deleteTipopension(Tipopension tipopension);
	
	public List<Tipopension> listTipopensionsQuery(Tipopension tipopension, String query, int page, int size);

	public List<Tipopension> listTipopensionsPagination(Tipopension tipopension, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

