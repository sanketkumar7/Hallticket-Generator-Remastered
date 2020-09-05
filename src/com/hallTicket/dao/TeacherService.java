package com.hallTicket.dao;

public interface TeacherService {
	public boolean addTeacher(Teacher t);
	public boolean searchTeacher(String uname);
	public boolean masterkey(String key);
	public Teacher TeacherDetails(String uname);
	public boolean UpdateTeacherDetails(Teacher teacher);
	public int ApproveStudent(String[] verifystudent);
	public int DisapprovedStudent(String[] verifystudent);
}
