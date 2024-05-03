package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.Role;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.enumarated.Degree;
import com.healthcaresystem.enumarated.Gender;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.RoleService;
import com.healthcaresystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class AdminController {

    private DoctorsService doctorsService;
    private RoleService roleService;
    private UserService userService;

    public AdminController(DoctorsService doctorsService, RoleService roleService, UserService userService) {
        this.doctorsService = doctorsService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){


        User user = new User();
        Doctors doctors = new Doctors();
        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.Male);
        genders.add(Gender.Female);
        genders.add(Gender.Other);

        List<Degree> degree = new ArrayList<>();
        degree.add(Degree.Ast_Dr);
        degree.add(Degree.Dr);
        degree.add(Degree.Fzt);
        degree.add(Degree.Exp_Dr);
        degree.add(Degree.Op_Dr);

        model.addAttribute("degrees" , degree);


        model.addAttribute("gender", genders);
        model.addAttribute("doctor" , doctors);

        model.addAttribute("user" , user);

        return "doc-form";
    }

    @GetMapping("/list")
    public String list(Model theModel){

        //get the employees from db
        List<Doctors> doctorsList = doctorsService.findAll();

        for (int i = 0; i < doctorsList.size(); i++) {
            System.out.println(doctorsList.get(i).getUser().getName());
        }

        //add to the spring model
        theModel.addAttribute("doctorList" , doctorsList);

        return "adminPage";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") User user,
                               @ModelAttribute("doctor") Doctors doctors){

        Role role = roleService.findById(2);
        user.setRole(role);


        Random random = new Random();

        // 6 haneli rastgele sayı üret
        int min = 100000; // En küçük 6 haneli sayı
        int max = 999999; // En büyük 6 haneli sayı
        int randomNumber = random.nextInt(max - min + 1) + min;

        user.setPassword(String.valueOf(randomNumber));


        userService.save(user);
        user.setDoctors(doctors);
        doctorsService.save(doctors);


        return "redirect:/list";

    }
}
