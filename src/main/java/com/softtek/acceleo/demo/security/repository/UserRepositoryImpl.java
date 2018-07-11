package com.softtek.acceleo.demo.security.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.domain.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUsername(String username) {
		logger.info("findByUsername() :" + username);
		User user = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", username)).list();
			List<User> users = (List<User>) criteria.list();

			user = users.get(0);

			List<Authority> lstAuthority = user.getAuthorities();
			for (Authority authority : lstAuthority) {
				logger.info("IdAuthority: " + authority.getIdAuthority() + "\tName: " + authority.getName()
						+ "\tPrivilege" + authority.getPrivilege());
				for (Privilege privilege : authority.getPrivilege())

					logger.info("  --> IdPrivilege: " + privilege.getIdPrivilege() + "\tName: " + privilege.getName());

			}

			java.util.Date da = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(da);
			cal.add(Calendar.MONTH, -1);
			da = cal.getTime();
			user.setLastPasswordResetDate(da);
		} catch (HibernateException e) {
			logger.error("Error - HibernateException: ", e);
			logger.info("Error - HibernateException: ", e);
			System.out.println("Error - HibernateException: " + e);
		} catch(IndexOutOfBoundsException e) {
			logger.error("Error - IndexOutOfBoundsException: ", e);
		} catch (RuntimeException e) {
			logger.error("Error - RuntimeException: ", e);
		} catch (Exception e) {
			logger.error("Error - Exception: ", e);
		}

		return user;
	}

	/*
	 * @Override public User findByUsername(String username) {
	 * 
	 * logger.info("findByUsername() :"+username);
	 * 
	 * User user=null; if (username.equals("admin")) { user = new User();
	 * user.setId((long) 1); user.setUsername(username); user.setPassword(
	 * "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
	 * user.setFirstname("admin"); user.setLastname("admin");
	 * user.setEmail("admin@admin.com"); user.setEnabled(true);
	 * 
	 * java.util.Date da = new Date(); Calendar cal = Calendar.getInstance();
	 * cal.setTime(da); cal.add(Calendar.MONTH, -1); da = cal.getTime();
	 * user.setLastPasswordResetDate(da);
	 * 
	 * Authority aut1 =new Authority();
	 * 
	 * aut1.setId((long) 1); aut1.setName(AuthorityName.ROLE_USER); Authority aut2
	 * =new Authority();
	 * 
	 * aut2.setId((long) 2); aut2.setName(AuthorityName.ROLE_ADMIN);
	 * 
	 * List<Authority> listAuthority = new ArrayList<Authority>();
	 * 
	 * listAuthority.add(aut1); listAuthority.add(aut2);
	 * 
	 * user.setAuthorities(listAuthority);
	 * 
	 * } if (username.equals("user")) { user = new User(); user.setId((long) 2);
	 * user.setUsername(username); user.setPassword(
	 * "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
	 * user.setFirstname("user"); user.setLastname("user");
	 * user.setEmail("user@user.com"); user.setEnabled(true);
	 * 
	 * java.util.Date da = new Date(); Calendar cal = Calendar.getInstance();
	 * cal.setTime(da); cal.add(Calendar.MONTH, -1); da = cal.getTime();
	 * user.setLastPasswordResetDate(da);
	 * 
	 * Authority aut1 =new Authority();
	 * 
	 * List<Authority> listAuthority = new ArrayList<Authority>();
	 * 
	 * aut1.setId((long) 1); aut1.setName(AuthorityName.ROLE_USER);
	 * listAuthority.add(aut1); aut1 =new Authority();
	 * 
	 * aut1.setId((long) 3); aut1.setName(AuthorityName.ROLE_AFILIADOCREATE);
	 * listAuthority.add(aut1); aut1 =new Authority();
	 * 
	 * aut1.setId((long) 4); aut1.setName(AuthorityName.ROLE_AFILIADODELETE);
	 * listAuthority.add(aut1); aut1 =new Authority();
	 * 
	 * aut1.setId((long) 5); aut1.setName(AuthorityName.ROLE_AFILIADOSEARCH);
	 * listAuthority.add(aut1); aut1 =new Authority();
	 * 
	 * aut1.setId((long) 5); aut1.setName(AuthorityName.ROLE_AFILIADOUPDATE);
	 * listAuthority.add(aut1); aut1 =new Authority();
	 * 
	 * user.setAuthorities(listAuthority);
	 * 
	 * } if (username.equals("disabled")) { user = new User(); user.setId((long) 3);
	 * user.setUsername(username); user.setPassword(
	 * "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC");
	 * user.setFirstname("user"); user.setLastname("user");
	 * user.setEmail("disabled@user.com"); user.setEnabled(false);
	 * 
	 * java.util.Date da = new Date(); Calendar cal = Calendar.getInstance();
	 * cal.setTime(da); cal.add(Calendar.MONTH, -1); da = cal.getTime();
	 * user.setLastPasswordResetDate(da);
	 * 
	 * Authority aut1 =new Authority();
	 * 
	 * aut1.setId((long) 1); aut1.setName(AuthorityName.ROLE_USER);
	 * 
	 * List<Authority> listAuthority = new ArrayList<Authority>();
	 * 
	 * listAuthority.add(aut1);
	 * 
	 * user.setAuthorities(listAuthority);
	 * 
	 * } return user; }
	 */

	public void addUser(User user) {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			// sessionFactory.getCurrentSession().persist(user);
			session.clear();
			session.flush();
			logger.info("IdUser: " + user.getIdUser() + "\t UserName: " + user.getUserName() + "\t Password: "
					+ user.getPassword());
			session.persist(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}/*finally {
			if( session != null ) {
				session.clear();
				session.flush();		
			}
		}*/
	}

	public void editUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked" })
	public List<User> listUserss() {

		List<User> lstUser = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.addOrder(Order.asc("firstname")).list();
			
			lstUser = (List<User>) criteria.list();
		}catch(Exception e) {
			logger.error("Error: ", e);
		}
		
		return lstUser;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUserssQuery(User user, String query, int page, int size) {
		// userProxy.set#columnsGrid(user.get#columnsGrid());
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setFirstResult((page - 1) * size).add(
						Restrictions.or(
								Restrictions.or(
										Restrictions.or(
												Restrictions.or(
														Restrictions.or(Restrictions.like("iduser", "%" + query + "%"),
																Restrictions.like("fechamodificacion",
																		"%" + query + "%")),
														Restrictions.like("password", "%" + query + "%")),
												Restrictions.like("fechacreacion", "%" + query + "%")),
										Restrictions.like("estatus", "%" + query + "%")),
								Restrictions.like("username", "%" + query + "%"))

				).list();
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsersPagination(User user, int page, int size) {
		// cuentaProxy.set#columnsGrid(cuenta.get#columnsGrid());
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setFirstResult((page - 1) * size)

				.setMaxResults(size).list();
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows() {

		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return totalRows;
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRowsSearch(String query) {

		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setProjection(Projections.rowCount()).add(
						Restrictions.or(
								Restrictions.or(
										Restrictions.or(
												Restrictions.or(
														Restrictions.or(Restrictions.like("iduser", "%" + query + "%"),
																Restrictions.like("fechamodificacion",
																		"%" + query + "%")),
														Restrictions.like("password", "%" + query + "%")),
												Restrictions.like("fechacreacion", "%" + query + "%")),
										Restrictions.like("estatus", "%" + query + "%")),
								Restrictions.like("username", "%" + query + "%"))

				).uniqueResult();
		return totalRows;
	}

	@SuppressWarnings({ "unchecked" })
	public long getTotalRows(String query) {

		long totalRows = 0;
		totalRows = (Long) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setProjection(Projections.rowCount())

				.uniqueResult();
		return totalRows;
	}

	public User getUser(Long empid) {
		return (User) sessionFactory.getCurrentSession().get(User.class, empid);
	}

	public void deleteUser(User user) {
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
			criteria.add(Restrictions.eq("userName", user.getUserName())).list();
			lstUser = (List<User>) criteria.list();
			/**/

			// lstUser = (List<User>)
			// sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userName",
			// user.getUserName())).list();
		} catch (HibernateException e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		} catch (Exception e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		}

		return lstUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario2(User user) {
		if (user != null) {
			User userProxy = new User();
			return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Example.create(userProxy)).add(Restrictions.eq("userName", user.getUserName())).list();
			// .add(Example.create(userProxy)).add(Restrictions.eq("idUser",
			// user.getIdUser())).list();
		}

		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	/**
	 * Obtiene informacion del usuario.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> consultarInformacionPorUsuario(String userName) {
		List<User> lstUser = null;

		try {
			lstUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("userName", userName)).list();
		} catch (HibernateException e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		} catch (Exception e) {
			logger.error("Error al ejecutar la consulta para obtener los User. - " + e);
		}

		return lstUser;
	}
}
