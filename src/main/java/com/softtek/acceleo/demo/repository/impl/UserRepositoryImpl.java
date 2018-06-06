
package com.softtek.acceleo.demo.repository.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.softtek.acceleo.demo.domain.User;
import com.softtek.acceleo.demo.exception.GenericException;
import com.softtek.acceleo.demo.repository.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
	private static final Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	
	static final String USER_NAME = "userName";
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		try {
			logger.info("IdUser: " + user.getIdUser() + "\t UserName: " + user.getUserName() + "\t Password: " + user.getPassword() + "\t Rol: " + user.getRol() + "\t Imagen: " + user.getImagen());
			
			/**sessionFactory.getCurrentSession().persist(user);**/
			Session session = sessionFactory.getCurrentSession();
			session.persist(user);
		}catch(HibernateException e) {
			logger.error("Erro HibernateException - " + e);
		}catch(Exception e) {
			logger.error("Erro Exception - " + e);
		}
	}

	public void editUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		}catch(HibernateException e) {
			logger.error(e);
		}catch(Exception e) {
			logger.error("Erro - " + e);
		}

	}

	@SuppressWarnings({ "unchecked" })
	public List<User> listUserss(User user) {

		if (user != null) {

			User userProxy = new User();








			return (List<User>) sessionFactory.getCurrentSession()
					.createCriteria(User.class)
					.add(Example.create(userProxy)).list();

		}

		return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();

	}


	@SuppressWarnings("unchecked")
	public List<User> listUserssQuery(User user, String query, int page, int size) {

			return (List<User>) sessionFactory.getCurrentSession()
					.createCriteria(User.class).setFirstResult((page - 1) * size)
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("iduser", "%" + query +"%"),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("password", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like(USER_NAME, "%" + query +"%"))	
	
	
	
	
	
).list();
	}


	@SuppressWarnings("unchecked")
	public List<User> listUsersPagination(User user, int page, int size) {

			return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).setFirstResult((page - 1) * size)
				
				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(User.class).setProjection(Projections.rowCount())
		.uniqueResult();	
		return totalRows;  
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(User.class).setProjection(Projections.rowCount())
					.add(	
							Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(Restrictions.or(	
						Restrictions.like("iduser", "%" + query +"%"),Restrictions.like("fechamodificacion", "%" + query +"%")),Restrictions.like("password", "%" + query +"%")),Restrictions.like("fechacreacion", "%" + query +"%")),Restrictions.like("estatus", "%" + query +"%")),Restrictions.like("username", "%" + query +"%"))	
	
	
	
	
	
).uniqueResult();
		return totalRows;  
	}


	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {
		
		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession()
		.createCriteria(User.class).setProjection(Projections.rowCount())
		
		.uniqueResult();
		return totalRows;  
	}

	

	public User getUser(int empid) {
		return (User) sessionFactory.getCurrentSession().get(
				User.class, empid);
	}

	public void deleteUser(User user) throws GenericException {
		sessionFactory.getCurrentSession().delete(user);
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario(User user) {
		List<User> lstUser = null;
		
		try {
			/**/
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq(USER_NAME, user.getUserName())).list();
			lstUser = (List<User>) criteria.list();
			/**/
			
			/**lstUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userName", user.getUserName())).list();**/
		}catch(HibernateException e) {
			logger.error("HibernateException - " + e);
		}catch(Exception e) {
			logger.error("Exception - " + e);
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
					.add(Example.create(userProxy)).add(Restrictions.eq(USER_NAME, user.getUserName())).list();
		}

		return (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
	}

	/**
	 * Obtiene informacion del usuario.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario(String userName) {
		List<User> lstUser = null;
		
		try {
			lstUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(USER_NAME, userName)).list();
		}catch(HibernateException e) {
			logger.error("HibernateException - " + e);
		}catch(Exception e) {
			logger.error("Exception - " + e);
		}
		
		return lstUser;
	}
	
	
	
}
