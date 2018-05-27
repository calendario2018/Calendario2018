package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.ParameterDao;
import entity.Parameter;
import impl.ParameterDaoImpl;
@ManagedBean
@SessionScoped
public class ParameterBean {
	private Parameter parameter;
	private DataModel<Parameter> listaParameter;

	
	public String prepararAdicionarParameter()
	{
		parameter = new Parameter();
		return "panelAdmin.xhtml";
	}

	public String adicionarParameter() 
	{
		ParameterDao dao = new ParameterDaoImpl();
		dao.save(parameter);

		return "panelAdmin.xhtml";
	}

	public Parameter getParameter()
	{
		return parameter;
	}

	public void setParameter(Parameter parameter) 
	{
		this.parameter = parameter;
	}
	
	public DataModel<Parameter> getListaParameter() {
		List<Parameter> lista = new ParameterDaoImpl().list();
		listaParameter = new ListDataModel<Parameter>(lista);
		return listaParameter;
	}

	public void setListalistaParameter(DataModel<Parameter> listaParameter) {
		this.listaParameter = listaParameter;
	}
	public String prepararModificarParameter() {
		parameter= (Parameter) listaParameter.getRowData();
		return "panelAdmin.xhtml";
	}
	public String modificarParameter() {
		ParameterDaoImpl dao= new ParameterDaoImpl();
		dao.update(parameter);
		AuditBean auditoria = new AuditBean();
		auditoria.adicionarAuditoria("UpdatParam", (int)(long)parameter.getId(), "parameter", (int) (long) parameter.getId());
		return "panelAdmin.xhtml";
	}

}
