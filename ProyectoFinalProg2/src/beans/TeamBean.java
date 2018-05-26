package beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.TeamDao;
import entity.Team;
import impl.TeamDaoImpl;

@ManagedBean
@SessionScoped
public class TeamBean {

	
	private Team team;
	private DataModel<Team> listaEquipos;

	public String prepararAdicionarTeam() {
		team = new Team();
		team.setState("A");
		return "panelAdmin.xhtml";
	}

	public String prepararModificarTeam() {
		team = (Team) (listaEquipos.getRowData());
		return "EditarEquipo.xhtml";
	}

	public String eliminarTeam() {

		Team teamTemp = (Team) (listaEquipos.getRowData());
		TeamDao dao = new TeamDaoImpl();
		teamTemp.setState("I");
		dao.update(teamTemp);

		return "verTablaEquipo.xhtml";
	}

	public String adicionarTeam() {

		TeamDao dao = new TeamDaoImpl();
		dao.save(team);

		return "panelAdmin.xhtml";
	}

	public String modificarTeam() {

		TeamDaoImpl dao = new TeamDaoImpl();
		dao.update(team);

		return "verTablaEquipo.xhtml";
	}

	public Team getTeam() {
		return team;
	}

	public void setUser(Team team) {
		this.team = team;
	}

	public DataModel<Team> getListaEquipos() {
		List<Team> lista = new TeamDaoImpl().list();
		listaEquipos = new ListDataModel<Team>(lista);
		return listaEquipos;
	}

	public void setListaEquipos(DataModel<Team> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
}
