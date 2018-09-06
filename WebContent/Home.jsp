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
			<a class="home" href="Home.jsp">Home</a>
			<span>|</span>
			<a  id="getQuote" href="GetQuote.jsp">Get Quote</a>
			<span>|</span>
			<a class="retrieveQuote" href="./retrievequote">Retrive Quote</a>
			<span>|</span>
			<a id="mypolicy" href="./MyPolicies">My Policies</a>
			<span>|</span>
			<a class="logout" href="LoginPage.jsp">Logout</a>
			<span>|</span>
		</center>
	</div>
	<hr>
	</header>
	<center>
		<h2>Get Started Page</h2>
	</center>
	<section>
		<nav >
			<img src="https://i.imgur.com/uRN0zZ2.jpg?1" title="source: imgur.com" align="center" style="width: 400px;padding-top: 10%;height: 384.525px;">
		</nav>

		<article style="
    padding-top: 10%;">
			<!-- <input style="font-family: Garamond;" type="submit"
							value="Get Quote" > -->
							
			
			<a class="getbutton" href="GetQuote.jsp"><button>Get Quote</button></a>
							<br><br>
			
			<a class="quotebutton" href="RetrieveQuote.jsp"><button>Retrieve Quote</button></a>
		</article>
	</section>
<div class="footer" >
  <hr>
  <p>Copyright © 2018 Homeownersinsurance.com All Rights Reserved</p>
</div>
</body>
</html>