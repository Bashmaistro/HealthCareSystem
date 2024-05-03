package com.healthcaresystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @OneToOne
    @JoinColumn(name = "uid")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "patient" , fetch = FetchType.EAGER )
    private List<HealthRecord> healthRecords;



    public Patient(Long pid, User user, List<HealthRecord> healthRecords) {
        this.pid = pid;this.user = user;
        this.healthRecords = healthRecords;

    }


    public Patient() {
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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


}
