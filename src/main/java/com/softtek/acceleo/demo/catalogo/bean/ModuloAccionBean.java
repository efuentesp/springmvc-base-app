package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ModuloAccionBean {

	private Integer id;

	private Integer idaccion;
	private Boolean estatus;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Integer idmodulo;
	private Integer idmoduloaccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAccion () {
	    return idaccion;  		
    }

	public void setIdAccion(Integer idaccion) {
		this.idaccion = idaccion;
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
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public Integer getIdModulo () {
	    return idmodulo;  		
    }

	public void setIdModulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}
	public Integer getIdModuloAccion () {
	    return idmoduloaccion;  		
    }

	public void setIdModuloAccion(Integer idmoduloaccion) {
		this.idmoduloaccion = idmoduloaccion;
	}
}
