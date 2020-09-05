<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    if(session.getAttribute("active")==null)
        response.sendRedirect("login.html");
    %>
<%! String Invalid; Connection con;Statement st; ResultSet rs; HashSet<String> hs; Iterator values;  %>  
<% ConnectionFactory connectionFactory=new ConnectionFactory(); 
		con=connectionFactory.getCon();
		Statement st=con.createStatement();
		rs=st.executeQuery("select Department_Name from HallticketDetails");
		hs=new HashSet<String>();
		while(rs.next()) hs.add(rs.getString(1));
		values=hs.iterator();
		if(hs==null)
			Invalid="Please Add Hallticket!";
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Add Hallticket]</title>
<style type="text/css">
body,html {
	margin: 0;
    padding: 0;
    border: 0;
    line-height:0;
    
    outline: 0;
    font-size: 100%;
    vertical-align: baseline;
}
	a{
		color: #998C8C;
		font-weight: bold;
		display:inline-block;
		text-decoration: none;
	}
	
.inputvalue{
	width: 250px;
	height:30px;
	font-size: 20px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-bottom:1px solid black;
	autocomplete:off;	
}
	label{
	font-size: 25px;
	font-family: monospace;
	}
	.buttons{
	font-size: 20px;
	border-radius: 3px;
	
	}
	.buttons:hover {
	background: #D8BABA;
	}
	.register:hover {
		color: purple;
		position:relative;
		font-size: 20px;
	}
	
	.register:active {
		color:#DDAE56;
		}
	.forgotpass:hover{
		color: purple;
	}
	.forgotpass:active {
		color:#DDAE56;
}
	
</style>
</head>
<body bgcolor="floralwhite">
<form method="post" action="./showstudent">
	<div align="center" style='padding-top:20px;'>
		<div class='second-input' style='margin:10px;' > <label for='department' class='label' >Department Name:</label>
		 <select name="department" style='width: 255px;font-size: 20px;'>
						<% for(String DepartmentValue:hs){ %>
							<option <c:set var="temp" value="<%=DepartmentValue%>"/><c:if test='${sessionScope["department"]==temp}'><c:out  value="selected"/></c:if>>			
							<%=DepartmentValue %>
							</option>
						<% ;} %>
					</select>
					</select> </div>
		<div style='padding-top: 5px; padding-left: 150px;'> <label for='yeardetails' class='label'>Year:</label> 
		 <select name='yeardetails' style='width:255px;font-size: 20px;'><option >First Year</option><option <c:if test='${sessionScope["yeardetails"]=="Second Year" }'><c:out  value="selected"/> </c:if> > Second Year</option><option <c:if test='${sessionScope["yeardetails"]=="Third Year" }'><c:out  value="selected"/></c:if>>Third Year</option><option <c:if test='${sessionScope["yeardetails"]=="Fourth Year" }'><c:out  value="selected"/></c:if>>Fourth Year</option></select>
		  </div>
		 <div style='padding-top: 20px;padding-left:200px;'> <input type="submit" class='buttons' value='Show Students'> 
		</div>	
	</div>
</form>
</body>
</html>