package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.Authority;

public interface AuthorityRepository {

	 public Authority getAuthority(long authoritoryId);
	 
	 public List<Authority> getAuthority();
}
