package com.zdotavv.enterprise_homework13.service.interfaces;

import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.model.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PersonService extends UserDetailsService {
    Person createPerson(String firstName, String lastName, String email, String username, String password);

    Person getPersonById(Long idPerson) throws NotFoundException;

    Person updatePerson(Person person) throws NotFoundException;

    void deletePerson(Long idPerson) throws NotFoundException;

    List<Person> getAllPersons();

    Person getPersonByUsername(String username);
}
