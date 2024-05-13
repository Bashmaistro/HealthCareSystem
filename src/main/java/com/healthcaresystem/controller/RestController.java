package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.PatientService;
import com.healthcaresystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/events")
    public String getEventsForDay(
            @RequestParam int day,
            @RequestParam int month,
            @RequestParam int year, Principal principal) {


        year = year  - 1900;
        month =  month -1;


        Date date = new Date(year,month,day);

        System.out.println(date.toString());

        String date1 = STR."\{year}-\{month}-\{day}";

        System.out.println(date1);


        User user = userService.findByEmail(principal.getName());

        Doctors doctors = user.getDoctors();

        String eventDescription = "You don't have any appointment";
        
        List<Appointment> appointments = doctors.getAppointments();

        for (int i = 0; i < appointments.size(); i++) {


            System.out.println(appointments.get(i).getAppointmentDate().toString());



            if (appointments.get(i).getAppointmentDate().equals(date)) {

                 eventDescription = "You have appointment with" + " " + appointments.get(i).getPatient().getUser().getName() + " " + appointments.get(i).getPatient().getUser().getSurname() ;
                 break;

            }else {
                 eventDescription = "You don't have any appointment";
            }

        }


        
        return eventDescription;
    }
}
