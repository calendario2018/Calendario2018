package dao;

import java.util.List;

import entity.Parameter;


public interface ParameterDao {
	
	public void save(Parameter parameter);
	
	public List<Parameter> list();

	public void update(Parameter parameter);
}
