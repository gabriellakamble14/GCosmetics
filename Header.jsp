<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
String userEmail=(String)session.getAttribute("userEmail");
String adminEmail=(String)session.getAttribute("adminEmail");
String status = (String)request.getAttribute("success");
if(status!=null)
	out.print(status);
%>
	<div style="clear: both; width: 960px;">
		<ul>

			<li><a href="Home.jsp">Home</a></li>
			<li><a href="CosmeticsServlet">Product Menu</a></li>

			<%if(userEmail==null && adminEmail == null){ %>
			<li><a href="Login.jsp">Login</a></li>
			<li><a href="AddCustomer.jsp">Register</a></li>
			<%} %>
			<%if(userEmail==null && adminEmail != null){ %>
			<li><a href="AddCosmetics.jsp">Add Product</a></li>
			<li><a href="CustomerServlet">Customers</a></li>
			<%} %>
			<%if(userEmail!=null && adminEmail == null){ %>
			<li><a href="CustomerServlet?operation=getCust">Edit Profile</a></li>
			<li><a href="CartServlet">MyCart</a></li>
			<li><a href="Home.jsp">Orders</a></li>
			<%} %>
			<%if(userEmail!=null || adminEmail != null){ %>
			<li><a href="LoginServlet">Logout</a></li>
			<%} %>
			<li><a href="Contact.jsp">Contact</a></li>
			<!-- <li> <a href="ChangePassword.jsp">Change Password</a></li>
<li> <a href="ProductList.jsp">Product List</a></li>
 -->


		</ul>
	</div>

</body>
</html>