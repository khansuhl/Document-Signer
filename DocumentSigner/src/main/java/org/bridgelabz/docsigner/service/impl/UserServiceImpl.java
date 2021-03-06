package org.bridgelabz.docsigner.service.impl;

import org.bridgelabz.docsigner.model.User;
import org.bridgelabz.docsigner.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		// Transaction tr = ses.beginTransaction();
		try {
			session.save(user);
			// tr.commit();
		} catch (Exception e) {
			// tr.rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public User authUser(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		// select * from users where userName = '' and password = '';
		try {
			Criteria cr = session.createCriteria(User.class);

			User user = (User) cr.add(Restrictions.conjunction().add(Restrictions.eq("email", email))
					.add(Restrictions.eq("password", password))).uniqueResult();
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
