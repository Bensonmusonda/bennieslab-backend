package com.bennieslab.portfolio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bennieslab.portfolio.model.Project;
import com.bennieslab.portfolio.repository.ProjectRepository;
import com.bennieslab.portfolio.repository.mini.ProjectMini;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<ProjectMini> getAllProjectNames() {
        return projectRepository.findAllProjectMini();
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    
}
