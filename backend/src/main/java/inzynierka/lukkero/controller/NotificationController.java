package inzynierka.lukkero.controller;

import inzynierka.lukkero.security.JwtTokenUtil;
import inzynierka.lukkero.util.NotificationConverter;
import inzynierka.lukkero.dto.NotificationDTO;
import inzynierka.lukkero.model.Notification;
import inzynierka.lukkero.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ( "/notifications" )
public class NotificationController {
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    NotificationConverter notificationConventer;
    
    @Value ("${jwt.header}")
    private String tokenHeader;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping ( method = RequestMethod.GET )
    @ResponseBody
    private List< NotificationDTO > getAllNotifications (HttpServletRequest request) {
        if ( notificationService != null ) {
            String token = request.getHeader(tokenHeader);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            List< Notification > notifications = notificationService.getByProjectOrTask ( username );
            List< NotificationDTO > notificationDTOList = new ArrayList<> (  );
            for(Notification notification : notifications) {
                notificationDTOList.add ( notificationConventer.entityToDto ( notification ) );
            }
            return notificationDTOList;
        }
        return new ArrayList<> ( );
    }
    
    @RequestMapping(method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postNotification( @RequestBody NotificationDTO notificationDTO) throws ParseException {
        if ( notificationService != null ) {
            Notification notification = notificationConventer.dtoToEntity ( notificationDTO );
            notificationService.save ( notification );
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
}
