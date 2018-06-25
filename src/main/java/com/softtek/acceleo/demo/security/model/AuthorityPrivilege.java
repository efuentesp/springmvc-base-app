package com.softtek.acceleo.demo.security.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authority_privilege")
public class AuthorityPrivilege {
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "AUTHORITY",
            joinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")},
            inverseJoinColumns = {@JoinColumn(name = "ID_AUTHORITY", referencedColumnName = "ID_AUTHORITY")})
	private List<Authority> authorities;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PRIVILEGE",
            joinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PRIVILEGE", referencedColumnName = "ID_PRIVILEGE")})
	private List<Privilege> privileges;
	
}
