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




    public Doctors() {
    }

    public Doctors(Long did, User user, Degree degree, String specialty, List<HealthRecord> healthRecords, List<Appointment> appointments) {
        this.did = did;
        this.user = user;
        this.degree = degree;
        Specialty = specialty;
        this.healthRecords = healthRecords;
        this.appointments = appointments;

    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


}
