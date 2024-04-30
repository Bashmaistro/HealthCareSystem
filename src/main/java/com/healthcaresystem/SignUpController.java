package com.healthcaresystem;

import com.healthcaresystem.entity.Patient;
import com.healthcaresystem.entity.Role;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.enumarated.Gender;
import com.healthcaresystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("genders" ,genders);


        long i = 3;
        Role Patient = new Role(i,"Patient");

        user.setRole(Patient);

        model.addAttribute("user" , user);

        return "register";



    }

    @RequestMapping("/emailCheck")
    public String emailCheck(@ModelAttribute("user") User user,
                             Model model){

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

        emailSenderService.sendMail(user.getEmail(),"Email Verification" , String.valueOf(randomNumber));

        model.addAttribute("check" , randomNumber);
        model.addAttribute("pUser" , user);

        return "email_check";

    }

    @RequestMapping("/verification")
    public String verification(@RequestParam("verificationCode") int verificationCode,
                               @ModelAttribute("user") User user,
                               @RequestParam("check") int check,
                               Model model ){



            if (verificationCode == check){
                userService.save(user);
                Patient patient = new Patient();
                user.setPatient(patient);
                patientService.save(user.getPatient());
                return "login";
            }else {
                model.addAttribute("error", "Wrong Code!!!!!!");
                verificationCode = 0;
                return "redirect:/emailCheck";
            }




    }



}
