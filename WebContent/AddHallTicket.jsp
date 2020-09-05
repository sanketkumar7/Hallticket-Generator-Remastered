
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hallticket [Add Hallticket]</title>
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
	text-transform:uppercase;
	
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
<body bgcolor="9f8fba">
<form method="post" action="./addhallticket">
	<div align="center" style='padding-top:20px;'>
		<div class='second-input' style='margin:10px'> <label for='Department' class='label' >Department Name:</label>
		 <input type="text" class='inputvalue' name='department' required pattern='[a-zA-Z \s]{3,30}' title='Only alphabets are allowed and 3 to 30 in length.'> </div>
		<div style='padding-top: 5px; padding-left: 152px;'> <label for='Year' class='label'>Year:</label> 
		 <select name='yeardetails' style='width:255px;font-size: 20px;'><option >First Year</option><option <c:if test='${sessionScope["YearDetails"]=="Second Year" }'><c:out  value="selected"/></c:if> > Second Year</option><option <c:if test='${sessionScope["YearDetails"]=="Third Year" }'><c:out  value="selected"/></c:if>>Third Year</option><option <c:if test='${sessionScope["YearDetails"]=="Fourth Year" }'><c:out  value="selected"/></c:if>>Fourth Year</option></select>
		  </div>
		  <div style='margin:10px;padding-top: 5px; padding-left: 97px'> <label for='Semester' class='label'>Semester:</label> 
		 <select name='semester' style='width:255px;font-size:20px'><option >First Semester</option><option <c:if test='${sessionScope.Semester=="Second Semester"}'><c:out  value="selected"/></c:if>> Second Semester</option></select>
		  </div>
		  <div class='second-input' style='margin:10px;padding-left:27px;'> <label for='noofsub' class='label' >No of Subject:</label>
		 <input type="text" class='inputvalue' name='noofsub' required="required" pattern='[123456789]{1}' title='maximum subject allowed 9.'> </div>
		<div style='padding-top: 20px;padding-left:200px;'> <input type="submit" class='buttons' value='Add Hallticket'> 
		<button type="Reset" class='buttons' style='margin-left: 10px;'>Reset</button>
		</div>	
	</div>
</form>
</body>
</html>