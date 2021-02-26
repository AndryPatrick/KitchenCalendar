package com.calendar.DAO;

import org.springframework.data.repository.CrudRepository;

import com.calendar.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
