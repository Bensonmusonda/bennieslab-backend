package com.bennieslab.portfolio.model;

import com.bennieslab.portfolio.model.enums.StickieSource;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Stickie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StickieSource source;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "date_stuck", nullable = false, updatable = false)
    private Instant dateStuck;

    @PrePersist
    public void setTimestamp() {
        this.dateStuck = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StickieSource getSource() {
        return source;
    }

    public void setSource(StickieSource source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDateStuck() {
        return dateStuck;
    }

    public void setDateStuck(Instant dateStuck) {
        this.dateStuck = dateStuck;
    }
}
