package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stadium database table.
 * 
 */
@Entity
@Table(name="stadium")
public class Stadium implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String capacity;
	private String city;
	private String photo;
	private String population;
	private String temperature;

	public Stadium() {
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

	@Column(name = "capacity",length =50)
	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Column(name = "city",length =25)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "photo",length =60)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "population",length =60)
	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Column(name = "temperature",length =60)
	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

}