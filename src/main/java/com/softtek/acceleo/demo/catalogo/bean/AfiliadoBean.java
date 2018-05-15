package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class AfiliadoBean {

	private Integer afiliadoId;

	private String apellido_paterno;
	private String nss;
	private String acta_nacimiento;
	private String apellido_materno;
	private String foto;
	private String semanas_cotizadas;
	private String fecha_afiliacion;
	private String correo;
	private String nombre;
	private String observaciones;
	private String monto_pension;


	private Genero generoId;
	private enum Genero { male,female}
	private Integer beneficiarioId;


	public Integer getAfiliadoId() {
		return afiliadoId;
	}

	public void setAfiliadoId(Integer afiliadoId) {
		this.afiliadoId = afiliadoId;
	}

	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getNss () {
	    return nss;  		
    }
	public void setNss(String nss) {
		this.nss = nss;
	}
	public String getActa_nacimiento () {
	    return acta_nacimiento;  		
    }
	public void setActa_nacimiento(String acta_nacimiento) {
		this.acta_nacimiento = acta_nacimiento;
	}
	public String getApellido_materno () {
	    return apellido_materno;  		
    }
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getFoto () {
	    return foto;  		
    }
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getSemanas_cotizadas () {
	    return semanas_cotizadas;  		
    }
	public void setSemanas_cotizadas(String semanas_cotizadas) {
		this.semanas_cotizadas = semanas_cotizadas;
	}
	public String getFecha_afiliacion () {
	    return fecha_afiliacion;  		
    }
	public void setFecha_afiliacion(String fecha_afiliacion) {
		this.fecha_afiliacion = fecha_afiliacion;
	}
	public String getCorreo () {
	    return correo;  		
    }
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservaciones () {
	    return observaciones;  		
    }
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getMonto_pension () {
	    return monto_pension;  		
    }
	public void setMonto_pension(String monto_pension) {
		this.monto_pension = monto_pension;
	}

	public Genero getGeneroId () {
	    return generoId;  		
    }
	public void setGeneroId (Genero generoId) {
		this.generoId = generoId;
	}
	public Integer getBeneficiarioId () {
	    return beneficiarioId;  		
    }
	public void setBeneficiarioId (Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}


}
