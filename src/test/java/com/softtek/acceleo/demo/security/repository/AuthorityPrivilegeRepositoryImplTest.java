package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class AuthorityPrivilegeRepositoryImplTest {
	private static final Logger logger = Logger.getLogger(AuthorityPrivilegeRepositoryImplTest.class);

	@Autowired
	AuthorityPrivilegeRepository authorityPrivilegeRepository; 
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AuthorityPrivilegeRepositoryImplTest... ******");
	}
	
	@Ignore
	@Test
	public void testGetAuthorityPrivilege() {
		List<AuthorityPrivilege> lstAuthorityPrivilege = authorityPrivilegeRepository.getAuthorityPrivilege();
		
		if( lstAuthorityPrivilege == null || lstAuthorityPrivilege.isEmpty() ) {
			logger.info("No se encontro informacion.");
		}else {
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
			logger.info("El numero de registros: " + lstAuthorityPrivilege.size());
			for(AuthorityPrivilege authorityPrivilege : lstAuthorityPrivilege) {
				logger.info("Nivel 1 -- AuthorityPrivilege ---->> IdAutorityPrivilege: " + authorityPrivilege.getIdAutorityPrivilege() + "\tIdAuthority: " + authorityPrivilege.getIdAuthority() + "\tIdPrivilege: " + authorityPrivilege.getIdPrivilege());
				logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
				logger.info("  Nivel 1.1 -- Authority ---->> Id: " + authorityPrivilege.getIdAuthority().getIdAuthority() + "\tName: " + authorityPrivilege.getIdAuthority().getName() + "\tPrivilege: " + authorityPrivilege.getIdAuthority().getPrivilege() /*+ "\tUser: " + authorityPrivilege.getIdAuthority().getUser()*/);
//				for(Privilege privilege : authorityPrivilege.getIdAuthority().getPrivilege()) {
//					logger.info("    Nivel 1.1.1 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tAuthority: " + privilege.getAuthority());
//					for(Authority authority : privilege.getAuthority()) {
//						logger.info("      Nivel 1.1.1.1 -- Authority ---->> Id: " + authority.getId() + "\tName: " + authority.getName());
//					}
//					
//				}				
//				for(User user : authorityPrivilege.getIdAuthority().getUser()) {
//					logger.info("    Nivel 1.1.2 -- User ---->> IdUser: " + user.getIdUser() + "\tUserName: " + user.getUserName() + "\tPassword: " + user.getPassword());
//				}
				
				
				logger.info("  Nivel 1.2 -- Privilege ---->> IdPrivilege: " + authorityPrivilege.getIdPrivilege().getIdPrivilege() + "\tName: " + authorityPrivilege.getIdPrivilege().getName() + "\tEnabled: " + authorityPrivilege.getIdPrivilege().getEnabled() + "\tAuthority: " + authorityPrivilege.getIdPrivilege().getAuthority() + "\tGrupo: " + authorityPrivilege.getIdPrivilege().getGrupo());
				for(Authority authority : authorityPrivilege.getIdPrivilege().getAuthority()) {
					logger.info("    Nivel 1.2.1 -- Authority ---->> Id: " + authority.getIdAuthority() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege() /*+ "\tUser: " + authority.getUser()*/);
					for(Privilege privilege : authority.getPrivilege()) {
						logger.info("      Nivel 1.2.2 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tGrupo: " + privilege.getGrupo());
						logger.info("      Nivel 1.2.3 -- Grupo ---->> IdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tName: " + privilege.getGrupo().getName());
					} 
				}
				
			}
		}
	}
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void testInsertAuthorityPrivilege() {
		AuthorityPrivilege authorityPrivilege = new AuthorityPrivilege();
		
		Authority authority = authorityRepository.getAuthority(3L);
		Privilege privilege = privilegeRepository.getPrivilege(1L);

		authorityPrivilege.setIdAuthority(authority);		
		authorityPrivilege.setIdPrivilege(privilege);
		authorityPrivilege.setEnabled(new Boolean(true));
		
		AuthorityPrivilege autPriv = authorityPrivilegeRepository.getAuthorityPrivilege(authorityPrivilege);
		if( autPriv == null) {			
			authorityPrivilegeRepository.insertAuthorityPrivilege(authorityPrivilege);
			logger.info("El registro no existia, por lo cual se inserto exitosamente...");
		}else {
			authorityPrivilegeRepository.updateAuthorityPrivilege(authorityPrivilege);
			logger.info("El registro se actualizo exitosamente...");
		}
	}

	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AuthorityPrivilegeRepositoryImplTest... ******");
	}
	
}