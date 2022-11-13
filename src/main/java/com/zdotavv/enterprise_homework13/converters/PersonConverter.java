package com.zdotavv.enterprise_homework13.converters;

import com.zdotavv.enterprise_homework13.dto.PersonDto;
import com.zdotavv.enterprise_homework13.model.Person;

public class PersonConverter {

    public static PersonDto convertPersonToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setIdPerson(person.getIdPerson());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setEmail(person.getEmail());
        personDto.setCarts(person.getCarts());
        personDto.setUsername(person.getUsername());
        personDto.setPassword(person.getPassword());
        return personDto;
    }

    public static Person convertPersonDtoToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setIdPerson(personDto.getIdPerson());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setCarts(personDto.getCarts());
        person.setUsername(personDto.getUsername());
        person.setPassword(personDto.getPassword());
        return person;
    }
}
