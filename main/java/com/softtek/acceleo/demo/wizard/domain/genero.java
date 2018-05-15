
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
@Table(name = "Genero")
public class Genero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

    @Column(name = "male") 
	private String male;
    @Column(name = "female") 
	private String female;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMale () {
	    return male;  		
    }

	public void setMale(String male) {
		this.male = male;
	}
	public String getFemale () {
	    return female;  		
    }

	public void setFemale(String female) {
		this.female = female;
	}

}			
