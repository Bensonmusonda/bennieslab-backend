package com.bennieslab.portfolio.model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String position;
    private String organization;
    @Column(name = "date_started")
    private LocalDate dateStarted;
    @Column(name = "date_ended")
    private LocalDate dateEnded;

    public long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getOrganization() {
        return organization;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public LocalDate getDateEnded() {
        return dateEnded;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateEnded (LocalDate dateEnded) {
        this.dateEnded = dateEnded;
    }

}
