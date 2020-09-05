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

import org.apache.catalina.Session;

import com.hallTicket.dao.Student;
import com.hallTicket.dao.StudentService;
import com.hallTicket.factory.ConnectionFactory;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/studentoperation")
public class StudentOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String input=request.getParameter("action");
		RequestDispatcher login=request.getRequestDispatcher("./login.html");
		RequestDispatcher homepage=request.getRequestDispatcher("StudentOperation.jsp");
		RequestDispatcher editform=request.getRequestDispatcher("EditStudent.jsp");
		RequestDispatcher showform=request.getRequestDispatcher("ShowDetails.jsp");
		RequestDispatcher hallticketgenform=request.getRequestDispatcher("HallticketGenerate.jsp");
		
		switch(input) {
		case "editDetails":
		{	homepage.include(request,response);
			editform.include(request,response);
			break;
		}
		case "showDetails":{
			homepage.include(request,response);
			showform.include(request, response);
			break;
		}
		case "signout":{
			request.getSession().invalidate();
			request.getRequestDispatcher("./login.html").forward(request, response);
			break;
		}
		case "hallticketGeneration":
			HttpSession hs=request.getSession();
			String username=(String)hs.getAttribute("uname");
			StudentService sos=ServiceDaoFactory.getStudentservice();
			Student std=sos.StudentDetails(username);
			String Available=sos.HallticketAvailability(std);
				switch (Available) {
				case "NotApproved":
					homepage.include(request,response);
					out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:5%;font-size:25px;color:green;font-family:monospace;'> Dear "+std.getFname()+" your details aren't approved. Contact your class Teacher</h3></body></html>");
					break;
				case "NoDepartment":
					homepage.include(request,response);
					out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:5%;font-size:25px;color:green;font-family:monospace;'> There is no Exam hallticket for "+std.getDepartment()+" Department.</h3></body></html>");
					
					break;
				case "NoYear":
					homepage.include(request,response);
					out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:5%;font-size:25px;color:green;font-family:monospace;'> There is no Exam hallticket for "+std.getDepartment()+"("+std.getYear()+").</h3></body></html>");
					
					break;
				case "NoSemester":
					homepage.include(request,response);
					out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:5%;font-size:25px;color:green;font-family:monospace;'> There is no Exam hallticket for "+std.getSemester()+" of "+std.getDepartment()+"("+std.getYear()+") .</h3></body></html>");
					
					break;
				case "HallTicketAvailable": 
					request.getRequestDispatcher("/GenerateHallticket.jsp").forward(request, response);
					break;
				default:
					homepage.include(request,response);
					out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:5%;font-size=25px;color:#04E5E1'> Something went wrong Contact resource person.</h3></body></html>");
					break;
					}
			break;
		default:{
			homepage.include(request,response);
			out.println("<html><body bgcolor='#9F8FBA'><h3 align='center' style='margin-top:10%'> Something went wrong Contact resource person.</h3></body></html>");
		}
		
		}
	}

}
