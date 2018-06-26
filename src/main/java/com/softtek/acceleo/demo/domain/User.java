package com.softtek.acceleo.demo.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long idUser;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String userName;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "ENABLED")
    private Boolean enabled;

    @Column(name = "ATTEMPS")
    private Long attemps;
    
	@Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @Column(name = "CREATIONDATE", length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creationDate;
    
    @Column(name = "MODIFIEDDATE", length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    
    

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")})
//    @Transient
    private List<Authority> authorities;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

	public Object getRole() {
		return null;
	}

	public void setRole(String string) {
	}
}