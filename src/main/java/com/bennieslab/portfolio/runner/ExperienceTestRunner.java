package com.bennieslab.portfolio.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bennieslab.portfolio.service.ExperienceService;
import com.bennieslab.portfolio.model.Experience;

@Component
public class ExperienceTestRunner implements CommandLineRunner {

    private final ExperienceService experienceService;

    public ExperienceTestRunner(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @Override
    public void run(String... args) {
        List<Experience> experienceList = experienceService.getAllExperience();

        System.out.println("Experience: ");
        System.out.println("---------------");
        if (experienceList.isEmpty()) {
            System.out.println("No experience");
        } else {
            experienceList.forEach(experience ->
                System.out.println(experience.getPosition() + "\t" + 
                                   experience.getOrganization() + "\t" +
                                   experience.getDateStarted() + "\t" +
                                   experience.getDateEnded()));
        }
        System.out.println("---------------");
    }
}