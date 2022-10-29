package com.zdotavv.enterprise_homework10.facade.interfaces;

import com.zdotavv.enterprise_homework10.dto.PersonDto;
import com.zdotavv.enterprise_homework10.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework10.model.Person;

import java.util.List;

public interface PersonFacade {

        PersonDto createPerson(PersonDto personDto);

        PersonDto getPersonById(PersonDto personDto) throws NotFoundException;

        PersonDto updatePerson(PersonDto personDto) throws NotFoundException;

        void deletePerson(PersonDto personDto) throws NotFoundException;

        List<PersonDto> getAllPersons();

        PersonDto getPersonByUsername(PersonDto personDto);
}
