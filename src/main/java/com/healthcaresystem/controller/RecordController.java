package com.healthcaresystem.controller;

import com.healthcaresystem.entity.Appointment;
import com.healthcaresystem.entity.Doctors;
import com.healthcaresystem.entity.HealthRecord;
import com.healthcaresystem.entity.User;
import com.healthcaresystem.enumarated.Gender;
import com.healthcaresystem.enumarated.Status;
import com.healthcaresystem.service.AppointmentService;
import com.healthcaresystem.service.DoctorsService;
import com.healthcaresystem.service.HealthRecordService;
import com.healthcaresystem.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {

    private DoctorsService doctorsService;
    private UserService userService;
    private HealthRecordService healthRecordService;
    private AppointmentService appointmentService;

    public RecordController(DoctorsService doctorsService, UserService userService, HealthRecordService healthRecordService, AppointmentService appointmentService) {
        this.doctorsService = doctorsService;
        this.userService = userService;
        this.healthRecordService = healthRecordService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    public String  getRecordList(Principal principal , Model model){

        User user = userService.findByEmail(principal.getName());

        Doctors doctors =  user.getDoctors();

        List<HealthRecord> healthRecords = doctors.getHealthRecords();

        List<Status> status = new ArrayList<>();
        status.add(Status.cancelled);
        status.add(Status.scheduled);
        status.add(Status.completed);

        List<Appointment> appointments = doctors.getAppointments();


        model.addAttribute("status", status);
        model.addAttribute("appo", appointments);


        model.addAttribute("records" , healthRecords);


        return "record";


    }
    @GetMapping("/add")
    public String  addRecord(Principal principal , Model model){

        HealthRecord healthRecords = new HealthRecord();


        model.addAttribute("hr" , healthRecords);




        return "record-form";


    }

    @GetMapping("/delete")
    public String delete(@RequestParam("recordId") int theId){

        HealthRecord healthRecord = healthRecordService.findById(theId);

        healthRecordService.deleteById(theId);

        return "redirect:/record/";
    }

    @GetMapping("/complete")
    public String complete(@RequestParam("appId") int theId){

        Appointment appointment = appointmentService.findById(theId);

        appointmentService.deleteById(theId);

        appointment.setStatus(Status.completed);

        appointmentService.save(appointment);



        return "redirect:/record/";
    }
    @GetMapping("/cancel")
    public String cancel(@RequestParam("appId") int theId){

        Appointment appointment = appointmentService.findById(theId);

        appointmentService.deleteById(theId);

        appointment.setStatus(Status.cancelled);

        appointmentService.save(appointment);



        return "redirect:/record/";
    }



    @PostMapping("/save")
    public String saveRec(Principal principal,Model model, @ModelAttribute("hr") HealthRecord HR, @RequestParam("userID") int id){

        User user = userService.findById(id);

        User userdoc = userService.findByEmail(principal.getName());

        if (user == null){


            model.addAttribute("error" , "Patient Id Not Found");


            HealthRecord healthRecords = new HealthRecord();


            model.addAttribute("hr" , healthRecords);


            return "record-form";
        }
        Calendar calendar = Calendar.getInstance();
        Date today = new Date(calendar.getTime().getTime());

        HR.setDoctor(userdoc.getDoctors());
        HR.setPatient(user.getPatient());
        HR.setRecordDate(today);

        healthRecordService.save(HR);

        return "redirect:/record/";

    }

}
