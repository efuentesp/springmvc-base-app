
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
@Table(name = "Accion")
public class Accion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idaccion") 
	private Integer idaccion;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "estatus") 
	private Boolean estatus;
    @Column(name = "accion") 
	private String accion;


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
