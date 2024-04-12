package com.healthcaresystem.entity;


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

    @Column(name = "dateOfBirth" ,nullable = false)
    private Date dateOfBirth;

    @Column(name = "contactNumber" ,nullable = false)
    private String contactNumber;

    @Column(name = "address" ,nullable = false)
    private String address;

    @OneToOne(mappedBy = "user")
    private Patient patient;

    @OneToOne(mappedBy = "user")
    private Doctors doctors;
}
