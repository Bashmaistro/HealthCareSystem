package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.repository.PatientRepository;
import com.healthcaresystem.service.PatientService;

import java.util.List;
import java.util.Optional;

public class PatientServiceImp implements PatientService {


    private PatientRepository patientRepository;

    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int pid) {

        Optional<Patient> result = patientRepository.findById(pid);
        Patient thePatient = null;

        if (result.isPresent()){
            thePatient = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + pid);

        }
        return thePatient;
    }

    @Override
    public Patient save(Patient thePatient) {
        return patientRepository.save(thePatient);
    }

    @Override
    public void deleteById(int pid) {

        patientRepository.deleteById(pid);

    }
}
