package com.healthcaresystem.repository;

import com.healthcaresystem.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository  extends JpaRepository<HealthRecord, Integer> {
}
