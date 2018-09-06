<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" type="text/css" href="./Static/css/style.css" />



</head>
<body>
	<header>
	<h2>Homeowner Insurance</h2>
	<div>
		<center>
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
		</center>
	</div>
	<hr>
	</header>
	<center>
		<h2>Coverage Details</h2>
	</center>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 3%;">
			<form name="loginform" id="loginform" method="post"
				action="QuoteDetails" onsubmit="return validateform();">
				
				<table>
					<tr>
						<td></td>
						<td>
						<a id="addinfo" style = "text-decoration: underline;font-size:20px"href="AdditionalInfo.jsp">Additional Info</a>
						</td>
					</tr>
					<tr>
						<td>Quote Id</td>
						<td name="quoteId">${quoteId}
						
						</td>
						
					</tr>
					
					<tr>
						<td>Monthly Premium:</td>
						<td name="monthlyPremium" >$${monthlyPremium}
						
						</td>
					</tr>
					
					
					<tr>
						<td>Dwelling Coverages</td>
						<td name="coverage" id="coverage" >$${coverage}</td>
					</tr>
					
					
					
					<tr>
						<td>Detached Structures</td>
						<td name="detacheStructure" id="detacheStructure">$${detacheStructure}</td>
					</tr>
					
					<tr>
						<td>Personal Property</td>
						<td name="personalProperty" id="personalProperty">$${personalProperty}</td>
					</tr>
					
					<tr>
						<td>Additional Living Expenses</td>
						<td name="living" id="living">$${living}</td>
					</tr>
					
					
					<tr>
						<td>Medical Expense</td>
						<td name="medicalExpense" id="medicalExpense">$${medicalExpense}</td>
					</tr>
					
					<tr>
						<td>Deductible</td>
						<td id="deductable">$${deductable}</td>
					</tr>
					
					<tr>
						<td></td>
						<td><input style="font-family: Garamond;" type="submit"
							onsubmit="return validateform();" value="Proceed to Buy" /></td>
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