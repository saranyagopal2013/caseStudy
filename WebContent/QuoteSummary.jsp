<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Insurance Company</title>
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
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
		
	<h2>Quote Summary</h2>
	<h2>Monthly Premium:</h2>
	${monthlyPremium}
	<form  name="RegForm" action="BuyPolicy"  method="Post" onsubmit="return validateform();">
	<input style="font-family: Garamond;" type="submit"
							value="Buy Quote" />
	<div>
	<table class="inlineTable">
	<caption align="left">Location Details</caption>	
        <tr>
            <td class="labelform1">Quote Id</td>
            <td class="formattd">${quoteId}</td>
        </tr>
         <tr>
            <td class="labelform1">Residence Type</td>
            <td class="formattd">${type}</td>
        </tr>
         <tr>
            <td class="labelform1">Address Line 1</td>
            <td class="formattd">${addressline1}</td>
        </tr>
         <tr>
            <td class="labelform1">Address Line 2</td>
            <td class="formattd">${addressline2}</td>
        </tr>
         <tr>
            <td class="labelform1">City</td>
            <td class="formattd">${city}</td>
        </tr>
         <tr>
            <td class="labelform1">State</td>
            <td class="formattd">${state}</td>
        </tr>
         <tr>
            <td class="labelform1">Zip</td>
            <td class="formattd">${zip}</td>
        </tr>
         <tr>
            <td class="labelform1">Residence Use</td>
            <td class="formattd">${use}</td>
        </tr>
    </table>
    <table  class="inlineTable">
    	<caption align="left">Homeowner Details</caption>	
        <tr>
            <td class="labelform1">First Name</td>
            <td class="formattd">${fname}</td>
        </tr>
         <tr>
            <td class="labelform1">Last Name</td>
            <td class="formattd">${lname}</td>
        </tr>
         <tr>
            <td class="labelform1">Date of Birth</td>
            <td class="formattd">${birth}</td>
        </tr>
         <tr>
            <td class="labelform1">Is Retired?</td>
            <td class="formattd">${retired}</td>
        </tr>
         <tr>
            <td class="labelform1">Social Security Number</td>
            <td class="formattd">${ssn}</td>
        </tr>
         <tr>
            <td class="labelform1">Email</td>
            <td class="formattd">${email}</td>
        </tr>
         <tr>
        </tr>
         <tr>
        </tr>
        </table>
	</div>
	<hr>
		<div>
	<table class="inlineTable">
	<caption align="left">Property Details</caption>	
        <tr>
            <td class="labelform1">Market Value</td>
            <td class="formattd">$${marketValue}</td>
        </tr>
         <tr>
            <td class="labelform1">Year Built</td>
            <td class="formattd">$${built}</td>
        </tr>
         <tr>
            <td class="labelform1">Square Footage</td>
            <td class="formattd">${footage}</td>
        </tr>
         <tr>
            <td class="labelform1">Dwelling Style</td>
            <td class="formattd">${dwelling}</td>
        </tr>
         <tr>
            <td class="labelform1">Roof Material</td>
            <td class="formattd">${roof}</td>
        </tr>
         <tr>
            <td class="labelform1">Garage Type</td>
            <td class="formattd">${garage}</td>
        </tr>
         <tr>
            <td class="labelform1">Number of Full Baths</td>
            <td class="formattd">${fullBaths}</td>
        </tr>
         <tr>
            <td class="labelform1">Number of Half Baths</td>
            <td class="formattd">${halfBaths}</td>
        </tr>
          <tr>
            <td class="labelform1">Has Swimming pool?</td>
            <td class="formattd">${pool}</td>
        </tr>
    </table>
    <table  class="inlineTable">
    	<caption align="left">Coverage Details</caption>	
        <tr>
            <td class="labelform1">Monthly premium</td>
            <td class="formattd">$${monthlyPremium}</td>
        </tr>
         <tr>
            <td class="labelform1">Dwelling Coverage</td>
            <td class="formattd">$${coverage}</td>
        </tr>
         <tr>
            <td class="labelform1">Detached Structure</td>
            <td class="formattd">$${detacheStructure}</td>
        </tr>
         <tr>
            <td class="labelform1">Personal Property</td>
            <td class="formattd">$${personalProperty}</td>
        </tr>
         <tr>
            <td class="labelform1">Additional Living expense</td>
            <td class="formattd">$${living}</td>
        </tr>
         <tr>
            <td class="labelform1">Medical expense</td>
            <td class="formattd">$${medicalExpense}</td>
        </tr>
         <tr>
            <td class="labelform1">Deductible</td>
            <td class="formattd">$${deductable}</td>
        </tr>
        
	</div>
	<input style="font-family: Garamond;" type="submit"
							value="Buy Quote" />
	</form>
</center>
<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>