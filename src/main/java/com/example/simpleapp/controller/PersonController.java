package com.example.simpleapp.controller;

import com.example.simpleapp.entity.Person;
import com.example.simpleapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/add")
    public ModelAndView addPerson() {
        ModelAndView modelAndView = new ModelAndView("addPerson");
        Person p = new Person();
        p.setFirstName("wpisz imie");
        p.setLastName("wpisz nazwisko");
        modelAndView.addObject("person", p);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savePerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addPerson";
        } else

            personRepository.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        List<Person> persons = personRepository.findAll();
        ModelAndView model = new ModelAndView("personList");
        model.addObject("persons", persons);
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable long id) {
        ModelAndView model = new ModelAndView("editPerson");
        Person person = personRepository.findFirstById(id);
        model.addObject("person", person);

        return model;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute Person personka) {
        // ModelAndView model = new ModelAndView("personList");
        this.personRepository.setPersonDataById(personka.getFirstName(), personka.getLastName(), personka.getEmail(), id);
        //model.addObject("person", personka);

        return "redirect:/person/list";
    }


    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable long id, @ModelAttribute Person person) {
        this.personRepository.deleteById(id);
        return "redirect:/person/list";
    }
}

