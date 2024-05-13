package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {



    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TestController(UserService userService, DoctorsService doctorsService, PatientService patientService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
    }

    @GetMapping("/secProcessUser")
    public String secProcessUser(Principal principal, Model model){


        //System.out.println(principal.getName());

        User user = userService.findByEmail(principal.getName());

        if (user.getRole().getName().equals("PATIENT")){
            model.addAttribute("patient", user);
            model.addAttribute("patientHealth", user.getPatient().getHealthRecords());
            return "patient";

        }if (user.getRole().getName().equals("ADMIN")){

            System.out.println("girdi");
            return "redirect:/admin/list";
        }else {

                model.addAttribute("doctor" , user);
                return "doctor";


        }

    }

    @PostMapping("/processUser")
    public String processUser(@ModelAttribute("user") User theUser,
                              @RequestParam("username") String email,
                              @RequestParam("password") String password,
                              Model model) {

        System.out.println(theUser.getEmail());

        theUser.setPassword(password);
        theUser.setEmail(email);

        System.out.println(theUser.getEmail());

        User existingUser = userService.findByEmail(theUser.getEmail());


        if (existingUser == null) {

            model.addAttribute("error", "Invalid email or password.");
            return "Login";
        }


        if (theUser.getEmail().equals("admin@medify.com")) {

            List<Doctors> doctorsList = doctorsService.findAll();

            model.addAttribute("doctorList", doctorsList);

            return "redirect:/admin/list";
        }
        Doctors existingDoctor = existingUser.getDoctors();
        Patient existingPatient = existingUser.getPatient();

        if (existingDoctor != null) {
            model.addAttribute("doctor" , existingUser);
            return "doctor";
        }
        if (existingPatient != null) {

            model.addAttribute("patient", existingUser);
            model.addAttribute("patientHealth", existingUser.getPatient().getHealthRecords());

            return "patient";
        }

        return "login";

    }

    @GetMapping("/")
    String getMedify(Model model){
        model.addAttribute("title","Medify");
        return "index";
    }

    @GetMapping("/patient")
    String getPatient(Model model){

        return "patient";
    }

    @GetMapping("/login")
    public String login(Model theModel){

        User user = new User();



        theModel.addAttribute("user" , user);

        return "Login";

    }

    @GetMapping("/logindeneme")
    String denemeLogin(){

        return "logindeneme";
    }

    }
