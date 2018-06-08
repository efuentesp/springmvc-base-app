package com.softtek.spring.seguridad.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SeguridadInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(SeguridadInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Before handling the request -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		
		logger.info("AuthType: " + request.getAuthType());
		logger.info("CharacterEncoding: " + request.getCharacterEncoding());
		logger.info("ContentLength: " + request.getContentLength());
		logger.info("ContentLengthLong: " + request.getContentLengthLong());
		logger.info("ContentType: " + request.getContentType());
		logger.info("ContextPath: " + request.getContextPath());
		logger.info("DateHeader-username: " + request.getDateHeader("username"));
		logger.info("DateHeader-password: " + request.getDateHeader("password"));
		logger.info("DateHeader-token: " + request.getDateHeader("token"));
		logger.info("DateHeader-authorities: " + request.getDateHeader("authorities"));
		logger.info("LocalAddr: " + request.getLocalAddr());
		logger.info("LocalName: " + request.getLocalName());
		logger.info("LocalPort: " + request.getLocalPort());
		logger.info("Method: " + request.getMethod());
		logger.info("Parameter-username: " + request.getParameter("username"));
		logger.info("Parameter-password: " + request.getParameter("password"));
		logger.info("Parameter-token: " + request.getParameter("token"));
		logger.info("Parameter-authorities: " + request.getParameter("authorities"));
		logger.info("PathInfo: " + request.getPathInfo());
		logger.info("PathTranslated: " + request.getPathTranslated());
		logger.info("Protocol: " + request.getProtocol());		
		logger.info("QueryString: " + request.getQueryString());
		logger.info("RemoteAddr: " + request.getRemoteAddr());
		logger.info("RemoteHost: " + request.getRemoteHost());
		logger.info("RemotePort: " + request.getRemotePort());
		logger.info("RemoteUser: " + request.getRemoteUser());
		logger.info("RequestedSessionId: " + request.getRequestedSessionId());
		logger.info("RequestURI: " + request.getRequestURI());
		logger.info("Scheme: " + request.getScheme());
		logger.info("ServerName: " + request.getServerName());
		logger.info("ServerPort: " + request.getServerPort());
		logger.info("ServletPath: " + request.getServletPath());
		/**logger.info("AsyncContext: " + request.getAsyncContext());*/
		logger.info("Class: " + request.getClass());
		logger.info("Cookies: " + request.getCookies());
		logger.info("DispatcherType: " + request.getDispatcherType());
		logger.info("HeaderNames: " + request.getHeaderNames());
		/**logger.info("HttpServletMapping: " + request.getHttpServletMapping());*/
		logger.info("InputStream: " + request.getInputStream());
		logger.info("Locale: " + request.getLocale());
		logger.info("Locales: " + request.getLocales());
		logger.info("ParameterMap: " + request.getParameterMap());
		logger.info("ParameterNames: " + request.getParameterNames());
		/**logger.info("Parts: " + request.getParts());*/
		/**logger.info("Reader: " + request.getReader());*/
		logger.info("RequestURL: " + request.getRequestURL());
		logger.info("ServletContext: " + request.getServletContext());
		logger.info("Session: " + request.getSession());
		/**logger.info("TrailerFields: " + request.getTrailerFields());*/
		logger.info("UserPrincipal: " + request.getUserPrincipal());
		logger.info("AttributeNames: " + request.getAttributeNames());
		
		boolean eureka = super.preHandle(request, response, handler);
		logger.info("eureka: " + eureka);
		
		
		return eureka && request.getCookies() == null && request.getRequestedSessionId() == null;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- After handling the request -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ After rendering the view -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		logger.info("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		super.afterCompletion(request, response, handler, ex);
	}	
}
