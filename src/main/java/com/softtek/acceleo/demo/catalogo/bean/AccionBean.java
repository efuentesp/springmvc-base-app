package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class AccionBean {

	private Integer id;

	private Date fechacreacion;
	private Date fechamodificacion;
	private Boolean estatus;
	private String accion;
	private Integer idaccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public String getAccion () {
	    return accion;  		
    }

	public void setAccion(String accion) {
		this.accion = accion;
	}
	public Integer getIdAccion () {
	    return idaccion;  		
    }

	public void setIdAccion(Integer idaccion) {
		this.idaccion = idaccion;
	}
}
