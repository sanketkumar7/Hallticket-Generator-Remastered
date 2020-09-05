	<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%! String department,year,semester;Connection con;Statement st; ResultSet rs; %>
	
	<%
		session=request.getSession();
		department=((String)session.getAttribute("department")).trim();
		year=(String)session.getAttribute("yeardetails");
		semester=(String)session.getAttribute("semester");
		int count=0;
	%>
	<%
	con=new ConnectionFactory().getCon();
	st=con.createStatement();
	rs=st.executeQuery("select * from hallticketdetails where department_name='"+department+"' AND (year='"+year+"' AND semester='"+semester+"') order by subject");
	
		
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
	.checkboxes{
		width:50%;height:50%;font-size:20px; position: relative;
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

.no-click {
   width: 100%;
	height:100%;
	font-family: monospace;
	font-size: 15px;
	background:#ffd5cd;
	border: none;
	pointerEvent:none;
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
<form method="post" action="./deletehallticket2">
	<div> <marquee style='background: #EA8FA9;'><h3 style="color=#C4EC52;position:relative;top:-5px;">Department Name: <%=department%>, Year: <%=year%>, Semester: <%=semester %>  </h3></marquee> </div>
	<div align="center" style='padding-top:20px;'>
	<table Style="padding-bottom: 10px;margin-top:10px;width:50%;position: relative;top:-25px;border: 2px solid black;" >
		<thead>	
			<tr align="center" style='background: #E2D5CC;width: 100%'>
				<td>Sr.No.</td>
				<td>Subject Name</td>
				<td>Theory</td>
				<td>Practical</td>
				<td style='padding:0 10px;'>Oral</td>
			</tr>
		</thead>
		<tbody>
		<%while(rs.next()){String tempCol;%>
			<tr>
				<td align="center"><%= ++count %></td>
				<td style='padding-left: 20px;'><label><%tempCol=rs.getString(4);%><%=tempCol %></label></td>
				<td align="center"><label><%if(rs.getString(5).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
				<td align="center"><label><%if(rs.getString(6).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
				<td align="center"><label><%if(rs.getString(7).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
			</tr>
			<% } %>
		</tbody>
		
	</table>
	<button class='buttons' type="submit" name='action' value='Delete Permanently' style='margin-left: 10px; width:20%'>Delete Permanently </button>
	<button type="submit" class='buttons' name='action' value='cancel' style='margin-left: 10px;'>Cancel</button>
	</div>
</form>
</body>
</html>