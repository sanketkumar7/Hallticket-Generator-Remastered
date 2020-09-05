<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%! Connection con;Statement st;ResultSet rs;HashSet<String> hs;Iterator values;String Invalid; %>
	
	<%
	con=new ConnectionFactory().getCon();
	Statement st=con.createStatement();
	rs=st.executeQuery("select Department_Name from HallticketDetails");
	hs=new HashSet<String>();
	while(rs.next()) hs.add(rs.getString(1));
	values=hs.iterator();
	if(hs==null)
		Invalid="There is no Department present, Contact your teacher";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Show Hallticket]</title>
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
	text-transform:uppercase;
	
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
<body bgcolor="9f8fba">
<form method="post" action="./deletehallticket1">
	<div align="center" style='padding-top:20px;'>
		<div class='second-input' style='margin:10px'> <label for='Department' class='label' >Department Name:</label>
		<select style='width:255px;font-size: 20px;' name="department">
						<% for(String DepartmentValue:hs){ %>
							<option <c:set var="temp" value="<%=DepartmentValue%>"/>>			
							<%= DepartmentValue %>
							</option>
						<% ;} %>
					</select></div>
		<div style='padding-top: 5px; padding-left: 152px;'> <label for='Year' class='label'>Year:</label> 
		 <select name='yeardetails' style='width:255px;font-size: 20px;'><option >First Year</option><option > Second Year</option><option>Third Year</option><option >Fourth Year</option></select>
		  </div>
		  <div style='margin:10px;padding-top: 5px; padding-left: 97px'> <label for='Semester' class='label'>Semester:</label> 
		 <select name='semester' style='width:255px;font-size:20px'><option >First Semester</option><option> Second Semester</option></select>
		  </div>
		 <div style='padding-top: 20px;padding-left:200px;'> <input type="submit" class='buttons' name='action' value='Delete Hallticket'> 
		<button type="Reset" class='buttons' style='margin-left: 10px;'>Reset</button>
		</div>	
	</div>
</form>
</body>
</html>