

package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.UserAuthorityRepository;
import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.service.UserAuthorityService;

@Service("userauthorityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserAuthorityServiceImpl implements UserAuthorityService {

	@Autowired
	private UserAuthorityRepository userauthorityRepository;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUserAuthority(UserAuthority userauthority) {
		
		userauthorityRepository.addUserAuthority(userauthority);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editUserAuthority(UserAuthority userauthority) {
		
		userauthorityRepository.editUserAuthority(userauthority);
	}
	
	
	public List<UserAuthority> listUserAuthorityss(UserAuthority userauthority) {

		return userauthorityRepository.listUserAuthorityss(userauthority);
	}

	public UserAuthority getUserAuthority(int empid) {

		return userauthorityRepository.getUserAuthority(empid);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserAuthority(UserAuthority userauthority) {
		System.out.println("Entrando al deleteUserAuthority");

		 userauthorityRepository.deleteUserAuthority(userauthority);
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<UserAuthority> listUserAuthoritysPagination(UserAuthority userauthority, int page, int size) {

		return userauthorityRepository.listUserAuthoritysPagination(userauthority, page, size);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return userauthorityRepository.getTotalRowsSearch(query);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return userauthorityRepository.getTotalRows(query);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {

		return userauthorityRepository.getTotalRows();
	}

	


	public List<UserAuthority> listUserAuthorityssQuery(UserAuthority userauthority, String query, int page, int size) {
		// TODO Auto-generated method stub
		return userauthorityRepository.listUserAuthorityssQuery(userauthority, query, page, size);
	}


	

	

}

