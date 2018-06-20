package com.softtek.acceleo.demo.catalogo.controller;

import java.nio.charset.Charset;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softtek.acceleo.demo.catalogo.api.BaseTest;

public class BaseControllerTest extends BaseTest{

	@Autowired
	private WebApplicationContext context;
	@Autowired
	ObjectMapper objectMapper;
	
	protected final static Locale LOCALE = new Locale("es", "MX");
	protected MockMvc mockMvc;
	protected MediaType contentType;
	
	@Override
	protected void setup() {
		super.setup();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		this.setUpContentType();
	}
	
	protected void setUpContentType() {
		this.contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
				Charset.forName("utf8"));
	}
	
}
