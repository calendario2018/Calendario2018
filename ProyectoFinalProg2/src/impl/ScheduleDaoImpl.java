package impl;

import dao.ScheduleDao;
import entity.Schedule;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ScheduleDaoImpl implements ScheduleDao {


	@Override	
	public void save(Schedule schedule) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(schedule);
		t.commit();
	}

	@Override
	public List<Schedule> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Schedule> lista = session.createQuery("from Schedule").list();
		t.commit();
		return lista;
	}
	@Override
	public Schedule getSchedule(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Schedule) session.load(Schedule.class, id);
	}
	@Override
	public void remove(Schedule calendario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(calendario);
		t.commit();
	}
	
	@Override
	public void update(Schedule schedule)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(schedule);
		t.commit();

	}



}
