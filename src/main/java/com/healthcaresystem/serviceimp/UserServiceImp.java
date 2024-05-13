package com.healthcaresystem.serviceimp;

import com.healthcaresystem.entity.User;
import com.healthcaresystem.repository.UserRepository;
import com.healthcaresystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImp implements UserService {



    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User save(User theUser) {

        String temp = theUser.getPassword();

        theUser.setPassword(passwordEncoder.encode(temp));

        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(int uid) {

        userRepository.deleteById(uid);
    }
}
