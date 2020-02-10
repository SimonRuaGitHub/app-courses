package com.appcourses.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.appcourses.model.Students;
import com.appcourses.repository.StudentsRepositoryCustom;

public class StudentsRepositoryCustomImpl implements StudentsRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Students findStudentById(String id) {
		Query query = entityManager.createQuery("SELECT s FROM Students s WHERE s.id = :idStudent");
		query.setParameter("idStudent",id);
		
		return (Students) query.getSingleResult();
	}
	

	@Override
	public int deleteStudent(String id) {
		Query query = entityManager.createQuery("DELETE FROM Students s WHERE s.id = :id");
		query.setParameter("id", id);
		
		return query.executeUpdate();
	}

}
