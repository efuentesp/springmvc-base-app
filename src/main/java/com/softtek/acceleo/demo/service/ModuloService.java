package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Modulo;
import com.softtek.acceleo.demo.exception.GenericException;

import java.util.List;

public interface ModuloService {

	public void addModulo(Modulo modulo);

	public void editModulo(Modulo modulo);
	
	public List<Modulo> listModuloss(Modulo modulo);

	public Modulo getModulo(int empid);

	public void deleteModulo(Modulo modulo) throws GenericException;
	
	public List<Modulo> listModulossQuery(Modulo modulo, String query, int page, int size);

	public List<Modulo> listModulosPagination(Modulo modulo, int page, int size);
	

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

//	public List<Modulo> getModuloByUsername(String userName);

	

	
}

