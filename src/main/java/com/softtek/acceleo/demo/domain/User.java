package com.softtek.acceleo.demo.domain;

import java.awt.Image;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1298403072446934327L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduser", nullable = false)	
	private String idUser;
	
	@Column(name = "username", nullable = false) 
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "rol", nullable = false)
    private String rol;
	
	@Column(name = "image")
    private String imagen;
	
		
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
