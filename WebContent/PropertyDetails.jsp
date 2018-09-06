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
	<h2>Property Details</h2>
	<form  name="RegForm" action="savePropertyInfo"  method="Post" onsubmit="return validateform();">
		
		<table>
			<tr>
				<td class="labelform">What is the market value for your home<span class="makered">*</span></td>
				
				<td>
					<input type=text name="marketvalue" id="marketvalue">
				</td>
			</tr>
			<tr>
				<td class="labelform">Which year your home was built<span class="makered">*</span></td>
				<td>
					<input type="text" name="yearbuilt" id="yearbuilt" >
				</td>
			</tr>
			<tr>
				<td class="labelform">Square Footage<span class="makered">*</span></td>
				<td>
					<input type="text" name="squarefootage" id="squarefootage" >
				</td>
			</tr>
			
			<tr>
				<td class="labelform">Dwelling Type<span class="makered">*</span></td>
				<td>
					<select name="dwellingtype" id="dwellingtype" >
					<option value="singlestorey">Single-Storey</option>
					
					<option value="Condo">Condo</option>
					</select>
				</td>
			</tr>
			
				<tr>
				<td class="labelform">Roof Material<span class="makered">*</span></td>
				<td>
					<select name="roofmaterial" id="roofmaterial" >
					<option value="concrete">Concrete</option>
					<option value="wood">Wood</option>
					<option value="clay">Clay</option>
					<option value="rubber">Rubber</option>
					<option value="steel">Steel</option>
					<option value="tin">Tin</option>
					</select>
				</td>
			</tr>
			
			
				<tr>
				<td class="labelform">Type of Garage<span class="makered">*</span></td>
				<td>
					<select name="garagetype" id="garagetype" >
					<option value="Attached">Attached</option>
					<option value="Seperate">Seperate</option>
					<option value="Detached">Detached</option>
					<option value="Built-in">Built-in</option>
					<option value="Basement">Basement</option>
					<option value="none">None</option>
					</select>
				</td>
			</tr>
			
			
				<tr>
				<td class="labelform">Number of full baths<span class="makered">*</span></td>
				<td>
					<select name="fullbath" id="fullbath" >
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					</select>
				</td>
			</tr>
			
				<tr>
				<td class="labelform">Number of half baths<span class="makered">*</span></td>
				<td>
					<select name="halfbath" id="halfbath" >
					<option value="1">1</option>
					<option value="2">2</option>
					</select>
				</td>
			</tr>
			
			
					<tr>
						<td class="labelform">Does your property have swimming pool<span class="makered">*</span></td>
						<td><input type="radio" name="pool" id="yes" />Yes
						<input type="radio" name="pool" id="no" />No</td>
					</tr>
			
			
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Continue" name="Continue">
				</td>
			</tr>
		</table>
		
		
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
</center>
<footer>
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</footer>
</body>
</html>