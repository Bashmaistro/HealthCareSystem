package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;

    public RestController(UserService userService, DoctorsService doctorsService, PatientService patientService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
    }

    @GetMapping("/getDoctors/{mainValue}")
    public List<User> getDoctors(@PathVariable String mainValue){

        System.out.println("work");

        List<Doctors> doctorsList = doctorsService.findBySpecialty(mainValue);
        List<User> users = new ArrayList<>();

        for (int i = 0; i < doctorsList.size(); i++) {

            users.add(doctorsList.get(i).getUser());
        }


        return users;


    }
}
