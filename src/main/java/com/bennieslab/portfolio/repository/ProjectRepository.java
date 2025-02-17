package com.bennieslab.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bennieslab.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
