package com.healthcaresystem.service;

import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HealthRecordService {

    List<HealthRecord> findAll();

    HealthRecord findById(int RecordID);

    HealthRecord save(HealthRecord theHealthRecord);

    void deleteById(int RecordID);

    List<HealthRecord> findHealthRecordsByPatient(Patient patient);



}
