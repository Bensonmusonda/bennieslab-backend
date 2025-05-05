package com.bennieslab.portfolio.controller;

import com.bennieslab.portfolio.model.Stickie;
import com.bennieslab.portfolio.service.StickieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stickie")
@CrossOrigin(origins = "http://localhost:5500")
public class StickieController {

    @Autowired
    private StickieService stickieService;

    @GetMapping
    public List<Stickie> getAllStickies() {
        return stickieService.getAllStickies();
    }

    @GetMapping("/{id}")
    public Optional<Stickie> getStickieById(@PathVariable Long id) {
        return stickieService.getStickieById(id);
    }

    @PostMapping
    public Stickie createStickie(@RequestBody Stickie stickie) {
        return stickieService.createStickie(stickie);
    }

    @PutMapping("/{id}")
    public Stickie updateStickie(@PathVariable Long id, @RequestBody Stickie updated) {
        return stickieService.updateStickie(id, updated);
    }

    @DeleteMapping("/{id}")
    public String deleteStickie(@PathVariable Long id) {
        stickieService.deleteStickie(id);
        return "Stickie with ID " + id + " deleted successfully.";
    }
}
