/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un UserAuthorityModuloAccion. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

/**
 * Clase UserAuthorityModuloAccionBean.
 * @author PSG.
 *
 */
public class UserAuthorityModuloAccionBean {

	private Integer id;

	private Integer idmoduloaccion;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Integer iduserauthority;
	private Boolean estatus;

	/**
	 * Obtiene el idUserAuthorityModuloAccion.
	 * @return Integer. 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Asigna el idUserAuthorityModuloAccion.
	 * @param id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene idModuloAccion.
	 * @return Integer.
	 */
	public Integer getIdModuloAccion () {
	    return idmoduloaccion;  		
    }

	/**
	 * Asigna idModuloAccion.
	 * @param idmoduloaccion.
	 */
	public void setIdModuloAccion(Integer idmoduloaccion) {
		this.idmoduloaccion = idmoduloaccion;
	}
	
	/**
	 * Obtiene la fecha de creacion del UserAuthorityModuloAccion.
	 * @return Date.
	 */
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	/**
	 * Asigna la fecha de creacion del UserAuthorityModuloAccion.
	 * @param fechacreacion.
	 */
	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	/**
	 * Obtiene la fecha de modificacion del UserAuthorityModuloAccion.
	 * @return Date.
	 */
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	/**
	 * Asigna la fecha de modificacion del UserAuthorityModuloAccion.
	 * @param fechamodificacion.
	 */
	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	/**
	 * Obtine el idUserAuthority.
	 * @return Integer.
	 */
	public Integer getIdUserAuthority () {
	    return iduserauthority;  		
    }

	/**
	 * Asigna el idUserAuthority.
	 * @param iduserauthority
	 */
	public void setIdUserAuthority(Integer iduserauthority) {
		this.iduserauthority = iduserauthority;
	}
	
	/**
	 * Obtiene el estatus de idUserAuthorityModuloAccion.
	 * @return Boolean.
	 */
	public Boolean getEstatus() {
		return estatus;
	}

	/**
	 * Asigna el estatus de idUserAuthorityModuloAccion.
	 * @param estatus.
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
}
