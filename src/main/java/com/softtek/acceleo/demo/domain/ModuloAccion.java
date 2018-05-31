
package com.softtek.acceleo.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Table(name = "ModuloAccion")
public class ModuloAccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "idaccion") 
	private Integer idaccion;
    
    @Column(name = "estatus")
    @Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean estatus;
    
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "idmodulo") 
	private Integer idmodulo;
    @Column(name = "idmoduloaccion") 
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
