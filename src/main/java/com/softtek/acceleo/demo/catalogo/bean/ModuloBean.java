package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ModuloBean {

	private Integer id;

	private Integer idmodulo;
	private String modulo;
	private Date fechamodificacion;
	private Boolean estatus;
	private Date fechacreacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdModulo () {
	    return idmodulo;  		
    }

	public void setIdModulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}
	public String getModulo () {
	    return modulo;  		
    }

	public void setModulo(String modulo) {
		this.modulo = modulo;
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
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
}
