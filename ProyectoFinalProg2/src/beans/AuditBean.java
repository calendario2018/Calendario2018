package beans;
import impl.AuditDaoImpl;
import dao.AuditDao;
import entity.Audit;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class AuditBean {
	
	private Audit auditoria;
	private DataModel<Audit> listaAuditoria;

//	public String prepararAdicionarAuditoria(Audit auditoria) {
//		auditoria = new Audit();
//		return "index";
//	}

	
	
	
	
	//Comentario Prueba 2
	
	
	
	
	public DataModel<Audit> getListaAuditoria() {
		List<Audit> lista = new AuditDaoImpl().listado();
		listaAuditoria = new ListDataModel<Audit>(lista);
		return listaAuditoria;
	}

	
	
	
	public void adicionarAuditoria(String operation,int tableId,String tableName,int userId) 
	{
		auditoria = new Audit();
		auditoria.setOperation(operation);
		auditoria.setTableId(tableId);
		auditoria.setTableName(tableName);
		auditoria.setUserId(userId);
		 Date ahora = new Date();
		auditoria.setCreateDate(ahora);
		String ipAddress;
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
		ipAddress = request.getRemoteAddr();
		}
		auditoria.setUserIp(ipAddress);
		AuditDao dao = new AuditDaoImpl();
		dao.save(auditoria);
	}
	
	public Audit getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Audit auditoria) {
		this.auditoria = auditoria;
	}

	

	public void setListaAuditoria(DataModel<Audit> listaAuditoria) {
		this.listaAuditoria = listaAuditoria;
	}

}
