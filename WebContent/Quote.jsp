<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.HashMap" %>
    <%@page import= "com.case_study.model.User_Location" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
  <h2>Homeowner Insurance</h2>
  <hr>
</header>


<center>	
	<h2>Quote Details</h2>
	
		
		<table border="1">
			<thead>
			<tr>
			     <th>QuoteId</th>
			     <th>Residence Type</th>
			     <th>Address</th>
			     <th>City</th>
			     <th>State</th>
			     <th>Zip</th>
			     <th>Residence Use</th>
			     <th>Status</th>
			     <th>Rest of Information</th>
			</tr>
			</thead>
			<tbody>
			<%HashMap<Integer,User_Location>  l= (HashMap<Integer,User_Location>)session.getAttribute("quotes");
				if(l!=null){
					for(HashMap.Entry<Integer,User_Location> quote:l.entrySet()){%>
			<tr>
			<td><%=quote.getKey() %></td>
			<td><%=quote.getValue().getResidence_Type()%></td>
			<td><%=quote.getValue().getAddress_line_1() %></td>
			<td><%=quote.getValue().getCity() %></td>
			<td><%=quote.getValue().getState() %></td>
			<td><%=quote.getValue().getZipcode() %></td>
			<td><%=quote.getValue().getResidence_use() %></td>
			<td>new</td>
			<td align="center">
				<a href="QuoteSummary" >Click</a>
			
			</td>
			</tr>
			<%}} %>
			</tbody>
			
			</table>
			</center></body>
</html>