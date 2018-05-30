/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un Solicitudpension. 
 */
package com.softtek.acceleo.demo.catalogo.bean;

/**
 * Clase SolicitudpensionBean.
 * @author PSG.
 *
 */
public class SolicitudpensionBean {

	private Integer solicitudpensionId;

	private String observaciones;
	private String numero;
	private String fechaSolicitud;


	private Integer afiliadoId;
	private Integer tipopensionId;

	/**
	 * Obtiene el id de la solicitud pension.
	 * @return Integer.
	 */
	public Integer getSolicitudpensionId() {
		return solicitudpensionId;
	}

	/**
	 * Asigna el id de la solicitud pension.
	 * @param solicitudpensionId.
	 */
	public void setSolicitudpensionId(Integer solicitudpensionId) {
		this.solicitudpensionId = solicitudpensionId;
	}

	/**
	 * Obtiene las observaciones de la solicitud pension.
	 * @return String.
	 */
	public String getObservaciones () {
	    return observaciones;  		
    }
	
	/**
	 * Asigna las observaciones de la solicitud pension.
	 * @param observaciones.
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/**
	 * Obtiene el numero de la solicitud pension.
	 * @return String.
	 */
	public String getNumero () {
	    return numero;  		
    }
	
	/**
	 * Asigna el numero de la solicitud pension.
	 * @param numero.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Obtiene la fecha de la solicitud.
	 * @return String.
	 */
	public String getFechaSolicitud () {
	    return fechaSolicitud;  		
    }
	
	/**
	 * Asigna la fecha de la solicitud.
	 * @param fechaSolicitud.
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * Obtiene el afiliadoId de la solicitud pension.
	 * @return Integer.
	 */
	public Integer getAfiliadoId () {
	    return afiliadoId;  		
    }
	
	/**
	 * Asigna el afiliadoId de la solicitud pension.
	 * @param afiliadoId.
	 */
	public void setAfiliadoId (Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}
	
	/**
	 * Obtiene el tipo pensionId de la solicitud.
	 * @return Integer.
	 */
	public Integer getTipopensionId () {
	    return tipopensionId;  		
    }
	
	/**
	 * Asigna el tipo pensionId de la solicitud.
	 * @param tipopensionId.
	 */
	public void setTipopensionId (Integer tipopensionId) {
		this.tipopensionId = tipopensionId;
	}


}
