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

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;

import org.apache.log4j.Logger;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
@Transactional
public class PrivilegeRepositoryImpltest {
	private static final Logger logger = Logger.getLogger(UserRepositoryImplTest.class);

	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - PrivilegeRepositoryImpltest... ******");
	}

	@Test
	public void testGetPrivilege() {
		try {
			List<Privilege> lstPrivilege = privilegeRepository.getPrivilege();
			
			if( lstPrivilege == null || lstPrivilege.isEmpty() ) {
				logger.info("No se encontraron registros...");
			}else {
				logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
				logger.info("******Iniciando");
				for(Privilege privilege : lstPrivilege) {
					logger.info("Nivel 1 -- Privilege ---->> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName() + "\tEnabled: " + privilege.getEnabled() + "\tAuthority: " + privilege.getAuthority());
					for(Authority authority : privilege.getAuthority()) {
						logger.info("Nivel 1.1 -- Authority ---->> Id: " + authority.getIdAuthority() + "\tName: " + authority.getName());
					}
					
				}
				logger.info("******Finalizando");
			}
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
	}

	@After
	public void finJUnit() {
		logger.info("****** Finalizando prueba de JUnit - PrivilegeRepositoryImpltest... ******");
	}	
}

