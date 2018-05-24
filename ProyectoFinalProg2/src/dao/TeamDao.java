package dao;

import java.util.List;

import entity.Team;

public interface TeamDao {


	public void save(Team team);

	public Team getTeam(long id);

	public List<Team> list();

	public void remove(Team team);

	public void update(Team team);

}
