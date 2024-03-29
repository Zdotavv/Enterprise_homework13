package com.zdotavv.enterprise_homework13.facade.interfaces;

import com.zdotavv.enterprise_homework13.dto.PersonDto;
import com.zdotavv.enterprise_homework13.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework13.model.Person;

import java.util.List;

public interface PersonFacade {

        PersonDto createPerson(PersonDto personDto);

        PersonDto getPersonById(PersonDto personDto) throws NotFoundException;

        PersonDto updatePerson(PersonDto personDto) throws NotFoundException;

        void deletePerson(PersonDto personDto) throws NotFoundException;

        List<PersonDto> getAllPersons();

        PersonDto getPersonByUsername(PersonDto personDto)throws NotFoundException;

}
