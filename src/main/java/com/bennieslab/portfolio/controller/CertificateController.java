package com.bennieslab.portfolio.controller;

import com.bennieslab.portfolio.model.Certificate;
import com.bennieslab.portfolio.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5500")@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Optional<Certificate> getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateService.createCertificate(certificate);
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id, @RequestBody Certificate certificateDetails) {
        return certificateService.updateCertificate(id, certificateDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return "Certificate with ID " + id + " deleted successfully.";
    }
}
