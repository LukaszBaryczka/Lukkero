package inzynierka.lukkero.model;

import java.math.BigInteger;
import java.util.Date;

public class Project {

    private BigInteger id;

    private String name;
    private String description;
    private int amountTasks;
    private int completeTasks;
    private int userTasks;
    private Date deadline;
    
    
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
	public int getAmountTasks() {
		return amountTasks;
	}
	public void setAmountTasks(int amountTasks) {
		this.amountTasks = amountTasks;
	}
	public int getCompleteTasks() {
		return completeTasks;
	}
	public void setCompleteTasks(int completeTasks) {
		this.completeTasks = completeTasks;
	}
	public int getUserTasks() {
		return userTasks;
	}
	public void setUserTasks(int userTasks) {
		this.userTasks = userTasks;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}