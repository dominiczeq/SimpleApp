package com.example.simpleapp.controller;

import com.example.simpleapp.entity.User;
import com.example.simpleapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class MyController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping({"/", "/home"})
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        String name = "Dawid";
        model.addObject("name", name);
        return model;
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