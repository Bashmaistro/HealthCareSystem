package com.healthcaresystem.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.healthcaresystem.enumarated.Gender;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private Role role;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "surname" ,nullable = false)
    private String surname;

    @Column(name = "password" ,nullable = false)
    private String password;

    @Column(name = "email" ,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",nullable = false)
    private Gender gender;

    @Column(name = "dateOfBirth" ,nullable = false)
    private Date dateOfBirth;

    @Column(name = "contactNumber" ,nullable = false)
    private long contactNumber;

    @Column(name = "address" ,nullable = false)
    private String address;

    @OneToOne(mappedBy = "user")
    private Patient patient;

    @OneToOne(mappedBy = "user" ,fetch = FetchType.EAGER)
    @JsonManagedReference
    private Doctors doctors;


    @Transient
    private int emailCode = 0;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long
                                         contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }



    public User(Long uid, Role role, String name, String surname, String password, String email, Gender gender, Date dateOfBirth, Long contactNumber, String address, Patient patient, Doctors doctors) {
        this.uid = uid;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.address = address;
        this.patient = patient;
        this.doctors = doctors;
    }

    public User() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(int emailCode) {
        this.emailCode = emailCode;
    }

      @Override
      public String toString() {
          return "User{" +
                  "email='" + email + '\'' +
                  // Diğer özellikler buraya eklenebilir
                  '}';
      }

















}
