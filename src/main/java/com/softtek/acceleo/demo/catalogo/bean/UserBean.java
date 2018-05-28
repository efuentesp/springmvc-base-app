package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class UserBean {

	private Integer id;

	private Integer iduser;
	private Date fechamodificacion;
	private String password;
	private Date fechacreacion;
	private Boolean estatus;
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser () {
	    return iduser;  		
    }

	public void setIdUser(Integer iduser) {
		this.iduser = iduser;
	}
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public String getPassword () {
	    return password;  		
    }

	public void setPassword(String password) {
		this.password = password;
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
	public String getUserName () {
	    return username;  		
    }

	public void setUserName(String username) {
		this.username = username;
	}
}
