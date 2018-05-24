package dao;

import java.util.List;

import entity.New;

public interface NewDao {
	public void save(New news);

	public New getNew(int id);

	public List<New> list();

	public void remove(New news);

	public void update(New news);
}
