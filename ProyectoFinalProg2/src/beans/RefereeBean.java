package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.RefereeDao;
import impl.RefereeDaoImpl;
import entity.Referee;

@ManagedBean
@SessionScoped
public class RefereeBean {
	private Referee referee;
	private DataModel<Referee> listaReferes;

	public String prepararAdicionarReferee()
	{
		referee = new Referee();
		referee.setState("Activo");
		return "panelAdmin.xhtml";
	}

	public String prepararModificarReferee() 
	{
		referee = (Referee) (listaReferes.getRowData());
		return "userRegister";
	}

	public String eliminarReferee()
	{
		Referee refereeTemp = (Referee) (listaReferes.getRowData());
		RefereeDao dao = new RefereeDaoImpl();
		refereeTemp.setState("Inactivo");
		dao.update(referee);
		return "listarUsuarios";
	}

	public String adicionarReferee()
	{
		RefereeDao dao = new RefereeDaoImpl();
		dao.save(referee);
		return "listarUsuarios";
	}

	public String modificarReferee()
	{
		RefereeDao dao = new RefereeDaoImpl();
		dao.update(referee);
		return "listarUsuarios";
	}

	public Referee getReferee()
	{
		return referee;
	}

	public void setReferee(Referee referee)
	{
		this.referee = referee;
	}

	public DataModel<Referee> getListaReferes()
	{
		List<Referee> lista = new RefereeDaoImpl().list();
		listaReferes = new ListDataModel<Referee>(lista);
		return listaReferes;
	}

	

	public void setListaReferes(DataModel<Referee> listaReferes) 
	{
		this.listaReferes = listaReferes;
	}
}
