package com.softtek.acceleo.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authority_privilege")
public class AuthorityPrivilege {
    @Id
    @Column(name = "ID_AUT_PRIV")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAutorityPrivilege;
    
    @Column(name = "ENABLED")    
    private Boolean enabled;
    
    
//	@Column(name = "ID_PRIVILEGE")
//  @NotNull
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRIVILEGE")    
    private Privilege idPrivilege;
    
//  @Column(name = "ID_AUTHORITY")
//  @NotNull
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AUTHORITY")    
    private Authority idAuthority;
    
	public Long getIdAutorityPrivilege() {
		return idAutorityPrivilege;
	}

	public void setIdAutorityPrivilege(Long idAutorityPrivilege) {
		this.idAutorityPrivilege = idAutorityPrivilege;
	}

    public Privilege getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Privilege idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
    
	public Authority getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
