package com.appcourses.repository;

import org.springframework.transaction.annotation.Transactional;

import com.appcourses.model.Students;

public interface StudentsRepositoryCustom{
    
	public Students findStudentById(String id);
	@Transactional
	public int deleteStudent(String id);
}
