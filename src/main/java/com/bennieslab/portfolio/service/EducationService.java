package com.bennieslab.portfolio.service;

import com.bennieslab.portfolio.model.Education;
import com.bennieslab.portfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Optional<Education> getEducationById(Long id) {
        return educationRepository.findById(id);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(Long id, Education updated) {
        return educationRepository.findById(id).map(edu -> {
            edu.setLevel(updated.getLevel());
            edu.setTitle(updated.getTitle());
            edu.setInstitution(updated.getInstitution());
            edu.setDateStarted(updated.getDateStarted());
            edu.setDateEnded(updated.getDateEnded());
            edu.setCurrentlyHere(updated.getDateEnded() == null);
            return educationRepository.save(edu);
        }).orElseThrow(() -> new RuntimeException("Education not found with ID: " + id));
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
