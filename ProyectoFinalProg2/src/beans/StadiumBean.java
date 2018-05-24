package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.StadiumDao;
import dao.UserDao;
import entity.Stadium;
import entity.User;
import impl.StadiumDaoImpl;
import impl.UserDaoImpl;;

@ManagedBean
@SessionScoped
public class StadiumBean {

	private Stadium stadium;
	private DataModel<Stadium> listaEstadios;

	private DataModel<Stadium> filtrados;
	private String buscar;
	private List<Stadium> listaFiltrados;


	public String prepararAdicionarEstadio() {
		stadium = new Stadium();
		return "RegistroEstadio";
	}

	public String prepararModificarEstadio() {
		stadium = (Stadium) (listaEstadios.getRowData());
		return "EditarEstadio.xhtml";
	}

	public String eliminarEstadio() {

		Stadium usuarioTemp = (Stadium) (listaEstadios.getRowData());
		StadiumDao dao = new StadiumDaoImpl();
		dao.remove(usuarioTemp);

		return "verTablaEstadio.xhtml";
	}

	public String adicionarEstadio() {

		StadiumDao dao = new StadiumDaoImpl();
		dao.save(stadium);

		return "panelAdmin.xhtml";
	}

	public String modificarEstadio() {

		StadiumDao dao = new StadiumDaoImpl();
		dao.update(stadium);

		return "verTablaEstadio.xhtml";
	}


	public void buscarEstadio() {
		AuditBean auditoria = new AuditBean();

		StadiumDao dao = new StadiumDaoImpl();
		listaFiltrados = dao.getEstadio(buscar);
		if (!listaFiltrados.isEmpty()) {
			filtrados = new ListDataModel<Stadium>(listaFiltrados);
		} else {
			filtrados = new ListDataModel<Stadium>(new StadiumDaoImpl().list());
		}
	}


	public DataModel<Stadium> getFiltrados() {

		if(filtrados==null) 
		{
			List<Stadium> lista = new StadiumDaoImpl().list();
			filtrados = new ListDataModel<Stadium>(lista);
		}

		return filtrados;
	}

	public String getBuscar() {
		return buscar;
	}

	public void setBuscar(String buscar) {
		this.buscar = buscar;
	}

	public List<Stadium> getListaFiltrados() {

		return listaFiltrados;

	}

	public void setListaFiltrados(List<Stadium> listaFiltrados) {
		this.listaFiltrados = listaFiltrados;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public DataModel<Stadium> getListaEstadio() {
		List<Stadium> lista = new StadiumDaoImpl().list();
		listaEstadios = new ListDataModel<Stadium>(lista);
		return listaEstadios;
	}

	public void setListaEstadio(DataModel<Stadium> listaEstadio) {
		this.listaEstadios = listaEstadio;
	}

}
