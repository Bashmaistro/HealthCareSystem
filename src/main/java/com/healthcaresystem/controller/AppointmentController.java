package com.healthcaresystem.controller;


import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.enumarated.Status;
import com.healthcaresystem.service.*;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/appointment")

public class AppointmentController {

    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;
    private AppointmentService appointmentService;
    private RestTemplate restTemplate;
    private HealthRecordService healthRecordService;


    public AppointmentController(UserService userService, DoctorsService doctorsService, PatientService patientService, AppointmentService appointmentService, RestTemplate restTemplate, HealthRecordService healthRecordService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
        this.appointmentService = appointmentService;

        this.restTemplate = restTemplate;
        this.healthRecordService = healthRecordService;
    }


    @GetMapping("/create")
    public String takeAppointment(Principal principal, Model theModel,
                                  jakarta.servlet.http.HttpSession  session
                                  ){


        List<Doctors> doctorsList = doctorsService.findAll();



        User user = userService.findByEmail(principal.getName());



        theModel.addAttribute("user" , user);

        Appointment appointment = new Appointment();

        session.setAttribute("patient", user.getPatient());

        theModel.addAttribute("appointment" , appointment);

        Set<String> specialties = new HashSet<>();

        for (Doctors doctor : doctorsList) {
            specialties.add(doctor.getSpecialty());
        }

        theModel.addAttribute("specialties" , specialties);

        return "appointment";





    }

    @RequestMapping ("/submit")
    public String submit(@ModelAttribute("appointment") Appointment appointment,
                         Model model,
                         @RequestParam("doctorId") int id,
                         jakarta.servlet.http.HttpSession  session){

        Doctors doctors = userService.findById(id).getDoctors();

        Patient patient = (Patient) session.getAttribute("patient");



        appointment.setPatient(patient);

        appointment.setDoctor(doctors);
        appointment.setStatus(Status.scheduled);

        appointmentService.save(appointment);

        System.out.println(patient.getHealthRecords());



        model.addAttribute("patient" , patient.getUser());
        model.addAttribute("patientHealth", patient.getHealthRecords());
        model.addAttribute("success", "\"Your appointment has been made successfully.\"");
        return "patient";


    }

    @GetMapping("/healthrecord")
    public String getHealthrecord(Principal principal, Model model){

        User user = userService.findByEmail(principal.getName());

        model.addAttribute("user" , user);
        model.addAttribute("health", user.getPatient().getHealthRecords());




        return "HealthRecords";
    }








}


