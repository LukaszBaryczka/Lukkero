package inzynierka.lukkero.model.context;

import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.dto.ProjectDTO;
import inzynierka.lukkero.dto.TaskDTO;

import java.io.Serializable;

/**
 * Created by lukasz on 26.08.17.
 */
public class NewTaskContext implements Serializable {
    
    private static final long serialVersionUID = -8445943548965154778L;
    
    private TaskDTO task;
    CustomerDTO customer;
    ProjectDTO project;
    
    public TaskDTO getTask () {
        return task;
    }
    
    public void setTask ( TaskDTO task ) {
        this.task = task;
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
