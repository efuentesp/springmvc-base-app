package com.softtek.acceleo.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authority_privilege")
public class AuthorityPrivilege {
    @Id
    @Column(name = "ID_AUT_PRIV")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAutorityPrivilege;
    
//    @Column(name = "ID_PRIVILEGE")
//    @NotNull
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRIVILEGE")    
    private Privilege idPrivilege;
    
//    @Column(name = "ID_AUTHORITY")
//    @NotNull
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AUTHORITY")    
    private Authority idAuthority;
    
	
//	@ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "AUTHORITY",
//            joinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")}/**,
//            inverseJoinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")}*/)
//	private List<Authority> authorities;
	
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "PRIVILEGE",
//            joinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")}/**,
//            inverseJoinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")}*/)
//	private List<Privilege> privileges;

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
    
}
