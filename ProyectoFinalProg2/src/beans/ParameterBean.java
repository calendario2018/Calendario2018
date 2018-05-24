package beans;

import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import dao.ParameterDao;
import entity.Parameter;
import impl.ParameterDaoImpl;

public class ParameterBean {
	private Parameter parameter;
	private DataModel<Parameter> listaParameter;

	public String prepararAdicionarParameter()
	{
		parameter = new Parameter();
		return "PanelUsuario.xhtml";
	}

	public String adicionarParameter() 
	{
		ParameterDao dao = new ParameterDaoImpl();
		dao.save(parameter);

		return "PanelUsuario.xhtml";
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

}
