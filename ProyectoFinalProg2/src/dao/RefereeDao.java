package dao;

import java.util.List;

import entity.Referee;

public interface RefereeDao {
	public void save(Referee referee);

	public Referee getReferee(int id);

	public List<Referee> list();

	public void remove(Referee referee);

	public void update(Referee referee);
}
