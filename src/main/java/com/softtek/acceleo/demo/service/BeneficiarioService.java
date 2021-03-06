package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Beneficiario;
import com.softtek.acceleo.demo.exception.GenericException;

import java.util.List;

public interface BeneficiarioService {

	public void addBeneficiario(Beneficiario beneficiario);

	public void editBeneficiario(Beneficiario beneficiario);
	
	public List<Beneficiario> listBeneficiarios(Beneficiario beneficiario);

	public Beneficiario getBeneficiario(int empid);

	public void deleteBeneficiario(Beneficiario beneficiario) throws GenericException;
	
	public List<Beneficiario> listBeneficiariosQuery(Beneficiario beneficiario, String query, int page, int size);

	public List<Beneficiario> listBeneficiariosPagination(Beneficiario beneficiario, int page, int size);
	
	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

}

