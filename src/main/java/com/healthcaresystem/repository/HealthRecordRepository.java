package com.healthcaresystem.repository;

import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRecordRepository  extends JpaRepository<HealthRecord, Integer> {

    List<HealthRecord> findHealthRecordsByPatient(Patient patient);
}
