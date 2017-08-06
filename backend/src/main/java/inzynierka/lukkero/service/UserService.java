package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.repository.ProjectRepository;
import inzynierka.lukkero.repository.TaskRepository;
import inzynierka.lukkero.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "userService" )
//@Scope("session")
public class UserService implements IService< Customer > {
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    public String save ( Customer customer ) {
        if ( userRepository == null ) return StringUtils.EMPTY;
        userRepository.save ( customer );
        return "Success";
    }
    
    @Override
    public String delete ( Customer customer ) {
        if ( userRepository == null ) return StringUtils.EMPTY;
        userRepository.delete ( customer );
        return "Success";
    }
    
    @Override
    public Customer findOne ( BigInteger id ) {
        if ( userRepository == null ) return new Customer ( );
        return userRepository.findOne ( id );
    }
    
    @Override
    public List< Customer > getAll () {
        if ( userRepository == null ) return new ArrayList<> ( );
        return ( List< Customer > ) userRepository.findAll ( );
    }
    
    public Customer findSessionUser () {
        if ( userRepository == null ) return new Customer ( );
            //TODO Wyszukanie projektów dla jednego usera(zaiplementowanie mechanizmu sesji oraz pobieranie z niego id usera)
            BigInteger id = BigInteger.ONE;
            return userRepository.findOne ( id );
    }
    
    public List< Customer > findByProjectId ( String projectId ) {
        if ( userRepository == null) return new ArrayList<> ( );
        if ( projectRepository == null) return new ArrayList<> ( );
        if ( projectId == null) return new ArrayList<> ( );

        Project project = projectRepository.findOne ( BigInteger.valueOf (
                Long.parseLong ( projectId ) ) );
        return  userRepository.findUserByProjects( project );
    }
}
