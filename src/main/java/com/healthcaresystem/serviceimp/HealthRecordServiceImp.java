package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.repository.DoctorsRepository;
import com.healthcaresystem.service.DoctorsService;


import java.util.List;
import java.util.Optional;

public class HealthRecordServiceImp implements DoctorsService {

    private DoctorsRepository doctorsRepository;

    public HealthRecordServiceImp(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @Override
    public List<Doctors> findAll() {
        return doctorsRepository.findAll();
    }

    @Override
    public Doctors findById(int did) {

        Optional<Doctors> result = doctorsRepository.findById(did);
        Doctors theDoctors = null;

        if (result.isPresent()){
            theDoctors = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + did);

        }
        return theDoctors;

    }

    @Override
    public Doctors save(Doctors theDoctors) {
        return doctorsRepository.save(theDoctors);
    }

    @Override
    public void deleteById(int did) {

        doctorsRepository.deleteById(did);

    }
}
