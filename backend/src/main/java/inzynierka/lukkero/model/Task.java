package inzynierka.lukkero.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table ( name = "task" )
public class Task implements Serializable {
    
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat ( "yyyy-MM-dd" );
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    @Column ( name = "task_id" )
    private BigInteger taskId;
    
    @Column ( name = "title" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column ( name = "deadline" )
    private Date deadline;
    @Column ( name = "ess_time" )
    private Date essTime;
    @Column ( name = "all_time" )
    private Date allTime;
    @Column ( name = "day_time" )
    private Date dayTime;
    @ManyToOne
    @JoinColumn ( name = "customer" )
    private Customer customer;
    @ManyToOne
    @JoinColumn ( name = "project" )
    private Project project;
    
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    public Task () {
    }
    
    public Task ( String name, String description, Date deadline, Date essTime, Date allTime, Date dayTime, Customer customer ) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.essTime = essTime;
        this.allTime = allTime;
        this.dayTime = dayTime;
        this.customer = customer;
    }
    
    public BigInteger getTaskId () {
        return taskId;
    }
    
    public void setTaskId ( BigInteger taskId ) {
        this.taskId = taskId;
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
    
    public String getDeadline () {
        if ( this.deadline != null ) {
            return dateFormat.format ( this.deadline );
        } else {
            return StringUtils.EMPTY;
        }
    }
    
    public void setDeadline ( String deadline ) throws ParseException {
        if(deadline != null && !deadline.isEmpty ()){
            this.deadline = dateFormat.parse ( deadline );
        }
    }
    
    public String getEssTime () {
        if ( this.essTime != null ) {
            return dateFormat.format ( this.essTime );
        } else {
            return StringUtils.EMPTY;
        }
    }
    
    public void setEssTime ( String essTime ) throws ParseException {
        if(essTime != null && !essTime.isEmpty ()){
            this.essTime = dateFormat.parse ( essTime );
        }
    }
    
    public String getAllTime () {
        if ( this.allTime != null ) {
            return dateFormat.format ( this.allTime );
        } else {
            return StringUtils.EMPTY;
        }
    }
    
    public void setAllTime ( String allTime ) throws ParseException {
        if(allTime != null && !allTime.isEmpty ()){
            this.allTime = dateFormat.parse ( allTime );
        }
    }
    
    public String getDayTime () {
        if ( this.dayTime != null ) {
            return dateFormat.format ( this.dayTime );
        } else {
            return StringUtils.EMPTY;
        }
    }
    
    public void setDayTime ( String dayTime ) throws ParseException {
        if(dayTime != null && !dayTime.isEmpty ()){
            this.dayTime = dateFormat.parse ( dayTime );
        }
    }
    
    public Customer getCustomer () {
        return customer;
    }
    
    public void setCustomer ( Customer user ) {
        this.customer = user;
    }
    
    public Project getProject () {
        return project;
    }
    
    public void setProject ( Project project ) {
        this.project = project;
    }
    
    public List< Comment > getComments () {
        return comments;
    }
    
    public void setComments ( List< Comment > comments ) {
        this.comments = comments;
    }
    
    @Override
    public String toString () {
        return "Task{" +
                "taskId=" + taskId +
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