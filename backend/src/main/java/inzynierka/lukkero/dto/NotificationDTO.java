package inzynierka.lukkero.dto;


public class NotificationDTO {
    
    private String id;
    
    private CustomerDTO customer;
    
    private ProjectDTO project;
    
    private TaskDTO task;
    
    private Boolean visible;
    
    public String getId () {
        return id;
    }
    
    public void setId ( String id ) {
        this.id = id;
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
    
    public TaskDTO getTask () {
        return task;
    }
    
    public void setTask ( TaskDTO task ) {
        this.task = task;
    }
    
    public Boolean getVisible () {
        return visible;
    }
    
    public void setVisible ( Boolean visible ) {
        this.visible = visible;
    }
}
