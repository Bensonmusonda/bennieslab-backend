package com.bennieslab.portfolio.model;

import com.bennieslab.portfolio.model.enums.EducationLevel;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EducationLevel level;

    private String title;

    private String institution;

    @Column(name = "date_started", nullable = false)
    private LocalDate dateStarted;

    @Column(name = "date_ended")
    private LocalDate dateEnded;

    @Column(name = "currently_here", nullable = false, insertable = false, updatable = false)
    private Boolean currentlyHere;

    @PrePersist
    @PreUpdate
    public void computeCurrentlyHere() {
        this.currentlyHere = (this.dateEnded == null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public void setLevel(EducationLevel level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(LocalDate dateEnded) {
        this.dateEnded = dateEnded;
        this.currentlyHere = (dateEnded == null);
    }

    public Boolean getCurrentlyHere() {
        return currentlyHere;
    }

    public void setCurrentlyHere(Boolean currentlyHere) {
        this.currentlyHere = currentlyHere;
    }
}
