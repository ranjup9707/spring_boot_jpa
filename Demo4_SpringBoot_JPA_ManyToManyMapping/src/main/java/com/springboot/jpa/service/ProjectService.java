package com.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Project;
import com.springboot.jpa.repository.ProjectRepository;

@Service
public class ProjectService 
{
	
	@Autowired
	private ProjectRepository projectRepository;

	public void saveProject(Project project) {
		projectRepository.save(project);
	}

	public List<Project> getProjectDetails(Long projectId) {
		if(null != projectId) {
			return projectRepository.findAllByProjectId(projectId);
		}
		else {
			return projectRepository.findAll();
		}
	}

	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
	}

}
