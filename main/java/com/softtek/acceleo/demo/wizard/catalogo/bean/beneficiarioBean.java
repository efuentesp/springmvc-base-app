package com.softtek.acceleo.demo.wizard.catalogo.bean;

import java.util.Date;

public class BeneficiarioBean {

	private Integer id;

	private String fecha_nacimiento;
	private String curp;
	private String nombre;
	private String apellido_materno;
	private String parentesco;
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
