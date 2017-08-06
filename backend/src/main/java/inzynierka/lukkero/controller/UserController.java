package inzynierka.lukkero.controller;

import inzynierka.lukkero.util.UserConverter;
import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserConverter userConverter;
    
    @RequestMapping ( method = RequestMethod.GET, value = "/user" )
    @ResponseBody
    private CustomerDTO getUser () {
        if ( userService != null ) {
            Customer customer = userService.findSessionUser ( );
            return userConverter.entityToDto ( customer );
        }
        return null;
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/members/{projectId}" )
    @ResponseBody
    private List< CustomerDTO > getUsersByProjectId ( @PathVariable String projectId ) {
        if ( userService != null ) {
            List< Customer > customers = userService.findByProjectId ( projectId );
            List< CustomerDTO > customerDTOList = new ArrayList<> ( );
            for ( Customer customer : customers ) {
                customerDTOList.add ( userConverter.entityToDto ( customer ) );
            }
            return customerDTOList;
        }
        return null;
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/members" )
    @ResponseBody
    private List< CustomerDTO > getAllUsers() {
        if ( userService != null ) {
            List< Customer > customers = userService.getAll ();
            List< CustomerDTO > customerDTOList = new ArrayList<> ( );
            for ( Customer customer : customers ) {
                customerDTOList.add ( userConverter.entityToDto ( customer ) );
            }
            return customerDTOList;
        }
        return null;
    }
}
