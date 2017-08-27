package inzynierka.lukkero.controller;

import inzynierka.lukkero.model.context.NewTaskContext;
import inzynierka.lukkero.util.ProjectConverter;
import inzynierka.lukkero.util.TaskConverter;
import inzynierka.lukkero.dto.TaskDTO;
import inzynierka.lukkero.model.Task;
import inzynierka.lukkero.service.TaskService;
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
public class TaskController {
    
    @Autowired
    TaskService taskService;
    
    @Autowired
    TaskConverter taskConverter;
    
    @Autowired
    UserConverter userConverter;
    
    @Autowired
    ProjectConverter projectConverter;
    
    @RequestMapping ( method = RequestMethod.GET, value = "/task/{taskId}" )
    @ResponseBody
    private TaskDTO getTaskById ( @PathVariable BigInteger taskId ) {
        if ( taskService != null ) {
            Task task = taskService.findOne ( taskId );
            return taskConverter.entityToDto ( task );
        }
        return null;
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/project-list/{projectId}" )
    @ResponseBody
    private List< TaskDTO > getAllTaskByProjectId ( @PathVariable BigInteger projectId ) {
        if ( taskService != null ) {
            List< Task > tasks = taskService.getTaskByProjectId ( projectId );
            List< TaskDTO > taskDTOList = new ArrayList<> (  );
            for ( Task task : tasks ) {
                taskDTOList.add ( taskConverter.entityToDto ( task ) );
            }
            return taskDTOList;
        }
        return null;
    }
    
    @RequestMapping ( method = RequestMethod.GET, value = "/task-list" )
    @ResponseBody
    private List< TaskDTO > getAllTaskForUser () {
        if ( taskService != null ) {
            List< Task > tasks = taskService.getTaskBySessionUser ( );
            List< TaskDTO > taskDTOList = new ArrayList<> (  );
            for ( Task task : tasks ) {
                taskDTOList.add ( taskConverter.entityToDto ( task ) );
            }
            return taskDTOList;
        }
        return null;
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> postTask( @RequestBody NewTaskContext newTaskContext) throws ParseException {
        Task task = taskConverter.dtoToEntity ( newTaskContext.getTask () );
        task.setCustomer ( userConverter.dtoToEntity ( newTaskContext.getCustomer () ) );
        task.setProject ( projectConverter.dtoToEntity ( newTaskContext.getProject () ) );
        
        taskService.save ( task );
        
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
