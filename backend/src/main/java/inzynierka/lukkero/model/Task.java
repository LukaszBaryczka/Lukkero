package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "deadline")
	private Date deadline;
	@Column(name = "essTime")
	private Date essTime;
	@Column(name = "allTime")
	private Date allTime;
	@Column(name = "dayTime")
	private Date dayTime;
	@Column(name = "customer")
    private Customer customer;

	public Task() {}

	public Task(String name, String description, Date deadline, Date essTime, Date allTime, Date dayTime, Customer customer) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.essTime = essTime;
		this.allTime = allTime;
		this.dayTime = dayTime;
		this.customer = customer;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getEssTime() {
		return essTime;
	}

	public void setEssTime(Date essTime) {
		this.essTime = essTime;
	}

	public Date getAllTime() {
		return allTime;
	}

	public void setAllTime(Date allTime) {
		this.allTime = allTime;
	}

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer user) {
		this.customer = user;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", deadline=" + deadline +
				", essTime=" + essTime +
				", allTime=" + allTime +
				", dayTime=" + dayTime +
				", customer=" + customer +
				'}';
	}
}