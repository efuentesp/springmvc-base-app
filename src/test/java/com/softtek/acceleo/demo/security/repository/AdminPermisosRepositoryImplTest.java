package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.ConfigAuthority;
import com.softtek.acceleo.demo.domain.ConfigPermisos;

import org.apache.log4j.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class AdminPermisosRepositoryImplTest {
	private static final Logger logger = Logger.getLogger(AdminPermisosRepositoryImplTest.class);

	@Autowired
	AdminPermisosRepository adminPermisosRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AdminPermisosRepositoryImplTest... ******");
	}

	@Ignore
	@Test
	@Transactional
	public void testGetPermisos() {
		try {
			List<AdminPermiso> lstAdminPermiso = adminPermisosRepository.getPermisos();
			if( lstAdminPermiso == null || lstAdminPermiso.isEmpty() ) {
				logger.info("No se encontro informacion");
			}else {
				logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");				
				logger.info("El numero de registros obtenidos: " + lstAdminPermiso.size());
				
				for(AdminPermiso adminPermiso : lstAdminPermiso) {
					logger.info("IdGrupo: " + adminPermiso.getIdGrupo() + "\tNombreGrupo: " + adminPermiso.getNombreGrupo() + "\tIdPrivilege: " + adminPermiso.getIdPrivilege() +
							    "\tNombrePrivilege: " + adminPermiso.getNombrePrivilege() + "\tAdmin: " + adminPermiso.isAdmin() + "\tUser: " + adminPermiso.isUser() + 
							    "\tAnonymous: " + adminPermiso.isAnonymous() + "\tIdAuthorityAdmin: " + adminPermiso.getIdAuthorityAdmin() + "\tIdPrivilegeAdmin: " + adminPermiso.getIdPrivilegeAdmin() +
							    "\tIdAuthorityUser: " + adminPermiso.getIdAuthorityUser() + "\tIdPrivilegeUser: " + adminPermiso.getIdPrivilegeUser() + 
							    "\tIdAuthorityAnonymous: " + adminPermiso.getIdAuthorityAnonymous() + "\tIdPrivilegeAnonymous: " + adminPermiso.getIdPrivilegeAnonymous());
				}
			}
		}catch(Exception e) {
			logger.info("Error: ", e);
		}
	}
	
	//@Ignore
	@Test
	@Transactional
	public void testGetConfiguracionPermisos(){
		List<ConfigPermisos> lstConfigPermisos = adminPermisosRepository.getConfiguracionPermisos();
		if( lstConfigPermisos == null || lstConfigPermisos.isEmpty() ) {
			logger.info("No se encontraron registros.");
		}else {
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");			
			logger.info("El numero de registros obtenidos es: " + lstConfigPermisos.size());
			
			for(ConfigPermisos configPermisos: lstConfigPermisos) {
				logger.info("IdGrupo: " + configPermisos.getIdGrupo() + "\tNombreGrupo: " + configPermisos.getNombreGrupo() + "\tIdPrivilege: " + configPermisos.getIdPrivilege() + 
							"\tNombrePrivilege: " + configPermisos.getNombrePrivilege());
				
				for(ConfigAuthority configAuthority : configPermisos.getLstConfigAuthority()) {
					logger.info("  NameAuthority: " + configAuthority.getNameAuthority() + "\tIdAuthority: " + configAuthority.getIdAuthority() + "\tIdPrivilege: " + configAuthority.getIdPrivilege() + "\tEnabled: " + configAuthority.getEnabled());
				}
			}
		}
	}

	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AdminPermisosRepositoryImplTest... ******");
	}
	
}

