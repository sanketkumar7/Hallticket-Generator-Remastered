package com.hallTicket.FrontEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hallTicket.dao.HallticketOperation;
import com.hallTicket.factory.ServiceDaoFactory;

@WebServlet("/addhallticket1")
public class AddHallTicket1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String department=((String)session.getAttribute("department")).trim();
		String year=(String)session.getAttribute("yeardetails");
		String semester=(String)session.getAttribute("semester");
		int noofsub=Integer.parseInt((String)session.getAttribute("noofsub"));
		
		String subject[]=new String[noofsub];
		String theory[]=new String[noofsub];
		String practical[]=new String[noofsub];
		String oral[]=new String[noofsub];
		for(int i=0;i<noofsub;i++) {
			subject[i]=request.getParameter("subject"+i);
			
			if(request.getParameter("theory"+i)==null)
				theory[i]="no";
			else 
				theory[i]=request.getParameter("theory"+i);
			
			if(request.getParameter("practical"+i)==null)
				practical[i]="no";
			else 
				practical[i]=request.getParameter("practical"+i);
			
			if(request.getParameter("oral"+i)==null)
				oral[i]="no";
			else 
				oral[i]=request.getParameter("oral"+i);
		}
		LinkedHashSet<String> Subjecthash=new LinkedHashSet<String>(Arrays.asList(subject));
		HallticketOperation hallops=ServiceDaoFactory.getHallticketoperation();
		if(Subjecthash.size()==subject.length)
			if(hallops.addhallticket(department,year,semester,subject,theory,practical,oral)) {
			request.getRequestDispatcher("/TeacherOperation.jsp").include(request, response);
			request.getRequestDispatcher("/Hallticket.jsp").include(request, response);
			out.println("<html><body><div align=\"center\" style=\"margin:2in; background-color:'grey; '\"><h3 style='color:Green;font-size:20px; '>Hallticket added Successful.</h3></body></html>");
			}else {
				request.getRequestDispatcher("/TeacherOperation.jsp").include(request, response);
				request.getRequestDispatcher("/AddHallTicket.jsp").include(request, response);
				out.println("<html><body><h3 style='padding-top:20px;padding-left:40px;font-size: 25px;color:#622520;' align='center'>Hallticket Already Exists with "+department+","+year+" and "+semester+".</h3></body></html>");	
				}
		else {
			request.getRequestDispatcher("/TeacherOperation.jsp").include(request, response);
			request.getRequestDispatcher("/AddHallticket1.jsp").include(request, response);
			out.println("<html><body><div align=\"center\" style=\"margin:2in; background-color:'grey; '\"><h3 style='color:Green;font-size:20px; '>Please Do not repeat Subject.</h3></body></html>");
			
		}
	}

}
