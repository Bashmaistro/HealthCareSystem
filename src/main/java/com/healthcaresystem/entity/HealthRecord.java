package com.healthcaresystem.entity;

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
    private Patient patient;

    @Column(name = "record_date", nullable = false)
    private Date recordDate;

    @Column(nullable = false)
    private String prescription;
}
