package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.GoalscorerDao;
import entity.Goalscorer;
import impl.GoalscorerDaoImpl;

@ManagedBean
@SessionScoped
public class GoalscorerBean {

	
	private Goalscorer goalscorer;
	private DataModel<Goalscorer> listaGoalscorer;

	public String prepararAdicionarGoleador() {
		goalscorer = new Goalscorer();
		return "RegistroGoleador";
	}

	public String prepararModificarGoleador() {
		goalscorer = (Goalscorer) (listaGoalscorer.getRowData());
		return "EditarGoleador.xhtml";
	}

	public String eliminarGoleador() {

		Goalscorer usuarioTemp = (Goalscorer) (listaGoalscorer.getRowData());
		GoalscorerDao dao = new GoalscorerDaoImpl();
		dao.remove(usuarioTemp);

		return "verTablaGoleador.xhtml";
	}

	public String adicionarGoleador() {

		GoalscorerDao dao = new GoalscorerDaoImpl();
		dao.save(goalscorer);

		return "panelAdmin.xhtml";
	}

	public String modificarGoleador() {

		GoalscorerDao dao = new GoalscorerDaoImpl();
		dao.update(goalscorer);

		return "verTablaGoleador.xhtml";
	}

	public Goalscorer getgoalscorer() {
		return goalscorer;
	}

	public void setGoalscorer(Goalscorer goalscorer) {
		this.goalscorer = goalscorer;
	}

	public DataModel<Goalscorer> getListaGoleadores() {
		List<Goalscorer> lista = new GoalscorerDaoImpl().list();
		listaGoalscorer = new ListDataModel<Goalscorer>(lista);
		return listaGoalscorer;
	}

	public void setListaGoleadores(DataModel<Goalscorer> listaGoalscorer) {
		this.listaGoalscorer = listaGoalscorer;
	}
}
