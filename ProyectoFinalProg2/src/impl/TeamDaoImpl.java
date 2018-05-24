package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.TeamDao;
import entity.Team;
import util.HibernateUtil;

public class TeamDaoImpl implements TeamDao {

	
	public void save(Team team) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(team);
		t.commit();
	}


	public Team getTeam(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Team) session.load(Team.class, id);
	}


	public List<Team> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Team").list();
		t.commit();
		return lista;
	}


	public void remove(Team team) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(team);
		t.commit();

	}


	public void update(Team team) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(team);
		t.commit();

	}
}
