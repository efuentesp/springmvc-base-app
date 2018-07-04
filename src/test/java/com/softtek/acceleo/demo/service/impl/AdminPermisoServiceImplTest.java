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
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.ConfigAuthority;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.service.AdminPermisoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
//@Transactional
//@Rollback(false)
public class AdminPermisoServiceImplTest {
	private static final Logger logger = Logger.getLogger(AdminPermisoServiceImplTest.class);

	@Autowired
	AdminPermisoService adminPermisoService;
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AdminPermisoServiceImplTest... ******");
	}

	//@Ignore
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateAuthorityPrivilege() {
		List<ConfigAuthority> lstConfigAuthority = new ArrayList<>();
		Long idPrivilege = 1L;
		String namePrivilege = "ROLE_AFILIADOCREATE";
		Long idGrupo = 1L;
		String nameGrup = "AFILIADO";
		Long activarUser = 1L;
		Boolean enabled = Boolean.TRUE;
		
		List<Authority> lstAuthority = authorityRepository.getAuthority();
		for(Authority authority : lstAuthority) {
			ConfigAuthority configAuthority = new ConfigAuthority();
			
			configAuthority.setIdAuthority(authority.getIdAuthority());
			configAuthority.setIdPrivilege(idPrivilege);
			configAuthority.setNameAuthority(authority.getName());
			if( authority.getIdAuthority().longValue() == activarUser.longValue() ) {
				configAuthority.setEnabled(enabled);
			}
			
			lstConfigAuthority.add(configAuthority);
			
		}

		ConfigPermisos configPermisos = new ConfigPermisos();
		
		configPermisos.setIdGrupo(idGrupo);
		configPermisos.setNombreGrupo(nameGrup);
		configPermisos.setIdPrivilege(idPrivilege);		
		configPermisos.setNombrePrivilege(namePrivilege);
		configPermisos.setLstConfigAuthority(lstConfigAuthority);
		configPermisos.setActiveUser(activarUser);
				
		logger.info("INICIANDO update / insert de authority_privilege");
		adminPermisoService.updateAuthorityPrivilege(configPermisos);
		logger.info("FINALIZANDO update / insert de authority_privilege");
	}
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AdminPermisoServiceImplTest... ******");
	}
	
}