package com.example.simpleapp.controller;

import com.example.simpleapp.entity.User;
import com.example.simpleapp.repository.UserRepo;
import com.example.simpleapp.service.EmailSender;
import com.example.simpleapp.service.EmailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Email;

@Controller
public class MyController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailSenderImpl emailSender;

    @RequestMapping({"/", "/home"})
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        String name = "Dawid";
        model.addObject("name", name);
        return model;
    }

    @GetMapping("/sendEmail")
    public String sendMail() {
        emailSender.sendEmail("dejv666@wp.pl", "subject test e-mail", "very quick content");
        return "redirect:/home";
    }

//    @PostConstruct
//    public String CreateUser () {
//        User u = new User();
//        u.setUsername("admin");
//        u.setUserRole("ROLE_ADMIN");
//        u.setPassword("admin");
//        u.setEnabled(true);
//        userRepo.save(u);
//
//        return "/person/list";
//
//    }

}