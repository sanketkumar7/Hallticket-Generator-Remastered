package com.hallTicket.factory;

import com.hallTicket.dao.HallticketOperation;
import com.hallTicket.dao.LoginService;
import com.hallTicket.dao.ResetPassword;
import com.hallTicket.dao.ServiceDao;
import com.hallTicket.dao.StudentService;
import com.hallTicket.dao.SubjectServices;
import com.hallTicket.dao.TeacherService;


public class ServiceDaoFactory {
private static  TeacherService teacherservice=null;
private static SubjectServices subjectservice=null;
private static StudentService studentservice=null;
private static LoginService loginservice=null;
private static ResetPassword resetpassword=null;
private static HallticketOperation hallticketoperation=null;

private static ServiceDao servicedao=new ServiceDao();
static {
	resetpassword=servicedao;
	subjectservice=servicedao;
	teacherservice=servicedao;
	studentservice=servicedao;
	loginservice=servicedao;
	hallticketoperation=servicedao;
	
}
public static  TeacherService getTeacherservice() {
	return teacherservice;
}
public static  SubjectServices getSubjectservice() {
	return subjectservice;
}
public static StudentService getStudentservice() {
	return studentservice;
}
public static LoginService getLoginservice() {
	return loginservice;
}
public static ResetPassword getResetpassword() {
	return resetpassword;
}
public static HallticketOperation getHallticketoperation() {
	return hallticketoperation;
}

}
