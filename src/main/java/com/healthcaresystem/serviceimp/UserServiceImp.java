package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.User;
import com.healthcaresystem.repository.UserRepository;
import com.healthcaresystem.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int uid) {
        Optional<User> result = userRepository.findById(uid);
        User theUser = null;

        if (result.isPresent()){
            theUser = result.get();

        }else {
            throw new RuntimeException("Did not find employee id - " + uid);

        }
        return theUser;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(int uid) {

        userRepository.deleteById(uid);
    }
}
