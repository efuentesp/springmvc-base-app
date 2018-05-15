package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class SolicitudpensionBean {

	private Integer solicitudpensionId;

	private String observaciones;
	private String numero;
	private String fecha_solicitud;


	private Integer afiliadoId;
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
