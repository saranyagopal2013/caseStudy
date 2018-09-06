<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home Insurance Company</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<hr>
	</header>

	<section>
		<nav>
			<p align="left">Home insurance, also commonly called Hazard
				Insurance or homeowner's insurance, is a type of property insurance
				that covers a private residence, such as a condominium or renters'
				insurance or home or multiple unit buildings.</p>
			<p align="left">It is an insurance policy that combines various
				personal insurance protections, which can include losses occuring to
				one's home, its contents, loss of use (additional living expenses),
				or loss of other personal possessions of the homeowner, as well as
				liability insurances for accidents that may happen at the home or at
				the hands of the homeowner within the policy territory. If a home
				does not meet the underwriting guidelines of a standard homeowners
				policy, the residence could qualify for a limited coverage dwelling
				policy.</p>
		</nav>

		<article>
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1"
				title="source: imgur.com" align="center" align="right"
				style="width: 300px;" />


			<h2 style="color: red">
				<%
					if (null != request.getAttribute("errorMessage")) {
						out.println(request.getAttribute("errorMessage"));
					}
				%>
			</h2>

			<form name="loginform" id="loginform" method="post"
				action="LoginServlet" onsubmit="return validateform();">

				<table>
					<tr>
						<td>User id</td>
						<td><input required type="text" name="username" id="username" /></td>
					</tr>

					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password" /></td>
					</tr>

					<tr>
						<td></td>
						<td><input style="font-family: Garamond;" type="submit"
							onsubmit="return validateform();" value="Login" /></td>
					</tr>
				</table>
			</form>
			<br> New User?<a id="new" href="UserRegistration.jsp"> Register Here</a>
		</article>
	</section>

<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>

</body>
</html>
