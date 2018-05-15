
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
@Table(name = "Solicitudpension")
public class Solicitudpension implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "solicitudpensionId")
	private Integer  solicitudpensionId;

	@Column(name = "observaciones") 
	private String observaciones;
	@Column(name = "numero") 
	private String numero;
	@Column(name = "fecha_solicitud") 
	private String fecha_solicitud;

	@Column(name = "afiliadoId") 
	private Integer afiliadoId;
	@Column(name = "tipopensionId") 
	private Integer tipopensionId;


	public Integer getSolicitudpensionId() {
		return solicitudpensionId;
	}

	public void setSolicitudpensionId(Integer solicitudpensionId) {
		this.solicitudpensionId = solicitudpensionId;
	}

	public String getObservaciones () {
	    return observaciones;  		
    }

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getNumero () {
	    return numero;  		
    }

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getFecha_solicitud () {
	    return fecha_solicitud;  		
    }

	public void setFecha_solicitud(String fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Integer getAfiliadoId () {
	    return afiliadoId;  		
    }

	public void setAfiliadoId (Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}
	public Integer getTipopensionId () {
	    return tipopensionId;  		
    }

	public void setTipopensionId (Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}

}			
