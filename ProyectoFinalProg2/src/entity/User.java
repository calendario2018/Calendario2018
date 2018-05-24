package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.Entity;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long id;
	private String active;
	private Date dateLastPassword;
	private String emailAddress;
	private String fullName;
	private String password;
	private String phoneNumber;
	private String userName;
	private String userType;
	private int intentos;
	public User() {
	}
	public User(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "userName", length = 8)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 256)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fullName", length = 60)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "emailAddress", length = 75)
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "phoneNumber", length = 10)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateLastPassword", length = 20)
	public Date getDateLastPassword() {
		return dateLastPassword;
	}

	public void setDateLastPassword(Date dateLastPassword) {
		this.dateLastPassword = dateLastPassword;
	}

	@Column(name = "active", length = 1)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "userType", length = 12)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "intentos", length = 1)
	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
}