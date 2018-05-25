package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	public void save(News news);

	public News getNew(int id);

	public List<News> list();

	public void remove(News news);

	public void update(News news);
}
