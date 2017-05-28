package inzynierka.lukkero.model;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "change")
public class Change implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	@Column(name = "customer")
	private Customer customer;
	@Column(name = "project")
	private Project project;
	@Column(name = "task")
	private Task task;
	@Column(name = "visible")
	private Boolean visible;

	public Change() {}

	public Change(Customer customer, Project project, Task task, Boolean visible) {
		this.customer = customer;
		this.project = project;
		this.task = task;
		this.visible = visible;
	}

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Project getProject() {return project;}
	public void setProject(Project project) {this.project = project;}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "Change{" +
				"id=" + id +
				", customer=" + customer +
				", project=" + project +
				", task=" + task +
				", visible=" + visible +
				'}';
	}
}