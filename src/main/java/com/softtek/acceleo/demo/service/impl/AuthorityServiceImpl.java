

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.service.AuthorityService;

@Service("authorityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAuthority(Authority authority) {
		
		authorityRepository.addAuthority(authority);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editAuthority(Authority authority) {
		
		authorityRepository.editAuthority(authority);
	}
	
	
	public List<Authority> listAuthorityss(Authority authority) {

		return authorityRepository.listAuthorityss(authority);
	}
	
	

	public Authority getAuthority(int empid) {

		return authorityRepository.getAuthority(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteAuthority(Authority authority) {
		System.out.println("Entrando al deleteAuthority");

		 authorityRepository.deleteAuthority(authority);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Authority> listAuthoritysPagination(Authority authority, int page, int size) {

		return authorityRepository.listAuthoritysPagination(authority, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return authorityRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return authorityRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return authorityRepository.getTotalRows();
	}

	


	public List<Authority> listAuthorityssQuery(Authority authority, String query, int page, int size) {
		return authorityRepository.listAuthorityssQuery(authority, query, page, size);
	}

	@Override
	public Authority getAuthority(Long empid) {
		return authorityRepository.getAuthority(empid);
	}

	@Override
	public List<Authority> getAuthority() {
		return authorityRepository.getAuthority();
	}

	@Override
	public List<Authority> listAuthoritys() {
		return authorityRepository.getAuthority();
	}


	

	

}

