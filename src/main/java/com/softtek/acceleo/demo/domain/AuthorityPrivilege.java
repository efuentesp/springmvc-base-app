package com.softtek.acceleo.demo.domain;

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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authority_privilege")
public class AuthorityPrivilege {
    @Id
    @Column(name = "ID_AUT_PRIV")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAutorityPrivilege;
    
    @Column(name = "ID_PRIVILEGE")
    @NotNull
    private Long idPrivilege;
    
    @Column(name = "ID_AUTHORITY")
    @NotNull
    private Long idAuthority;
    
	
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "AUTHORITY",
//            joinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")},
//            inverseJoinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")})
    @Transient
	private List<Authority> authorities;
	
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "PRIVILEGE",
//            joinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")},
//            inverseJoinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")})
    @Transient
	private List<Privilege> privileges;

	public Long getIdAutorityPrivilege() {
		return idAutorityPrivilege;
	}

	public void setIdAutorityPrivilege(Long idAutorityPrivilege) {
		this.idAutorityPrivilege = idAutorityPrivilege;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
    public Long getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
    
	public Long getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Long idAuthority) {
		this.idAuthority = idAuthority;
	}
    
}
