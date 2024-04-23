package com.healthcaresystem;

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
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/login")
    public String login(Model theModel){

        User user = new User();

        theModel.addAttribute("user" , user);

        return "Login";

    }

    @PostMapping("/processUser")
    public String processUser(@ModelAttribute("user")
                              User theUser,
                              Model model){

        User existingUser = userService.findByEmail(theUser.getEmail());


        System.out.println(existingUser.getName());

        if (existingUser != null){

            Doctors existingDoctor = existingUser.getDoctors() ;
            Patient existingPatient = existingUser.getPatient();

            if (existingDoctor != null){
                return "doctors";
            }if (existingPatient != null){
                return "patient";
            }else{

                model.addAttribute("error", "User can't Found");
                return "Login";

            }

        }
        else {

            model.addAttribute("error", "Invalid email or password.");
            return "Login";
        }



    }


}
