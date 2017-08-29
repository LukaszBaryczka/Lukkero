package inzynierka.lukkero.controller;

import inzynierka.lukkero.security.JwtTokenUtil;
import inzynierka.lukkero.util.ChangesConverter;
import inzynierka.lukkero.dto.ChangeDTO;
import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.service.ChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ( "/changes" )
public class ChangesController {
    
    @Autowired
    ChangesService changesService;
    
    @Autowired
    ChangesConverter changesConverter;
    
    @Value ("${jwt.header}")
    private String tokenHeader;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping ( method = RequestMethod.GET )
    private @ResponseBody
    List< ChangeDTO > getAllChanges (HttpServletRequest request) {
        if ( changesService != null ) {
            String token = request.getHeader(tokenHeader);
            String username = jwtTokenUtil.getUsernameFromToken(token);
            List< Change > changes = changesService.getByProjectOrTask ( username );
            List< ChangeDTO > changeDTOList = new ArrayList<> (  );
            for(Change change : changes) {
                changeDTOList.add ( changesConverter.entityToDto ( change ));
            }
            return changeDTOList;
        }
        return new ArrayList<> ( );
    }
    
    @RequestMapping(method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postChange( @RequestBody ChangeDTO changeDTO) throws ParseException {
        if ( changesService != null ) {
            Change change = changesConverter.dtoToEntity ( changeDTO );
            changesService.save ( change );
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
}
