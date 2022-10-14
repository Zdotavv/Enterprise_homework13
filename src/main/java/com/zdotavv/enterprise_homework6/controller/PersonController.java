package com.zdotavv.enterprise_homework6.controller;

import com.zdotavv.enterprise_homework6.dto.PersonDto;
import com.zdotavv.enterprise_homework6.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework6.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
    @RequestMapping(path="/person")

    public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String personIndex(Model model) {
        String message = "Person control page";
        model.addAttribute("message", message);
        return "personIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "createPerson";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") PersonDto personDto) {
        personService.createPerson(personDto);
        return "createPersonSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPersonByIdView(Model model) {
        model.addAttribute("personById", new PersonDto());
        return "getPerson";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Transactional
    public String getPersonById(@ModelAttribute("personById") PersonDto personDto, Model model) throws NotFoundException {
        PersonDto personById = personService.getPersonById(personDto.getIdPerson());
        model.addAttribute("personById", personById);
        return "getPersonSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "updatePerson";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personService.updatePerson(personDto);
        return "updatePersonSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePersonByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "deletePerson";
    }


    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deletePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personService.deletePerson(personDto.getIdPerson());
        return "deletePersonSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllPersons(Model model) {
        model.addAttribute("all", personService.getAllPersons());
        return "allPersons";
    }
}


