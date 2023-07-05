package com.dshritama.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dshritama.springapp.model.Pharmacy;
import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
  List<Pharmacy> findByPatientId(Long patientId);
}
