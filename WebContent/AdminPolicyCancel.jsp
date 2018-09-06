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
			<a href="LoginPage.jsp">Logout</a>
			<span>|</span>
		</center>
	</div>
	<hr>
	</header>
	<center>
		<h2>Policy Details</h2>
	</center>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

	
    		<h2>Policy Cancelled Successfully</h2>
			
				
				<table>
					<tr>
						<td class="quote">Quote Id</td>
						<td name="quoteId">${quoteId}
						
						</td>
						
					</tr>
					
					<tr>
						<td class="policyId">Policy Key</td>
						<td name="policyKey" >${policyKey}
						
						</td>
					</tr>
					
					
					<tr>
						<td class="startDate">Policy Effective date</td>
						<td name="policyStart" id="policyDate" >${newStartDate}</td>
					</tr>
					
					
					
					<tr>
						<td class="endDate">Policy End Date</td>
						<td name="policyEnd" id="policyEnd">${newEndDate}</td>
					</tr>
					
					<tr>
						<td class="term">Policy Term</td>
						<td name="policyTerm" id="policyTerm">${term}</td>
					</tr>
					
					<tr>
						<td class="status">Policy Status</td>
						<td name="policyStatus" id="policyStatus">${newCancel}</td>
					</tr>
					
					
						</table>
		
	
	</section>



<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>