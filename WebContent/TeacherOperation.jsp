<%@page import="com.hallTicket.dao.Student"%>
<%@page import="com.hallTicket.factory.ServiceDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%
    	Name=session.getAttribute("fname")+" "+session.getAttribute("sname");
    %>
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    if(session.getAttribute("active")==null)
        request.getRequestDispatcher("login.html").forward(request, response);
    %>
    <%!String Name; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Teacher]</title>
<style type="text/css">
body,html {
	margin: 0;
    padding: 0;
    border: 0;
    line-height:0;
     outline: 0;
    font-size: 100%;
    vertical-align: baseline;
    position: relative;
	top:-10px;
}
.upperdiv{
	background: #826ea1;
	font-size: 20px;
	height: 150px;
}
.clickbutton2{
	font-size: 20px;
	border-style: solid;
	margin-left: 10px;	
	cursor: url("go to details");
	background:#f7b360;
	color: black;
	margin-top: 10px;
}
.clickbutton1{
	font-size: 20px;
	border-style: solid;
	margin-left: 10px;	
	cursor: url("go to details");
	background:white;
	color: black;
	margin-top: 10px;
}
.lowerdiv{
	align-content: left;
	padding-left:100px;
	background:#df6589;
	height:50px;
	

}
.clickbutton1:hover {
	border-color: red;
	background: black;
	color: white;
}
.clickbutton2:hover {
	border-color: maroon;
	background: black;
	color: white; 
}

</style>
</head>
<body>

<form  method="post" action="./teacheroperation">

<div class="upperdiv">
	<h3 align="center" style='padding-top:75px;font-size: 20px; color: white' >Welcome Prof. <%=Name %></h3>
	<button class='clickbutton1' type="submit" name='action' value='signout' style="float: right; margin-right:15px; "> Signout</button> 
</div>
<div class='lowerdiv'>
	<button class='clickbutton2' type="submit" name='action' value='editDetails'>Edit Details</button> 
	<button class='clickbutton2' type="submit" name='action' value='showDetails'>Show Details</button> 
	<button class='clickbutton2' type="submit" name='action' value='Hallticket'>Hallticket</button>
	<button class='clickbutton2' type="submit" name='action' value='verifyStudents'> Verify Students</button>	
		
</div>

</form>

</body>
</html>