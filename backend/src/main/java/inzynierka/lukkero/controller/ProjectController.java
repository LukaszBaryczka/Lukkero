package inzynierka.lukkero.controller;

import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.context.NewProjectContext;
import inzynierka.lukkero.util.ProjectConverter;
import inzynierka.lukkero.dto.ProjectDTO;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.service.ProjectService;
import inzynierka.lukkero.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    ProjectConverter projectConverter;
    
    @Autowired
    UserConverter userConverter;
    
    @RequestMapping ( method = RequestMethod.GET, value = "/project/{projectId}" )
    @ResponseBody
    private ProjectDTO getProjectById ( @PathVariable BigInteger projectId ) {
        if ( projectService != null ) {
            Project project = projectService.findOne ( projectId );
            return projectConverter.entityToDto ( project );
        }
        return null;
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/project-list" )
    @ResponseBody
    private List< ProjectDTO > getAllProjectsForUser () {
        if ( projectService != null ) {
            List< Project > projects = projectService.getAll ( );
            List< ProjectDTO > projectDTOList = new ArrayList<> (  );
            for(Project project : projects) {
                projectDTOList.add ( projectConverter.entityToDto ( project ) );
            }
            return projectDTOList;
        }
        return new ArrayList<> ( );
    }
    
    @RequestMapping(value = "/project", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postProject( @RequestBody NewProjectContext newProjectContext) throws ParseException {
        Project project = projectConverter.dtoToEntity ( newProjectContext.getProject () );
        List<Customer> customers = new ArrayList<> (  );
        for( CustomerDTO customerDTO : newProjectContext.getSelectedUser ()) {
            customers.add ( userConverter.dtoToEntity ( customerDTO ) );
        }
        project.setCustomers ( customers );
    
        projectService.save ( project );
        
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
