package com.softtek.acceleo.demo.domain;

import java.util.List;

public class ConfigPermisos {
	private Long idGrupo;
	private String nombreGrupo;
	private Long idPrivilege;
	private String nombrePrivilege;
	private List<ConfigAuthority> lstConfigAuthority;
	private Long activeUser;
		
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	public Long getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public String getNombrePrivilege() {
		return nombrePrivilege;
	}
	public void setNombrePrivilege(String nombrePrivilege) {
		this.nombrePrivilege = nombrePrivilege;
	}
	public List<ConfigAuthority> getLstConfigAuthority() {
		return lstConfigAuthority;
	}
	public void setLstConfigAuthority(List<ConfigAuthority> lstConfigAuthority) {
		this.lstConfigAuthority = lstConfigAuthority;
	}
	public Long getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(Long activeUser) {
		this.activeUser = activeUser;
	}

}
