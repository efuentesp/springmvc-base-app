package com.softtek.acceleo.demo.security.repository;

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
		String userName = "admin";
		
		User user = userRepository.findByUsername(userName);
		if( user != null ) {
			logger.info("/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
			logger.info("Email: " + user.getEmail() + "\tFirstname: " + user.getFirstname() + "\tLastname: " + user.getLastname() + 
					    "\tPassword: " + user.getPassword() + "\tUsername: " + user.getUserName() + "\tId: " + user.getIdUser() + "\tAuthorities" + user.getAuthorities() +
					    "\tEnabled: " + user.getEnabled() + "\tLastPasswordResetDate: " + user.getLastPasswordResetDate() + "\tRole: " + user.getRole());
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
