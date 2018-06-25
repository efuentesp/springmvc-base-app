package com.softtek.acceleo.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_AUTHORITY")
	private Integer  idAuthority;

	@Column(name = "NAME") 
	private String name;
	
	@Column(name = "ENABLED") 
	private Boolean enabled;
	
	@Column(name = "CREATIONDATE") 
	private Date fechaCreacion;
	
	@Column(name = "MODIFIEDDATE") 
	private String fechaModificacion;

	
	public Integer getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Integer idAuthority) {
		this.idAuthority = idAuthority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
