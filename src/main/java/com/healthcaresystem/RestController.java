package com.healthcaresystem;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.Doc;
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
    public List<String> getDoctors(@PathVariable String mainValue){

        List<Doctors> doctorsList = doctorsService.findAll();
        List<String> users = new ArrayList<>();

        for (Doctors doctor:doctorsList) {

            if (doctor.getSpecialty().equals(mainValue)){
                users.add(doctor.getUser().getName());
            }

        }

        return users;


    }
}
