
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
@Table(name = "Afiliado")
public class Afiliado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "afiliadoId")
	private Integer  afiliadoId;

	@Column(name = "apellido_paterno") 
	private String apellido_paterno;
	@Column(name = "nss") 
	private String nss;
	@Column(name = "acta_nacimiento") 
	private String acta_nacimiento;
	@Column(name = "apellido_materno") 
	private String apellido_materno;
	@Column(name = "foto") 
	private String foto;
	@Column(name = "semanas_cotizadas") 
	private String semanas_cotizadas;
	@Column(name = "fecha_afiliacion") 
	private String fecha_afiliacion;
	@Column(name = "correo") 
	private String correo;
	@Column(name = "nombre") 
	private String nombre;
	@Column(name = "observaciones") 
	private String observaciones;
	@Column(name = "monto_pension") 
	private String monto_pension;

	@Column(name = "beneficiarioId") 
	private Integer beneficiarioId;

	@Column(name = "generoId", nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero generoId;

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

	public Integer getBeneficiarioId () {
	    return beneficiarioId;  		
    }

	public void setBeneficiarioId (Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}

	public Genero getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Genero generoId) {
		this.generoId = generoId;
	}
}			
