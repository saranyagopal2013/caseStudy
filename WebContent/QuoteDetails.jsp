<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />

<script type="text/javascript">
		function validateform() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var password_confirm = document.getElementById("password_confirm").value;
	
			if (username == null || password == null) {
				alert("User/Password can't be blank");
				return false;
			}
			if (password.length <= 8) {
				alert("Password must be at least 8 characters long.");
				return false;
			}
			if(password != password_confirm) {
				alert("Password doesn't match");
				return false;
			}
			return true;
		};
</script>
</head>
<body>
<header>
  <h2>Homeowner Insurance</h2>
  <hr>
</header>


<center>	
	<h2>Quote Details</h2>
	
		
		<table border="1">
			<thead>
			<tr>
			     <th>QuoteId</th>
			     <th>Residence Type</th>
			     <th>Address</th>
			     <th>City</th>
			     <th>State</th>
			     <th>Zip</th>
			     <th>Residence Use</th>
			     <th>Status</th>
			     <th>Rest of Information</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td>${quoteId}</td>
			<td>${type}</td>
			<td>${addressline1}</td>
			<td>${city}</td>
			<td>${state}</td>
			<td>${zip}</td>
			<td>${use}</td>
			<td>new</td>
			<td align="center">
				<a name="summary" href="QuoteSummary" >Click</a>
			
			</td>
			</tr>
			</tbody>
			
			
		</table>
		
		
	
</center>

<div class="footer">
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>