package inzynierka.lukkero.controller;

import inzynierka.lukkero.dto.CommentDTO;
import inzynierka.lukkero.dto.ProjectDTO;
import inzynierka.lukkero.model.*;
import inzynierka.lukkero.service.ChangesService;
import inzynierka.lukkero.service.ProjectService;
import inzynierka.lukkero.service.TaskService;
import inzynierka.lukkero.util.CommentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    TaskService taskService;
    
    @Autowired
    CommentConverter commentConverter;
    
    @Autowired
    ChangesService changesService;
    
    @RequestMapping ( method = RequestMethod.GET, value = "/project/comment/{projectId}"  )
    private @ResponseBody
    List<CommentDTO> getCommentFromProject ( @PathVariable BigInteger projectId) {
        if ( projectService != null ) {
            List<Comment> comments = projectService.findOne ( projectId ).getComments ();
            return entityListToDtoList(comments);
        }
        return new ArrayList<> (  );
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/task/comment/{taskId}"  )
    private @ResponseBody
    List<CommentDTO> getCommentFromTask ( @PathVariable BigInteger taskId) {
        if ( taskService != null ) {
            List<Comment> comments = taskService.findOne ( taskId ).getComments ();
            return entityListToDtoList(comments);
        }
        return new ArrayList<> (  );
    }
    
    @RequestMapping(value = "/project/comment/{projectId}", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postCommentFromProject( @RequestBody Comment comment, @PathVariable BigInteger projectId) {
        if ( projectService != null ) {
            Project project = projectService.findOne ( projectId );
            comment.setProject ( project );
            List<Comment> comments = project.getComments ();
            comments.add ( comment );
            project.setComments ( comments );
            projectService.save ( project );
            Change change = new Change (  );
            change.setProject ( project );
            change.setVisible ( true );
            changesService.save ( change );
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
    
    @RequestMapping(value = "/task/comment/{taskId}", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postCommentFromTask( @RequestBody Comment comment, @PathVariable BigInteger taskId) {
        if ( taskService != null ) {
            Task task = taskService.findOne ( taskId );
            comment.setTask ( task );
            List<Comment> comments = task.getComments ();
            comments.add ( comment );
            task.setComments ( comments );
            taskService.save ( task );
            Change change = new Change (  );
            change.setTask ( task );
            change.setVisible ( true );
            changesService.save ( change );
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED);
    }
    
    private List<CommentDTO> entityListToDtoList(List<Comment> comments) {
        List< CommentDTO > commentDTOList = new ArrayList<> (  );
        for(Comment comment : comments) {
            commentDTOList.add ( commentConverter.entityToDto ( comment ) );
        }
        return commentDTOList;
    }
}
