package dao;

import entity.Schedule;

import java.util.List;

public interface ScheduleDao {

	public void save(Schedule schedule);

	public Schedule getSchedule(long id);

	public List<Schedule> list();

	public void remove(Schedule usuario);

	public void update(Schedule usuario);
	
}
