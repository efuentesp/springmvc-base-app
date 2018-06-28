package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AuthorityPrivilegeRepositoryImplTest... ******");
	}
	
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
				logger.info("  Nivel 1.1 -- Authority ---->> Id: " + authorityPrivilege.getIdAuthority().getId() + "\tName: " + authorityPrivilege.getIdAuthority().getName() + "\tPrivilege: " + authorityPrivilege.getIdAuthority().getPrivilege() + "\tUser: " + authorityPrivilege.getIdAuthority().getUser());
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
					logger.info("    Nivel 1.2.1 -- Authority ---->> Id: " + authority.getId() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege() + "\tUser: " + authority.getUser());
					for(Privilege privilege : authority.getPrivilege()) {
						logger.info("      Nivel 1.2.2 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tGrupo: " + privilege.getGrupo());
						logger.info("      Nivel 1.2.3 -- Grupo ---->> IdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tName: " + privilege.getGrupo().getName());
					} 
				}
				
			}
		}
	}

	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AuthorityPrivilegeRepositoryImplTest... ******");
	}
	
}

/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class UserRepositoryImplTest {
	private static final Logger logger = Logger.getLogger(UserRepositoryImplTest.class);

	@Autowired
	UserRepository userRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - UserRepositoryImplTest... ******");
	}
	
	
	@Test
	public void testFindByUsername() {
//		String userName = "admin";
		String userName = "user";
		
		User user = userRepository.findByUsername(userName);
		if( user != null ) {
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
			logger.info("Nivel 1 -- user --> Email: " + user.getEmail() + "\tFirstname: " + user.getFirstname() + "\tLastname: " + user.getLastname() + 
					    "\tPassword: " + user.getPassword() + "\tUsername: " + user.getUserName() + "\tAttemps: " + user.getAttemps() + 
					    "\tIdUser: " + user.getIdUser() + "\tAuthority" + user.getAuthority() +
					    "\tEnabled: " + user.getEnabled() + "\tLastPasswordResetDate: " + user.getLastPasswordResetDate());
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			for(Authority authority : user.getAuthority()) {
				logger.info("Nivel 2 -- authority --> Id: " + authority.getId() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege() + "\tUser: " + authority.getUser());	
				logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
				for(Privilege privilege : authority.getPrivilege()) {
					logger.info("Nivel 3 -- pivilege --> Name: " + privilege.getName() + "\tIdPrivilege: " + privilege.getIdPrivilege() + "\tAuthority: " + privilege.getAuthority() + 
							"\tEnabled: " + privilege.getEnabled() + "\tGrupo: " + privilege.getGrupo());
					
					
					logger.info("Nivel 4 -- grupo --> IdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tName: " + privilege.getGrupo().getName());
				}
				logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
			}
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
			
			
			
			
		}else {
			logger.info("No hay informacion del user...");
		}
		
	}
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - UserRepositoryImplTest... ******");
	}

}

 */