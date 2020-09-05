package com.hallTicket.dao;

public interface StudentService {
	public boolean addStudentDetails(Student s);
	public boolean searchStudent(String uname);
	public boolean updateStudent(Student s);
	String StudentName(String username);
	Student StudentDetails(String username);
	boolean UpdateStudentDetails(Student student);
	public String HallticketAvailability(Student std);
}
