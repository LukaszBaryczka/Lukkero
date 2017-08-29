package inzynierka.lukkero.dto;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectDTO {
    
    private String projectId;

    private String name;

    private String description;

    private int amountTasks;

    private int completeTasks;

    private int userTasks;

    private String deadline;
    
    public String getProjectId () {
        return projectId;
    }
    
    public void setProjectId ( String projectId ) {
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
    
    public String getDeadline () {
        return deadline;
    }
    
    public void setDeadline ( String deadline ) {
        this.deadline = deadline;
    }
}
