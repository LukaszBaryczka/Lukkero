package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

	@Column(name = "first_name")
    private String name;
	@Column(name = "last_name")
	private String surname;
	@Column(name = "email")
	private String email;
	@Column(name = "work_time")
	private Date workTime;

	public Customer() {
	}

	public Customer(String name, String surname, String email, Date workTime) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.workTime = workTime;
	}

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", email='" + email + '\'' +
				", workTime=" + workTime +
				'}';
	}
}