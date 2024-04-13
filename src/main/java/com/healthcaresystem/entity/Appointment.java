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

    public Appointment() {
    }

    public Appointment(Long aid, Doctors doctor, Patient patient, Date appointmentDate, Integer status) {
        this.aid = aid;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
