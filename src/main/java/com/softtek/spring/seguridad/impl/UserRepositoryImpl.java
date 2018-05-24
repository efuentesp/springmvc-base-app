package com.softtek.spring.seguridad.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.spring.seguridad.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	private static final Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario(User user) {
		List<User> lstUser = null;
		
		try {
			/**
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", user.getUserName())).list();
			lstUser = (List<User>) criteria.list();
			/**/
			
			lstUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userName", user.getUserName())).list();
		}catch(HibernateException e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		}catch(Exception e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		}
		
		return lstUser;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario2(User user) {
		if (user != null) {
			User userProxy = new User();
			return (List<User>) sessionFactory.getCurrentSession()
					.createCriteria(User.class)
					.add(Example.create(userProxy)).add(Restrictions.eq("userName", user.getUserName())).list();
					//.add(Example.create(userProxy)).add(Restrictions.eq("idUser", user.getIdUser())).list();
		}

		return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
	}

}
