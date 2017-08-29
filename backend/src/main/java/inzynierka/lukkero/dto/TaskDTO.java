package inzynierka.lukkero.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDTO implements Serializable {
    
    private String taskId;
    
    private String name;

    private String description;

    private String deadline;

    private String essTime;

    private String allTime;

    private String dayTime;

    private CustomerDTO customer;

    private ProjectDTO project;
    
    public TaskDTO () {
    }
    
    public String getTaskId () {
        return taskId;
    }
    
    public void setTaskId ( String taskId ) {
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
    
    public CustomerDTO getCustomer () {
        return customer;
    }
    
    public void setCustomer ( CustomerDTO customer ) {
        this.customer = customer;
    }
    
    public ProjectDTO getProject () {
        return project;
    }
    
    public void setProject ( ProjectDTO project ) {
        this.project = project;
    }
    
    public String getDeadline () {
        return deadline;
    }
    
    public void setDeadline ( String deadline ) {
        this.deadline = deadline;
    }
    
    public String getEssTime () {
        return essTime;
    }
    
    public void setEssTime ( String essTime ) {
        this.essTime = essTime;
    }
    
    public String getAllTime () {
        return allTime;
    }
    
    public void setAllTime ( String allTime ) {
        this.allTime = allTime;
    }
    
    public String getDayTime () {
        return dayTime;
    }
    
    public void setDayTime ( String dayTime ) {
        this.dayTime = dayTime;
    }
}
