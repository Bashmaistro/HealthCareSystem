package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import java.util.List;

@Controller
public class TestController {

    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;

    public TestController(UserService userService, DoctorsService doctorsService, PatientService patientService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
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

    @RequestMapping("/processUser")
    public String processUser(@ModelAttribute("user") User theUser,
                              @RequestParam("username") String email,
                              @RequestParam("password") String password,
                              Model model){

        System.out.println(theUser.getEmail());

        theUser.setPassword(password);
        theUser.setEmail(email);

        System.out.println(theUser.getEmail());

        User existingUser = userService.findByEmail(theUser.getEmail());

        System.out.println(theUser.getPassword());

        if (existingUser == null){

            model.addAttribute("error", "Invalid email or password.");
            return "Login";
        }



        //check password
        if (existingUser.getPassword().equals(theUser.getPassword())){

            if(theUser.getEmail().equals("admin@medify.com") && theUser.getPassword().equals("admin123")){

                List<Doctors> doctorsList = doctorsService.findAll();

                model.addAttribute("doctorList" , doctorsList);

                return "redirect:/list";
            }
            Doctors existingDoctor = existingUser.getDoctors() ;
            Patient existingPatient = existingUser.getPatient();

            if (existingDoctor != null){
                return "doctors";
            }if (existingPatient != null){

                model.addAttribute("patient", existingUser );
                model.addAttribute("patientHealth" , existingUser.getPatient().getHealthRecords());

                return "patient";
            }





        }else{

            model.addAttribute("error", "Invalid email or password.");
            return "Login";

        }

        model.addAttribute("error", "Invalid email or password.");
        return "Login";

     }}
