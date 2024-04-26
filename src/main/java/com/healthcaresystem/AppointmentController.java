package com.healthcaresystem;


import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/appointment")

public class AppointmentController {

    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;

    public AppointmentController(UserService userService, DoctorsService doctorsService, PatientService patientService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
    }


    @GetMapping("/{Uid}")
    public String takeAppointment(@PathVariable int Uid, Model theModel){

        List<Doctors> doctorsList = doctorsService.findAll();

        theModel.addAttribute("doctors" , doctorsList);

        User user = userService.findById(Uid);

        theModel.addAttribute("user" , user);

        Appointment appointment = new Appointment();

        theModel.addAttribute("appointment" , appointment);

        Set<String> specialties = new HashSet<>();

        for (Doctors doctor : doctorsList) {
            specialties.add(doctor.getSpecialty());
        }

        theModel.addAttribute("specialties" , specialties);

        return "appointment";





    }



    @GetMapping("/getDoctors")
    public List<Doctors> getDoctors(){

        return doctorsService.findBySpecialty("Cardiology");


    }
}


