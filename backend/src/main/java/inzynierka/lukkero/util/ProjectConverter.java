package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.ProjectDTO;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.ParseException;

@Component
public class ProjectConverter implements IConverter<Project, ProjectDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    ProjectService projectService;
    
    public ProjectDTO entityToDto ( Project project ) {
        ProjectDTO projectDTO = modelMapper.map ( project, ProjectDTO.class );
        return projectDTO;
    }
    
    public Project dtoToEntity ( ProjectDTO projectDTO ) throws ParseException {
        Project project = modelMapper.map ( projectDTO, Project.class );
        
        if ( projectDTO.getProjectId ( ) != null ) {
            Project oldProject = projectService.findOne ( BigInteger.valueOf ( Long.valueOf ( projectDTO.getProjectId ( ) ) ) );
            project.setCustomers ( oldProject.getCustomers ( ) );
            project.setTasks ( oldProject.getTasks ( ) );
        }
        return project;
    }
}
