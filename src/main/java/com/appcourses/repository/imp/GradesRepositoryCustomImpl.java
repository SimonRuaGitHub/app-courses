package com.appcourses.repository.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.appcourses.model.Courses;
import com.appcourses.model.Grades;
import com.appcourses.model.Students;
import com.appcourses.model.dto.GradeSavingDTO;
import com.appcourses.repository.CoursesRepository;
import com.appcourses.repository.GradesRepositoryCustom;
import com.appcourses.repository.StudentsRepository;

public class GradesRepositoryCustomImpl implements GradesRepositoryCustom{
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private CoursesRepository coursesRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private Query query;
	
	@Override
	public List<Grades> findGradesByStudent(String studentID) {
		
		query = entityManager.createQuery("SELECT g FROM Grades g WHERE g.gradesId.student.id = ?1");
		query.setParameter(1, studentID);
		
		List<Grades> gradesListByStudent = new ArrayList<Grades>(query.getResultList());
		
		return gradesListByStudent;
	}
	
	@Override
	public List<Grades> bestGradesByStudentAndCourse() {
		
		query = entityManager.createQuery("SELECT gr FROM Grades gr WHERE (gr.value ,gr.gradesId.course.id) IN "
				                              + "(SELECT max(g.value) as max_grade, g.gradesId.course.id FROM Grades g "
				                              + "GROUP BY g.gradesId.course.id)"
				                              + "ORDER BY gr.value DESC");

		return new ArrayList<Grades>(query.getResultList());
	}

	@Override
	public List<Grades> worstGradesByStudentAndCourse() {
		
		query = entityManager.createQuery("SELECT gr FROM Grades gr WHERE (gr.value ,gr.gradesId.course.id) IN "
											+ "(SELECT min(g.value) as max_grade, g.gradesId.course.id FROM Grades g "  
											+ "GROUP BY g.gradesId.course.id) "
				                            + "ORDER BY gr.value DESC");
		
		return new ArrayList<Grades>(query.getResultList());
	}

	@Override
	@Transactional
	public int saveGrade(GradeSavingDTO gradeDto) {
		
		Query queryInsertGrade = entityManager.createNativeQuery("INSERT INTO Grades(studentid,courseid,value) VALUES(:stID,:crID,:value)");
		
		return queryInsertGrade.setParameter("stID", gradeDto.getStudentid())
		                .setParameter("crID", gradeDto.getCourseid())
		                .setParameter("value", gradeDto.getValue())
		                .executeUpdate();
		
	}
}
