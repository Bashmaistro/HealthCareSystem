package com.healthcaresystem.service;

import com.healthcaresystem.entity.Role;
import com.healthcaresystem.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int uid);

    User save(User theUser);

    void deleteById(int uid);
}
