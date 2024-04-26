package com.healthcaresystem.repository;

import com.healthcaresystem.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {

     @Query("select d from Doctors d where d.Specialty =?1")
     List<Doctors> findBySpecialty(String Specialty);


}
