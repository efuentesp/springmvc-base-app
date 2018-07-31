package com.softtek.acceleo.demo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

public final class JwtUserFactory {
	private static final Logger logger = Logger.getLogger(JwtUserFactory.class);

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(user.getIdUser(), user.getUserName(), user.getFirstname(), user.getLastname(),
				user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getAuthorities()), user.getEnabled(),
				user.getLastPasswordResetDate());
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		// Barrer los autorities
		// Por cada Autority obtener privilegios
		// Y cada nombre de privilegio crear un arrglo de GrantedAuthority
		List<GrantedAuthority> listGrantedAuthority = new ArrayList<>();
		String prefijoRole = "ROLE_";

		logger.info(
				"/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");
		logger.info("Iniciando convert AUTHORITY --> PRIVILEGE:");
		for (Authority authority : authorities) {
			logger.info("JAAAAAS" + authority.getEnabled());
			//Si al obtener el rol (Authority) no esta habilitado
			//no se agregan los privilegios
			if (authority.getEnabled())
				for (Privilege privilege : authority.getPrivilege()) {
					listGrantedAuthority.add(new SimpleGrantedAuthority(prefijoRole + privilege.getName()));
					logger.info("Name: " + prefijoRole + privilege.getName());
				}
		}
		logger.info("Finalizando convert AUTHORITY --> PRIVILEGE:");
		logger.info(
				"/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_");

		return listGrantedAuthority;

		// return authorities.stream()
		// .map(authority -> new SimpleGrantedAuthority(authority.getName))
		// .collect(Collectors.toList());
	}

	// private static List<GrantedAuthority> mapToGrantedPrivileges(List<Authority>
	// authorities) {
	//
	// List<Privilege> privileges = new ArrayList<Privilege>();
	//
	// for(Authority a: authorities){
	// for (Privilege p: a.getPrivilege()){
	// privileges.add(p);
	// }
	// }
	//
	//
	// return privileges.stream()
	// .map(privilege -> new SimpleGrantedAuthority(privilege.getName()))
	// .collect(Collectors.toList());
	// }

}
