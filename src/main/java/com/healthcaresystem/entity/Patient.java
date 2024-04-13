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


    public Patient(Long pid, Gender gender, String contactNumber, User user, List<HealthRecord> healthRecords, Doctors doctor) {
        this.pid = pid;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.user = user;
        this.healthRecords = healthRecords;
        this.doctor = doctor;
    }


    public Patient() {
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }
}
