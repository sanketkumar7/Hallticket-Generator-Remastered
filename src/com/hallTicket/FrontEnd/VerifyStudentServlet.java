package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hallTicket.dao.TeacherService;
import com.hallTicket.factory.ConnectionFactory;
import com.hallTicket.factory.ServiceDaoFactory;


@WebServlet("/verifystudent")
public class VerifyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher OrderStudent=request.getRequestDispatcher("/VerifyStudent.jsp");
		RequestDispatcher HomePage=request.getRequestDispatcher("TeacherOperation.jsp");
			String order=request.getParameter("action");
			HttpSession session=request.getSession();
		
		switch(order) {
		case "username": 	
		case "fname": 	
		case "surname": 	
		case "rollno": 	
		case "mobile": 	
		case "email": 	
		case "birthdate": 	
		case "Department_name": 	
		case "year":		
		case "semester":	
		case "seatno":	
		case "status": 
				session.setAttribute("order", order);
				HomePage.include(request,response);
				OrderStudent.include(request, response);
			break;		
		case "verify":
			String approvestudent[]=request.getParameterValues("checkpositivestatus");
			String disapprovestudent[]=request.getParameterValues("checknegativestatus");
			TeacherService teacherservice=ServiceDaoFactory.getTeacherservice();
			
			String color[]= {"#ff0000","#ff0000","#CD04E8","#04E5E1","#04E282","#04E282","#41db23","#b0db23","#41db23","#22d8c0"};
			int num=(int) (Math.random()*10);
			if(approvestudent!=null && disapprovestudent!=null) {
				int ApprovedStudent=teacherservice.ApproveStudent(approvestudent);
				int DisapprovedStudent=teacherservice.DisapprovedStudent(disapprovestudent);
				HomePage.include(request,response);
				request.getRequestDispatcher("/VerifyStudent.jsp").include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:"+color[(int) (Math.random()*10)]+";' align='center'>"+ApprovedStudent+" Students Approved.</h3></body></html>");
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:"+color[(int) (Math.random()*10)]+";' align='center'>"+DisapprovedStudent+" Students Disapproved.</h3></body></html>");		
			}
			else if(approvestudent!=null && disapprovestudent==null) {
				int ApprovedStudent=teacherservice.ApproveStudent(approvestudent);
				HomePage.include(request,response);
				request.getRequestDispatcher("/VerifyStudent.jsp").include(request, response);;
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:"+color[num]+";' align='center'>"+ApprovedStudent+" Students Approved.</h3></body></html>");
				}	
			else if(approvestudent==null && disapprovestudent!=null) {
				int DisapprovedStudent=teacherservice.DisapprovedStudent(disapprovestudent);
				HomePage.include(request,response);
				request.getRequestDispatcher("/VerifyStudent.jsp").include(request, response);;
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:"+color[num]+";' align='center'>"+DisapprovedStudent+" Students Disapproved.</h3></body></html>");
				}
			else if(approvestudent==null && disapprovestudent==null) {
				HomePage.include(request,response);
				request.getRequestDispatcher("/VerifyStudent.jsp").include(request, response);;
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:"+color[num]+";' align='center'>0 Students Selected.</h3></body></html>");
			
			}
			
			break;
		
		default: 
		}
		
	}

}
