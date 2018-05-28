
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
@Table(name = "UserAuthority")
public class UserAuthority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "iduserauthority") 
	private Integer iduserauthority;
    @Column(name = "iduser") 
	private Integer iduser;
    @Column(name = "estatus") 
	private Boolean estatus;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "idrol") 
	private Integer idrol;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUserAuthority () {
	    return iduserauthority;  		
    }

	public void setIdUserAuthority(Integer iduserauthority) {
		this.iduserauthority = iduserauthority;
	}
	public Integer getIdUser () {
	    return iduser;  		
    }

	public void setIdUser(Integer iduser) {
		this.iduser = iduser;
	}
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public Integer getIdRol () {
	    return idrol;  		
    }

	public void setIdRol(Integer idrol) {
		this.idrol = idrol;
	}
	public Date getFechaCreacion () {
	    return fechacreacion;  		
    }

	public void setFechaCreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

}			
