package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.repository.AppointmentRepository;
import com.healthcaresystem.service.AppointmentService;
import org.springframework.aop.target.AbstractPoolingTargetSource;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImp implements AppointmentService {

   private AppointmentRepository appointmentRepository;

    public AppointmentServiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {

        return appointmentRepository.findAll();

    }

    @Override
    public Appointment findById(int aid) {

        Optional<Appointment> result = appointmentRepository.findById(aid);
        Appointment theAppointment = null;

        if (result.isPresent()){
            theAppointment = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + aid);

        }
        return theAppointment;

    }

    @Override
    public Appointment save(Appointment theAppointment) {
        return appointmentRepository.save(theAppointment);
    }

    @Override
    public void deleteById(int aid) {

        appointmentRepository.deleteById(aid);

    }
}
