package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.RefereeDao;
import entity.Referee;
import util.HibernateUtil;

public class RefereeDaoImpl implements RefereeDao{

	@Override
	public void save(Referee referee) {
		Session session=  HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		session.save(referee);
		t.commit();
		
	}

	@Override
	public Referee getReferee(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Referee) session.load(Referee.class, id);
	}

	@Override
	public List<Referee> list() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		List lista= session.createQuery("from Referee").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Referee referee) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(referee);
		t.commit();
		
	}

	@Override
	public void update(Referee referee) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction t= session.beginTransaction();
		session.update(referee);
		t.commit();
		
	}

}
