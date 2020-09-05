<%@page import="com.hallTicket.dao.Teacher"%>
<%@page import="com.hallTicket.dao.TeacherService"%>
<%@page import="com.hallTicket.dao.StudentService"%>
<%@page import="com.hallTicket.dao.Student"%>
<%@page import="com.hallTicket.factory.ServiceDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! String uname, fname, sname, pass1, pass2, email, mobile, birthdate;Teacher t;%>
    

<%
uname=(String)session.getAttribute("uname");
TeacherService ts=ServiceDaoFactory.getTeacherservice();
t=ts.TeacherDetails(uname);
fname=t.getFname();
sname=t.getSname();
pass1=pass2=t.getPassword();
email=t.getEmail();
mobile=t.getMobile();
birthdate=t.getBirthdate();	
session.setAttribute("uname", uname);
session.setAttribute("fname", fname);
session.setAttribute("sname", sname);
session.setAttribute("pass1", pass1);
session.setAttribute("pass2", pass2);
session.setAttribute("mobile", mobile);
session.setAttribute("email", email);
session.setAttribute("birthdate",birthdate);
	%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Teacher Details]</title>
<style type="text/css">
.labelname{
	text-transform: uppercase;
	font-size: 18px;
}
label{
	font-size: 20px;
}
.fcol{
	padding-left: 5px;
	padding-right: 5px;
}
.scol{
	padding-left: 5px;
	padding-right: 5px;
}
</style>
</head>
<body bgcolor="#9f8fba">
<div align="center" style='padding-top:20px;'>
	<table style='height:450px; color: white;' align="center" border="1">
	 <colgroup>
    <col span="2" style="background-color:red">
    <col style="background-color:yellow">
  </colgroup>
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Username:</label></td> <td class='scol'><label  style='border-bottom:1px solid #9F8FBA;' ><%=uname %></label></td></tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>First Name:</label></td><td class='scol'><label  ><%=fname %></label></td> </tr>
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Last Name:</label></td><td class='scol'><label   ><%=sname %></label></td>  </tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>Mobile No:</label></td><td class='scol'><label  ><%=mobile %></label></td> </tr>
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Email:</label></td><td class='scol'><label  ><%=email %></label></td> </tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>Birth Date:</label></td><td class='scol'><label   ><%=birthdate %></label></td> </tr>
	
	</table>
</div>
</body>
</html>
