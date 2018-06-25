package com.softtek.acceleo.demo.security.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "privilege")
public class Privilege {

	@Id
    @Column(name = "ID_PRIVILEGE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_seq")
    @SequenceGenerator(name = "privilege_seq", sequenceName = "privilege_seq", allocationSize = 1)
    private Long id_privilege;

    @Column(name = "NAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    @Column(name = "ENABLED", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private Boolean enabled;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "CREATIONDATE", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private Date creationdate;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private Date modifieddate;

    @OneToOne(cascade = CascadeType.ALL)
	private Group idGroup;
    
    public Long getId_privilege() {
		return id_privilege;
	}

	public void setId_privilege(Long id_privilege) {
		this.id_privilege = id_privilege;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public Date getCreationdate() {
		return creationdate;
	}



	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}



	public Date getModifieddate() {
		return modifieddate;
	}



	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Group getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Group idGroup) {
		this.idGroup = idGroup;
	}

 
    
}
