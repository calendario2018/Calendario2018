package beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.NewsDao;
import impl.NewsDaoImpl;
import entity.News;

@ManagedBean
@SessionScoped
public class NewBean
{
	private News news;
	private DataModel<News> listaNoticias;
	public String prepararAdicionarNoticia(){
		news = new News();
		news.setState("A");
		Date date = new Date();
		date.getTime();
		news.setDateNews(date);
		news.setIdUser(1);
		return "panelAdmin.xhtml";
		
	}
	public String prepararModificarNoticia(){
		news= (News) (listaNoticias.getRowData());
		return "userRegister";
	}
	public String eliminarNoticia(){
		News noticiaTemp = (News) (listaNoticias.getRowData());
		NewsDao dao= new NewsDaoImpl();
		noticiaTemp.setState("Inactivo");
		dao.update(noticiaTemp);
		return "listaUsuarios";
	}
	public String adicionarNoticia(){	
		
		NewsDao dao= new NewsDaoImpl();
		dao.save(news);
		return "";
	}
	public String modificarNoticia(){
		NewsDao dao= new NewsDaoImpl();
		dao.update(news);
		return "listarUsuarios";

	}

	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public DataModel<News> getListaNoticias(){
		List<News> lista= new NewsDaoImpl().list();
		listaNoticias= new ListDataModel<News>(lista);
		return listaNoticias;

	}
	
	public void setListaNoticias(DataModel<News> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}
}
