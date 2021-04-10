<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div style="color: red; font-size: 20px;">
		<%
String status = (String)request.getAttribute("failure");
if(status!=null)
	out.print(status);
%>
	</div>
	<form method="post" action="CustomerServlet">
		<input type="hidden" name="operation" value="addCust">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="custName"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="custEmail"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="custPass"></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="text" name="custContact"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="custAddress"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="Reset" value="clear"></td>
			</tr>

		</table>
</body>
</html>