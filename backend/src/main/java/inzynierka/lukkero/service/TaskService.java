package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.Task;
import inzynierka.lukkero.repository.TaskRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "taskService" )
//@Scope("session")
public class TaskService implements IService< Task > {
    
    @Autowired
    TaskRepository taskRepository;
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    UserService userService;
    
    @Override
    public String save ( Task task ) {
        if ( taskRepository == null ) return StringUtils.EMPTY;
        taskRepository.save ( task );
        return "Success";
    }
    
    @Override
    public String delete ( Task task ) {
        if ( taskRepository == null ) return StringUtils.EMPTY;
        taskRepository.delete ( task );
        return "Success";
    }
    
    @Override
    public Task findOne ( BigInteger id ) {
        if ( taskRepository == null ) new Task ( );
        return taskRepository.findOne ( id );
    }
    
    @Override
    public List< Task > getAll () {
        if ( taskRepository == null ) return new ArrayList<> ( );
        return ( List< Task > ) taskRepository.findAll ( );
        
    }
    
    public List< Task > getTaskByProjectId ( BigInteger projectId ) {
        if ( projectService == null ) return new ArrayList<> ( );
        if ( taskRepository == null ) return new ArrayList<> ( );
        Project project = projectService.findOne ( projectId );
        if ( project == null ) return new ArrayList<> ( );
        return taskRepository.findTasksByProject ( project );
    }
    
    public List< Task > getTaskBySessionUser () {
        //TODO Pobieranie userId z sesji usera
        if ( taskRepository == null ) return new ArrayList<> ( );
        if ( userService == null ) return new ArrayList<> ( );
        Customer customer = userService.findOne ( BigInteger.ONE );
        return ( List< Task > ) taskRepository.findTasksByCustomer ( customer );

    }
}