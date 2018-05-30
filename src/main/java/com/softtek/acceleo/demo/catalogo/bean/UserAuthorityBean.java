/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un UserAuthority. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;


/**
 * Clase UserAuthorityBean.
 * @author PSG.
 *
 */
public class UserAuthorityBean {

	private Integer id;

	private Integer iduser;
	private Boolean estatus;
	private Date fechamodificacion;
	private Integer idrol;
	private Date fechacreacion;

	/**
	 * Obtiene el id del userAuthority.
	 * @return Integer.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Asigna el id del userAuthority.
	 * @param id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene el idUser.
	 * @return Integer.
	 */
	public Integer getIdUser () {
	    return iduser;  		
    }

	/**
	 * Asigna el idUser
	 * @param iduser.
	 */
	public void setIdUser(Integer iduser) {
		this.iduser = iduser;
	}
	
	/**
	 * Obtiene el estatus del userAuthority.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus del userAuthority.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	/**
	 * Obtiene la fecha de modificacion del userAuthority.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion del userAuthority.
	 * @param fechamodificacion
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtienen el idRol.
	 * @return Integer.
	 */
	public Integer getIdRol () {
	    return idrol;  		
    }

	/**
	 * Asigna el idRol.
	 * @param idrol.
	 */
	public void setIdRol(Integer idrol) {
		this.idrol = idrol;
	}
	
	/**
	 * Obtiene la fecha de creacion del userAuthority.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion del userAuthority.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
}
