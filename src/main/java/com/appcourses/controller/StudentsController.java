package com.appcourses.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appcourses.model.Students;
import com.appcourses.repository.StudentsRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class StudentsController {

	@Autowired
	private StudentsRepository studentsRepository;
	
	@RequestMapping("/allStudents")
	public List<Students> getAllStudents(){
		
		   List<Students> studentsList = new ArrayList<>();
		   
		   studentsRepository.findAll().forEach(student -> studentsList.add(student));
		
		   return studentsList;
	}
	
	
	@RequestMapping(path="/saveStudent",method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String saveStudent(@RequestBody Students student) {
		
		   studentsRepository.save(student);
		   
		   return "Saved";
	}
	
	@RequestMapping(path="/deleteStudent/{id}", method=RequestMethod.GET)
    public String deleteStudent(@PathVariable String id) {
		
		   studentsRepository.deleteStudent(id);
		   
    	   return "Deleted";
    }
}

