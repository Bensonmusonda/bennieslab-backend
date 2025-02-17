package com.bennieslab.portfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bennieslab.portfolio.model.Project;
import com.bennieslab.portfolio.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Optional<Project> getprojectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping
    public List<Project> getAllprojects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createproject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @DeleteMapping("/{id}")
    public String deleteproject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "project deleted successfully";
    }
}
