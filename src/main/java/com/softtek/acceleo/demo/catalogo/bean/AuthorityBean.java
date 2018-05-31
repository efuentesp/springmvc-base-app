/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Authority (ROL). 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase AuthorityBean.
 * @author PSG.
 *
 */
public class AuthorityBean {

	private Date fechamodificacion;
	private Date fechacreacion;
	private Boolean estatus;
	private Integer idrol;
	private String rol;

	/**
	 * Obtine el id authority (ROL).
	 * @return Integer.
	 */
	public Integer getIdrol() {
		return idrol;
	}

	/**
	 * Asigna el id authority (ROL).
	 * @param id.
	 */
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	/**
	 * Obtiene la fecha modificacion del authority.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha modificacion del authority.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtiene la fecha de creacion del authority.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion del authority.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * Obtiene el estatus del authority.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus del authority.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene el nombre del rol (authority).
	 * @return String.
	 */
	public String getRol () {
	    return rol;  		
    }

	/**
	 * Asigna el nombre del rol (authority).
	 * @param rol.
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}


}
