<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />

<script type="text/javascript">
	function validateform() {
		
		var regex = new RegExp("^([a-zA-Z0-9]){1,20}$");
		var username = document.getElementById("username").value;
		var isvalid = regex.test(username);
		
		if(isvalid != true) {
			alert("User can't be blank");
		}
		var password = document.getElementById("password").value;

		if (username == "" || password == "") {
			alert("User can't be blank");
			return false;
		}
		/* else if (password.length <=5) {
			alert("Password must be at least 8 characters long.");
			return false;
		} */
		return true;
	};
</script>

</head>
<body>
	<header>
	<h2>Homeowner Insurance</h2>
	<div>
		<center>
			<a name="home" href="AdminScreen.jsp">Home</a>
			<span>|</span>
			<a name="logout" href="LoginPage.jsp">Logout</a>
			<span>|</span>
		</center>
	</div>
	<hr>
	</header>
	<center>
		<h2>Admin Screen</h2>
	</center>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 5%;">
			<form name="loginform" id="loginform" method="post"
				action="./MyPolicies" onsubmit="return validateform();">

				<table>
					<tr>
						<td>Search User</td>
						<td>
						<input required type="text" name="username" id="username" /></td>
					</tr>
					
					
							
					<tr>
						<td></td>
						<td><input style="font-family: Garamond;" type="submit"
							onsubmit="return validateform();" value="Submit" /></td>
					</tr>
				</table>
			</form>
		</article>
	</section>



<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>