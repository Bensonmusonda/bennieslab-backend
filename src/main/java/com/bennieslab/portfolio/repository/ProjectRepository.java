package com.bennieslab.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bennieslab.portfolio.model.Project;
import com.bennieslab.portfolio.repository.mini.ProjectMini;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p")
    List<ProjectMini> findAllProjectMini();
}
