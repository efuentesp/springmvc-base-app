package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class ModuloaAccionAuthorityBean {

	private Integer id;

	private Integer idauthority;
	private Date fechacreacion;
	private Date fechamodificacion;
	private Integer idmoduloaccion;
	private Integer idmoduloaccionauthority;
	private Boolean estatus;

	public Integer getIdAuthority () {
	    return idauthority;  		
    }

	public void setIdAuthority(Integer idauthority) {
		this.idauthority = idauthority;
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
	public Integer getIdModuloAccion () {
	    return idmoduloaccion;  		
    }

	public void setIdModuloAccion(Integer idmoduloaccion) {
		this.idmoduloaccion = idmoduloaccion;
	}
	public Integer getIdmoduloaccionauthority () {
	    return idmoduloaccionauthority;  		
    }

	public void setIdmoduloaccionauthority(Integer idmoduloaccionauthority) {
		this.idmoduloaccionauthority = idmoduloaccionauthority;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	
	
}
