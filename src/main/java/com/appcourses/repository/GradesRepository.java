package com.appcourses.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.appcourses.model.Grades;
import com.appcourses.model.dto.GradeSavingDTO;

public interface GradesRepository extends CrudRepository<Grades,Long>, GradesRepositoryCustom{


}
