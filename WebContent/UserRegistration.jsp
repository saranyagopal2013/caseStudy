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
			
			var regex = new RegExp("^([a-zA-Z0-9]){8,20}$");
			var username = document.getElementById("username").value;
			var userValid = regex.test(username);
			var err =  [];
			var flag=false;
			if(userValid != true) {
				err.push("UserName - Enter only alphanumeric & length atleast 8 and less than 20 characters");
				err.push("<br>")
				flag=true;
			}
			
			var password = document.getElementById("password").value;
			var pwdValid = regex.test(password);
			if(pwdValid != true) {
				
				err.push("Password - Enter only alphanumeric & length atleast 8 and less than 20 characters")
				err.push("<br>")
				flag=true;
			}
			
			var password_confirm = document.getElementById("password_confirm").value;
	
			var cpwdValid = regex.test(password_confirm);
			if(cpwdValid != true) {
				err.push("Confirm Password - Enter only alphanumeric & length less than 20 characters")
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
  <hr>
</header>


<div class="aligncenter">	
	<h2>User Details</h2>
	<h3>Note:Password must be at least 8 characters with numbers and characters</h3>
	<form  name="RegForm" action="NewUserRegisterServlet"  method="Post" onsubmit="return validateform();">
		
		<table>
			<tr>
				<td class="labelform">User id<span class="makered">*</span></td>
				
				<td>
					<input required type=text name="regname" id="username">
				</td>
			</tr>
			<tr>
				<td class="labelform">Password<span class="makered">*</span></td>
				<td>
					<input  required type="password" name="regpassword" id="password" >
				</td>
			</tr>
			<tr>
				<td class="labelform">Re-enter Password<span class="makered">*</span></td>
				<td>
					<input required type="password" name="password_confirm" id="password_confirm" >
				</td>
			</tr>
					
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Register" name="Register">
				</td>
			</tr>
			
		</table>
		
		<div class="makered" id ="errors">
			
			</div>
		
		
		<!-- <div>
			<label class="labelform" for="name">User id</label>
			<input name="regname" id="name">
			
		</div>
		
		<div>
			<label class="labelform" >Password</label>
			<input type="password" name="regpassword" id="password" >
			
		</div>
		<div>
			<label>Re-enter Password:</label>
			<input type="password" name="password_confirm" id="password_confirm" >
			
		</div>
		<div>
			<input type="submit" value="Login" name="Login">
			
		</div> -->
	</form>
</div>
<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>