package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.AuthorityPrivilege;

public interface AuthorityPrivilegeRepository {

	AuthorityPrivilege getAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
		
	List<AuthorityPrivilege> getAuthorityPrivilege();
	
	void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
	
	void insertAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
}
