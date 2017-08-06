package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.NotificationDTO;
import inzynierka.lukkero.model.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class NotificationConverter implements IConverter<Notification, NotificationDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public NotificationDTO entityToDto ( Notification change ) {
        NotificationDTO changeDTO = modelMapper.map ( change, NotificationDTO.class );
        return changeDTO;
    }
    
    @Override
    public Notification dtoToEntity ( NotificationDTO changeDTO ) throws ParseException {
        Notification change = modelMapper.map ( changeDTO, Notification.class );
        return change;
    }
}