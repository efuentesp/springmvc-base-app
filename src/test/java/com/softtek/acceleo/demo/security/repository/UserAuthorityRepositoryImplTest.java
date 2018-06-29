package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.fail;

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
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.domain.UserAuthority;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class UserAuthorityRepositoryImplTest {
	private static final Logger logger = Logger.getLogger(UserAuthorityRepositoryImplTest.class);
	
	@Autowired
	UserAuthorityRepository userAuthorityRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - UserAuthorityRepositoryImplTest... ******");
	}

	@Test
	public void testFindByUsername() {
		User user = new User();
		user.setIdUser(1L);
		
		List<UserAuthority> lstUserAuthority = userAuthorityRepository.findByUsername(user);
		if( lstUserAuthority == null || lstUserAuthority.isEmpty() ) {
			logger.info("No se encontro informacion relacionada al user...");
		}else {
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
			logger.info("Numero de registros: " + lstUserAuthority.size());			
			for(UserAuthority userAuthority : lstUserAuthority) {
				logger.info("Nivel 1 -- UserAuthority ---->> IdUserAuthority: " + userAuthority.getIdUserAuthority() + "\tIdUser: " + userAuthority.getIdUser() + "\tIdAuthority: " + userAuthority.getIdAuthority());
				
				logger.info("  Nivel 1.1 -- User ---->> IdUser: " + userAuthority.getIdUser().getIdUser() + "\tUserName: " + userAuthority.getIdUser().getUserName() + 
						    "\tAuthority: " /*+ userAuthority.getIdUser().getAuthority()*/);
//				for(Authority authority : userAuthority.getIdUser().getAuthority()) {
//					logger.info("    Nivel 1.1.1 -- Authority ---->> Id: " + authority.getId() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege());
//					for(Privilege privilege :  authority.getPrivilege()) {
//						logger.info("      Nivel 1.1.1.1 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tGrupo: " + privilege.getGrupo());
//						logger.info("        Nivel 1.1.1.1.1 -- Grupo ---->> IdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tName: " + privilege.getGrupo().getName());
//					}
//				}
				
				logger.info("  Nivel 1.2 -- Authority ---->> Id: " + userAuthority.getIdAuthority().getIdAuthority() + "\tName: " + userAuthority.getIdAuthority().getName() + 
						    "\tPrivilege: " + userAuthority.getIdAuthority().getPrivilege());
				for(Privilege privilege : userAuthority.getIdAuthority().getPrivilege()) {
					logger.info("    Nivel 1.2.1 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tGrupo" + privilege.getGrupo());
					logger.info("      Nivel 1.2.1.1 -- Grupo ---->> IdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tName: " + privilege.getGrupo().getName());
				}
				
			} 
			
			
		}
	}	
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - UserAuthorityRepositoryImplTest... ******");
	}

}
