package com.softtek.spring.seguridad.impl;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.spring.seguridad.IJwtAuthenticationProvider;
import com.softtek.spring.seguridad.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/applicationContext.xml")
//@ContextConfiguration(classes = {AppConfig.class})
//@ContextConfiguration(locations = "classpath*: applicationContext.xml")
public class JwtAuthenticationProviderTest {
	private static final Logger logger = Logger.getLogger(JwtAuthenticationProviderTest.class);
	
	@Autowired//@Qualifier("TestJUnitTest")
	IJwtAuthenticationProvider jwtap;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - JwtAuthenticationProviderTest... ******");
	}
	
	@Test
	public void testRetrieveUserStringUsernamePasswordAuthenticationToken() {
		try {
			//User capturado en pantalla.
			String userName = "user01";
			
			//Password capturado en pantalla.
			String password = "user03";//user01 - OK   --- userTest - NO OK
			
			AuthenticatedUser ud = (AuthenticatedUser) jwtap.validarAutenticacionUser(password, userName);
			logger.info("---->>>> token: " + ud.getToken());
			logger.info("---->>>> roles: " + ud.getAuthorities());			
		} catch(AuthenticationException ae) {
			logger.error("****** Error: Autenticacion no valida - " + ae);
		} catch(Exception e) {
			logger.error("****** Error JUnit: " + e);
		} 
	}
	
	@After
	public void finJUnit(){
		logger.info("****** Finalizando prueba de JUnit - JwtAuthenticationProviderTest... ******");
	}

}
