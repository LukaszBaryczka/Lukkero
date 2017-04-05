package inzynierka.lukkero.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.util.DefaultService;

@Service("projectService")
public class ProjectService implements DefaultService<Project> {

	@Override
	public Project findById(String id) {
		for(Project project : projects) {
			if(project.getId().equals(BigInteger.valueOf(Long.valueOf(id)))) {
				return project;
			}
		}
		return null;
	}

	@Override
	public Project findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Project object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Project object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> findAll() {
		return projects;
	}
	
	
	private static List<Project> projects;
	
	static {
		projects = initDefaultData();
	}
	
	private static List<Project> initDefaultData() {
		List<Project> newProjects = new ArrayList<>();
		newProjects.add(new Project());
		newProjects.get(newProjects.size()-1).setId(BigInteger.valueOf((long) 1));
		newProjects.get(newProjects.size()-1).setName("Łukasz1");
		newProjects.add(new Project());
		newProjects.get(newProjects.size()-1).setId(BigInteger.valueOf((long) 2));
		newProjects.get(newProjects.size()-1).setName("Łukasz2");
		newProjects.add(new Project());
		newProjects.get(newProjects.size()-1).setId(BigInteger.valueOf((long) 3));
		newProjects.get(newProjects.size()-1).setName("Łukasz3");
		newProjects.add(new Project());
		newProjects.get(newProjects.size()-1).setId(BigInteger.valueOf((long) 4));
		newProjects.get(newProjects.size()-1).setName("Łukasz4");
		newProjects.add(new Project());
		newProjects.get(newProjects.size()-1).setId(BigInteger.valueOf((long) 5));
		newProjects.get(newProjects.size()-1).setName("Łukasz5");
		return newProjects;
	}
}
