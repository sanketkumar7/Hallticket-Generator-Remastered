<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
 
 <%! Connection con;Statement st; ResultSet rs; String order,department,year;%> 
 	<%	
 	session=request.getSession();
 	department=(String)session.getAttribute("department");
 	year=(String)session.getAttribute("yeardetails");
 	order=(String)session.getAttribute("order");
 	if(order==null||order.equals("")) order="fname";
 	con=new ConnectionFactory().getCon();
 	st=con.createStatement();
 	rs=st.executeQuery("select * from student where Department_name='"+department+"' AND year='"+year+"' order by "+order+"");
 	%>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Verify Student]</title>
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
.no-click {
   width: 100%;
	height:100%;
	font-family: monospace;
	font-size: 18px;
	border: none;
	font-weight: bold;
}
td{
padding: 0px;
background: #563966 ;
color: white;
height: 40px;
font-size: 15px;
white-space:pre-wrap; 
word-wrap:break-word;
align-self: center;

}
.tbutton{ 
	width: 100%;
	height:100%;
	font-family: monospace;
	font-size: 15px;
	background:#ffd5cd;
	border-radius: 
	
	
	}
.tbutton:hover {
	background: #d3c09a;
	color: white;
	border:1px #776d8a;
}
	
</style>
</head>
<body bgcolor="#9F8FBA">
<form method="post" action="./verifystudent">
	<div> <marquee style='background: #EA8FA9;'><h3 style="color=#C4EC52;position:relative;top:-5px;"><%=department%>:<%=year%> </h3></marquee> </div>
	<div align="center" style='padding-top:20px;'>
	<table Style="padding-bottom: 10px;width:100%;position: relative;top:-25px;"border="2" >	
			<tr align="center" style='background: #E2D5CC;width: 100%'>
				<td><button class='tbutton'  type="submit" name='action' value='username'>Username</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='fname'>First Name</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='surname'>Last Name</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='rollno'>Roll No.</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='mobile'>Mobile No.</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='email'>Email Address</button></td>
				<td><button class='tbutton'  type="submit" name='action'  value='birthdate'>Birthdate</button></td>
		<!--  	<td><button class='tbutton'  type="submit" name='action' value='Department_name'>Department</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='year'>Year</button></td> -->
				<td><button class='tbutton'  type="submit" name='action' value='semester'>Semester</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='seatno'>Seat No.</button></td>
				<td><button class='tbutton'  type="submit" name='action' value='status'>Status</button></td>
				<td bgcolor="#ffd5cd"><label class='no-click'>Approve</label></td>
				<td bgcolor="#ffd5cd"><label class='no-click'>disapprove</label></td>
			<!--  <td><button class='no-click' input type="disable" name='action' >Not Verify</td>-->
			</tr>
		<%while(rs.next()){ String tempCol="";%>
			
			<tr>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(1); %><%=tempCol %></td> <c:set var="user" value="<%=tempCol%>"></c:set>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(2); %><%=tempCol %></td>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(3); %><%=tempCol %></td>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(7); %><%=tempCol %></td>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(5); %><%=tempCol %></td>
				<td style='padding-left: 5px;'><%tempCol=rs.getString(6); %><%=tempCol %></td>
			 	<td style='padding-left: 5px;'><%tempCol=rs.getString(8); %><%=tempCol %></td>
		<!--	<td><%tempCol=rs.getString(9); %><%=tempCol %></td>
				<td><%tempCol=rs.getString(10); %><%=tempCol %></td>  -->	
				<td style='padding-left: 5px;'><%tempCol=rs.getString(11); %><%=tempCol %></td>  
				<td style='padding-left: 5px;'><%tempCol=rs.getString(12); %><%=tempCol %></td>
				<td align="center"><%tempCol=rs.getString(13); %><%=tempCol %></td>	
				 <c:set var="status" value="<%=tempCol%>" scope="page"/>
				 <c:choose>
				 	<c:when test="${status=='Approved'}"><c:set var="inputtype1" value="display: none;visibility: hidden;opacity: 0;"/></c:when>
				 	<c:otherwise><c:set var="inputtype1" value=""/></c:otherwise>
				 </c:choose>
				<td><div align="center"><input type='checkbox' name='checkpositivestatus' value='<c:out value="${user}"/>' style='<c:out value="${inputtype1}"/>'></div></td>
				 <c:choose>
				 	<c:when test="${status=='Approved'}"><c:set var="inputtype2" value=""/></c:when>
				 	<c:otherwise><c:set var="inputtype2" value="display: none;visibility: hidden;opacity: 0;"/></c:otherwise>
				 </c:choose>
				<td><div align="center"><input type='checkbox' name='checknegativestatus' value='<c:out value="${user}"/>' style='<c:out value="${inputtype2}"/>'></div></td>
			</tr>
			<% } %>
		
	</table>
		
		<button class='buttons' type="submit" name='action' value='verify' style='margin-left: 10px;width: 20%;'>Submit</button>
			
	</div>
</form>
</body>
</html>