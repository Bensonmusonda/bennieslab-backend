package com.bennieslab.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bennieslab.portfolio.model.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {}
