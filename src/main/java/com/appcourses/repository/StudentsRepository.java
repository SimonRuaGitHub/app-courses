package com.appcourses.repository;

import org.springframework.data.repository.CrudRepository;

import com.appcourses.model.Students;

public interface StudentsRepository extends CrudRepository<Students, Long>, StudentsRepositoryCustom{

}
