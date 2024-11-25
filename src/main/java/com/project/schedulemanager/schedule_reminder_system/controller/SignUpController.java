package com.project.schedulemanager.schedule_reminder_system.controller;

import com.project.schedulemanager.schedule_reminder_system.dto.SignUpDto;
import com.project.schedulemanager.schedule_reminder_system.entity.Demographics;
import com.project.schedulemanager.schedule_reminder_system.entity.User;
import com.project.schedulemanager.schedule_reminder_system.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @GetMapping("/signup")

    public String signUp(Model model){
        SignUpDto signupDto = new SignUpDto();
        model.addAttribute("signupDto", signupDto);
       return "signup-page";
    }

    @PostMapping("/signup")

    public String submitSignUp(@ModelAttribute("signupDto") SignUpDto signUpDto, Model model){

       System.out.println(signUpDto);

       signUpService.registerUser(signUpDto,  model);
        return "signup-successfull";
    }

}
