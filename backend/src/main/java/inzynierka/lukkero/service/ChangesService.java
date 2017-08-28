package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.Task;
import inzynierka.lukkero.repository.ChangesRepository;
import inzynierka.lukkero.repository.ProjectRepository;
import inzynierka.lukkero.repository.TaskRepository;
import inzynierka.lukkero.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "changesService" )
public class ChangesService implements IService< Change > {
    
    @Autowired
    ChangesRepository changesRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TaskRepository taskRepository;
    
    @Override
    public String save ( Change change ) {
        if ( changesRepository == null ) return StringUtils.EMPTY;
        changesRepository.save ( change );
        return "Success";
    }
    
    @Override
    public String delete ( Change change ) {
        if ( changesRepository == null ) return StringUtils.EMPTY;
        changesRepository.delete ( change );
        return "Success";

    }
    
    @Override
    public Change findOne ( BigInteger id ) {
        if ( changesRepository == null ) return new Change ( );
        return changesRepository.findOne ( id );
    }
    
    @Override
    public List< Change > getAll () {
        if ( changesRepository == null ) return new ArrayList<> ( );
        return ( List< Change > ) changesRepository.findAll ( );
    }
    
    public List<Change> getByProjectOrTask(String username) {
        Customer customer = userRepository.findByUsername ( username );
        List<Project> projects = projectRepository.findProjectByCustomers ( customer );
        List<Task> tasks = taskRepository.findTasksByCustomer ( customer );
        List<Change> changes = new ArrayList<> (  );
        for(Project project : projects) {
            for(Change change : changesRepository.findChangesByProject ( project )) {
                if(!changes.contains ( change ) && change.getVisible ()) {
                    changes.add ( change );
                }
            }
        }
        
        for(Task task : tasks) {
            for(Change change : changesRepository.findChangesByTask ( task )) {
                if(!changes.contains ( change ) && change.getVisible ()) {
                    changes.add ( change );
                }
            }
        }
        return changes;
    }
}