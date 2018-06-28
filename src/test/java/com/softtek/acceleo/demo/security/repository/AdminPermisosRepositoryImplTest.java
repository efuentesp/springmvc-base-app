package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;

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

	@Test
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

	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AdminPermisosRepositoryImplTest... ******");
	}
	
}

/**
 * package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

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
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

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
**/