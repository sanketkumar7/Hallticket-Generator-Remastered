<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@page import="com.hallTicket.factory.ServiceDaoFactory"%>
<%@page import="com.hallTicket.dao.Student"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%! String uname, fname, sname,email,mobile,birthdate,Invalid; Student std;%>
   
	<%
	session=request.getSession(false); 
	uname=(String)session.getAttribute("uname");
	fname=(String)session.getAttribute("fname");
	sname=(String)session.getAttribute("sname");
	email=(String)session.getAttribute("email");
	mobile=(String)session.getAttribute("mobile");  		
	birthdate=(String)session.getAttribute("birthdate");	
	Invalid=(String)session.getAttribute("Invalid");
	if(Invalid==null) Invalid="";
		%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Update Teacher]</title>
<style type="text/css">
	input{
		
		font-size: 25px;
	}

</style>
</head>
<body bgcolor="#9f8fba">
<div style='margin-left:5in;margin-right:5in; margin-bottom: 2px' align='center'>

	<form name='signup' method="post" action="./updateteacher"  >
		<div style="margin:5px;padding-top: 20px;padding-right:40px;"><label style="color:black;font-weight: bold;font-family: monospace;font-size: 18px;font-weight:lighter;">USERNAME : </label> <label style="color:#A23365;font-weight: bold;font-family: monospace;font-size: 20px;"><%=uname %></label></div>
			<table align="center" style="margin:3px; border-spacing: 10px;">
				<tr style='padding-bottom: 10px;'> <td><input type="hidden" name='uname' value='<%=uname%>' ></td> <td> </td> </tr>
				<tr> <td style='font-size: 20px;'>First Name:</td> <td > <input type="text" name='fname' value='<%=fname %>' pattern='[A-Za-z]{2,15}' style='text-transform: capitalize;' required placeholder="example: John"  title='Name must be start with Uppercase letter and 3 to 15 character in length'></td> </tr>
				<tr> <td style='font-size: 20px;'>SurName:</td> <td> <input type="text" name='sname' value='<%=sname %>' pattern='[A-Za-z]{2,15}' style='text-transform: capitalize;' required placeholder="example: Smith" title='Name must be start with Uppercase letter and 3 to 15 character in length'></td> </tr>
				<tr> <td style='font-size: 20px;'>Email-Id:</td> <td> <input type="email" name='email' value='<%=email %>' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length" required></td> </tr>
				<tr> <td style='font-size: 20px;'>Mobile-No:</td> <td> <input type="text" name='mobile' value='<%=mobile %>' pattern='(0|91)?[0-9]{10}'title='Ten to Twelve digit no. are allowed' placeholder="e.g. 919921XXXXXX" required></td> </tr>
				<tr> <td style='font-size: 20px;'>Birth Date:</td> <td> <input style='width:98.5%;' type="date" name='birthdate' value='<%=birthdate %>' title='Select your Birthday' required style='width:160px;'></td> </tr>
				<tr>  <td></td><td> <input type="submit" value='Update' ><input type="reset" value='Reset' style='margin-left:20px;'></td> </tr>				
		
			</table>
	
	</form>
</div>
	<div style='color:red;font-style: italic; margin:10px;padding-left: 450pt;'>Note:<%=Invalid %></div>

</body>
</html>