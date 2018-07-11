package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.domain.UserAuthority;

public interface UserAuthorityRepository {
	List<UserAuthority> findByUsername(User user);
	List<UserAuthority> findUserAuthorityByIdAuthority(Authority authority);
}
