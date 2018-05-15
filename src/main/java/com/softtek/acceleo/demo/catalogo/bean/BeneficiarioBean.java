package com.softtek.acceleo.demo.catalogo.bean;

import java.util.Date;

public class BeneficiarioBean {

	private Integer beneficiarioId;

	private String fecha_nacimiento;
	private String nombre;
	private String apellido_paterno;
	private String curp;
	private String apellido_materno;


	private Parentesco parentescoId;
	private enum Parentesco { hijo,conyuge,ascendiente}


	public Integer getBeneficiarioId() {
		return beneficiarioId;
	}

	public void setBeneficiarioId(Integer beneficiarioId) {
		this.beneficiarioId = beneficiarioId;
	}

	public String getFecha_nacimiento () {
	    return fecha_nacimiento;  		
    }
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNombre () {
	    return nombre;  		
    }
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_paterno () {
	    return apellido_paterno;  		
    }
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getCurp () {
	    return curp;  		
    }
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getApellido_materno () {
	    return apellido_materno;  		
    }
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public Parentesco getParentescoId () {
	    return parentescoId;  		
    }
	public void setParentescoId (Parentesco parentescoId) {
		this.parentescoId = parentescoId;
	}


}
