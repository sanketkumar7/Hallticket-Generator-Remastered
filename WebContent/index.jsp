<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Login]</title>
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
<form method="post" action="./login">
<div style='height: 180px; background-color: #826ea1; position: relative;top:-25px;' align="center"> <h3 style='padding-top:85px;font-size: 25px;color: white;'> SIGN IN</h3></div> 
	<div align="center" style='padding-top:20px;'>
		<div class='second-input' style='margin:10px'> <label for='Username:' class='label' >Username:</label>
		 <input type="text" class='inputvalue' name='uname' required="required"  style=''> </div>
		<div style='padding-top: 5px; padding-left: 2px'> <label for='Password:' class='label'>Password:</label> 
		 <input type="password" class='inputvalue' name='password' required >
		  </div>
		  <div><a href="ResetPassword.html" style="margin-top: 10px;" class='forgotpass' >forgot password?</a></div>
		<div style='padding-top: 20px;padding-left:200px;'> <input type="submit" class='buttons' value='Sign In'> 
		<button type="button" onclick="document.location='login.html'" class='buttons' style='margin-left: 10px;'>Reset</button>
		</div>
		<div><h3 style='display:inline-block;padding-left: 230px;padding-top:5px;'>New Here!</h3> <a href="SignUp.html" class='register'>Register</a></div>
		
	</div>
</form>
</body>
</html>