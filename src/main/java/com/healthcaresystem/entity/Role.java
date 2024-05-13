package com.healthcaresystem.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Role")
public class Role implements GrantedAuthority {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private Long rid;

    @Column(name = "name" , nullable = false)
    private String name;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(Long rid, String name) {
        this.rid = rid;
        this.name = name;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
