package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.StadiumDao;
import entity.Stadium;
import entity.User;
import util.HibernateUtil;

public class StadiumDaoImpl implements StadiumDao{

	public void save(Stadium stadium) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(stadium);
		t.commit();
	}


	public Stadium getUser(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Stadium) session.load(Stadium.class, id);
	}


	public List<Stadium> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Stadium").list();
		t.commit();
		return lista;
	}


	public void remove(Stadium stadium) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(stadium);
		t.commit();

	}


	public void update(Stadium stadium) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(stadium);
		t.commit();

	}


	@Override
	public List<Stadium> getEstadio(String estadio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Stadium where city= :city").setParameter("city", estadio).list();
		t.commit();
		return lista;
	}


}
