/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Tipopension. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

/**
 * Clase TipopensionBean.
 * @author PSG.
 *
 */
public class TipopensionBean {

	private Integer tipopensionId;

	private String nombre;
	private String clave;



	/**
	 * Obtiene el tipoPensionId.
	 * @return Integer.
	 */
	public Integer getTipopensionId() {
		return tipopensionId;
	}

	/**
	 * Asigna el tipoPensionId.
	 * @param tipopensionId.
	 */
	public void setTipopensionId(Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}

	/**
	 * Obtiene el nombre del tipo pension.
	 * @return String.
	 */
	public String getNombre () {
	    return nombre;  		
    }
	
	/**
	 * Asigna el nombre del tipo pension.
	 * @param nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene la clave del tipo pension.
	 * @return String.
	 */
	public String getClave () {
	    return clave;  		
    }
	
	/**
	 * Asigna la clave del tipo pension.
	 * @param clave.
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}



}
