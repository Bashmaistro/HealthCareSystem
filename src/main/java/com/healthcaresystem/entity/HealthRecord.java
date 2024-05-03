package com.healthcaresystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "HealthRecords")
public class HealthRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecordID")
    private Long recordID;

    @ManyToOne
    @JoinColumn(name = "did", nullable = false)
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    @JsonManagedReference
    private Patient patient;

    @Column(name = "RecordDate", nullable = false)
    private Date recordDate;

    @Column(name="Prescription", nullable = false)
    private String prescription;


    public HealthRecord(Long recordID, Doctors doctor, Patient patient, Date recordDate, String prescription) {
        this.recordID = recordID;
        this.doctor = doctor;
        this.patient = patient;
        this.recordDate = recordDate;
        this.prescription = prescription;
    }

    public HealthRecord() {
    }

    public Long getRecordID() {
        return recordID;
    }

    public void setRecordID(Long recordID) {
        this.recordID = recordID;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
