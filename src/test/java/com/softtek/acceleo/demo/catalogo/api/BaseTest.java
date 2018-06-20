package com.softtek.acceleo.demo.catalogo.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Profile;
import com.softtek.acceleo.demo.domain.User;

public abstract class BaseTest {

	protected final static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

	protected Profile profile = new Profile();
	protected List<Profile> profiles = new ArrayList<Profile>();
	
	protected Authority authority = new Authority();
	protected List<Authority> authorities = new ArrayList<Authority>();	
	
	protected void setup() {

		this.setMemoryAuthority();
		this.setMemoryProfile();
		
	}
	
	private void setMemoryAuthority() {
		
		Authority a1 = new Authority();
		a1.setEstatus(true);
		a1.setFechaCreacion(new Date());
		a1.setFechaModificacion(new Date());
		a1.setIdRol(1);
		a1.setRol("ROLE_AFILIADOCREATE");
		a1.setAuthority("ROLE_AFILIADOCREATE");
		
		Authority a2 = new Authority();
		a2.setEstatus(true);
		a2.setFechaCreacion(new Date());
		a2.setFechaModificacion(new Date());
		a2.setIdRol(2);
		a2.setRol("ROLE_AFILIADOREAD");
		a2.setAuthority("ROLE_AFILIADOREAD");
		
		Authority a3 = new Authority();
		a3.setEstatus(true);
		a3.setFechaCreacion(new Date());
		a3.setFechaModificacion(new Date());
		a3.setIdRol(3);
		a3.setRol("ROLE_AFILIADOUPDATE");
		a3.setAuthority("ROLE_AFILIADOUPDATE");
		
		Authority a4 = new Authority();
		a4.setEstatus(true);
		a4.setFechaCreacion(new Date());
		a4.setFechaModificacion(new Date());
		a4.setIdRol(4);
		a4.setRol("ROLE_AFILIADODELETE");
		a4.setAuthority("ROLE_AFILIADODELETE");
		
		this.authorities.add(a1);
		this.authorities.add(a2);
		this.authorities.add(a3);
		this.authorities.add(a4);

	}

	private void setMemoryProfile() {
		
		Profile p1 = new Profile();
		p1.setAuthorities(this.authorities);
		
		p1.setFechacreacion(new Date());
		p1.setFechamodificacion(new Date());
		p1.setId(1);
		p1.setToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDEiLCJ1c2VySWQiOiIxIiwicm9sZSI6ImFkbWluaXN0cmFkb3IifQ.HfOt7azVFeW9YAWpI5rSyiHnw00WbzMJXBH7pym0JvZDQHhSW3o-9qTqLs4qKlEq2WjT77uDKU7xvXawZXoTIw");
		p1.setPassword("user01");
		p1.setRol("administrador");
		p1.setUsername("user01");
		p1.setEmail("normaysel.carbajal@softtek.com");
		p1.setFirstname("Normaysel");
		p1.setLastname("Carbajal");
		p1.setEstatus(true);
		
		this.profiles.add(p1);
	}
	
	
	
}
