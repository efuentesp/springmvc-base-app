package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;

public interface AuthorityPrivilegeRepository {

	AuthorityPrivilege getAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
		
	List<AuthorityPrivilege> getAuthorityPrivilege();
	
	List<AuthorityPrivilege> getAuthorityPrivilegePorIdAuthority(Authority authority);
	
	void updateAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
	
	void insertAuthorityPrivilege(AuthorityPrivilege authorityPrivilege);
	
	void deleteAuthority(AuthorityPrivilege authorityPrivilege);
	
	void deleteAuthorities(Authority authority);
	
}
