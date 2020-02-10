package com.appcourses.repository;

import java.util.List;

import com.appcourses.model.Grades;
import com.appcourses.model.dto.GradeSavingDTO;

public interface GradesRepositoryCustom {

	public List<Grades> findGradesByStudent(String id);
	public List<Grades> bestGradesByStudentAndCourse();
	public List<Grades> worstGradesByStudentAndCourse();
	public int saveGrade(GradeSavingDTO gradeDto);
}
