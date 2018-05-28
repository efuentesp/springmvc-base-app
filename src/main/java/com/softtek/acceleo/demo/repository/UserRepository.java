
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.User;

public interface UserRepository {

	
	 public void addUser(User user);   
	 
	 public void editUser(User user);
	   
	 public List<User> listUserss(User user);   
	    
	 public User getUser(int empid);   
	    
	 public void deleteUser(User user); 

	 public List<User> listUserssQuery(User user, String query, int page, int size);

	 public List<User> listUsersPagination(User user, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

	

 	public List<User> consultarInformacionPorUsuario(User user);
	
 	public List<User> consultarInformacionPorUsuario(String userName);
 	
 	public List<User> consultarInformacionPorUsuario2(User user);
	
}

