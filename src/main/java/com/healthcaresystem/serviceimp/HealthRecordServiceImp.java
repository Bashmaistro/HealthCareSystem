package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.repository.DoctorsRepository;
import com.healthcaresystem.repository.HealthRecordRepository;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.HealthRecordService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class HealthRecordServiceImp implements HealthRecordService {


    private HealthRecordRepository healthRecordRepository;

    public HealthRecordServiceImp(HealthRecordRepository healthRecordRepository) {
        this.healthRecordRepository = healthRecordRepository;
    }

    @Override
    public List<HealthRecord> findAll() {
        return healthRecordRepository.findAll();
    }

    @Override
    public HealthRecord findById(int RecordID)

    {
        Optional<HealthRecord> result = healthRecordRepository.findById(RecordID);
        HealthRecord theHealthRecord = null;

        if (result.isPresent()){
            theHealthRecord = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + RecordID);

        }

        return theHealthRecord;
    }

    @Override
    public HealthRecord save(HealthRecord theHealthRecord) {
        return healthRecordRepository.save(theHealthRecord);
    }

    @Override
    public void deleteById(int RecordID) {
        healthRecordRepository.deleteById(RecordID);

    }

    @Override
    public List<HealthRecord> findHealthRecordsByPatient(Patient patient) {

        return findHealthRecordsByPatient(patient);
    }
}
