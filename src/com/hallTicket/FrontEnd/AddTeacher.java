package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hallTicket.dao.Teacher;
import com.hallTicket.dao.TeacherService;
import com.hallTicket.factory.ServiceDaoFactory;
import com.hallTicket.factory.ValidateImplFactory;
import com.hallTicket.validate.Validate;

@WebServlet("/addteacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("unameTeacher");
		String fname=request.getParameter("fnameTeacher");
		String sname=request.getParameter("snameTeacher");
		String pass1=request.getParameter("password1Teacher");
		String pass2=request.getParameter("password2Teacher");
		String mobile=request.getParameter("mobileTeacher");
		String email=request.getParameter("emailTeacher");
		String birthdate=request.getParameter("birthdateTeacher");
		String masterkey=request.getParameter("masterkeyTeacher");
		
		HttpSession hs=request.getSession();
		hs.setAttribute("uname",uname);
		hs.setAttribute("fname", fname);
		hs.setAttribute("sname", sname);
		hs.setAttribute("pass1", pass1);
		hs.setAttribute("pass2", pass2);
		hs.setAttribute("mobile", mobile);
		hs.setAttribute("birthdate", birthdate);
		hs.setAttribute("email", email);
		
		RequestDispatcher review=request.getRequestDispatcher("SignUpTeacher.jsp");
		RequestDispatcher registered=request.getRequestDispatcher("./Registration.html");
		
		Teacher t=new Teacher();
		boolean validDetails=false;
		TeacherService ts=ServiceDaoFactory.getTeacherservice();	
		
		if(ts.searchTeacher(uname)) {
			hs.setAttribute("Invalid","The Username "+uname+" Already Exists! Use another Username");
			review.include(request, response);
			hs.setMaxInactiveInterval(2);
		}
		else if(!pass1.equals(pass2)) {
			hs.setAttribute("Invalid","Entered Password didn't match!");
			review.include(request, response);
			hs.setMaxInactiveInterval(2);
		}
		else if(!ts.masterkey(masterkey)) {
			hs.setAttribute("Invalid","Please Enter valid Masterkey!");
			review.include(request, response);
			hs.setMaxInactiveInterval(2);
			
		}else {
			t.setUname(uname);
			t.setFname(fname);
			t.setSname(sname);
			t.setPassword(pass1);
			t.setMobile(mobile);
			t.setEmail(email);
			t.setBirthdate(birthdate);
			t.setMasterkey(masterkey);
			validDetails=true;
		}
		if(validDetails) {
			if(ts.addTeacher(t)) {
				registered.forward(request, response);
				hs.setMaxInactiveInterval(5);
				
				
			}
		}
		
	}

}
