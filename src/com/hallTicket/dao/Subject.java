package com.hallTicket.dao;

public class Subject {
	private String Department,Year;
	private String SemesterSubject[]=new String[11];
	public String getDepartment() {
		return Department;
	}
	public String getYear() {
		return Year;
	}
	public String[] getSemesterSubject() {
		return SemesterSubject;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public void setYear(String year) {
		Year = year;
	}
	public void setSemesterSubject(String[] semesterSubject) {
		SemesterSubject = semesterSubject;
	}
	
	
	
}
