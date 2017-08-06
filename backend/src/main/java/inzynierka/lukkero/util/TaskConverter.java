package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.TaskDTO;
import inzynierka.lukkero.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class TaskConverter implements IConverter<Task, TaskDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    public TaskDTO entityToDto ( Task task ) {
        TaskDTO taskDTO = modelMapper.map ( task, TaskDTO.class );
        return taskDTO;
    }
    
    public Task dtoToEntity ( TaskDTO taskDTO ) throws ParseException {
        Task task = modelMapper.map ( taskDTO, Task.class );
        return task;
    }
}
