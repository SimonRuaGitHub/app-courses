package com.appcourses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appcourses.model.Courses;
import com.appcourses.repository.CoursesRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CoursesController {
	
	@Autowired
	private CoursesRepository coursesRepository;

	@RequestMapping(path="/infoCourse",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Courses getInfoCourse() {
		   return new Courses("OL_134","Olympus Gods","Above Greek, over clouds, st 777");
	}
	
	@RequestMapping("/mock")
	public String sayHiMrJack() {
		   return "Hi, Mr Cosmefulanito";
	}
	
	@RequestMapping("/dummyObject")
	public Courses getCourse() {
		   return new Courses("WA_909","Watson Biography","London St 666");
	}
	
	@RequestMapping(path="/findAllCourses", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Courses> getListAllCourses(){
		List<Courses> listCourses = new ArrayList<>();
		
		coursesRepository.findAll().forEach(listCourses::add);
		
	    return listCourses;
	}
	
	@RequestMapping("/coursesQuantity")
	public long getCoursesQuantity() {
		    return coursesRepository.count();
	}
	
	@RequestMapping(path="/saveCourse", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String saveCourse(@RequestBody Courses course) {
		
		   coursesRepository.save(course);
		
		   return "Saved";
	}
	
	@RequestMapping(path="/deleteCourse", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleteCourse(@RequestBody Courses course) {
		
		  coursesRepository.delete(course);
		  
		  return "Deleted";
	}
}
