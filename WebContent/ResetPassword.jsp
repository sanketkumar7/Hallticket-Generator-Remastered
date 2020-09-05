<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! String userName,userType; %>
    
    <%
    	session=request.getSession();
    	userName=(String)session.getAttribute("unameReset");
    	userType=(String)session.getAttribute("usertypeReset");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Reset Password]</title>
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
	
</style>
</head>
<body bgcolor="floralwhite">
<form method="post" action="./updatepassword">
<div style='height: 180px; background-color: #826ea1; position: relative;top:-25px;' align="center"> <h3 style='padding-top:85px;font-size: 25px;color: white;'> RESET PASSWORD</h3></div> 
	<div align="center" style='padding-top:20px;'>
		<div class='second-input' style='margin:10px'> <label for='Username:' class='label' >Username:</label>
		 <input type="text" class='inputvalue' value='<%=userName %>' name='username' disabled="disabled"  style=''> </div>
		<div style='padding-top: 5px; padding-left: 2px'> <label for='Password1Reset' class='label'>Password:</label> 
		 <input type="password" class='inputvalue' name='pass1Reset' required pattern='[a-zA-Z0-9$@#]{8,12}' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length" >
		  </div>
		  <div style='padding-top: 5px; padding-right: 94px'> <label for='Password2Reset' class='label'>Retype Password:</label> 
		 <input type="password" class='inputvalue' name='pass2Reset' pattern='[a-zA-Z0-9$@#]{8,12}' title="alphanumeric values allowed,special symbol($,@,#,) allowed and 8 to 12 character in length"  required >
		  </div>
		<div style='padding-top: 20px;padding-left:140px;'> <input type="submit" class='buttons' value='Reset Password'> 
		<button type="button" onclick="document.location='login.html'" class='buttons' style='margin-left: 10px;'>Login</button>
		</div>
		<div><h3 style='display:inline-block;padding-left: 230px;padding-top:5px;'>New Here!</h3> <a href="SignUp.html" class='register'>Register</a></div>
		
	</div>
</form>
</body>
</html>