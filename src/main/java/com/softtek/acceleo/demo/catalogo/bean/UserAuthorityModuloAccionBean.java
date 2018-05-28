package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class UserAuthorityModuloAccionBean {

	private Integer id;

	private Integer idmoduloaccion;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Integer iduserauthority;
	private Integer iduserauthoritymoduloaccion;
	private Boolean estatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdModuloAccion () {
	    return idmoduloaccion;  		
    }

	public void setIdModuloAccion(Integer idmoduloaccion) {
		this.idmoduloaccion = idmoduloaccion;
	}
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public Integer getIdUserAuthority () {
	    return iduserauthority;  		
    }

	public void setIdUserAuthority(Integer iduserauthority) {
		this.iduserauthority = iduserauthority;
	}
	public Integer getIdUserAuthorityModuloAccion () {
	    return iduserauthoritymoduloaccion;  		
    }

	public void setIdUserAuthorityModuloAccion(Integer iduserauthoritymoduloaccion) {
		this.iduserauthoritymoduloaccion = iduserauthoritymoduloaccion;
	}
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
}
