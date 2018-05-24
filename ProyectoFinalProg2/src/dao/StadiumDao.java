package dao;

import java.util.List;

import entity.Stadium;
import entity.User;

public interface StadiumDao {

	public void save(Stadium stadium);

	public Stadium getUser(long id);

	public List<Stadium> list();
	
	public List<Stadium> getEstadio(String estadio);

	public void remove(Stadium stadium);

	public void update(Stadium stadium);

}
