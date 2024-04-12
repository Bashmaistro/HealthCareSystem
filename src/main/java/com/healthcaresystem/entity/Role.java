package com.healthcaresystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private Long rid;

    @Column(name = "name" , nullable = false)
    private String name;
}
