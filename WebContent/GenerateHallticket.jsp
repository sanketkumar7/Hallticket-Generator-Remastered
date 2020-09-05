<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!String username; %>
    
    <%
    	session=request.getSession();
      String username=(String)session.getAttribute("uname");
      String fname=(String)session.getAttribute("fname");
      String sname=(String)session.getAttribute("sname");
      String rollno=(String)session.getAttribute("rollno");
      String department=(String)session.getAttribute("department");
      String year=(String)session.getAttribute("yeardetails");
      String semester=(String)session.getAttribute("semester");
      String seatno=(String)session.getAttribute("seatno");
      int count=0;

    %>
    
    <%
    	Connection con=new ConnectionFactory().getCon(); Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery("select * from hallticketdetails where department_name='"+department+"'AND (year='"+year+"' AND semester='"+semester+"') order by subject");
    %>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
  <style imput="text/css">
   .div1 {
  margin:auto;
  width: 500px;
  height: 700px;
  border: 1px solid black;
  box-sizing: border-box;
  text-transform: uppercase;
   }
   .photograph{
     width: 100px;
     height: 130px;
     border: 1px dashed black;
     box-sizing: border-box;
     float: right;
     position: relative;
     top:-15px;
     margin-right: 4%;
   }
   .studentdetails{
    position: relative;
     top:-15px;
     width:400px;
     height:180px;
     margin-left: 2%;
     
     
   }
  h3{
    text-align: center;

  }
  h4{
    text-align: center;
    position: relative;
    top:-15px;
  }
  h5{
    text-align: center;
    position: relative;
    top:-35px;
  }
  label{
    
  }
  </style>
</head>
<body bgcolor="white">
  <div class='div1'>
    
    <h3>Amrutvahini Collage Of Engineering,</h3>
    <h4>At/Post Amrutnagar, Ghulewadi,</h4>
    <h5>SANGAMNER</h5>
    <div class="photograph">
      <hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><h1>
        </div>
    <div class="studentdetails">
      <table>
        <tr><td><label>Full Name : <%=fname%> <%=sname %></label></td></tr>
        <tr><td> <label>Roll No : <%=rollno %></label></td></tr>
        <tr><td><label>Seat No : <%=seatno %> </label></td></tr>
         <tr><td><label>Academic Year : <%=year %> </label></td></tr>
        <tr><td><label>Semester : <%=semester %> </label></td><td></td></tr>
        <tr><td><label>Department : <%=department %></label></td></tr>
      </table>
    </div>
    <div align='center' style="position: relative;top: -50px;"><label>***Subject Details***</label></div>
<div style="position: relative;top: -50px; width: 500px;height:360px;">
    <hr>
    <table align="center" style="width: 98%;height: 90%;border:1px dashed black;" >
      <tr>
      	<td align="center">Sr.No.</td>
      	<td align="center" style='border:1px dashed black;border-right: none;border-bottom: none;border-top:none;'>Subject Name</td>
      	<td align="center" style='border:1px dashed black;border-right: none;border-bottom: none;border-top:none;'>Theory</td>
      	<td align="center" style='border:1px dashed black;border-right: none;border-bottom: none;border-top:none;'>Practical</td>
      	<td align="center" style='border:1px dashed black;border-right: none;border-bottom: none;border-top:none;'>Oral</td>
      </tr>
      <%while(rs.next()){String tempCol;%>
			<tr>
				<td align="center" style='border:1px dashed black;border-right: none;border-bottom: none;border-left:none;'><%= ++count %></td>
				<td style='padding-left: 20px;border:1px dashed black;border-right: none;border-bottom: none;'><label><%tempCol=rs.getString(4);%><%=tempCol %></label></td>
				<td align="center"style='border:1px dashed black;border-right: none;border-bottom: none;'><label><%if(rs.getString(5).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
				<td align="center"style='border:1px dashed black;border-right: none;border-bottom: none;'><label><%if(rs.getString(6).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
				<td align="center"style='border:1px dashed black;border-right: none;border-bottom: none;'><label><%if(rs.getString(7).equals("yes")) tempCol="&#x2714";else tempCol="&#x2718;"; %><%=tempCol %></label></td>
			</tr>
			<% } %>
		
    </table>
<hr>
</div>
<div align="center"style="position: relative;top: -50px;"><label>All the best !!!</label></div>
  </div>
 

</body>
</html>