
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
@Table(name = "UserAuthorityModuloAccion")
public class UserAuthorityModuloAccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "idmoduloaccion") 
	private Integer idmoduloaccion;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "iduserauthority") 
	private Integer iduserauthority;
    @Column(name = "iduserauthoritymoduloaccion") 
	private Integer iduserauthoritymoduloaccion;
    @Column(name = "estatus") 
	private Boolean estatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdModuloAccion () {
	    return idmoduloaccion;  		
    }

	public void setIdModuloAccion(Integer idmoduloaccion) {
		this.idmoduloaccion = idmoduloaccion;
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
	public Integer getIdUserAuthority () {
	    return iduserauthority;  		
    }

	public void setIdUserAuthority(Integer iduserauthority) {
		this.iduserauthority = iduserauthority;
	}
	public Integer getIdUserAuthorityModuloAccion () {
	    return iduserauthoritymoduloaccion;  		
    }

	public void setIdUserAuthorityModuloAccion(Integer iduserauthoritymoduloaccion) {
		this.iduserauthoritymoduloaccion = iduserauthoritymoduloaccion;
	}
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

}			
