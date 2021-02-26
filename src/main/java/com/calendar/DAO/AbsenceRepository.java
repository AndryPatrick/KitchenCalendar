package com.calendar.DAO;

import org.springframework.data.repository.CrudRepository;

import com.calendar.model.Absence;

public interface AbsenceRepository extends CrudRepository<Absence, Long> {

}
