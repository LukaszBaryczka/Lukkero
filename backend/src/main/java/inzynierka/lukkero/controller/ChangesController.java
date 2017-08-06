package inzynierka.lukkero.controller;

import inzynierka.lukkero.util.ChangesConverter;
import inzynierka.lukkero.dto.ChangeDTO;
import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.service.ChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ( "/changes" )
public class ChangesController {
    
    @Autowired
    ChangesService changesService;
    
    @Autowired
    ChangesConverter changesConverter;
    
    @RequestMapping ( method = RequestMethod.GET )
    private @ResponseBody
    List< ChangeDTO > getAllChanges () {
        if ( changesService != null ) {
            List< Change > changes = changesService.getAll ( );
            List< ChangeDTO > changeDTOList = new ArrayList<> (  );
            for(Change change : changes) {
                changeDTOList.add ( changesConverter.entityToDto ( change ));
            }
            return changeDTOList;
        }
        return new ArrayList<> ( );
    }
}
