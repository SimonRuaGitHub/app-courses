package com.appcourses.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class GradesId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5928750907175131097L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentid")
	private Students student;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courseid")
	private Courses course;
	
	public GradesId() {
		
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradesId other = (GradesId) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	
	
}
