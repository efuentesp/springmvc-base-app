
package com.softtek.acceleo.demo.wizard.domain;

import java.io.Serializable;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "apellido_materno") 
	private String apellido_materno;
    @Column(name = "fecha_afiliacion") 
	private String fecha_afiliacion;
    @Column(name = "email") 
	private String email;
    @Column(name = "semanas_cotizadas") 
	private String semanas_cotizadas;
    @Column(name = "acta_nacimiento") 
	private String acta_nacimiento;
    @Column(name = "decimal") 
	private String decimal;
    @Column(name = "foto") 
	private String foto;
    @Column(name = "apellido_paterno") 
	private String apellido_paterno;
    @Column(name = "observaciones") 
	private String observaciones;
    @Column(name = "monto_pension") 
	private String monto_pension;
    @Column(name = "nombre") 
	private String nombre;
    @Column(name = "nss") 
	private String nss;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido_materno () {
	    return apellido_materno;  		
    }

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getFecha_afiliacion () {
	    return fecha_afiliacion;  		
    }

	public void setFecha_afiliacion(String fecha_afiliacion) {
		this.fecha_afiliacion = fecha_afiliacion;
	}
	public String getEmail () {
	    return email;  		
    }

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSemanas_cotizadas () {
	    return semanas_cotizadas;  		
    }

	public void setSemanas_cotizadas(String semanas_cotizadas) {
		this.semanas_cotizadas = semanas_cotizadas;
	}
	public String getActa_nacimiento () {
	    return acta_nacimiento;  		
    }

	public void setActa_nacimiento(String acta_nacimiento) {
		this.acta_nacimiento = acta_nacimiento;
	}
	public String getDecimal () {
	    return decimal;  		
    }

	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}
	public String getFoto () {
	    return foto;  		
    }

	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
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
	public String getNombre () {
	    return nombre;  		
    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNss () {
	    return nss;  		
    }

	public void setNss(String nss) {
		this.nss = nss;
	}

}			
