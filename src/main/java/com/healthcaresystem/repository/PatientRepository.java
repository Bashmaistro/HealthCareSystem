package com.healthcaresystem.repository;

import com.healthcaresystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient , Integer> {
}
