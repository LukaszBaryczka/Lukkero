package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.security.Authority;
import inzynierka.lukkero.model.security.AuthorityName;
import inzynierka.lukkero.repository.AuthorityRepository;
import inzynierka.lukkero.repository.ProjectRepository;
import inzynierka.lukkero.repository.TaskRepository;
import inzynierka.lukkero.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service ( "userService" )
public class UserService implements IService< Customer > {
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    AuthorityRepository authorityRepository;
    
    @Override
    public String save ( Customer customer ) {
        if ( userRepository == null ) return StringUtils.EMPTY;
        if (customer != null &&
                userRepository.exists ( customer.getUserId ()))
            return StringUtils.EMPTY;
        customer.setEnabled ( true );
        customer.setLastPasswordResetDate ( new Date (  ) );
        List< Authority > authorities = new ArrayList<> (  );
        authorities.add ( authorityRepository.findByName ( AuthorityName.ROLE_USER ) );
        customer.setAuthorities ( authorities );
        customer.setTasks ( new ArrayList<> (  ) );
        customer.setProjects ( new ArrayList<> (  ) );
        customer.setWorkTime ( new Date ( 0, 0 , 0, 0, 0, 0  ));
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
    
    public Customer findUserByUsername (String username) {
        if ( userRepository == null ) return new Customer ( );
            return userRepository.findByUsername ( username );
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
