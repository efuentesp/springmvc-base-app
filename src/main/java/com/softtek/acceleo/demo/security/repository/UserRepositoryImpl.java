package com.softtek.acceleo.demo.security.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.security.model.Authority;
import com.softtek.acceleo.demo.security.model.AuthorityName;
import com.softtek.acceleo.demo.security.model.User;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User findByUsername(String username) {
		
		logger.info("findByUsername() :"+username);
		
		User user=null;
		if (username.equals("admin")) {
			user = new User();
			user.setId((long) 1);
			user.setUsername(username);
			user.setPassword("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setEmail("admin@admin.com");
			user.setEnabled(true);
			
			java.util.Date da = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(da);
		    cal.add(Calendar.MONTH, -1);
		    da = cal.getTime();
			user.setLastPasswordResetDate(da);
			
			Authority aut1 =new Authority();
			
			aut1.setId((long) 1);
			aut1.setName(AuthorityName.ROLE_USER);
			Authority aut2 =new Authority();
			
			aut2.setId((long) 2);
			aut2.setName(AuthorityName.ROLE_ADMIN);

			List<Authority> listAuthority = new ArrayList<Authority>(); 
			
			listAuthority.add(aut1);
			listAuthority.add(aut2);

			user.setAuthorities(listAuthority);
			
		}
		if (username.equals("user")) {
			user = new User();
			user.setId((long) 2);
			user.setUsername(username);
			user.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
			user.setFirstname("user");
			user.setLastname("user");
			user.setEmail("user@user.com");
			user.setEnabled(true);
			
			java.util.Date da = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(da);
		    cal.add(Calendar.MONTH, -1);
		    da = cal.getTime();
			user.setLastPasswordResetDate(da);
			
			Authority aut1 =new Authority();

			List<Authority> listAuthority = new ArrayList<Authority>(); 
			
			aut1.setId((long) 1);
			aut1.setName(AuthorityName.ROLE_USER);
			listAuthority.add(aut1);
			aut1 =new Authority();
			
			aut1.setId((long) 3);
			aut1.setName(AuthorityName.ROLE_AFILIADOCREATE);
			listAuthority.add(aut1);
			aut1 =new Authority();
			
			aut1.setId((long) 4);
			aut1.setName(AuthorityName.ROLE_AFILIADODELETE);
			listAuthority.add(aut1);
			aut1 =new Authority();
			
			aut1.setId((long) 5);
			aut1.setName(AuthorityName.ROLE_AFILIADOSEARCH);
			listAuthority.add(aut1);
			aut1 =new Authority();
			
			aut1.setId((long) 5);
			aut1.setName(AuthorityName.ROLE_AFILIADOUPDATE);
			listAuthority.add(aut1);
			aut1 =new Authority();
			
			user.setAuthorities(listAuthority);
			
		}
		if (username.equals("disabled")) {
			user = new User();
			user.setId((long) 3);
			user.setUsername(username);
			user.setPassword("$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
			user.setFirstname("user");
			user.setLastname("user");
			user.setEmail("disabled@user.com");
			user.setEnabled(false);
			
			java.util.Date da = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(da);
		    cal.add(Calendar.MONTH, -1);
		    da = cal.getTime();
			user.setLastPasswordResetDate(da);
			
			Authority aut1 =new Authority();
			
			aut1.setId((long) 1);
			aut1.setName(AuthorityName.ROLE_USER);

			List<Authority> listAuthority = new ArrayList<Authority>(); 
			
			listAuthority.add(aut1);

			user.setAuthorities(listAuthority);
			
		}
		return user;
	}

}
