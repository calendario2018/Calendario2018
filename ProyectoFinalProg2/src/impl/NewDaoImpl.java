package impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.NewDao;
import entity.New;
import util.HibernateUtil;

public class NewDaoImpl implements NewDao {

	@Override
	public void save(New news) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(news);
		t.commit();
		
	}

	@Override
	public New getNew(int id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		return (New) session.load(New.class, id);
	}

	@Override
	public List<New> list() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista= session.createQuery("from News").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(New news) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t= session.beginTransaction();
	session.delete(news);
	t.commit();
		
	}

	@Override
	public void update(New news) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		session.update(news);
		t.commit();
		
	}

}
