package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.repository.DoctorsRepository;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.HealthRecordService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class HealthRecordServiceImp implements HealthRecordService {

    @Override
    public List<HealthRecord> findAll() {
        return null;
    }

    @Override
    public HealthRecord findById(int RecordID) {
        return null;
    }

    @Override
    public HealthRecord save(HealthRecord theHealthRecord) {
        return null;
    }

    @Override
    public void deleteById(int RecordID) {

    }
}
