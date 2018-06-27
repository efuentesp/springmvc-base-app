package com.softtek.acceleo.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @Column(name = "ID_GRUPO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGrupo;

    @Column(name = "NAME", length = 30, unique = true)
    @NotNull
    @Size(min = 4, max = 30)
    private String name;

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
