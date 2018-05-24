package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date gameDate;

	private int idReferee;

	private int idStadium;

	private int localGoals;

	private int localTeam;

	private String state;

	private int visitGoals;

	private int visitTeam;

	public Schedule() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	public int getId() 
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	@Column(name="gameDate")
	public Date getGameDate()
	{
		return this.gameDate;
	}

	public void setGameDate(Date gameDate) 
	{
		this.gameDate = gameDate;
	}
	@Column(name="idReferee",length =5)
	public int getIdReferee()
	{
		return this.idReferee;
	}

	public void setIdReferee(int idReferee)
	{
		this.idReferee = idReferee;
	}
	@Column(name="idStadium",length =5)
	public int getIdStadium() {
		return this.idStadium;
	}

	public void setIdStadium(int idStadium)
	{
		this.idStadium = idStadium;
	}
	@Column(name="localGoals",length =2)
	public int getLocalGoals() 
	{
		return this.localGoals;
	}

	public void setLocalGoals(int localGoals) 
	{
		this.localGoals = localGoals;
	}
	@Column(name="localTeam",length =5)
	public int getLocalTeam()
	{
		return this.localTeam;
	}

	public void setLocalTeam(int localTeam)
	{
		this.localTeam = localTeam;
	}
	@Column(name="state",length =1)
	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}
	@Column(name="visitGoals",length =2)
	public int getVisitGoals() 
	{
		return this.visitGoals;
	}

	public void setVisitGoals(int visitGoals)
	{
		this.visitGoals = visitGoals;
	}
	@Column(name="visitTeam",length =5)
	public int getVisitTeam() 
	{
		return this.visitTeam;
	}

	public void setVisitTeam(int visitTeam) 
	{
		this.visitTeam = visitTeam;
	}

}