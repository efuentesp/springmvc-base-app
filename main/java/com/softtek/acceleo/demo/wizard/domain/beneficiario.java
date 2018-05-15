
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
@Table(name = "Beneficiario")
public class Beneficiario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "fecha_nacimiento") 
	private String fecha_nacimiento;
    @Column(name = "curp") 
	private String curp;
    @Column(name = "nombre") 
	private String nombre;
    @Column(name = "apellido_materno") 
	private String apellido_materno;
    @Column(name = "parentesco") 
	private String parentesco;
    @Column(name = "apellido_paterno") 
	private String apellido_paterno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha_nacimiento () {
	    return fecha_nacimiento;  		
    }

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getCurp () {
	    return curp;  		
    }

	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getNombre () {
	    return nombre;  		
    }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_materno () {
	    return apellido_materno;  		
    }

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getParentesco () {
	    return parentesco;  		
    }

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

}			
