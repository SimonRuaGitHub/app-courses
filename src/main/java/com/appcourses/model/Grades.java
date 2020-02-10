package com.appcourses.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grades")
public class Grades implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1707179189713411629L;
	
	@EmbeddedId
	private GradesId gradesId;
	
	@Column(name="value")
	private int value;

	public Grades() {
		
	}
	
	

	public GradesId getGradesId() {
		return gradesId;
	}

	public void setGradesId(GradesId gradesId) {
		this.gradesId = gradesId;
	}



	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
