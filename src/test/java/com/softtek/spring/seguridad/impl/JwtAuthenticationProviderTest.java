package com.softtek.spring.seguridad.impl;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.spring.seguridad.JwtAuthenticationProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/applicationContext.xml")
//@ContextConfiguration(classes = {AppConfig.class})
//@ContextConfiguration(locations = "classpath*: applicationContext.xml")
@TransactionConfiguration
@Transactional
public class JwtAuthenticationProviderTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger logger = Logger.getLogger(JwtAuthenticationProviderTest.class);
	
	@Autowired
	JwtAuthenticationProvider jwtap;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit - JwtAuthenticationProviderTest... ******");
	}
	
	/**
	 * 
	 */
	@Test
	public void testRetrieveUserStringUsernamePasswordAuthenticationToken() {
		try {
	    	User user = new User();
	    	user.setIdUser(1);
	    	user.setUserName("user01");//User capturado en pantalla.
	    	user.setPassword("user01");//Password capturado en pantalla.
	    	user.setRol("administrador");
						
			/**
			 * Genera token de pruebas JUnit cuando no se conoce el token del password. (ESTE TOKEN ES EL EQUIVALENTE AL QUE SE DEBE OBTENER DE BASE DE DATOS)
			 * El token generado se debe sustituir en el metodo jwtap.validarAutenticacionUser(password, userName) donde se obtiene el token de base de datos.
			 **/
			//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDEiLCJ1c2VySWQiOiIxIiwicm9sZSI6ImFkbWluIn0.ssZU4ybtaPVkgRHsvxM3rGZ6QQN7gi2cFU42mmJ-1ooVV9zxlJfxarJ9omCLi5Nd3qSPcF2QCBVLPNSzf9KRuw";//user01
			//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDIiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.lCVVfVgFlMq7FIRUHZs9adC2YrmgOJ5MdcDbvdjQh9FD53AC8mLqgFr_PND5uvGWBUU7nPGhYsu46GB1sxJwMw";//user02
			//String passwordToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDMiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.Yx78P6YRQcJkiA04ldaWqUjtxTyiZOPztBpbVkoUKabiC_A2U7jKT0IAE1FigKYy1jrUCjsnooEqwkWp6SO4BQ";//user03		
			String passwordToken = jwtap.makerToken(user); 
			logger.info("***+++passwordToken: " + passwordToken);
			
			AuthenticatedUser ud = (AuthenticatedUser) jwtap.validarAutenticacionUser(user.getPassword(), user.getUserName());
			logger.info("---->>>> token: " + ud.getToken());
			logger.info("---->>>> roles: " + ud.getAuthorities());	
			logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Exito: Autenticación de usuario OK. -_-_-_-_-_-_-_-_-_-_-_-_-_-_");
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
