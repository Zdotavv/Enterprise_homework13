package com.zdotavv.enterprise_homework10.controller;

import com.zdotavv.enterprise_homework10.dto.PersonDto;
import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.facade.interfaces.PersonFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path="/person")
@Slf4j
    public class PersonController {

    private final PersonFacade personFacade;

    public PersonController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String personIndex(Model model) {
        String message = "Person control page";
        model.addAttribute("message", message);
        return "/person/personIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/createPerson";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") PersonDto personDto) {
        personFacade.createPerson(personDto);
        log.info("New person is created with username [{}] and email [{}]", personDto.getUsername(), personDto.getEmail());
        return "/person/createPersonSuccess";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPersonByIdView(Model model) {
        model.addAttribute("personById", new PersonDto());
        return "/person/getPerson";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Transactional
    public String getPersonById(@ModelAttribute("personById") PersonDto personDto, Model model) throws NotFoundException {
        PersonDto personById = personFacade.getPersonById(personDto);
        model.addAttribute("personById", personById);
        log.info("Person with ID [{}] is gotten", personDto.getIdPerson());
        return "/person/getPersonSuccess";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatePersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/updatePerson";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personFacade.updatePerson(personDto);
        log.info("Person with ID [{}] is updated", personDto.getIdPerson());
        return "/person/updatePersonSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deletePersonByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "/person/deletePerson";
    }


    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deletePerson(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        personFacade.deletePerson(personDto);
        log.info("Person with ID [{}] is deleted", personDto.getIdPerson());
        return "/person/deletePersonSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllPersons(Model model) {
        model.addAttribute("all", personFacade.getAllPersons());
        return "/person/allPersons";
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
    public String getPersonByUsername(Model model) {
        model.addAttribute("personByUsername", new PersonDto());
        return "/person/getPersonByUsername";
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.POST)
    @Transactional
    public String getPersonByUsername(@ModelAttribute("personByUsername") PersonDto personDto, Model model) throws NotFoundException {
        PersonDto personByUsername = personFacade.getPersonByUsername(personDto);
        model.addAttribute("personByUsername", personByUsername);
        log.info("Person with Username [{}] is gotten", personDto.getUsername());
        return "/person/getPersonByUsernameSuccess";
    }
}



