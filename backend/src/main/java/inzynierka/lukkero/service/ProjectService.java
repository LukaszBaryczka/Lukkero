package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.repository.ProjectRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "projectService" )
//@Scope("session")
public class ProjectService implements IService< Project > {
    
    @Autowired
    ProjectRepository projectRepository;
    
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
        //TODO Wyszukanie projektów dla jednego usera(zaiplementowanie mechanizmu sesji oraz pobieranie z niego id usera)
        List< Project > projectForUser = new ArrayList<> ( );
        return projects;
    }
    
}