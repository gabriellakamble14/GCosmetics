<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.GCosmetics.pojo.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
Customer c = (Customer)session.getAttribute("custtoupdate");
String status = (String)request.getAttribute("success");
if(status!=null)
	out.print(status);
%>
	<jsp:include page="Header.jsp"></jsp:include>
	<form method="post" action="CustomerServlet">
		<input type="hidden" name="operation" value="updateCust"> <input
			type="hidden" name="CustId" value=<%=c.getCustId()%>>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="CustName"
					value=<%=c.getCustName()  %>></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="CustEmail"
					value=<%=c.getCustEmail()  %>></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="text" name="CustPass"
					value=<%=c.getCustPass()%>></td>
			</tr>

			<tr>
				<td>Contact:</td>
				<td><input type="text" name="CustContact"
					value=<%=c.getCustContactNo()  %>></td>
			</tr>

			<tr>
				<td>Address:</td>
				<td><input type="text" name="CustAddress"
					value=<%=c.getCustAddress()  %>></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="Reset" value="clear"></td>
			</tr>

		</table>
	</form>

</body>
</html>