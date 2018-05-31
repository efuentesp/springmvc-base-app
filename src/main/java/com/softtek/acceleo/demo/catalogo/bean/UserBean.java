/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un User. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase UserBean.
 * @author PSG.
 *
 */
public class UserBean {

	private Integer id;
	private Date fechamodificacion;
	private String password;
	private String rol;
	private Date fechacreacion;
	private Boolean estatus;
	private String username;
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}	

	/**
	 * Obtiene el id del user.
	 * @return Integer.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Asigna el id del user.
	 * @param id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene la fecha de modificacion.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtiene el password del user.
	 * @return String.
	 */
	public String getPassword () {
	    return password;  		
    }

	/**
	 * Asigna el password del user.
	 * @param password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Obtiene la fecha de creacion.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * Obtiene el estatus del user.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus del user.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * Obtiene el nombre del user.
	 * @return String.
	 */
	public String getUserName () {
	    return username;  		
    }

	/**
	 * Asigna el nombre del user.
	 * @param username.
	 */
	public void setUserName(String username) {
		this.username = username;
	}
}
