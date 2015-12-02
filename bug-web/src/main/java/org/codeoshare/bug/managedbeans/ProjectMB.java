package org.codeoshare.bug.managedbeans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.codeoshare.bug.entities.Project;
import org.codeoshare.bug.sessionbeans.ProjectRepository;

@Named
@RequestScoped
public class ProjectMB {
	
	@Inject
	private ProjectRepository projectRepository;
	
	private Project project = new Project();
	
	private List<Project> projects;
	
	public void save() {
		if (this.getProject().getId() == null) {
			this.projectRepository.add(this.getProject());
		} else {
			this.projectRepository.edit(this.getProject());
		}
		this.project = new Project();
		this.projects = null;
	}
	
	public void delete(Long id) {
		this.projectRepository.removeById(id);
		this.projects = null;
	}
	
	public void prepareEdit(Long id) {
		this.project = this.projectRepository.findById(id);
	}
	
	public Project getProject() {
		return project;
	}
	
	public List<Project> getProjects() {
		if (this.projects == null) {
			this.projects = this.projectRepository.findAll();
		}
		return projects;
	}

}
