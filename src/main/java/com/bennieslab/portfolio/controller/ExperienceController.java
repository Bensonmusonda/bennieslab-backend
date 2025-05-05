package com.bennieslab.portfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bennieslab.portfolio.model.Experience;
import com.bennieslab.portfolio.service.ExperienceService;

@CrossOrigin(origins = "http://localhost:5500")@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/{id}")
    public Optional<Experience> getExperienceById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @GetMapping
    public List<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }

    @PostMapping
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }

    @DeleteMapping("/{id}")
    public void removeExperience(@PathVariable Long id) {
        experienceService.removeExperience(id);
    }
}
