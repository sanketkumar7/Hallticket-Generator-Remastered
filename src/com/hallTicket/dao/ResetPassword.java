package com.hallTicket.dao;

public interface ResetPassword {
	public String userType(String username);
	public boolean ValidStudentDetails(String uname, String date, String key);
	public boolean updatePassword(String uname, String pass1, String usertype);
	public boolean ValidTeacherDetails(String uname, String date);
	public boolean masterkey(String key);
}
