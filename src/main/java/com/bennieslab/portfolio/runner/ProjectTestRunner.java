package com.bennieslab.portfolio.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bennieslab.portfolio.controller.ProjectController;
import com.bennieslab.portfolio.model.Project;

@Component
public class ProjectTestRunner implements CommandLineRunner{
    private final ProjectController projectController;

    public ProjectTestRunner(ProjectController projectController) {
        this.projectController = projectController;
    }

    @Override
    public void run(String... args) throws Exception {
        
        List<Project> projects = projectController.getAllprojects();

        
        if (projects.isEmpty()) {
            System.out.println("No projects found in the database.");
        } else {
            projects.forEach(project -> System.out.println(project.getName()));
        }
    }
}
