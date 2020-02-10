package com.appcourses.model.dto;

public class GradeSavingDTO {
   
	private String studentid;
	private String courseid;
	private int value;
	
	public GradeSavingDTO() {
		
	}
	
    public GradeSavingDTO(String stID, String crsID, int val) {
    	   studentid = stID;
    	   courseid = crsID;
    	   value=val;
    }

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}