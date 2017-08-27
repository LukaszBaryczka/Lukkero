package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Documentation;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.repository.ProjectRepository;
import inzynierka.lukkero.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "projectService" )
public class ProjectService implements IService< Project > {
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public String save ( Project project ) {
        if ( projectRepository == null ) return StringUtils.EMPTY;
        projectRepository.save ( project );
        return "Success";
    }
    
    @Override
    public String delete ( Project project ) {
        if ( projectRepository == null ) return StringUtils.EMPTY;
        projectRepository.delete ( project );
        return "Success";
    }
    
    @Override
    public Project findOne ( BigInteger id ) {
        if ( projectRepository == null ) return new Project ( );
        return projectRepository.findOne ( id );
    }
    
    @Override
    public List< Project > getAll () {
        if ( projectRepository == null ) return new ArrayList<> ( );
        List< Project > projects = ( List< Project > ) projectRepository.findAll ( );
        return projects;
    }
    
    public List<Project> getAllByUsername (String username) {
        if ( projectRepository == null ) return new ArrayList<> ( );
        if ( userRepository == null ) return new ArrayList<> ( );
        Customer customer = userRepository.findByUsername ( username );
        List< Project > projects = ( List< Project > )
                projectRepository.findProjectByCustomers ( customer );
        return projects;
    }
    
    public Documentation getDocumentationByProjectId(BigInteger projectId) {
        return findOne ( projectId ).getDocumentation ();
    }
}