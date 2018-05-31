/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un ModuloAccion. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase ModuloBean.
 * @author PSG.
 *
 */
public class ModuloBean {

	private Integer idModulo;
	private String modulo;
	private Date fechamodificacion;
	private Boolean estatus;
	private Date fechacreacion;



	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * Obtiene el nombre del modulo.
	 * @return String.
	 */
	public String getModulo () {
	    return modulo;  		
    }

	/**
	 * Asigna el nombre del modulo.
	 * @param modulo.
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	
	/**
	 * Obtiene la fecha de modificacion del modulo.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion del modulo.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtiene el estatus del modulo.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus del modulo.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * Obtiene la fecha de creacion del modulo.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion del modulo.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
}
