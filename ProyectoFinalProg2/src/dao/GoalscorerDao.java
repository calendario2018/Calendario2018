package dao;

import java.util.List;

import entity.Goalscorer;

public interface GoalscorerDao {

	public void save(Goalscorer goalscorer);

	public Goalscorer getUser(long id);

	public List<Goalscorer> list();

	public void remove(Goalscorer goalscorer);

	public void update(Goalscorer goalscorer);
}
