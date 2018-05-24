package dao;

import java.util.List;

import entity.User;


public interface UserDao {

	

	public void save(User usuario);

	public User getUser(long id);
	
	public List<User> getUserUsername(String username, String password);
	
	public List<User> getUserUsuario(String username);

	public List<User> list();

	public void remove(User usuario);

	public void update(User usuario);

	
}
