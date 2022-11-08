package com.zdotavv.enterprise_homework10.service.implementation;

import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.model.Person;
import com.zdotavv.enterprise_homework10.model.Role;
import com.zdotavv.enterprise_homework10.repository.PersonRepository;
import com.zdotavv.enterprise_homework10.service.interfaces.EmailService;
import com.zdotavv.enterprise_homework10.service.interfaces.PersonService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final EmailService emailService;

    public PersonServiceImpl(PersonRepository personRepository, BCryptPasswordEncoder bCryptPasswordEncoder, EmailService emailService) {
        this.personRepository = personRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.emailService = emailService;
    }


    @Override
    public Person createPerson(String firstName, String lastName, String email, String username, String password) {
        Person newPerson = new Person();
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setEmail(email);
        newPerson.setUsername(username);
        newPerson.setPassword(bCryptPasswordEncoder.encode(password));
        emailService.sendRegistrationEmail(newPerson);
        if (newPerson.getUsername().contains("admin")) {
            newPerson.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        } else {
            newPerson.setRoles(Collections.singleton(new Role(1L, "ROLE_CUSTOMER")));
        }
        return personRepository.save(newPerson);
    }

    @Override
    public Person getPersonById(Long idPerson) throws NotFoundException {
        if (personRepository.findById(idPerson).isPresent()) {
            return personRepository.findById(idPerson).orElseThrow(() -> new NotFoundException(idPerson.toString()));
        } else {
            throw new NotFoundException("Person with ID #" + idPerson + " is not found");
        }
    }

    @Override
    public void deletePerson(Long idPerson)throws NotFoundException {
        if (personRepository.existsById(idPerson)) {
            personRepository.deleteById(idPerson);
        }
    else {
        throw new NotFoundException("Person with ID #" + idPerson + " is not found");
    }

    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.findById(person.getIdPerson())
                .map(entity -> {
                    entity.setUsername(person.getUsername());
                    entity.setFirstName(person.getFirstName());
                    entity.setLastName(person.getLastName());
                    entity.setEmail(person.getEmail());
                    personRepository.save(entity);
                    return entity;
                })
                .orElseThrow(() -> new EntityNotFoundException("Not Found id = " + person.getIdPerson()));
    }

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPersonByUsername(String username) {
        if (personRepository.findPersonByUsername(username) != null) {
            return personRepository.findPersonByUsername(username);
        } else {
            try {
                throw new NotFoundException("Person with username " + username + " is not found");
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = getPersonByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }
        return person;
    }

}
