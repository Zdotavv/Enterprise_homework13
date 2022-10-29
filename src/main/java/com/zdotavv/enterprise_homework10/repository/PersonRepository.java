package com.zdotavv.enterprise_homework10.repository;


import com.zdotavv.enterprise_homework10.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findPersonByUsername(String username);

}
