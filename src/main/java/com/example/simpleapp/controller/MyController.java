package com.example.simpleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        String name = "Dawid";
        model.addObject("name", name);
        return model;
    }

}