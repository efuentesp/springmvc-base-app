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
@Table(name = "GROUP")
public class Group {

    @Id
    @Column(name = "ID_GROUP")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
    //@SequenceGenerator(name = "user_seq", sequenceName = "group_seq", allocationSize = 1)
    private Long idGroup;

    @Column(name = "NAME", length = 30, unique = true)
    @NotNull
    @Size(min = 4, max = 30)
    private String name;

	public Long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}