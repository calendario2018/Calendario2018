package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.GoalscorerDao;
import entity.Goalscorer;
import util.HibernateUtil;

public class GoalscorerDaoImpl implements GoalscorerDao {

	
	public void save(Goalscorer goalscorer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(goalscorer);
		t.commit();
	}


	public Goalscorer getUser(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Goalscorer) session.load(Goalscorer.class, id);
	}


	public List<Goalscorer> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Goalscorer").list();
		t.commit();
		return lista;
	}


	public void remove(Goalscorer goalscorer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(goalscorer);
		t.commit();

	}


	public void update(Goalscorer goalscorer) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(goalscorer);
		t.commit();

	}


}
