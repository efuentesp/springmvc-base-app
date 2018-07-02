package com.softtek.acceleo.demo.security.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;

@Repository("privilegeRepository")
public class PrivilegeRepositoryImpl implements PrivilegeRepository{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Privilege> getPrivilege() {
		List<Privilege> lstPrivilege = null;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Privilege.class);
		lstPrivilege = (List<Privilege>) criteria.list();
		
		return lstPrivilege;
	}

	@Override
	public Privilege getPrivilege(long idPrivilege) {
		Privilege privilege = null;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			privilege = (Privilege) session.get(Privilege.class, idPrivilege);
		}catch(Exception e) {
			logger.error("---->> Error: ", e);
		}
		
		return privilege;
	}
}
