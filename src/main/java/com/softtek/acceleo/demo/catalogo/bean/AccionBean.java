/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de una accion.
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase AccionBean.
 * @author PSG.
 *
 */
public class AccionBean {

	private Date fechacreacion;
	private Date fechamodificacion;
	private Boolean estatus;
	private String accion;
	private Integer idAccion;

	/**
	 * Obtiene el id de la accion.
	 * @return Integer.
	 */
	public Integer getIdAccion() {
		return idAccion;
	}
	
	/**
	 * Asigna el id de la accion.
	 * @param id.
	 */
	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}
	
	/**
	 * Obtiene la fecha de creacion de la accion.
	 * @return Date.
	 */	
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion de la accion.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * Obtiene la fecha de modificacion de la accion.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion de la accion.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	/**
	 * Obtiene el estatus de la accion.
	 * @return Boolean. (true -> activo, false -> inactivo)
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus de la accion.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene el nombre de la accion.
	 * @return String.
	 */
	public String getAccion () {
	    return accion;  		
    }

	/**
	 * Asigna el nombre de la accion.
	 * @param accion.
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}


	
}
