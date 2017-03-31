package inzynierka.lukkero.model;

import java.math.BigInteger;
import java.util.Date;

public class Task {

	private BigInteger id;

	private String name;
	private String description;
	private Date deadline;
    private Date essTime;
    private Date allTime;
    private Date dayTime;

    private User user;
    

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}