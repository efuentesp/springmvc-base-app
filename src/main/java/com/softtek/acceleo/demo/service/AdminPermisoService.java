package com.softtek.acceleo.demo.service;

import java.util.List;

import com.softtek.acceleo.demo.domain.ConfigPermisos;

public interface AdminPermisoService {

	public List<ConfigPermisos> listAdminPermiso();
	
	public void updateAuthorityPrivilege(ConfigPermisos configPermisos);
}
