package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class AuthorityBean {

	private Integer id;

	private Date fechamodificacion;
	private Date fechacreacion;
	private Boolean estatus;
	private Integer idrol;
	private String rol;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public Integer getIdRol () {
	    return idrol;  		
    }

	public void setIdRol(Integer idrol) {
		this.idrol = idrol;
	}
	public String getRol () {
	    return rol;  		
    }

	public void setRol(String rol) {
		this.rol = rol;
	}
}
