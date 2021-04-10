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
		<form action="CosmeticsServlet" method="post">
			<input type="hidden" name="operation" value="addcosmetics">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="CosmeticsName"></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="CosmeticsCat"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="Cosmeticsprice"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Cosmetics"></td>
					<td><input type="Reset" value="Cancel"></td>
				</tr>

			</table>
		</form>
</body>
</html>