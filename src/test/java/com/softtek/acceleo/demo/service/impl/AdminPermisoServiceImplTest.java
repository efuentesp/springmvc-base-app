package com.softtek.acceleo.demo.service.impl;

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
import com.softtek.acceleo.demo.service.AdminPermisoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
@Rollback(false)
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
		AdminPermiso adminPermiso = new AdminPermiso();
		adminPermiso.setActiveUser(1);
		adminPermiso.setIdAuthorityAdmin(3L);
		adminPermiso.setIdPrivilegeAdmin(1L);
		adminPermiso.setAdmin(true);
		
		logger.info("INICIANDO update / insert de authority_privilege");
		adminPermisoService.updateAuthorityPrivilege(adminPermiso);
		logger.info("FINALIZANDO update / insert de authority_privilege");
	}
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AdminPermisoServiceImplTest... ******");
	}
	
}