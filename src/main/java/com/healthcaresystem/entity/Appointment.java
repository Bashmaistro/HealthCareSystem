package com.healthcaresystem.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Appointments")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Long aid;

    @ManyToOne
    @JoinColumn(name = "did", nullable = false)
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private Patient patient;

    @Column(name = "AppointmentDate", nullable = false)
    private Date appointmentDate;

    @Column(name = "Status",nullable = false)
    private Integer status;
}
