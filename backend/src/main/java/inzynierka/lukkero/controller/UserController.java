package inzynierka.lukkero.controller;

import inzynierka.lukkero.model.context.SignUpContext;
import inzynierka.lukkero.util.UserConverter;
import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserConverter userConverter;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
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
    
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> signUp( @RequestBody SignUpContext signUpContext) throws ParseException {
        Customer user = userConverter.dtoToEntity ( signUpContext.getUserDto () );
        user.setUsername ( signUpContext.getUsername () );
        user.setPassword (passwordEncoder.encode(signUpContext.getPassword ()));
        userService.save(user);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
