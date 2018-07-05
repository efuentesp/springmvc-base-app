package com.softtek.acceleo.demo.service;

import com.softtek.acceleo.demo.domain.Authority;
import java.util.List;

public interface AuthorityService {

	public void addAuthority(Authority authority);

	public void editAuthority(Authority authority);
	
	public List<Authority> listAuthorityss(Authority authority);
	
	public List<Authority> listAuthoritys();

	public Authority getAuthority(Long empid);

	public void deleteAuthority(Authority authority);
	
	public List<Authority> listAuthorityssQuery(Authority authority, String query, int page, int size);

	public List<Authority> listAuthoritysPagination(Authority authority, int page, int size);
	
	public List<Authority> getAuthority();

	public long getTotalRows();

	public long getTotalRows(String query);

	public long getTotalRowsSearch(String query);

	

	

	
}

