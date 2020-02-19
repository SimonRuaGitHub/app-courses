package com.appcourses.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appcourses.model.Courses;
import com.appcourses.model.Grades;
import com.appcourses.model.dto.GradeSavingDTO;
import com.appcourses.repository.GradesRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class GradesController {
	
	@Autowired
	private GradesRepository gradesRepository;

	@RequestMapping("/allGrades")
	public  List<Grades> getAllGrades(){
		
		   List<Grades> allGradesList = new ArrayList<Grades>();
		   gradesRepository.findAll().forEach(grade -> allGradesList.add(grade));
		   
		   return allGradesList;
    }
	
	@RequestMapping("/allGradesByStudent/{id}")
	public List<Grades> getAllGradesByStudent(@PathVariable String id){
		return gradesRepository.findGradesByStudent(id);
	}
	
	@RequestMapping(path="/bestGrades/studentAndCourse", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Grades> getBestGradesByStudentAndCourse(){
		   return gradesRepository.bestGradesByStudentAndCourse();
	}
	
	@RequestMapping("/worstGrades/studentAndCourse")
	public List<Grades> getWorstGradesByStudentAndCourse(){
		   return gradesRepository.worstGradesByStudentAndCourse();
	}
	
	@RequestMapping(path="/saveGrade", method=RequestMethod.POST, produces=MediaType.TEXT_PLAIN_VALUE)
	public String saveCourse(@RequestBody GradeSavingDTO gradeSavingDTO) {
		
		   System.out.println("Saving grade info: ["+gradeSavingDTO.getCourseid()+"|"+gradeSavingDTO.getStudentid()+"|"+gradeSavingDTO.getValue()+"]");
		
		   gradesRepository.saveGrade(gradeSavingDTO);
		   
		   return "Saved";
	}
	
}
