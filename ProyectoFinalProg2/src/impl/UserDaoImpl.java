package impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.UserDao;
import entity.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	public void save(User usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
	}


	public User getUser(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (User) session.load(User.class, id);
	}
	public List<User> getUserUsername(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from User where userName= :username and password= :password").setParameter("username", username).setParameter("password", password).list();
		t.commit();
		return lista;
	}

	public List<User> getUserUsuario(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from User where userName= :username").setParameter("username", username).list();
		t.commit();
		return lista;
	}


	public List<User> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from User").list();
		t.commit();
		return lista;
	}


	public void remove(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(user);
		t.commit();

	}


	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(user);
		t.commit();

	}




}
