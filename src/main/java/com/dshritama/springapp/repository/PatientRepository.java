package com.dshritama.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dshritama.springapp.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
