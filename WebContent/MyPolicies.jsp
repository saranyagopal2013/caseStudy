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
  <div>
		<center>
			<a href="Home.jsp">Home</a>
			<span>|</span>
			<a href="LoginPage.jsp">Logout</a>
			<span>|</span>
		</center>
	</div>
	<hr>
	
</header>


<center>	
	<h2>user Policies</h2>
	<form  name="RegForm" action=""  method="Post" onsubmit="return validateform();">
		
		<table border="1">
			<thead>
			<tr>
			     <th>Policy Key</th>
			     <th>Quote Id</th>
			     <th>Policy Effective Date</th>
			     <th>Policy End Date</th>
			     <th>Policy Term</th>
			     <th>Policy Status</th>
			     <th>Renew Policy</th>
			     <th>Cancel Policy</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td> ${policyKey}</td>
			<td>${quoteId}</td>
			<td> ${startDate}</td>
			<td> ${endDate}</td>
			<td> ${term}</td>
			<td>${status}</td>
			
			
			
		
			</tr>
			</tbody>
			
			
		</table>
		
		
	
	</form>
</center>

<div class="footer">
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>

</html>