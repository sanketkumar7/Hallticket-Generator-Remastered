package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hallTicket.dao.Student;
import com.hallTicket.dao.StudentService;
import com.hallTicket.factory.ServiceDaoFactory;


@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String sname=request.getParameter("sname");
		String pass1=request.getParameter("password1");
		String pass2=request.getParameter("password2");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String rollno=request.getParameter("rollno");
		String birthdate=request.getParameter("birthdate");
		String Department=(String)request.getParameter("department");
		String Year=(String)request.getParameter("yeardetails");
		String Semester=request.getParameter("semester");
		String status="Not Verified";
		
		String seatno="---"; boolean validDetails=false;
		
		HttpSession hs=request.getSession();
		hs.setAttribute("unameSignup",uname);
		hs.setAttribute("fnameSignup", fname);
		hs.setAttribute("snameSignup", sname);
		hs.setAttribute("pass1Signup", pass1);
		hs.setAttribute("pass2Signup", pass2);
		hs.setAttribute("mobileSignup", mobile);
		hs.setAttribute("emailSignup", email);
		hs.setAttribute("birthdateSignup",birthdate);
		hs.setAttribute("rollnoSignup", rollno);
		hs.setAttribute("department",Department);
		hs.setAttribute("yeardetails", Year);
		hs.setAttribute("Semester", Semester);
		
		RequestDispatcher review=request.getRequestDispatcher("SignUpStudent.jsp");
		RequestDispatcher studentRegister=request.getRequestDispatcher("./Registration.html");
		
		Student student=new Student();
		StudentService studserv=new ServiceDaoFactory().getStudentservice();
		if(studserv.searchStudent(uname)) {
			hs.setAttribute("InvalidSignup","The Username "+uname+" Already Exists! Use another Username");
			review.include(request, response);
			hs.setMaxInactiveInterval(2);
		}
		else if(!pass1.equals(pass2)) {
			hs.setAttribute("InvalidSignup","Entered Password didn't match!");
			review.include(request, response);
			hs.setMaxInactiveInterval(2);
		}else {
			student.setUname(uname);
			student.setFname(fname);
			student.setSname(sname);
			student.setPassword(pass1);
			student.setMobile(mobile);
			student.setEmail(email);
			student.setRollno(rollno);
			student.setBirthdate(birthdate);
			student.setDepartment(Department);
			student.setYear(Year);
			student.setSemester(Semester);
			student.setSeatno(seatno);
			student.setStatus(status);
			validDetails=true;	
		}if(validDetails) {
			if(studserv.addStudentDetails(student)) {
				studentRegister.forward(request, response);
				hs.setMaxInactiveInterval(1);
			}
		}
	}

}
