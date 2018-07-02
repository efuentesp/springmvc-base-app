package com.softtek.acceleo.demo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getIdUser(),
                user.getUserName(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                //mapToGrantedPrivileges(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }
    
//    private static List<GrantedAuthority> mapToGrantedPrivileges(List<Authority> authorities) {
//  
//		List<Privilege> privileges = new ArrayList<Privilege>();
//		
//		for(Authority a: authorities){
//			for (Privilege p: a.getPrivilege()){
//				privileges.add(p);
//			}
//		}
//		
//		
//		return privileges.stream()
//	          .map(privilege -> new SimpleGrantedAuthority(privilege.getName()))
//	          .collect(Collectors.toList());
//		}
  
}
