package inzynierka.lukkero.controller;

import inzynierka.lukkero.util.NotificationConverter;
import inzynierka.lukkero.dto.NotificationDTO;
import inzynierka.lukkero.model.Notification;
import inzynierka.lukkero.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ( "/notifications" )
public class NotificationController {
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    NotificationConverter notificationConventer;
    
    @RequestMapping ( method = RequestMethod.GET )
    @ResponseBody
    private List< NotificationDTO > getAllNotifications () {
        if ( notificationService != null ) {
            List< Notification > notifications = notificationService.getAll ( );
            List< NotificationDTO > notificationDTOList = new ArrayList<> (  );
            for(Notification notification : notifications) {
                notificationDTOList.add ( notificationConventer.entityToDto ( notification ) );
            }
            return notificationDTOList;
        }
        return new ArrayList<> ( );
    }
}
