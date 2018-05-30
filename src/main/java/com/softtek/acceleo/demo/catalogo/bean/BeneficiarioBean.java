/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Beneficiario. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase BeneficiarioBean.
 * @author PSG.
 *
 */
public class BeneficiarioBean {

	private Integer beneficiarioId;

	private String fechaNacimiento;
	private String nombre;
	private String apellidoPaterno;
	private String curp;
	private String apellidoMaterno;


	private Parentesco parentescoId;
	private enum Parentesco { hijo,conyuge,ascendiente}


	/**
	 * Obtiene el id del beneficiario.
	 * @return Integer.
	 */
	public Integer getBeneficiarioId() {
		return beneficiarioId;
	}

	/**
	 * Asigna el id del beneficiario.
	 * @param beneficiarioId.
	 */
	public void setBeneficiarioId(Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}

	/**
	 * Obtiene la fecha de nacimiento del beneficiario.
	 * @return String.
	 */
	public String getFechaNacimiento () {
	    return fechaNacimiento;  		
    }
	
	/**
	 * Asigna la fecha de nacimiento del beneficiario.
	 * @param fechaNacimiento.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Obtiene el nombre del beneficiario.
	 * @return String.
	 */
	public String getNombre () {
	    return nombre;  		
    }
	
	/**
	 * Asigna el nombre del beneficiario.
	 * @param nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene el apellido paterno del beneficiario.
	 * @return String.
	 */
	public String getApellidoPaterno () {
	    return apellidoPaterno;  		
    }
	
	/**
	 * Asigna el apellido paterno del beneficiario.
	 * @param apellidoPaterno.
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	/**
	 * Obtiene la curp del beneficiario.
	 * @return String.
	 */
	public String getCurp () {
	    return curp;  		
    }
	
	/**
	 * Asigna la curp del beneficiario.
	 * @param curp.
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	/**
	 * Obtiene el apellido materno del beneficiario.
	 * @return String.
	 */
	public String getApellidoMaterno () {
	    return apellidoMaterno;  		
    }
	
	/**
	 * Asigna el apellido materno del beneficiario.
	 * @param apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtiene el parentescoId del beneficiario.
	 * @return Parentesco.
	 */
	public Parentesco getParentescoId () {
	    return parentescoId;  		
    }
	
	/**
	 * Asigna el parentescoId del beneficiario.
	 * @param parentescoId.
	 */
	public void setParentescoId (Parentesco parentescoId) {
		this.parentescoId = parentescoId;
	}


}
