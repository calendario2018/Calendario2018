package impl;


import dao.AuditDao;
import entity.Audit;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AuditDaoImpl implements AuditDao {

@Override
	public void save(Audit auditoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(auditoria);
		t.commit();
	}
@Override
	public List<Audit> listado() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Audit").list();
		t.commit();
		return lista;
	}

}
