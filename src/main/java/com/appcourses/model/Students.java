package com.appcourses.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Students {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "gradesId.student")
	private List<Grades> grades;
	
	public Students() {
		
	}
	
	public Students(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
