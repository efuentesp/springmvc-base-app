
package com.softtek.acceleo.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ModuloAccionAuthority")
public class ModuloAccionAuthority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmoduloaccionauthority") 
	private Integer idmoduloaccionauthority;

    @Column(name = "idauthority") 
	private Integer idauthority;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "idmoduloaccion") 
	private Integer idmoduloaccion;

    @Column(name = "estatus") 
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
