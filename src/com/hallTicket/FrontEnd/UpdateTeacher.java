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

import com.hallTicket.dao.Teacher;
import com.hallTicket.dao.TeacherService;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/updateteacher")
public class UpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String sname=request.getParameter("sname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String birthdate=request.getParameter("birthdate");
		
		HttpSession hs=request.getSession();
		String pass1=(String)hs.getAttribute("pass1");
		boolean ValidDetails=false;
		
		RequestDispatcher homepage=request.getRequestDispatcher("/TeacherOperation.jsp");
		RequestDispatcher UpdatedTeacher=request.getRequestDispatcher("./Update.html");
		RequestDispatcher Updatefail=request.getRequestDispatcher("./UpdateFailed.html");
		
		Teacher teacher=new Teacher();
		if(true) {
			teacher.setUname(uname);
			teacher.setFname(fname);
			teacher.setSname(sname);
			teacher.setPassword(pass1);
			teacher.setMobile(mobile);
			teacher.setEmail(email);
			teacher.setBirthdate(birthdate);
			ValidDetails=true;
		}
		if(ValidDetails) {
			TeacherService ts=ServiceDaoFactory.getTeacherservice();
				if(ts.UpdateTeacherDetails(teacher)) {
					homepage.include(request, response);
					UpdatedTeacher.include(request, response);	
				}
		}
	}

}
