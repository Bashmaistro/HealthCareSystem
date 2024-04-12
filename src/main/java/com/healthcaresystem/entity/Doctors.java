package com.healthcaresystem.entity;


import com.healthcaresystem.enumarated.Degree;
import com.healthcaresystem.enumarated.Gender;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;

    @OneToOne
    @JoinColumn(name = "uid", unique = true)
    private User user;


    @Enumerated(EnumType.STRING)
    @Column(name = "Degree",nullable = false)
    private Degree degree;


    @Column(name = "Specialty" , nullable = false)
    private String Specialty;

    @OneToMany(mappedBy = "doctor")
    private List<HealthRecord> healthRecords;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}
