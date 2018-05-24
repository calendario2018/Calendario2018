package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the goalscorer database table.
 * 
 */
@Entity
@Table(name = "goalscorer")
public class Goalscorer implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;
	private String fullName;
	private int goals;
	private String photo;
	private String team;

	public Goalscorer() {
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

	@Column(name = "fullName",length =50)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "goals",length =2)
	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}
	@Column(name = "photo",length =60)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Column(name = "team",length =35)
	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}