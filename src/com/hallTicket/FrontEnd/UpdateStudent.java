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

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String sname=request.getParameter("sname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String rollno=request.getParameter("rollno");
		String birthdate=request.getParameter("birthdate");
		String Department=(String)request.getParameter("department");
		String Year=(String)request.getParameter("yeardetails");
		String Semester=request.getParameter("semester");
		String Status="Not Verified";
		
		HttpSession hs=request.getSession();
		String pass1=(String)hs.getAttribute("pass1");
		String seatno="---"; boolean validDetails=false;
		
		RequestDispatcher homepage=request.getRequestDispatcher("StudentOperation.jsp");
		RequestDispatcher studentUpdated=request.getRequestDispatcher("./Update.html");
		RequestDispatcher Updatefail=request.getRequestDispatcher("./UpdateFailed.html");
		Student student=new Student();
		StudentService studopsserv=ServiceDaoFactory.getStudentservice();
		
		if(true){
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
			student.setStatus(Status);
			validDetails=true;	
		}if(validDetails) {
			if(studopsserv.UpdateStudentDetails(student)) {
				hs.removeAttribute("Invalid");
				homepage.include(request, response);
				studentUpdated.include(request, response);
				}
			else {
				homepage.include(request, response);
				Updatefail.include(request, response);
			}
		}
	}

}
