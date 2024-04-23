package com.healthcaresystem.service;

import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {



    List<Patient> findAll();

    Patient findById(int pid);

    Patient save(Patient thePatient);

    void deleteById(int pid);
}
