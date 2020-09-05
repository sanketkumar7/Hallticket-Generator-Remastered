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

import com.hallTicket.dao.ResetPassword;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/resetpassword")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String date=request.getParameter("birthdate");
		String key=request.getParameter("key");
		
		RequestDispatcher ResetPassword=request.getRequestDispatcher("/ResetPassword.html");
		
		ResetPassword resetpassword=ServiceDaoFactory.getResetpassword();
		String UserType=resetpassword.userType(uname);
		switch(UserType) {
		
		case "Student":{
			if(resetpassword.ValidStudentDetails(uname,date,key)) {
				HttpSession hs=request.getSession();
				hs.setAttribute("usertypeReset", UserType);
				hs.setAttribute("unameReset", uname);
				request.getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
				
			}else {
				ResetPassword.include(request, response);
				out.println("<html><body><h3 align='center' style='margin-top:20px;color:#826EA1;font-size:25px;'>Note:- Please Enter Correct Details. </h3></body></html>");
				
			}
		break;	
		}
		case "Teacher":{
			if(resetpassword.masterkey(key))
				if(resetpassword.ValidTeacherDetails(uname,date)) {
					HttpSession hs=request.getSession();
					hs.setAttribute("usertypeReset", UserType);
					hs.setAttribute("unameReset", uname);
					request.getRequestDispatcher("/ResetPassword.jsp").forward(request, response);
				}else {
					ResetPassword.include(request, response);
					out.println("<html><body><h3 align='center' style='margin-top:20px;color:#826EA1;font-size:25px;'>Note:- Dear Teacher please Enter Correct Details. </h3></body></html>");
				}
			break;
		}
		case "NotFound":{
			ResetPassword.include(request, response);
			out.println("<html><body><h3 align='center' style='margin-top:20px;color:#826EA1;font-size:25px;'>Note:- User "+uname+" not found.</h3></body></html>");
			break;
			
		}
		default:{
			ResetPassword.include(request, response);
			out.println("<html><body><h3 align='center' style='margin-top:20px;color:#826EA1;font-size:25px;'>Note:- Something went wrong Contact resource person.</h3></body></html>");
			break;
		}
		}
	}

}
