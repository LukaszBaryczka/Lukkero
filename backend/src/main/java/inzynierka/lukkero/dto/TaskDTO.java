package inzynierka.lukkero.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDTO implements Serializable {
    
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" );
    
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
    
    public Date getDeadline () throws ParseException {
        if((this.deadline != null && this.deadline.isEmpty ()) || this.deadline == null){
            return null;
        }
        return dateFormat.parse ( this.deadline );
    }
    
    public void setDeadline ( Date date ) {
        if ( date != null ) {
            this.deadline = dateFormat.format ( date );
        } else {
            this.deadline = StringUtils.EMPTY;
        }
    }
    
    public Date getEssTime () throws ParseException {
        if((this.essTime != null && this.essTime.isEmpty ()) || this.essTime == null){
            return null;
        }
        return dateFormat.parse ( this.essTime );
    }
    
    public void setEssTime ( Date date ) {
        if ( date != null ) {
            this.essTime = dateFormat.format ( date );
        } else {
            this.essTime = StringUtils.EMPTY;
        }
    }
    
    public Date getAllTime () throws ParseException {
        if((this.allTime != null && this.allTime.isEmpty ()) || this.allTime == null){
            return null;
        }
        return dateFormat.parse ( this.allTime );
    }
    
    public void setAllTime ( Date date ) {
        if ( date != null ) {
            this.allTime = dateFormat.format ( date );
        } else {
            this.allTime = StringUtils.EMPTY;
        }
    }
    
    public Date getDayTime () throws ParseException {
        if((this.dayTime != null && this.dayTime.isEmpty ()) || this.dayTime == null){
            return null;
        }
        return dateFormat.parse ( this.dayTime );
    }
    
    public void setDayTime ( Date date ) {
        if ( date != null ) {
            this.dayTime = dateFormat.format ( date );
        } else {
            this.dayTime = StringUtils.EMPTY;
        }
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
}
