package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Notification;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.Task;
import inzynierka.lukkero.repository.NotificationRepository;
import inzynierka.lukkero.repository.ProjectRepository;
import inzynierka.lukkero.repository.TaskRepository;
import inzynierka.lukkero.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "notificationService" )
public class NotificationService implements IService< Notification > {
    
    @Autowired
    NotificationRepository notificationRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TaskRepository taskRepository;
    
    @Override
    public String save ( Notification notification ) {
        if ( notificationRepository == null ) return StringUtils.EMPTY;
        notificationRepository.save ( notification );
        return "Success";
    }
    
    @Override
    public String delete ( Notification notification ) {
        if ( notificationRepository == null ) return StringUtils.EMPTY;
        notificationRepository.delete ( notification );
        return "Success";
    }
    
    @Override
    public Notification findOne ( BigInteger id ) {
        if ( notificationRepository == null ) return new Notification ( );
        return notificationRepository.findOne ( id );
    }
    
    @Override
    public List< Notification > getAll () {
        if ( notificationRepository == null ) return new ArrayList<> ( );
        return ( List< Notification > ) notificationRepository.findAll ( );
    }
    
    public List<Notification> getByProjectOrTask(String username) {
        Customer customer = userRepository.findByUsername ( username );
        List<Notification> notifications =
                notificationRepository.findNotificationsByCustomerAndVisible ( customer, true );
        return notifications;
    }
    
    public String save ( List<Notification> notifications ) {
        if ( notificationRepository == null ) return StringUtils.EMPTY;
        notificationRepository.save ( notifications );
        return "Success";
    }
}