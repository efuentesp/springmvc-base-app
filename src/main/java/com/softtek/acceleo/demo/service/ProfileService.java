package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Profile;

public interface ProfileService {

	public Profile getProfileByToken(String token);
	
}
