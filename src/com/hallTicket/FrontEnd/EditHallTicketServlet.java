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


@WebServlet("/edithallticket")
public class EditHallTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String department=request.getParameter("department");
		String Year=request.getParameter("yeardetails");
		String Semester=request.getParameter("semester");
		RequestDispatcher homepage=request.getRequestDispatcher("/TeacherOperation.jsp");
		RequestDispatcher edithallticket=request.getRequestDispatcher("/EditHallTicket.jsp");
		RequestDispatcher edithallticket1=request.getRequestDispatcher("/EditHallTicket1.jsp");
		
			HallticketOperation hallops=ServiceDaoFactory.getHallticketoperation();
			if(!hallops.searchHallticket(department,Year,Semester)) {
				homepage.include(request, response);
				edithallticket.include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Hallticket Not Exists of "+department+","+Year+" and "+Semester+".</h3></body></html>");	
			}
			else {
				HttpSession hs=request.getSession();
				hs.setAttribute("department",department);
				hs.setAttribute("yeardetails",Year);
				hs.setAttribute("semester",Semester);
				homepage.include(request, response);
				edithallticket1.include(request, response);
			}
	}

}
