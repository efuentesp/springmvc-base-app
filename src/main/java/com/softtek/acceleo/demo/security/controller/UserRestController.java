package com.softtek.acceleo.demo.security.controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softtek.acceleo.demo.domain.Afiliado;
import com.softtek.acceleo.demo.domain.Authority;
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
    public PasswordEncoder passwordEncoder;

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
    
    
    /**
    * Crea un nuevo afiliado.
    * @param afiliado.
    * @param ucBuilder.
    * @return ResponseEntity.
    */

    @RequestMapping(value = "/user/{username}/{privileges}", method = RequestMethod.POST)
        public ResponseEntity<Void> createAfiliado(@RequestBody User user, @PathVariable("username") String userName,  @PathVariable("privileges") String privileges, UriComponentsBuilder ucBuilder) {
       
                 user.setCreationDate(new Date()); 
                 user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setUserName(userName);
                user.setEnabled(true);
                user.setLastPasswordResetDate(new Date());
                
                 List<Authority> auths = new ArrayList<>();
                Authority auth = new Authority();
                auth.setIdAuthority(new Long(privileges)); ;
                auths.add(auth);
                
                 user.setAuthorities(auths);
                
            userService.addUser(user);
            
     
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/afiliado/{id}").buildAndExpand(user.getIdUser()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
