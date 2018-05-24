package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private Date dateNews;

	private int idUser;

	private String largeDescription;

	private String shortDescription;

	private String state;

	public New() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)

	public int getId()
	{
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateNews")
	public Date getDateNews() {
		return this.dateNews;
	}

	public void setDateNews(Date dateNews) {
		this.dateNews = dateNews;
	}
	@Column (name="idUser" , length=5)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	@Column (name="largeDescription" , length=120)
	public String getLargeDescription() {
		return this.largeDescription;
	}

	public void setLargeDescription(String largeDescription) {
		this.largeDescription = largeDescription;
	}
	@Column (name="shortDescription" , length= 60)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	@Column (name="state", length=1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}