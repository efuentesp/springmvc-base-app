
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
@Table(name = "Authority")
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrol") 
	private Integer idrol;

    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "estatus") 
	private Boolean estatus;
    @Column(name = "rol") 
	private String rol;



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
