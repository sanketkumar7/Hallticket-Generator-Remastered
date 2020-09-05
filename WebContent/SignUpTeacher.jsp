<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <%! String username, fname, sname,pass1,pass2,email,mobile,birthdate,Invalid;  %>
    
    <% session=request.getSession(false);
    if(session!=null){
    	username=(String)session.getAttribute("uname");  
    	fname=(String)session.getAttribute("fname");
    	sname=(String)session.getAttribute("sname");
    	pass1=(String)session.getAttribute("pass1");
    	pass2=(String)session.getAttribute("pass2");
    	email=(String)session.getAttribute("email");
    	mobile=(String)session.getAttribute("mobile");
    	birthdate=(String)session.getAttribute("birthdate");
    	Invalid=(String)session.getAttribute("Invalid");
    }if(username==null){
    	username=fname=sname=pass1=pass2=email=mobile=birthdate=Invalid="";
    }
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HallTicket[Teacher SignUp]</title>
<style type="text/css">
</style>
</head>
<body  bgcolor="grey" >
	<div style=' background: floralwhite; margin-left:5in;margin-right:5in; margin-bottom: 5px' align='center'>
	<h1 align="center" style='padding-top:20px;margin 5px; color:Black;'>Create your account:</h1>
	
	<form name='signup' method="post" action="./addteacher"  >
		<table align="center" style="margin: 5px; border-spacing: 15px;">
			<tr> <td>Username:</td> <td> <input type="text" name='unameTeacher' value='<%=username %>'  pattern='[a-z][a-z0-9]{2,7}' required="required" placeholder="e.g. john123" title='Username must be start with letter and 3 to 8 character in length'><span class='validity' ></span></td> </tr>
			<tr> <td>First Name:</td> <td> <input type="text" name='fnameTeacher' value='<%=fname %>' pattern='[A-Za-z]{2,14}' style='text-transform: capitalize;' required placeholder="e.g. John"  title='Name must be start with Uppercase letter and 3 to 15 character in length'><span class='validity' ></span></td> </tr>
			<tr> <td>SurName:</td> <td> <input type="text" name='snameTeacher' value='<%=sname %>' pattern='[A-Za-z]{2,14}' style='text-transform: capitalize;' required placeholder="e.g. Smith" title='Name must be start with Uppercase letter and 3 to 15 character in length'><span class='validity' ></span></td> </tr>
			<tr> <td>Password:</td> <td> <input type="text" name='password1Teacher' value='<%=pass1 %>' pattern='[a-zA-Z0-9$@#]{8,12}' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length"   required><span class='validity' title=' lowercase, Uppercase, Special Symbol($,@,#,), Numbers are allowed and 8 to 12 character in length. '></span></td> </tr>
			<tr> <td>Confirm Password:</td> <td> <input type="password" name='password2Teacher' value='<%=pass2 %>' pattern='[a-zA-Z0-9$@#]{8,12}' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length"   required><span class='validity' ></span></td> </tr>
			<tr> <td>Email-Id:</td> <td> <input type="email" name='emailTeacher' value='<%=email %>' required><span class='validity' ></span></td> </tr>
			<tr> <td>Birthdate:</td> <td> <input style='width: 121pt;' type="date" name='birthdateTeacher' value='<%=birthdate %>' required><span class='validity' ></span></td> </tr>
			<tr> <td>Mobile-No:</td> <td> <input type="text" name='mobileTeacher' value='<%=mobile %>' pattern='(0|91)?[0-9]{10}'title='Ten to Twelve digit no. are allowed' placeholder="e.g. 919921XXXXXX" required><span class='validity' ></span></td> </tr>
			<tr> <td>Master-Key:</td> <td> <input type="password" name='masterkeyTeacher' required placeholder='Enter Master Key'><span class='validity' ></span></td></tr>
			<tr>  <td></td><td> <input type="submit" value='Next' ></td> </tr>			
		</table>
		<div align="center" style='color:red;font-style: italic; margin:10px'>Note:<%=Invalid %></div>
	</form>
	</div>
	<script>
	</script>
</body>
</html>