package com.bennieslab.portfolio.controller;

import com.bennieslab.portfolio.model.Education;
import com.bennieslab.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5500")@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/{id}")
    public Optional<Education> getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education updated) {
        return educationService.updateEducation(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return "Education with ID " + id + " deleted successfully.";
    }
}
