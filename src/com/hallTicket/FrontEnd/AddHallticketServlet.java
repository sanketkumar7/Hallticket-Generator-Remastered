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

import com.hallTicket.dao.HallticketOperation;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/addhallticket")
public class AddHallticketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String department=request.getParameter("department");
		String Year=request.getParameter("yeardetails");
		String Semester=request.getParameter("semester");
		String noofsub=request.getParameter("noofsub");
		
		RequestDispatcher homepage=request.getRequestDispatcher("/TeacherOperation.jsp");
		RequestDispatcher addhallticket=request.getRequestDispatcher("/AddHallTicket.jsp");
		RequestDispatcher addhallticket1=request.getRequestDispatcher("/AddHallTicket1.jsp");
		
			HallticketOperation hallops=ServiceDaoFactory.getHallticketoperation();
			if(hallops.searchHallticket(department,Year,Semester)) {
				homepage.include(request, response);
				addhallticket.include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Hallticket Already Exists with "+department+","+Year+" and "+Semester+".</h3></body></html>");	
			}
			else {
				HttpSession hs=request.getSession();
				hs.setAttribute("department", department);
				hs.setAttribute("yeardetails", Year);
				hs.setAttribute("semester", Semester);
				hs.setAttribute("noofsub", noofsub);
				homepage.include(request, response);
				addhallticket1.include(request, response);
			}
	}

}
