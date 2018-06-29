package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.security.repository.AdminPermisosRepository;
import com.softtek.acceleo.demo.service.AdminPermisoService;

/**
 * Clase AdminPermisoServiceImpl.
 * @author PSG.
 *
 */
@Service("adminPermisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminPermisoServiceImpl implements AdminPermisoService{

	@Autowired
	private AdminPermisosRepository adminPermisoRepository;

	/**
	 * Consulta informacion de adminPermiso.
	 */
	public List<AdminPermiso> listAdminPermiso() {
		return adminPermisoRepository.getPermisos();
	}
	
}
