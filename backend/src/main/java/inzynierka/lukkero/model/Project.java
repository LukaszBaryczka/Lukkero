package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

	@Column(name = "name")
    private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "amountTasks")
    private int amountTasks;
	@Column(name = "completeTasks")
    private int completeTasks;
	@Column(name = "userTasks")
    private int userTasks;
	@Column(name = "deadline")
    private Date deadline;

	public Project() {}

	public Project(String name, String description, int amountTasks, int completeTasks, int userTasks, Date deadline) {
		this.name = name;
		this.description = description;
		this.amountTasks = amountTasks;
		this.completeTasks = completeTasks;
		this.userTasks = userTasks;
		this.deadline = deadline;
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

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", amountTasks=" + amountTasks +
				", completeTasks=" + completeTasks +
				", userTasks=" + userTasks +
				", deadline=" + deadline +
				'}';
	}
}