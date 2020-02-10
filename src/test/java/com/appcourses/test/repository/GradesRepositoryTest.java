package com.appcourses.test.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.appcourses.model.dto.GradeSavingDTO;
import com.appcourses.repository.GradesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class GradesRepositoryTest {
	
	@Autowired
    private GradesRepository gradeRepository;
	
	private static final String STUDENT_ID_FOR_SEARCHING = "9012432";
	private static final String STUDENT_ID_FOR_INSERTION = "723591";
    private static final String COURSE_ID = "HGM-235";

	@Test
	public void testGettingFilledBestGradesByStudentAndCourseList() {
		
		assertEquals("The Best grades were not found",true, gradeRepository.bestGradesByStudentAndCourse().size() > 0);
	}
	
	@Test
	public void testGettingFilledWorstGradesByCourseList() {
		 assertEquals("The Worst grades were not found",true, gradeRepository.worstGradesByStudentAndCourse().size() > 0);
	}
	
	@Test
	public void testGettingGradesByStudent() {
		 assertEquals("The grades were not found",true, gradeRepository.findGradesByStudent(STUDENT_ID_FOR_SEARCHING).size() > 0);
	}
	
	@Test
	public void testCreateGrade() {
		GradeSavingDTO gradeDTO = new GradeSavingDTO(STUDENT_ID_FOR_INSERTION, COURSE_ID, (int) Math.random()*5);
		
		assertThat("Could not save grade", gradeRepository.saveGrade(gradeDTO), Matchers.equalTo(1));
		assertThat("Information saved is not persisting", gradeRepository.findGradesByStudent(gradeDTO.getStudentid())
				                                                         .stream()
				                                                         .findFirst()
				                                                         .get()
				                                                         .getGradesId()
				                                                         .getStudent()
				                                                         .getId(), Matchers.equalTo(gradeDTO.getStudentid()));
	}

}
