package com.healthcaresystem.repository;

import com.healthcaresystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment , Integer> {
}
