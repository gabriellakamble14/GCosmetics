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
	<form action="LoginServlet" method="post">
		<!-- Default method is get so all the parameters are visible so we us post -->
		<table>
			<div style="color: red; font-size: 20px;">

				<%
String status_f = (String)request.getAttribute("failure");
if(status_f!=null)
	out.print(status_f);
String status = (String)request.getAttribute("success");
if(status!=null)
	out.print(status);
%>
			</div>
			<tr>
				<td>Type</td>
				<td><input type="radio" name="type" value="user">User <input
					type="radio" name="type" value="admin">Admin</td>
				<td>Email</td>
				<td><input type="text" name="CustEmail">
			</tr>
			<td>Password</td>
			<td><input type="Password" name="Custpass">
			</tr>
			<tr>
				<td><input type="Submit" Value="Login"></td>
				<td><input type="reset" Value="Cancel">
			<tr>
		</table>
	</form>
</body>
</html>