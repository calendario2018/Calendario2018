package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name = "team")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;
	private String country;
	private String flag;
	private int goalsAgainst;
	private int goalsFavor;
	private String group;
	private int lostMatches;
	private int playedGames;
	private String state;
	private int tiedMatches;
	private int wonMatches;
	
	public Team() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "country",length =30)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "flag",length =60)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Column(name = "goalsAgainst",length =1)
	public int getGoalsAgainst() {
		return this.goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	@Column(name = "goalsFavor",length =1)
	public int getGoalsFavor() {
		return this.goalsFavor;
	}

	public void setGoalsFavor(int goalsFavor) {
		this.goalsFavor = goalsFavor;
	}

	@Column(name = "group_",length =1)
	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column(name = "lostMatches",length =1)
	public int getLostMatches() {
		return this.lostMatches;
	}

	public void setLostMatches(int lostMatches) {
		this.lostMatches = lostMatches;
	}

	@Column(name = "playedGames",length =1)
	public int getPlayedGames() {
		return this.playedGames;
	}

	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	@Column(name = "state",length =1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "tiedMatches",length =1)
	public int getTiedMatches() {
		return this.tiedMatches;
	}

	public void setTiedMatches(int tiedMatches) {
		this.tiedMatches = tiedMatches;
	}

	@Column(name = "wonMatches",length =1)
	public int getWonMatches() {
		return this.wonMatches;
	}

	public void setWonMatches(int wonMatches) {
		this.wonMatches = wonMatches;
	}

}