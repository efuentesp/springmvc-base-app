package com.softtek.acceleo.demo.security.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_authority")
public class UserAuthority {

    @OneToOne(cascade = CascadeType.ALL)
	private User idUser;
    
    @OneToOne(cascade = CascadeType.ALL)
	private Authority idAuthority;
	
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	public Authority getIdAuthority() {
		return idAuthority;
	}
	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}
	
	
	
	
}
