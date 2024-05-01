package com.healthcaresystem;

import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.Role;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.enumarated.Gender;
import com.healthcaresystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SignUpController {

    private UserService userService;
    private DoctorsService doctorsService;
    private PatientService patientService;

    private RoleService roleService;



    private EmailSenderService emailSenderService;

    // Mail server settings



    public SignUpController(UserService userService, DoctorsService doctorsService, PatientService patientService, RoleService roleService, EmailSenderService emailSenderService) {
        this.userService = userService;
        this.doctorsService = doctorsService;
        this.patientService = patientService;
        this.roleService = roleService;
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/signUp")
    public String signUp(Model model){

        User user = new User();
        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.Male);
        genders.add(Gender.Female);
        genders.add(Gender.Other);

        System.out.println(user.getUid());



        model.addAttribute("genders" ,genders);

        model.addAttribute("user" , user);



        return "register";



    }

    @RequestMapping ("/emailCheck")
    public String emailCheck(@ModelAttribute("user") User user,
                             Model model,
                             jakarta.servlet.http.HttpSession  session){





        User tempUser = userService.findByEmail(user.getEmail());


        if (tempUser != null){
            model.addAttribute("error", "This Mail is being used");
            return "register";
        }
        Random random = new Random();

        // 6 haneli rastgele sayı üret
        int min = 100000; // En küçük 6 haneli sayı
        int max = 999999; // En büyük 6 haneli sayı
        int randomNumber = random.nextInt(max - min + 1) + min;

        user.setEmailCode(randomNumber);


        session.setAttribute("pUser" , user);

        if (user.getEmail() != null) {
            emailSenderService.sendMail(user.getEmail(), "Email Verification", String.valueOf(randomNumber));
            System.out.println("Email-Sended");
            return "email_check";
        } else {
            model.addAttribute("error", "Failed to send email: Email address is null");
            return "register";
        }





    }

    @RequestMapping("/verification")
    public String verification(@RequestParam("verificationCode") int verificationCode,
                               jakarta.servlet.http.HttpSession  session,
                               Model model ){


        User pUser = (User) session.getAttribute("pUser");

            if (verificationCode == pUser.getEmailCode()){


                Patient patient = new Patient();

                //Add patient  Role
                Role role = roleService.findById(3);
                pUser.setRole(role);

                userService.save(pUser);

                patient.setUser(userService.findById(Math.toIntExact(pUser.getUid())));

                patientService.save(patient);

                return "Login";
            }else {
                model.addAttribute("error", "Wrong Code!!!!!!");

                return "register";
            }




    }



}
