package com.softtek.acceleo.demo.catalogo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.Profile;
import com.softtek.acceleo.demo.service.ProfileService;

@Controller
@RequestMapping(value = ProfileController.CONTRACT_BASE_URI)
public class ProfileController {

	private static final Logger logger = Logger.getLogger(AccionController.class);
	public final static String CONTRACT_BASE_URI = "/SADF";
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/profile/{token}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody  Profile getProfileByToken(@PathVariable("token") String token) {
        
        Profile profile = null;
        profile = profileService.getProfileByToken(token);
		return profile;
 }

	
}
