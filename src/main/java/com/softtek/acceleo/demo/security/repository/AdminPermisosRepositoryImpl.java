package com.softtek.acceleo.demo.security.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.softtek.acceleo.demo.domain.AdminPermiso;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository("adminPermisosRepository")
public class AdminPermisosRepositoryImpl implements AdminPermisosRepository {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<AdminPermiso> getPermisos() {
		List<AdminPermiso> lstAdminPermisos = new ArrayList();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			
			SQLQuery query = session.createSQLQuery("select g.ID_GRUPO, g.NAME, p.ID_PRIVILEGE, p.NAME, (CASE WHEN ra.ENABLED is null THEN 0 ELSE ra.ENABLED END) as 'ADMIN', (CASE WHEN ru.ENABLED is null THEN 0 ELSE ru.ENABLED END) as 'USER', (CASE WHEN ran.ENABLED is null THEN 0 ELSE ran.ENABLED END) as 'ANONYMOUS', ra.ID_PRIVILEGE, ra.ID_AUTHORITY, ru.ID_PRIVILEGE, ru.ID_AUTHORITY, ran.ID_PRIVILEGE, ran.ID_AUTHORITY\r\n" + 
					"from demoacceleo.grupo g, demoacceleo.privilege p \r\n" + 
					"left outer join (select a.ENABLED, a.ID_PRIVILEGE, a.ID_AUTHORITY\r\n" + 
					"				 from demoacceleo.authority_privilege a, demoacceleo.authority b, demoacceleo.privilege c\r\n" + 
					"				 where a.ID_AUTHORITY = b.ID_AUTHORITY\r\n" + 
					"				 and a.ID_PRIVILEGE = c.ID_PRIVILEGE\r\n" + 
					"				 and b.name = 'ROLE_ADMIN'\r\n" + 
					"				 order by c.NAME desc) ra\r\n" + 
					"ON(p.ID_PRIVILEGE = ra.ID_PRIVILEGE) \r\n" + 
					"left outer join (select a.ENABLED, a.ID_PRIVILEGE, a.ID_AUTHORITY\r\n" + 
					"				 from demoacceleo.authority_privilege a, demoacceleo.authority b, demoacceleo.privilege c\r\n" + 
					"				 where a.ID_AUTHORITY = b.ID_AUTHORITY\r\n" + 
					"				 and a.ID_PRIVILEGE = c.ID_PRIVILEGE\r\n" + 
					"				 and b.name = 'ROLE_USER'\r\n" + 
					"				 order by c.NAME desc) ru\r\n" + 
					"ON(p.ID_PRIVILEGE = ru.ID_PRIVILEGE)                 \r\n" + 
					"left outer join (select a.ENABLED, a.ID_PRIVILEGE, a.ID_AUTHORITY\r\n" + 
					"				 from demoacceleo.authority_privilege a, demoacceleo.authority b, demoacceleo.privilege c\r\n" + 
					"				 where a.ID_AUTHORITY = b.ID_AUTHORITY\r\n" + 
					"				 and a.ID_PRIVILEGE = c.ID_PRIVILEGE\r\n" + 
					"				 and b.name = 'ROLE_ANONYMOUS'\r\n" + 
					"				 order by c.NAME desc) ran\r\n" + 
					"ON (p.ID_PRIVILEGE = ran.ID_PRIVILEGE)                 \r\n" + 
					"where g.ID_GRUPO = p.ID_GRUPO and p.ENABLED = 1");
			
			List<Object[]> lstAdminPerm =  query.list();
			
			for(Object[] row : lstAdminPerm) {
				AdminPermiso adminPermiso = new AdminPermiso();
				
				adminPermiso.setIdGrupo(row[0] == null ? null : Long.parseLong(row[0].toString()));
				adminPermiso.setNombreGrupo(row[1] == null ? null : row[1].toString());
				adminPermiso.setIdPrivilege(row[2] == null ? null : Long.parseLong(row[2].toString()));
				adminPermiso.setNombrePrivilege(row[3] == null ? null : row[3].toString());
				adminPermiso.setAdmin(row[4] == null ? new Boolean("0") : Boolean.parseBoolean(row[4].toString()));
				adminPermiso.setUser(row[5] == null ? new Boolean("0") : Boolean.parseBoolean(row[5].toString()));
				adminPermiso.setAnonymous(row[6] == null ? new Boolean("0") : Boolean.parseBoolean(row[6].toString()));
				adminPermiso.setIdAuthorityAdmin(row[7] == null ? null : Long.parseLong(row[7].toString()));
				adminPermiso.setIdPrivilegeAdmin(row[8] == null ? null : Long.parseLong(row[8].toString()));
				adminPermiso.setIdAuthorityUser(row[9] == null ? null : Long.parseLong(row[9].toString()));
				adminPermiso.setIdPrivilegeUser(row[10] == null ? null : Long.parseLong(row[10].toString()));
				adminPermiso.setIdAuthorityAnonymous(row[11] == null ? null : Long.parseLong(row[11].toString()));
				adminPermiso.setIdPrivilegeAnonymous(row[12] == null ? null : Long.parseLong(row[12].toString()));
				
				lstAdminPermisos.add(adminPermiso);
			}
		}catch(Exception e) {
			logger.error("Erro", e);
		}
		
		return lstAdminPermisos;
	}

}

