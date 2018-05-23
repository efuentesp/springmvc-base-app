package com.softtek.spring.seguridad.impl;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.spring.seguridad.IPruebaJUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/applicationContext.xml")
public class PruebaJUnitImplTest {
	private static final Logger logger = Logger.getLogger(PruebaJUnitImplTest.class);
	
	@Autowired
	IPruebaJUnit pruebaJUnit;
	
	@Before
	public void initJUnit() {
		logger.info("****** Iniciando prueba de JUnit... ******");
	}
	
	@Test
	public void testImpresorMensajes() {
		try {
			pruebaJUnit.impresorMensajes("Mensaje para validar la correcta invocación del JUnit...");
		}catch(Exception e) {
			logger.error("****** Error JUnit: " + e);
		} 
	}
	
	@After
	public void finJUnit(){
		logger.info("****** Finalizando prueba de JUnit... ******");
	}
}
