package com.healthcaresystem.entity;

import com.healthcaresystem.enumarated.Gender;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Long pid;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",nullable = false)
    private Gender gender;

    @Column(name = "ContactNumber" , nullable = false)
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<HealthRecord> healthRecords;

    @ManyToOne // Many patients can be associated with one doctor
    @JoinColumn(name = "did") // Column name in the Patients table that references the doctor
    private Doctors doctor; // Add this property to represent the doctor associated with the patient

}
