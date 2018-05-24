package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referee database table.
 * 
 */
@Entity
@Table(name= "referee")
public class Referee implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String fullName;

	private String nationality;

	private String state;

	public Referee() {
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
	@Column (name="fullName" , length=50)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Column (name="nationality" , length= 50)
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Column (name="state" , length= 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}