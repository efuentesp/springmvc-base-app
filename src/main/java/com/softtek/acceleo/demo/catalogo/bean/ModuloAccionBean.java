/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un ModuloAccion. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase ModuloAccion.
 * @author javier.perezb
 *
 */
public class ModuloAccionBean {

	private Integer id;

	private Integer idaccion;
	private Boolean estatus;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Integer idmodulo;

	/**
	 * Obtine el id del moduloAccion.
	 * @return Integer.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Asigna el id del moduloAccion.
	 * @param id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene el idAccion.
	 * @return Integer.
	 */
	public Integer getIdAccion () {
	    return idaccion;  		
    }

	/**
	 * Asigna el idAccion.
	 * @param idaccion.
	 */
	public void setIdAccion(Integer idaccion) {
		this.idaccion = idaccion;
	}
	
	/**
	 * Obtiene el estatus del moduloAccion.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus del moduloAccion.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * Obtiene la fecha de creacion del moduloAccion.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion del moduloAccion.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * Obtiene la fecha de modificacion del moduloAccion.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion del moduloAccion.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtiene el idModulo.
	 * @return Integer.
	 */
	public Integer getIdModulo () {
	    return idmodulo;  		
    }

	/**
	 * Asigna el idModulo.
	 * @param idmodulo.
	 */
	public void setIdModulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}
}
