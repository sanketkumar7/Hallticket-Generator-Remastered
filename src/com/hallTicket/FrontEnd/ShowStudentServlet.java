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

import com.hallTicket.factory.ConnectionFactory;

@WebServlet("/showstudent")
public class ShowStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Department=request.getParameter("department");
		String Year=request.getParameter("yeardetails");
		HttpSession hs=request.getSession();
		hs.setAttribute("department", Department);
		hs.setAttribute("yeardetails", Year);
		boolean available=false;
		Connection con=new ConnectionFactory().getCon();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where Department_name='"+Department+"' AND year='"+Year+"'");
			if(rs.next()) {
				request.getRequestDispatcher("/TeacherOperation.jsp").include(request, response);
				request.getRequestDispatcher("/VerifyStudent.jsp").include(request, response);
			}else {
				request.getRequestDispatcher("/TeacherOperation.jsp").include(request, response);
				request.getRequestDispatcher("/ShowStudent.jsp").include(request, response);
				String color[]= {"#ff0000","#EA04B4","#CD04E8","#04E5E1","#04E282","#26AD72","#41db23","#b0db23","#dbbc23","#db8823"};
				int num=(int) (Math.random()*10);
				out.println("<html><body><h3 style='padding-top:20px;font-size: 25px;color:"+color[num]+";' align='center'> Student not Found!.</h3></body></html>");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
