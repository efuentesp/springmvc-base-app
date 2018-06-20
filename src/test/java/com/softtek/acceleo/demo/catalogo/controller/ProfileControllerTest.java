package com.softtek.acceleo.demo.catalogo.controller;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.softtek.acceleo.demo.service.ProfileService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:pom.xml","classpath:dispatcher-servlet.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfileControllerTest extends BaseControllerTest{
		
		@Mock
		private ProfileService profileService; 

		@Before
		public void setup() {
			super.setup();
		}

		@Test
		public void getProfileByToken() throws Exception {
			final String url = new StringBuilder()
					.append(ProfileController.CONTRACT_BASE_URI)
					.append("/").append("profile")
					.append("/").append("{token}").toString();
			
			//when(profileService.getProfileByToken(isA(String.class))).thenReturn(super.profile);
			
			final RequestBuilder request = MockMvcRequestBuilders
					.get(url,super.profile.getToken())
					.accept(contentType)
					.contentType(contentType);
			
	        super.mockMvc.perform(request)
			.andExpect(status().isOk())		
			.andExpect(jsonPath("$.status").value(200))
			.andExpect(jsonPath("$.responseBody.countryId").value(super.profile.getToken()))
			.andDo(print())
			.andReturn();
		}
		
}
