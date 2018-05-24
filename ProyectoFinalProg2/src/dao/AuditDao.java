package dao;

import entity.Audit;
import java.util.List;
public interface AuditDao {
	
	public void save(Audit auditoria);

	public List<Audit> listado();

}
