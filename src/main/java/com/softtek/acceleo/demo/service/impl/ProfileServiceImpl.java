package com.softtek.acceleo.demo.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Profile;
import com.softtek.acceleo.demo.repository.ProfileRepository;
import com.softtek.acceleo.demo.service.ProfileService;

@Service("profileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProfileServiceImpl implements ProfileService{
	
private static final Logger logger = Logger.getLogger(ModuloServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile getProfileByToken(String token) {
		return profileRepository.getProfileByToken(token);
	}

}
