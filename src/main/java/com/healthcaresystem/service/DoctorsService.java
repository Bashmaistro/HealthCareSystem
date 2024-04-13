package com.healthcaresystem.service;

import com.healthcaresystem.entity.Doctors;

import java.util.List;

public interface DoctorsService {



    List<Doctors> findAll();

    Doctors findById(int did);

    Doctors save(Doctors theDoctors);

    void deleteById(int did);
}