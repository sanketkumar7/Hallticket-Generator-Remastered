<%@page import="com.hallTicket.dao.StudentService"%>
<%@page import="com.hallTicket.dao.Student"%>
<%@page import="com.hallTicket.factory.ServiceDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! String uname, fname, sname, pass1, pass2, email, mobile, rollno, birthdate, department, year, semester,status,seatno;Student std;%>
<%
uname=(String)session.getAttribute("uname");
StudentService sos=ServiceDaoFactory.getStudentservice();
std=sos.StudentDetails(uname);
fname=std.getFname();
sname=std.getSname();
pass1=pass2=std.getPassword();
email=std.getEmail();
mobile=std.getMobile();
rollno=std.getRollno();
birthdate=std.getBirthdate();
department=std.getDepartment();
year=std.getYear();
semester=std.getSemester();
status=std.getStatus();
seatno=std.getSeatno();
	
session.setAttribute("uname", uname);
session.setAttribute("fname", fname);
session.setAttribute("sname", sname);
session.setAttribute("pass1", pass1);
session.setAttribute("pass2", pass2);
session.setAttribute("mobile", mobile);
session.setAttribute("email", email);
session.setAttribute("birthdate",birthdate);
session.setAttribute("rollno", rollno);
session.setAttribute("department",department);
session.setAttribute("yeardetails",year);
session.setAttribute("semester",semester);	

	%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Student Details]</title>
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
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Roll No:</label></td><td class='scol'><label   ><%=rollno %></label></td> </tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>Department Name:</label></td><td class='scol'><label   ><%=department %></label></td> </tr>
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Year:</label></td><td class='scol'><label ><%=year %></label></td> </tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>Semester:</label></td><td class='scol'><label ><%=semester %></label></td> </tr>
	<tr style="background-color:#563966"><td class='fcol'> <label class='labelname'>Status:</label></td><td class='scol'><label ><%=status %></label></td> </tr>
	<tr style="background-color:#654165"><td class='fcol'> <label class='labelname'>Seat no:</label></td><td class='scol'><label ><%=seatno %></label></td> </tr>
	
	</table>
</div>
</body>
</html>