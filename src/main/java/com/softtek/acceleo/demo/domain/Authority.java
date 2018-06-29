package com.softtek.acceleo.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "AUTHORITY")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_AUTHORITY")
    private Long idAuthority;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;
    
    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "authority_privilege", joinColumns = { 
			@JoinColumn(name = "ID_AUTHORITY", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_PRIVILEGE", nullable = false, updatable = false) })    
    private List<Privilege> privilege;
    
    
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_authority", joinColumns = { 
			@JoinColumn(name = "ID_AUTHORITY", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ID_USER", nullable = false, updatable = false) })    	
    private List<User> user;

	public Long getIdAuthority() {
        return idAuthority;
    }

    public void setIdAuthority(Long idAuthority) {
        this.idAuthority = idAuthority;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<Privilege> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(List<Privilege> privilege) {
		this.privilege = privilege;
	}
        
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
    
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
}