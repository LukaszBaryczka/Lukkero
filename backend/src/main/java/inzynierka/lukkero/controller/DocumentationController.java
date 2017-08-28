package inzynierka.lukkero.controller;

import inzynierka.lukkero.model.Documentation;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class DocumentationController {
    
    @Autowired
    ProjectService projectService;
    
    @RequestMapping ( method = RequestMethod.GET, value = "/doc/{projectId}"  )
    private @ResponseBody
    Documentation getDoc (@PathVariable BigInteger projectId) {
        if ( projectService != null ) {
            Documentation documentation = projectService
                    .getDocumentationByProjectId ( projectId );
            return documentation;
        }
        return new Documentation();
    }
    
    @RequestMapping(value = "/doc/{projectId}", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postProject( @RequestBody Documentation documentation, @PathVariable BigInteger projectId) {
        if ( projectService != null ) {
            Project project = projectService.findOne ( projectId );
            project.setDocumentation ( documentation );
            projectService.save ( project );
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
}
