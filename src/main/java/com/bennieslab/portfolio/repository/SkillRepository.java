package com.bennieslab.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bennieslab.portfolio.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
