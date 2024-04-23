package com.healthcaresystem.service;

import com.healthcaresystem.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findAll();

    Appointment findById(int aid);

    Appointment save(Appointment theAppointment);

    void deleteById(int aid);
}
