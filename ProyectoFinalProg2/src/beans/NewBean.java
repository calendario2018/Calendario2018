package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.NewDao;
import impl.NewDaoImpl;
import entity.New;

@ManagedBean
@SessionScoped
public class NewBean
{
	private New noticia;
	private DataModel<New> listaNoticias;
	public String prepararAdicionarNoticia(){
		noticia = new New();
		noticia.setState("Activo");
		return "userRegister";
	}
	public String prepararModificarNoticia(){
		noticia= (New) (listaNoticias.getRowData());
		return "userRegister";
	}
	public String eliminarNoticia(){
		New noticiaTemp = (New) (listaNoticias.getRowData());
		NewDao dao= new NewDaoImpl();
		noticiaTemp.setState("Inactivo");
		dao.update(noticiaTemp);
		return "listaUsuarios";
	}
	public String adicionarNoticia(){
		NewDao dao= new NewDaoImpl();
		dao.save(noticia);
		return "listarUsuarios";
	}
	public String modificarNoticia(){
		NewDao dao= new NewDaoImpl();
		dao.update(noticia);
		return "listarUsuarios";

	}
	public New getNoticia(){
		return noticia;
	}
	public void setNoticia(New noticia){
		this.noticia= noticia;
	}
	public DataModel<New> getListarNoticias(){
		List<New> lista= new NewDaoImpl().list();
		listaNoticias= new ListDataModel<New>(lista);
		return listaNoticias;

	}
	public DataModel<New> getListaNoticias() {
		return listaNoticias;
	}
	public void setListaNoticias(DataModel<New> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}
}
