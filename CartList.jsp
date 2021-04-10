<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.util.List,com.GCosmetics.pojo.cosmetics,com.GCosmetics.pojo.Cart"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
String userEmail = (String)session.getAttribute("userEmail");
String adminEmail = (String)session.getAttribute("adminEmail");
%>
	<jsp:include page="Header.jsp"></jsp:include>
	<% 
List<Cart> ctlist =(List<Cart>)session.getAttribute("mycart");
  String status =(String)request.getAttribute("Success");
  if(status!= null)
	    out.print(status);
  String status_f = (String)request.getAttribute("failure");
  if(status_f!=null)
  	out.print(status_f);
 %>
	<h3>Product List</h3>
	<form action="CartServlet" method="post">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			</tbody>
			<%
for (Cart ct:ctlist) {
%>
			<tr>

				<td><%=ct.getCartId()%></td>
				<td><%=ct.getCosmeticsName()%></td>
				<td><input type="text" name="price"
					value="<%=ct.getCosmeticsPrice()%>" readonly></td>
				<td><input type="number" name="quantity"
					value="<%=ct.getQuantity()%>" min="1"></td>
				<td><a
					href="CartServlet?id=<%=ct.getCartId()%>&operation=delete">Delete</a>
			</tr>

			<%} %>
			</tbody>
		</table>
		<input type="submit" value="Place Order">
	</form>
</body>
</html>