package com.softtek.spring.interceptor.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.spring.seguridad.impl.JwtUtilImpl;

public class InterceptorImpl implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(InterceptorImpl.class);
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_ Ejecutando el metodo preHandle _-_-_-_-_-_-_-_-_-_-_-_-");
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_ Ejecutando el metodo postHandle _-_-_-_-_-_-_-_-_-_-_-_-");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_ Ejecutando el metodo afterCompletion _-_-_-_-_-_-_-_-_-_-_-_-");
	}

}
