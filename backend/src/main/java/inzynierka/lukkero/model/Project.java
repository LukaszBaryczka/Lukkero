package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table ( name = "project" )
public class Project implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    @Column ( name = "project_id" )
    private BigInteger projectId;
    
    @Column ( name = "title" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column ( name = "amount_tasks" )
    private int amountTasks;
    @Column ( name = "complete_tasks" )
    private int completeTasks;
    @Column ( name = "user_tasks" )
    private int userTasks;
    @Column ( name = "deadline" )
    private Date deadline;
    @ManyToMany()
    @JoinTable (
            name = "user_project",
            inverseJoinColumns = { @JoinColumn ( name = "customer_id", referencedColumnName = "customer_id") },
            joinColumns = { @JoinColumn ( name = "project_id", referencedColumnName = "project_id" ) } )
    private List< Customer > customers;
    @OneToMany ( mappedBy = "project", cascade = CascadeType.ALL )
    private List< Task > tasks;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documentation")
    private Documentation documentation;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    public Project () {
    }
    
    public Project ( String name, String description, int amountTasks, int completeTasks, int userTasks, Date deadline ) {
        this.name = name;
        this.description = description;
        this.amountTasks = amountTasks;
        this.completeTasks = completeTasks;
        this.userTasks = userTasks;
        this.deadline = deadline;
    }
    
    public BigInteger getProjectId () {
        return projectId;
    }
    
    public void setProjectId ( BigInteger projectId ) {
        this.projectId = projectId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setDescription ( String description ) {
        this.description = description;
    }
    
    public int getAmountTasks () {
        return amountTasks;
    }
    
    public void setAmountTasks ( int amountTasks ) {
        this.amountTasks = amountTasks;
    }
    
    public int getCompleteTasks () {
        return completeTasks;
    }
    
    public void setCompleteTasks ( int completeTasks ) {
        this.completeTasks = completeTasks;
    }
    
    public int getUserTasks () {
        return userTasks;
    }
    
    public void setUserTasks ( int userTasks ) {
        this.userTasks = userTasks;
    }
    
    public Date getDeadline () {
        return deadline;
    }
    
    public void setDeadline ( Date deadline ) {
        this.deadline = deadline;
    }
    
    public List< Customer > getCustomers () {
        return customers;
    }
    
    public void setCustomers ( List< Customer > customers ) {
        this.customers = customers;
    }
    
    public List< Task > getTasks () {
        return tasks;
    }
    
    public void setTasks ( List< Task > tasks ) {
        this.tasks = tasks;
    }
    
    public Documentation getDocumentation () {
        return documentation;
    }
    
    public void setDocumentation ( Documentation documentation ) {
        this.documentation = documentation;
    }
    
    public List< Comment > getComments () {
        return comments;
    }
    
    public void setComments ( List< Comment > comments ) {
        this.comments = comments;
    }
    
    @Override
    public String toString () {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amountTasks=" + amountTasks +
                ", completeTasks=" + completeTasks +
                ", userTasks=" + userTasks +
                ", deadline=" + deadline +
                '}';
    }
}