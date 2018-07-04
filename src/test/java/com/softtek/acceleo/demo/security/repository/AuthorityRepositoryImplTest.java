package com.softtek.acceleo.demo.security.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class AuthorityRepositoryImplTest {
	private static final Logger logger = Logger.getLogger(AuthorityRepositoryImplTest.class);
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - AuthorityRepositoryImplTest... ******");
	}

	@Ignore
	@Test
	public void testGetAuthority() {
		long idAuthority = 2;
		
		Authority  authority = authorityRepository.getAuthority(idAuthority);
		logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
		logger.info("Id: " + authority.getIdAuthority() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege());
		for(Privilege privilege : authority.getPrivilege()) {
			logger.info("IdGroup: " + privilege.getGrupo() + "\tIdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tGrupo-Name: " + privilege.getGrupo().getName() + "\tName: " + privilege.getName() + "\tId_privilege: " + privilege.getIdPrivilege() + 
					"\tEnabled: " + privilege.getEnabled() + "\tCreationdate: " + privilege.getCreationdate() + "\tModifieddate: " + privilege.getModifieddate());
		}
		logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
	}
	
	@Test
	public void testGetLstAuthority() {
		List<Authority> lstAuthority = authorityRepository.getAuthority();
		logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
		for(Authority authority : lstAuthority) {
			logger.info("Id: " + authority.getIdAuthority() + "\tName: " + authority.getName() + "\tPrivilege: " + authority.getPrivilege());
			for(Privilege privilege : authority.getPrivilege()) {
				logger.info("IdGroup: " + privilege.getGrupo() + "\tIdGrupo: " + privilege.getGrupo().getIdGrupo() + "\tGrupo-Name: " + privilege.getGrupo().getName() + "\tName: " + privilege.getName() + "\tId_privilege: " + privilege.getIdPrivilege() + 
						"\tEnabled: " + privilege.getEnabled() + "\tCreationdate: " + privilege.getCreationdate() + "\tModifieddate: " + privilege.getModifieddate());
			}
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		}
		logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
	}
	
	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - AuthorityRepositoryImplTest... ******");
	}

}
