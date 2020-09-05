<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hallTicket.factory.ConnectionFactory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    <%! String username, fname, sname,pass1,pass2,email,mobile,rollno,birthdate,Invalid; Connection con;Statement st; ResultSet rs; HashSet<String> hs; Iterator values;  %>
    <% 
    session=request.getSession();
    if(session!=null){
    	username=(String)session.getAttribute("unameSignup");
    	fname=(String)session.getAttribute("fnameSignup");
    	sname=(String)session.getAttribute("snameSignup");
    	pass1=(String)session.getAttribute("pass1Signup");
    	pass2=(String)session.getAttribute("pass2Signup");
    	email=(String)session.getAttribute("emailSignup");
    	mobile=(String)session.getAttribute("mobileSignup");  	
    	rollno=(String)session.getAttribute("rollnoSignup");  	
    	birthdate=(String)session.getAttribute("birthdateSignup");  	
    	Invalid=(String)session.getAttribute("InvalidSignup");
    }if(username==null){
    	username=fname=sname=pass1=pass2=email=mobile=rollno=birthdate=Invalid="";
    }
    %>
    <% ConnectionFactory connectionFactory=new ConnectionFactory(); 
		con=connectionFactory.getCon();
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
<meta charset="UTF-8">
<title>HallTicket[Student SignUp]</title>
<style type="text/css">
</style>
</head>
<body  bgcolor="grey" >
	<div style=' background: floralwhite; margin-left:5in;margin-right:5in; margin-bottom: 5px' align='center'>
	<h1 align="center" style='padding-top:20px;margin 5px; color:Black;'>Create your account:</h1>
	
	<form name='signup' method="post" action="./addstudent"  >
		<table align="center" style="margin: 5px; border-spacing: 15px;">
			<tr> <td>Username:</td> <td> <input type="text" name='uname' value='<%=username %>'  pattern='[a-z][a-z0-9]{2,7}' required="required" placeholder="e.g. john123" title='Username must be start with letter and 3 to 8 character in length'></td> </tr>
			<tr> <td>First Name:</td> <td> <input type="text" name='fname' value='<%=fname %>' pattern='[A-Za-z]{2,15}' style='text-transform: capitalize;' required placeholder="example: John"  title='Name must be start with Uppercase letter and 3 to 15 character in length'></td> </tr>
			<tr> <td>SurName:</td> <td> <input type="text" name='sname' value='<%=sname %>' pattern='[A-Za-z]{2,15}' style='text-transform: capitalize;' required placeholder="example: Smith" title='Name must be start with Uppercase letter and 3 to 15 character in length'></td> </tr>
			<tr> <td>Password:</td> <td> <input type="text" name='password1' value='<%=pass1 %>' pattern='[a-zA-Z0-9$@#]{8,12}' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length"   required><span class='validity' title=' lowercase, Uppercase, Special Symbol($,@,#,), Numbers are allowed and 8 to 12 character in length. '></span></td> </tr>
			<tr> <td>Confirm Password:</td> <td> <input type="password" name='password2' value='<%=pass2 %>' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length"  pattern='[a-zA-Z0-9$@#]{8,12}'  required></td> </tr>
			<tr> <td>Email-Id:</td> <td> <input type="email" name='email' value='<%=email %>' required></td> </tr>
			<tr> <td>Mobile-No:</td> <td> <input type="text" name='mobile' value='<%=mobile %>' pattern='(0|91)?[0-9]{10}'title='Ten to Twelve digit no. are allowed' placeholder="e.g. 919921XXXXXX" required></td> </tr>
			<tr> <td>Roll No:</td> <td> <input type="text" name='rollno' value='<%=rollno %>' pattern='([0-9]{3}'title='Enter Your Roll No in Digit' placeholder="e.g. 01" required></td> </tr>
			<tr> <td>Birth Date:</td> <td> <input type="date" name='birthdate' value='<%=birthdate %>' title='Select your Birthday' required style='width:160px;'></td> </tr>
			
				<td>Department Name</td><td>
					<select name="department">
						<% for(String DepartmentValue:hs){ %>
							<option <c:set var="temp" value="<%=DepartmentValue%>"/><c:if test='${sessionScope["department"]==temp}'><c:out  value="selected"/></c:if>>			
							<%=DepartmentValue %>
							</option>
						<% ;} %>
					</select>
				</td>
			</tr>
			<tr><td>Academic Year :</td> <td> <select name='yeardetails' style='width:165px;'><option >First Year</option><option <c:if test='${sessionScope["yeardetails"]=="Second Year" }'><c:out  value="selected"/></c:if> >Second Year</option><option <c:if test='${sessionScope["yeardetails"]=="Third Year" }'><c:out  value="selected"/></c:if>>Third Year</option><option <c:if test='${sessionScope["yeardetails"]=="Fourth Year" }'><c:out  value="selected"/></c:if>>Fourth Year</option></select></td> </tr>
			<tr><td>Semester</td> <td><select name='semester' style='width:165px;'><option >First Semester</option><option <c:if test='${sessionScope.Semester=="Second Semester"}'><c:out  value="selected"/></c:if>>Second Semester</option></select> </td> </tr>
			
			<tr>  <td></td><td> <input type="submit" value='Register' ><input type="reset" value='Reset' style='margin-left:20px;'></td> </tr>				
		</table>
		<div align="center" style='color:red;font-style: italic; margin:10px'>Note:<%=Invalid %></div>
	 <c:set var='firstname' scope="application" value='${param.fname}'/>
	
	</form>
	</div>
	<script>
	</script>
</body>
</html>