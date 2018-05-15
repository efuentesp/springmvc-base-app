
package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tipopension")
public class Tipopension implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tipopensionId")
	private Integer  tipopensionId;

	@Column(name = "nombre") 
	private String nombre;
	@Column(name = "clave") 
	private String clave;



	public Integer getTipopensionId() {
		return tipopensionId;
	}

	public void setTipopensionId(Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}

	public String getNombre () {
	    return nombre;  		
    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave () {
	    return clave;  		
    }

	public void setClave(String clave) {
		this.clave = clave;
	}


}			
