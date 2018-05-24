package impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ParameterDao;
import entity.Parameter;
import entity.User;
import util.HibernateUtil;

public class ParameterDaoImpl implements ParameterDao {

	@Override
	public void save(Parameter parameter) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(parameter);
		t.commit();

	}

	@Override
	public List<Parameter> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Parameter").list();
		t.commit();
		return lista;
	}

	@Override
	public void update(Parameter parameter) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(parameter);
		t.commit();

	}

}
