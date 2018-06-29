package com.softtek.acceleo.demo.domain;

public class AdminPermiso {
	private Long idGrupo;
	private String nombreGrupo;
	private Long idPrivilege;
	private String nombrePrivilege;
	private Boolean admin;
	private Boolean user;
	private Boolean anonymous;
	private Long idAuthorityAdmin;
	private Long idPrivilegeAdmin;
	private Long idAuthorityUser;
	private Long idPrivilegeUser;
	private Long idAuthorityAnonymous;
	private Long idPrivilegeAnonymous;
	private Integer activeUser;
	

	public Integer getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(Integer activeUser) {
		this.activeUser = activeUser;
	}
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
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean isUser() {
		return user;
	}
	public void setUser(Boolean user) {
		this.user = user;
	}
	public Boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(Boolean anonymous) {
		this.anonymous = anonymous;
	}
	public Long getIdAuthorityAdmin() {
		return idAuthorityAdmin;
	}
	public void setIdAuthorityAdmin(Long idAuthorityAdmin) {
		this.idAuthorityAdmin = idAuthorityAdmin;
	}
	public Long getIdPrivilegeAdmin() {
		return idPrivilegeAdmin;
	}
	public void setIdPrivilegeAdmin(Long idPrivilegeAdmin) {
		this.idPrivilegeAdmin = idPrivilegeAdmin;
	}
	public Long getIdAuthorityUser() {
		return idAuthorityUser;
	}
	public void setIdAuthorityUser(Long idAuthorityUser) {
		this.idAuthorityUser = idAuthorityUser;
	}
	public Long getIdPrivilegeUser() {
		return idPrivilegeUser;
	}
	public void setIdPrivilegeUser(Long idPrivilegeUser) {
		this.idPrivilegeUser = idPrivilegeUser;
	}
	public Long getIdAuthorityAnonymous() {
		return idAuthorityAnonymous;
	}
	public void setIdAuthorityAnonymous(Long idAuthorityAnonymous) {
		this.idAuthorityAnonymous = idAuthorityAnonymous;
	}
	public Long getIdPrivilegeAnonymous() {
		return idPrivilegeAnonymous;
	}
	public void setIdPrivilegeAnonymous(Long idPrivilegeAnonymous) {
		this.idPrivilegeAnonymous = idPrivilegeAnonymous;
	}
	
	
}
