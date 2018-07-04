package com.softtek.acceleo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.ConfigAuthority;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
import com.softtek.acceleo.demo.service.AdminPermisoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
//@Transactional
//@Rollback(false)
public class AdminPermisoServiceImplTest {
	private static final Logger logger = Logger.getLogger(AdminPermisoServiceImplTest.class);

	@Autowired
	AdminPermisoService adminPermisoService;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AdminPermisoServiceImplTest... ******");
	}

	//@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateAuthorityPrivilege() {
		ConfigPermisos configPermisos = new ConfigPermisos();
		configPermisos.setActiveUser(1);
		configPermisos.setIdGrupo(1L);
		configPermisos.setNombreGrupo("AFILIADO");
		configPermisos.setIdPrivilege(1L);		
		configPermisos.setNombrePrivilege("ROLE_AFILIADOCREATE");
		
		
		List<ConfigAuthority> lstConfigAuthority = new ArrayList<>();
		ConfigAuthority configAuthority = new ConfigAuthority();
		configAuthority.setIdAuthority(1L);
		configAuthority.setIdPrivilege(1L);
		configAuthority.setNameAuthority("ROLE_ADMIN");
		configAuthority.setEnabled(true);
		lstConfigAuthority.add(configAuthority);
		
		configPermisos.setLstConfigAuthority(lstConfigAuthority);
		
		logger.info("INICIANDO update / insert de authority_privilege");
		adminPermisoService.updateAuthorityPrivilege(configPermisos);
		logger.info("FINALIZANDO update / insert de authority_privilege");
	}
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AdminPermisoServiceImplTest... ******");
	}
	
}