package impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.NewsDao;
import entity.News;
import util.HibernateUtil;

public class NewsDaoImpl implements NewsDao {

	@Override
	public void save(News news) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(news);
		t.commit();
		
	}

	@Override
	public News getNew(int id) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		return (News) session.load(News.class, id);
	}

	@Override
	public List<News> list() {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista= session.createQuery("from News").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(News news) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t= session.beginTransaction();
	session.delete(news);
	t.commit();
		
	}

	@Override
	public void update(News news) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		session.update(news);
		t.commit();
		
	}

}
