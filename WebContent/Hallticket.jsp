<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Operation]</title>
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
<body bgcolor="#9f8fba">
<form method="post" action="./hallticket">
	<div align="center" style='padding-top:20px;'>
		<button type="submit" class='buttons' name='action' value='addHallticket' style='margin-left: 10px;'>Add Hallticket</button>		 
		<button type="submit" class='buttons' name='action' value='showHallticket' style= 'margin-left: 10px;'>Show Hallticket</button>
		<button type="submit" class='buttons' name='action' value='editHallticket' style= 'margin-left: 10px;'>Edit Hallticket</button>
		<button type="submit" class='buttons' name='action' value='deleteHallticket' style= 'margin-left: 10px;'>Delete Hallticket</button>
	</div>			
	</div>
</form>
</body>
</html>