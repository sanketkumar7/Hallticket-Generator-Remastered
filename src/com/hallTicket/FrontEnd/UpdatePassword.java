package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hallTicket.factory.ServiceDaoFactory;
@WebServlet("/updatepassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String pass1=request.getParameter("pass1Reset");
		String pass2=request.getParameter("pass2Reset");
		
	
		HttpSession hs=request.getSession();
		String usertype=(String)hs.getAttribute("usertypeReset");
		String uname=(String)hs.getAttribute("unameReset");
		
		String color[]= {"#ff0000","#EA04B4","#CD04E8","#04E5E1","#04E282","#26AD72","#41db23","#b0db23","#dbbc23","#db8823"};
		int num=(int) (Math.random()*10);
		
		if(!pass1.equals(pass2)) {
			request.getRequestDispatcher("ResetPassword.jsp").include(request, response);
			out.println("<html><body><h3 style='padding-top:20px;font-size: 25px;color:"+color[num]+";' align='center'> Entered Password didn't match.</h3></body></html>");
		}else {
			com.hallTicket.dao.ResetPassword resetpassword=ServiceDaoFactory.getResetpassword();
				if(resetpassword.updatePassword(uname,pass1,usertype)) {
					request.getRequestDispatcher("login.html").include(request, response);
					out.println("<html><body><h3 style='padding-top:20px;font-size: 25px;color:"+color[num]+";' align='center'> Password Updated Successfully.</h3></body></html>");
				}else {
					request.getRequestDispatcher("login.html").forward(request, response);
					out.println("<html><body><h3 style='padding-top:20px;font-size: 25px;color:"+color[num]+";' align='center'> Password Update failed.</h3></body></html>");
			
				}
			
		}
	}
}
