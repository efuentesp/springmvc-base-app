package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.ConfigPermisos;

public interface AdminPermisosRepository {
	List<AdminPermiso> getPermisos();
	
	List<ConfigPermisos> getConfiguracionPermisos();
}
