/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para encapsular informacion de un afiliado.
 */
package com.softtek.acceleo.demo.catalogo.bean;

/**
 * Clase AfiliadoBean.
 * @author PSG.
 *
 */
public class AfiliadoBean {

	private Integer afiliadoId;

	private String apellidoPaterno;
	private String nss;
	private String actaNacimiento;
	private String apellidoMaterno;
	private String foto;
	private String semanasCotizadas;
	private String fechaAfiliacion;
	private String correo;
	private String nombre;
	private String observaciones;
	private String montoPension;


	private Genero generoId;
	private enum Genero { MALE,FEMALE}
	private Integer beneficiarioId;


	/**
	 * Obtiene el id del afiliado
	 * @return Integer.
	 */
	public Integer getAfiliadoId() {
		return afiliadoId;
	}

	/**
	 * Asigna el id del afiliado.
	 * @param afiliadoId.
	 */
	public void setAfiliadoId(Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}

	/**
	 * Obtiene el apellido paterno del afiliado.
	 * @return String.
	 */
	public String getApellidoPaterno () {
	    return apellidoPaterno;  		
    }
	
	/**
	 * Asigna el apellido paterno del afiliado.
	 * @param apellidoPaterno.
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	/**
	 * Obtiene el NSS del afiliado.
	 * @return String.
	 */
	public String getNss () {
	    return nss;  		
    }
	
	/**
	 * Asigna el NSS del afiliado.
	 * @param nss.
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	
	/**
	 * Obtiene el acta de nacimiento del afiliado.
	 * @return String.
	 */
	public String getActaNacimiento () {
	    return actaNacimiento;  		
    }
	
	/**
	 * Asigna el acta de nacimiento del afiliado.
	 * @param actaNacimiento.
	 */
	public void setActaNacimiento(String actaNacimiento) {
		this.actaNacimiento = actaNacimiento;
	}
	
	/**
	 * Obtiene el apellido materno del afiliado.
	 * @return String.
	 */
	public String getApellidoMaterno () {
	    return apellidoMaterno;  		
    }
	
	/**
	 * Asigna el apellido materno del afiliado.
	 * @param apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	/**
	 * Obtiene la foto del afiliado.
	 * @return String.
	 */
	public String getFoto () {
	    return foto;  		
    }
	
	/**
	 * Asigna la foto del afiliado.
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/**
	 * Obtiene las semanas cotizadas del afiliado.
	 * @return String.
	 */
	public String getSemanasCotizadas () {
	    return semanasCotizadas;  		
    }
	
	/**
	 * Asigna las semanas cotizadas del afiliado.
	 * @param semanasCotizadas.
	 */
	public void setSemanasCotizadas(String semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}
	
	/**
	 * Obtiene la fecha de afiliacion.
	 * @return String.
	 */
	public String getFechaAfiliacion () {
	    return fechaAfiliacion;  		
    }
	
	/**
	 * Asigna la fecha de afiliacion.
	 * @param fechaAfiliacion.
	 */
	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}
	
	/**
	 * Obtiene el corro del afiliado.
	 * @return String.
	 */
	public String getCorreo () {
	    return correo;  		
    }
	
	/**
	 * Asigna el corro del afiliado.
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Obtiene el nombre del afiliado.
	 * @return String.
	 */
	public String getNombre () {
	    return nombre;  		
    }
	
	/**
	 * Asigna el nombre del afiliado.
	 * @param nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtine las observaciones del afiliado.
	 * @return String.
	 */
	public String getObservaciones () {
	    return observaciones;  		
    }
	
	/**
	 * Asigna las observaciones del afiliado.
	 * @param observaciones.
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/**
	 * Obtiene el monto de la penion del afiliado.
	 * @return String.
	 */
	public String getMontoPension () {
	    return montoPension;  		
    }
	
	/**
	 * Asigna el monto de la penion del afiliado.
	 * @param montoPension.
	 */
	public void setMontoPension(String montoPension) {
		this.montoPension = montoPension;
	}

	/**
	 * Obtiene el generoId del afiliado.
	 * @return Genero.
	 */
	public Genero getGeneroId () {
	    return generoId;  		
    }
	
	/**
	 * Asigna el generoId del afiliado.
	 * @param generoId.
	 */
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	
	/**
	 * Obtiene el beneficiarioId del afiliado.
	 * @return Integer.
	 */
	public Integer getBeneficiarioId () {
	    return beneficiarioId;  		
    }
	
	/**
	 * Asigna el beneficiarioId del afiliado.
	 * @param beneficiarioId.
	 */
	public void setBeneficiarioId (Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}


}
