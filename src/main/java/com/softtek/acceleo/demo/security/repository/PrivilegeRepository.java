package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.Privilege;

public interface PrivilegeRepository {
	Privilege getPrivilege(long idPrivilege);
	
	List<Privilege> getPrivilege();
}
