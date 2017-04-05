package inzynierka.lukkero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.service.ProjectService;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Project> getAllProjects() {
		return projectService.findAll();
	}

	@RequestMapping(value = "", params = { "id" }, method = RequestMethod.GET)
	public @ResponseBody Project getProjectByID(@RequestParam(value = "id") String id) {
		return projectService.findById(id);
	}
	
	@RequestMapping(value = "/changes", params = { "projectId" }, method = RequestMethod.GET)
	public @ResponseBody String getChangesByProjectID(@RequestParam(value = "projectId") String projectId) {
		return "changes by projectId = " + projectId;
	}
	
	@RequestMapping(value = "/changes", params = { "taskId" }, method = RequestMethod.GET)
	public @ResponseBody String getChangesByTaskID(@RequestParam(value = "taskId") String taskId) {
		return "changes by taskId = " + taskId;
	}

	@RequestMapping(value = "/users", params = { "projectId" }, method = RequestMethod.GET)
	public @ResponseBody String getUsersByTaskID(@RequestParam(value = "projectId") String projectId) {
		return "users by projectId = " + projectId;
	}
	
}
