package inzynierka.lukkero.controller;

import inzynierka.lukkero.util.ProjectConverter;
import inzynierka.lukkero.dto.ProjectDTO;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    ProjectConverter projectConverter;
    
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
}
