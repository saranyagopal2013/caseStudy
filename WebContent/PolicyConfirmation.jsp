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
		<h2>Policy Confirmation</h2>
	</center>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 3%;">
    		<h2>Our customer service department will contact you shortly for premium collections arrangements</h2>
			<form name="loginform" id="loginform" method="post"
				action="QuoteDetails" onsubmit="return validateform();">
				
				<table>
					<tr>
						<td class="labelform1">Quote Id</td>
						<td name="quoteId">${quoteId}
						
						</td>
						
					</tr>
					
					<tr>
						<td class="labelform1">Policy Key</td>
						<td name="policyId" >${policyId}
						
						</td>
					</tr>
					
					
					<tr>
						<td class="labelform1">Policy Effective date</td>
						<td name="startDate" id="startDate" >${startDate}</td>
					</tr>
					
					
					
					<tr>
						<td class="labelform1">Policy End Date</td>
						<td name="endDate" id="endDate">${endDate}</td>
					</tr>
					
					<tr>
						<td class="labelform1">Policy Term</td>
						<td name="policyTerm" id="policyTerm">${term}</td>
					</tr>
					
					<tr>
						<td class="labelform1">Policy Status</td>
						<td name="status" id="status">${status}</td>
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