package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hallTicket.dao.LoginService;
import com.hallTicket.dao.Student;
import com.hallTicket.dao.StudentService;
import com.hallTicket.dao.Teacher;
import com.hallTicket.dao.TeacherService;
import com.hallTicket.factory.ConnectionFactory;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=(String) request.getParameter("uname");
		String password=(String)request.getParameter("password");
		
		RequestDispatcher studentOperation=request.getRequestDispatcher("StudentOperation.jsp");
		RequestDispatcher teacherOperation=request.getRequestDispatcher("TeacherOperation.jsp");
		RequestDispatcher Loginfailed=request.getRequestDispatcher("./login.html");
		RequestDispatcher ShowTeacherDetails=request.getRequestDispatcher("ShowTeacherDetails.jsp");
		LoginService loginservice=ServiceDaoFactory.getLoginservice();
		switch(loginservice.LoginCheck(uname,password)) {
		case "TeacherLogin":{
				HttpSession session=request.getSession();
				session.setAttribute("active","true");
				
				String username, fname, sname,pass1,pass2,email,mobile,birthdate; Teacher tcr;
				
				TeacherService ts=ServiceDaoFactory.getTeacherservice();
				tcr=ts.TeacherDetails(uname); 
				
				fname=tcr.getFname();
				sname=tcr.getSname();
				pass1=pass2=tcr.getPassword();
				email=tcr.getEmail();
				mobile=tcr.getMobile();
				birthdate=tcr.getBirthdate();
				
				session.setAttribute("uname", uname);
				session.setAttribute("fname", fname);
				session.setAttribute("sname", sname);
				session.setAttribute("pass1", pass1);
				session.setAttribute("pass2", pass2);
				session.setAttribute("email", email);
				session.setAttribute("mobile", mobile);
				session.setAttribute("birthdate", birthdate);
				teacherOperation.include(request, response);
				ShowTeacherDetails.include(request, response);
			break;
		}
		case "StudentLogin":{
			HttpSession session=request.getSession();
			session.setAttribute("active","true");
			
			String fname, sname, pass1, pass2, email, mobile, rollno, birthdate, department, year, semester,seatno;Student std; 
			
				StudentService sos=ServiceDaoFactory.getStudentservice();
				std=sos.StudentDetails(uname);
				fname=std.getFname();
				sname=std.getSname();
				pass1=pass2=std.getPassword();
				email=std.getEmail();
				mobile=std.getMobile();
				rollno=std.getRollno();
				birthdate=std.getBirthdate();
				department=std.getDepartment();
				year=std.getYear();
				semester=std.getSemester();
				seatno=std.getSeatno();
				session.setMaxInactiveInterval(60*5);
				session.setAttribute("uname", uname);
				session.setAttribute("fname", fname);
				session.setAttribute("sname", sname);
				session.setAttribute("pass1", pass1);
				session.setAttribute("pass2", pass2);
				session.setAttribute("mobile", mobile);
				session.setAttribute("email", email);
				session.setAttribute("birthdate",birthdate);
				session.setAttribute("rollno", rollno);
				session.setAttribute("department",department);
				session.setAttribute("yeardetails",year);
				session.setAttribute("semester",semester);
				session.setAttribute("seatno", seatno);
				studentOperation.include(request, response);
				request.getRequestDispatcher("ShowDetails.jsp").include(request, response);
				
			break;
		}
		case "InvalidLogin":{
			Loginfailed.include(request, response);
			String color[]= {"#ff0000","#EA04B4","#CD04E8","#04E5E1","#04E282","#26AD72","#41db23","#b0db23","#dbbc23","#db8823"};
			int num=(int) (Math.random()*10);
			out.println("<html><body><h3 style='padding-top:20px;font-size: 25px;color:"+color[num]+";' align='center'> Login Failed! Please Enter valid Credentials.</h3></body></html>");
			break;
		}
		default:{
			Loginfailed.include(request, response);
			out.println("<html><body><h3 align='center' style='margin-top:20px'> Something went wrong Contact resource person.</h3></body></html>");
			break;
		}
		}
	}

}
