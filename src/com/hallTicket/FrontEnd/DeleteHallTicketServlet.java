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

@WebServlet(urlPatterns = { "/deletehallticket1", "/deletehallticket2" })
public class DeleteHallTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println(request.getParameter("action"));
		HallticketOperation hallops=ServiceDaoFactory.getHallticketoperation();
		RequestDispatcher homepage=request.getRequestDispatcher("/TeacherOperation.jsp");
		RequestDispatcher deletehallticket=request.getRequestDispatcher("/DeleteHallTicket.jsp");
		RequestDispatcher deletehallticket1=request.getRequestDispatcher("/DeleteHallTicket1.jsp");
	
		
		if(request.getParameter("action").equals("Delete Hallticket")) {
			String department=request.getParameter("department");
			String Year=request.getParameter("yeardetails");
			String Semester=request.getParameter("semester");
				if(!hallops.searchHallticket(department,Year,Semester)) {
				homepage.include(request, response);
				deletehallticket.include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Hallticket Not Exists of "+department+","+Year+" and "+Semester+".</h3></body></html>");	
			}
			else {
				HttpSession hs=request.getSession();
				hs.setAttribute("department",department);
				hs.setAttribute("yeardetails",Year);
				hs.setAttribute("semester",Semester);
				homepage.include(request, response);
				deletehallticket1.include(request, response);
			}
		}
		else if(request.getParameter("action").equals("Delete Permanently")) {
			HttpSession session=request.getSession();
			String department=((String)session.getAttribute("department")).trim();
			String year=(String)session.getAttribute("yeardetails");
			String semester=(String)session.getAttribute("semester");
			if(hallops.deleteHallticket(department,year,semester)) {
				homepage.include(request, response);
				request.getRequestDispatcher("/Hallticket.jsp").include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Hallticket Deleted Successfully with Department name:"+department+", Academic Year:"+year+" and Semester: "+semester+".</h3></body></html>");	
			}else {
				homepage.include(request, response);
				deletehallticket1.include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Either HallTicket deleted already or Something went wrong try again!.</h3></body></html>");	
		
			}
		}else if(request.getParameter("action").equals("cancel")) {
			homepage.include(request, response);
			deletehallticket.include(request, response);
		}
	}
}
