package com.healthcaresystem.service;

import com.healthcaresystem.entity.Role;
import com.healthcaresystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    List<User> findAll();

    User findById(int uid);


    User findByEmail(String email);

    User save(User theUser);

    void deleteById(int uid);
}
