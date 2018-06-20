package com.softtek.acceleo.demo.repository;

import com.softtek.acceleo.demo.domain.Profile;

public interface ProfileRepository {

	public Profile getProfileByToken(String token);   
}
