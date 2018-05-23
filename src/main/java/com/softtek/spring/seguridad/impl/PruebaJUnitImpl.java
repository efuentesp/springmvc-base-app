package com.softtek.spring.seguridad.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.softtek.spring.seguridad.IPruebaJUnit;

@Component
public class PruebaJUnitImpl implements IPruebaJUnit {
	private static final Logger logger = Logger.getLogger(PruebaJUnitImpl.class);
	
	@Override
	public void impresorMensajes(String msg) {
		logger.info("****** <<<< El mensaje a imprimir es: " + msg + " >>>>");
	}

}
