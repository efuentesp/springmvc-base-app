package com.softtek.acceleo.demo.domain;

/**
 * Clase para almacenar la configuracion de los authority.
 * @author javier.perezb
 *
 */
public class ConfigAuthority {
	private Long idAuthority;
	private String nameAuthority;
	private Long idPrivilege;
	private Boolean enabled;
	
	public Long getIdAuthority() {
		return idAuthority;
	}
	public void setIdAuthority(Long idAuthority) {
		this.idAuthority = idAuthority;
	}
	public String getNameAuthority() {
		return nameAuthority;
	}
	public void setNameAuthority(String nameAuthority) {
		this.nameAuthority = nameAuthority;
	}	
	public Long getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
}
