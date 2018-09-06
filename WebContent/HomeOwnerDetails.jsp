<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />
<script type="text/javascript">
		function validateform() {
			
			var regex = new RegExp("^([a-zA-Z0-9\s]){1,30}$");
			var fname = document.getElementById("fname").value;
			var userValid = regex.test(username);
			var err =  [];
			var flag=false;
			if(userValid != true) {
				err.push("FirstName - Enter only alphanumeric & length less than 30 characters");
				err.push("<br>")
				flag=true;
			}
			
			var lname = document.getElementById("lname").value;
			var lnameValid = regex.test(lname);
			if(lnameValid != true) {
				err.push("LasttName - Enter only alphanumeric & length less than 30 characters");
				err.push("<br>")
				flag=true;
			}
			
			var regexssn = new RegExp("^([0-9]){8,8}$");
			var ssn = document.getElementById("ssn").value;
	
			var ssnValid = regex.test(regexssn);
			if(ssnValid != true) {
				err.push("SSN - Enter only numbers less than 9 characters")
				err.push("<br>")
				flag=true;
			}

			if(password != password_confirm) {
				err.push("Password & Confirm Password doesn't match");
				err.push("<br>")
				flag=true;
			}
			if(flag) {
				document.getElementById("errors").innerHTML=err;
				return false;
			}else{
				return true;
			}			
		};
</script>


</head>
<body>
	<header>
	<h2>Homeowner Insurance</h2>
	<div class="aligncenter">
			<a href="Home.jsp">Home</a>
			<span>|</span>
			<a href="GetQuote.jsp">Get Quote</a>
			<span>|</span>
			<a href="/retrievequote">Retrieve Quote</a>
			<span>|</span>
			<a href="./MyPolicies">My Policies</a>
			<span>|</span>
			<a href="LoginPage.jsp">Logout</a>
			<span>|</span>
	</div>
	<hr>
	</header>
		<div class="aligncenter">
		<h2>HomeOwner Information</h2>
	</div>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 5%;">
			<form name="loginform" id="loginform" method="post"
				action="saveHomeOwnerInfo" onsubmit="return validateform();">

				<table>
					<tr>
						<td>First Name<span class="makered">*</span></td>
						<td><input type="text" name="fname" id="fname" required="required" /></td>
					</tr>
					
					<tr>
						<td>Last Name<span class="makered">*</span></td>
						<td><input type="text" name="lname" id="lname" required="required" /></td>
					</tr>
					
					<tr>
						<td>Date of Birth<span class="makered">*</span></td>
						<td><input type="text" name="dob" id="dob"  placeholder="yyyy-mm-dd" required="required"/></td>
					</tr>
					
					<tr>
						<td>Are you Retired<span class="makered">*</span></td>
						<td ><input type="radio" name="retired" id="yes" />Yes
						<input type="radio" name="retired" id="no" />No</td>
					</tr>

					<tr>
						<td>Social Security Number<span class="makered">*</span></td>
						<td><input type="text" name="ssn" id="ssn" placeholder="enter 9 digits for ssn" required="required"/></td>
					</tr>
					
					<tr>
						<td>Email Address<span class="makered">*</span></td>
						<td><input type="email" name="email" id="email" required="required"/></td>
					</tr>
					
							
					<tr>
						<td></td>
						<td><input style="font-family: Garamond;" type="submit"
							onsubmit="return validateform();" value="Continue" /></td>
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