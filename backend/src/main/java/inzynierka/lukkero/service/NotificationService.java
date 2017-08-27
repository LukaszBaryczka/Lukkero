package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Notification;
import inzynierka.lukkero.repository.NotificationRepository;
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
}