
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.UserAuthority;
import com.softtek.acceleo.demo.exception.GenericException;

public interface UserAuthorityRepository {

	
	 public void addUserAuthority(UserAuthority userauthority);   
	 
	 public void editUserAuthority(UserAuthority userauthority);
	   
	 public List<UserAuthority> listUserAuthorityss(UserAuthority userauthority);   
	    
	 public UserAuthority getUserAuthority(int empid);   
	    
	 public void deleteUserAuthority(UserAuthority userauthority) throws GenericException; 

	 public List<UserAuthority> listUserAuthorityssQuery(UserAuthority userauthority, String query, int page, int size);

	 public List<UserAuthority> listUserAuthoritysPagination(UserAuthority userauthority, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

	

 			

	
}

