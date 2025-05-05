package com.bennieslab.portfolio.service;

import com.bennieslab.portfolio.model.Stickie;
import com.bennieslab.portfolio.repository.StickieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StickieService {

    @Autowired
    private StickieRepository stickieRepository;

    public List<Stickie> getAllStickies() {
        return stickieRepository.findAll();
    }

    public Optional<Stickie> getStickieById(Long id) {
        return stickieRepository.findById(id);
    }

    public Stickie createStickie(Stickie stickie) {
        return stickieRepository.save(stickie);
    }

    public Stickie updateStickie(Long id, Stickie updated) {
        return stickieRepository.findById(id).map(existing -> {
            existing.setSource(updated.getSource());
            existing.setContent(updated.getContent());
            return stickieRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Stickie not found with ID: " + id));
    }

    public void deleteStickie(Long id) {
        stickieRepository.deleteById(id);
    }
}
