<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Quote</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />



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
		<h2>Get Quote</h2>
	</div>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 5%;">
			<form name="loginform" id="loginform" method="post"
				action="saveLocationInfo" onsubmit="return validateform();">

				<table>
					<tr>
						<td>Residence Type<span class="makered">*</span></td>
						<td >
						<select required  name="residenceType" id="residenceType">
							  <option value="">Select</option>
							  <option value="singel">Single-Family Home</option>
							  <option value="Condo">Condo</option>
							   <option value="Townhouse">Townhouse</option>
							  <option value="Rowhouse">Rowhouse</option>
							   <option value="Duplex">Duplex</option>
							  <option value="Apartment">Apartment</option>
							</select>
						</td>
					</tr>

					<tr>
						<td>Address Line 1<span class="makered">*</span></td>
						<td><input required type="text" name="Address_Line_1" id="Address_Line_1" /></td>
					</tr>
					
					<tr>
						<td>Address Line 2<span class="makered">*</span></td>
						<td><input required type="text" name="Address_Line_2" id="Address_Line_2" /></td>
					</tr>
					
					<tr>
						<td>State<span class="makered">*</span></td>
						<td><input  required type="text" name="state" id="state" /></td>
					</tr>
					
					<tr>
						<td>City<span class="makered">*</span></td>
						<td><input required type="text" name="city" id="city" /></td>
					</tr>

					<tr>
						<td>Zip<span class="makered">*</span></td>
						<td><input required type="text" name="zipcode" id="zipcode" /></td>
					</tr>
					
					<tr>
						<td>Residence Use<span class="makered">*</span></td>
						<td>
						<select required name="ResidentUse" id="ResidentUse">
						 <option value="">Select</option>
							  <option value="Primary">Primary</option>
							  <option value="Secondary">Secondary</option>
							  <option value="Rental">Rental Property</option>
							</select>
						</td>
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