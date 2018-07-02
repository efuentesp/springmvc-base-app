package com.softtek.acceleo.demo.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.security.JwtTokenUtil;
import com.softtek.acceleo.demo.security.JwtUser;
import com.softtek.acceleo.demo.service.UserService;

@RestController
public class UserRestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
	@Autowired
	private UserService userService;
	
	User user = new User();

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
    	logger.info("User REST :"+tokenHeader);
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "userList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {


		List<User> listUser = null;
       	listUser = userService.listUserss(user);
       	
       	Set<User> hs = new HashSet<User>();
       	hs.addAll(listUser);
       	listUser.clear();
       	listUser.addAll(hs);
       	
		System.out.print("Conttroller - Cantidad" + listUser.size());
		System.out.print("Fin Conttroller - userList ");
		return listUser;
	}

}
