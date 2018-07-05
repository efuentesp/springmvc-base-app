package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.ConfigAuthority;
import com.softtek.acceleo.demo.domain.ConfigPermisos;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.security.repository.AdminPermisosRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.security.repository.PrivilegeRepository;
import com.softtek.acceleo.demo.service.AdminPermisoService;

/**
 * Clase AdminPermisoServiceImpl.
 * @author PSG.
 *
 */
@Service("adminPermisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminPermisoServiceImpl implements AdminPermisoService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private AdminPermisosRepository adminPermisoRepository;
	
	@Autowired
	AuthorityPrivilegeRepository authorityPrivilegeRepository; 
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	

	/**
	 * Consulta informacion de adminPermiso.
	 */
	public List<ConfigPermisos> listAdminPermiso() {
		return adminPermisoRepository.getConfiguracionPermisos();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateAuthorityPrivilege(ConfigPermisos configPermisos) {
		AuthorityPrivilege authorityPrivilege = new AuthorityPrivilege();
		Long authorityID = null;
		Long privilegeID = null; 
		Boolean flag = Boolean.FALSE;
		
		if( configPermisos.getLstConfigAuthority() == null || configPermisos.getLstConfigAuthority().isEmpty() ) {
			logger.info("No existe informacion de los authority");
		}else {
			List<ConfigAuthority> lstConfigAuthority = configPermisos.getLstConfigAuthority();
			
			for(ConfigAuthority configAuth : lstConfigAuthority) {
				if( configAuth.getIdAuthority().longValue() == configPermisos.getActiveUser().longValue() ) {
					authorityID = configAuth.getIdAuthority();
					privilegeID = configAuth.getIdPrivilege() == null ? configPermisos.getIdPrivilege() : configAuth.getIdPrivilege();
					flag = configAuth.getEnabled();
					break;
				}
			}			
		}

		Authority authority = authorityRepository.getAuthority(authorityID);
		Privilege privilege = privilegeRepository.getPrivilege(privilegeID);
		
		authorityPrivilege.setIdAuthority(authority);		
		authorityPrivilege.setIdPrivilege(privilege);
		authorityPrivilege.setEnabled(flag);
		
		AuthorityPrivilege autPriv = authorityPrivilegeRepository.getAuthorityPrivilege(authorityPrivilege);

		if( autPriv == null) {			
			authorityPrivilegeRepository.insertAuthorityPrivilege(authorityPrivilege);
			logger.info("El registro no existe, por lo cual se inserto exitosamente.");
		}else {
			autPriv.setEnabled(flag);			
			authorityPrivilegeRepository.updateAuthorityPrivilege(autPriv);
			logger.info("El registro se actualizo exitosamente...");
		}		
	}
	
}
