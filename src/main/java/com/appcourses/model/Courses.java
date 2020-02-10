package com.appcourses.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "gradesId.course")
	private List<Grades> grades;
	
	public Courses() {}

	public Courses(String id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", location=" + location + ", grades=" + grades + "]";
	}
}
