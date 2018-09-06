<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript">

		$(function() {
			 var dtToday = new Date();
			 dtToday.setDate(dtToday.getDate() + 60);

			  var month = dtToday.getMonth() + 1;     // getMonth() is zero-based
			  var day = dtToday.getDate();
			  var year = dtToday.getFullYear();
			  if(month < 10)
			      month = '0' + month.toString();
			  if(day < 10)
			      day = '0' + day.toString();

			  var maxDate = year + '-' + month + '-' + day;
			  
			  $('#startDate').attr('max', maxDate);
			  
			  dtToday = new Date();

				  var month = dtToday.getMonth() + 1;     // getMonth() is zero-based
				  var day = dtToday.getDate();
				  var year = dtToday.getFullYear();
				  if(month < 10)
				      month = '0' + month.toString();
				  if(day < 10)
				      day = '0' + day.toString();

				  var minDate = year + '-' + month + '-' + day;
				  
				  $('#startDate').attr('min', minDate);

			  
		});
</script>
</head>
<body>
<header>
  <h2>Homeowner Insurance</h2>
  <hr>
</header>


<div class="aligncenter">	
	<h2>Buy Policy</h2>
	<form  name="RegForm" action="PolicyConfirmation"  method="Post" onsubmit="return validateform();">
		
		<table>
			<tbody>
			<tr>
				<td>QuoteId:</td>
			</tr>
			<tr>
				<td>Note: Policy State Date cannot be more than 60 days</td>
			</tr>
			
			<tr>
				<td>Enter Policy Date
				<input type="text" name="startDate" id="startDate">
				<span>yyyy-MM-dd</span>
				</td>
			</tr>
			
				<tr>
				<td>
				<a href="terms.jsp" target="_blank">Please click and read terms and conitions before buying the policy</a>
				
				</td>
			</tr>
			
			
				<tr>
				<td>
				<input type="checkbox" >This is to acknowledge that i have read the terms and conditions of the policy
				
				</td>
			</tr>
			
			<tr>
						<td align="center"><input  style="font-family: Garamond;" type="submit" enabled="enabled"
							onsubmit="return validateform();" value="Submit" /></td>
			</tr>
			
			
			</tbody>
		</table>
		
		
	
	</form>
</div>

<div class="footer">
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>