package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Afiliado;
import java.util.List;

public interface AfiliadoService {

	public void addAfiliado(Afiliado afiliado);

	public void editAfiliado(Afiliado afiliado);
	
	public List<Afiliado> listAfiliados(Afiliado afiliado);

	public Afiliado getAfiliado(int empid);

	public void deleteAfiliado(Afiliado afiliado);
	
	public List<Afiliado> listAfiliadosQuery(Afiliado afiliado, String query, int page, int size);

	public List<Afiliado> listAfiliadosPagination(Afiliado afiliado, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

