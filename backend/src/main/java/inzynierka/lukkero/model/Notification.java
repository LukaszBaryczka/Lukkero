package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table ( name = "notification" )
public class Notification implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    @Column ( name = "notification_id" )
    private BigInteger id;
    
    @ManyToOne
    @JoinColumn ( name = "customer" )
    private Customer customer;
    @ManyToOne
    @JoinColumn ( name = "project" )
    private Project project;
    @ManyToOne
    @JoinColumn ( name = "task" )
    private Task task;
    @Column ( name = "visible" )
    private Boolean visible;
    
    public Notification ( Customer customer, Project project, Task task, Boolean visible ) {
        this.customer = customer;
        this.project = project;
        this.task = task;
        this.visible = visible;
    }
    
    public Notification () {
    }
    
    public BigInteger getId () {
        return id;
    }
    
    public void setId ( BigInteger id ) {
        this.id = id;
    }
    
    public Customer getCustomer () {
        return customer;
    }
    
    public void setCustomer ( Customer customer ) {
        this.customer = customer;
    }
    
    public Project getProject () {
        return project;
    }
    
    public void setProject ( Project project ) {
        this.project = project;
    }
    
    public Task getTask () {
        return task;
    }
    
    public void setTask ( Task task ) {
        this.task = task;
    }
    
    public Boolean getVisible () {
        return visible;
    }
    
    public void setVisible ( Boolean visible ) {
        this.visible = visible;
    }
}
