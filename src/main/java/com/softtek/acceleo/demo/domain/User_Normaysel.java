
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
@Table(name = "User")
public class User_Normaysel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "iduser") 
	private Integer iduser;
    @Column(name = "fechamodificacion") 
	private Date fechamodificacion;
    @Column(name = "password") 
	private String password;
    @Column(name = "fechacreacion") 
	private Date fechacreacion;
    @Column(name = "estatus") 
	private Boolean estatus;
    @Column(name = "username") 
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser () {
	    return iduser;  		
    }

	public void setIdUser(Integer iduser) {
		this.iduser = iduser;
	}
	public Date getFechaModificacion () {
	    return fechamodificacion;  		
    }

	public void setFechaModificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public String getPassword () {
	    return password;  		
    }

	public void setPassword(String password) {
		this.password = password;
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
	public String getUserName () {
	    return username;  		
    }

	public void setUserName(String username) {
		this.username = username;
	}

}			
