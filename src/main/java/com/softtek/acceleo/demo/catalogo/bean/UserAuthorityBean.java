package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class UserAuthorityBean {

	private Integer id;

	private Integer iduserauthority;
	private Integer iduser;
	private Boolean estatus;
	private Date fechamodificacion;
	private Integer idrol;
	private Date fechacreacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUserAuthority () {
	    return iduserauthority;  		
    }

	public void setIdUserAuthority(Integer iduserauthority) {
		this.iduserauthority = iduserauthority;
	}
	public Integer getIdUser () {
	    return iduser;  		
    }

	public void setIdUser(Integer iduser) {
		this.iduser = iduser;
	}
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public Integer getIdRol () {
	    return idrol;  		
    }

	public void setIdRol(Integer idrol) {
		this.idrol = idrol;
	}
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
}
