
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
@Table(name = "Modulo")
public class Modulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "idmodulo") 
	private Integer idmodulo;
    @Column(name = "modulo") 
	private String modulo;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "estatus") 
	private Boolean estatus;
    @Column(name = "fechacreacion") 
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
