package com.healthcaresystem.service;

import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {

    List<Role> findAll();

    Role findById(int rid);

    Role save(Role theRole);

    void deleteById(int rid);

}
