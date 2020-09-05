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

import com.hallTicket.factory.ConnectionFactory;

@WebServlet(urlPatterns = {"/teacheroperation","/hallticket"})
public class TeacherOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		RequestDispatcher homepage=request.getRequestDispatcher("/TeacherOperation.jsp");
		RequestDispatcher editDetails=request.getRequestDispatcher("/EditTeacherDetails.jsp");
		RequestDispatcher showDetails=request.getRequestDispatcher("/ShowTeacherDetails.jsp");
		RequestDispatcher Hallticket=request.getRequestDispatcher("/Hallticket.jsp");
		RequestDispatcher verifyStudent=request.getRequestDispatcher("/ShowStudent.jsp");
		
		String input=request.getParameter("action");
		switch(input) {
		case "editDetails":{
			homepage.include(request, response);
			editDetails.include(request, response);
			break;
		}
		case "showDetails":{
			homepage.include(request, response);
			showDetails.include(request, response);
			break;
		}
		case "Hallticket":{
			homepage.include(request, response);
			Hallticket.include(request, response);
			break;
		}
		case "verifyStudents":{
			HttpSession hs=request.getSession();
			hs.removeAttribute("deparntment");
			hs.removeAttribute("yeardetails");
			
			homepage.include(request, response);
			verifyStudent.include(request, response);
			break;
		}case "signout":{
			request.getSession().invalidate();
			request.getRequestDispatcher("./login.html").forward(request, response);
			
		}case "addHallticket":
			homepage.include(request, response);
			request.getRequestDispatcher("/AddHallTicket.jsp").include(request, response);
			break;
		 case "showHallticket":
			 homepage.include(request, response);
			 request.getRequestDispatcher("/ShowHallTicket.jsp").include(request, response);
				break;
		 case "editHallticket":
			 homepage.include(request, response);
			 request.getRequestDispatcher("/EditHallTicket.jsp").include(request, response);
			 break;
		 case "deleteHallticket":
			 homepage.include(request, response);
			 request.getRequestDispatcher("/DeleteHallTicket.jsp").include(request, response);
			 break;
			default:{
				out.println("<html><body><h3 align='center' style='margin-top:20px'> Something went wrong Contact resource person.</h3></body></html>");
			}
		}
		
	}

}
