package beans;



import impl.ScheduleDaoImpl;
import dao.ScheduleDao;
import entity.Schedule;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ScheduleBean
{

	private Schedule schedule;
	private DataModel<Schedule> listaCronograma;
	
	public String prepararAdicionarSchedule() {
		schedule = new Schedule();
		schedule.setState("Activo");
		return "registroSchedule";
	}

	public String prepararModificarSchedule() 
	{
		schedule = (Schedule) (listaCronograma.getRowData()); //Donde le indico qué usuario es el que quiero obtener?
		return "registroSchedule";
	}

	public String eliminarSchedule() 
	{
		Schedule ScheduleTemp = (Schedule) (listaCronograma.getRowData());
		ScheduleDao dao = new ScheduleDaoImpl();
		ScheduleTemp.setState("Inactivo");
		dao.update(ScheduleTemp);

		return "verTabla";
	}

	public String adicionarSchedule() {

		ScheduleDao dao = new ScheduleDaoImpl();
		dao.save(schedule);

		return "PanelUsuario.xhtml";
	}

	public String modificarSchedule() {

		ScheduleDaoImpl dao = new ScheduleDaoImpl();
		dao.update(schedule);

		return "resultado";
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public DataModel<Schedule> getListaSchedules() {
		List<Schedule> lista = new ScheduleDaoImpl().list();
		listaCronograma = new ListDataModel<Schedule>(lista);
		return listaCronograma;
	}

	public void setListaSchedules(DataModel<Schedule> listaSchedule) {
		this.listaCronograma = listaSchedule;
	}



	
}
