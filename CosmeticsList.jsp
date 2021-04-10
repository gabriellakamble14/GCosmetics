<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.GCosmetics.pojo.cosmetics"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!--JSTL:JSP Standard Server Page
JSP: View technology taken care by web designers

-->
<%
String userEmail=(String)session.getAttribute("userEmail");
String adminEmail=(String)session.getAttribute("adminEmail");
 %>
<div Style="color: green; font-size: 20px;">
	<% 
 List<cosmetics> clist =(List<cosmetics>) session.getAttribute("cosmeticslist");
  String status =(String)request.getAttribute("Success");
  if(status!= null)
	    out.print(status);
 %>
</div>
<jsp:include page="Header.jsp"></jsp:include>
<body>
	<h3>Cosmetics List</h3>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Category</th>
				<th>Prize</th>
			</tr>
		</thead>

		</tbody>


		<%for(cosmetics c: clist)
  {%>
		<tr>

			<td><%=c.getCosmeticsId()%></td>
			<td><%=c.getCosmeticsName()%></td>
			<td><%=c.getCosmeticsCategory()%></td>
			<td><%=c.getCosmeticsPrice()%></td>
			<!--URL Rewriting "servletName?parameterlist"
always takes us to doGet() of servlet.
servlet doGet() we already have the code for displaying product List
So to differentiate bewteen the operations,we use operation.
-->
			<%if(adminEmail != null){ %>
			<td><a
				href="CosmeticsServlet?id=<%=c.getCosmeticsId()%>&operation=delete">Delete</a></td>
			<td><a
				href="CosmeticsServlet?id=<%=c.getCosmeticsId()%>&operation=getcosmeticsObj">Update</a></td>
			<%} %>
			<%if(userEmail != null){ %>
			<td><a
				href="CartServlet?cosmeticsId=<%=c.getCosmeticsId()%>&operation=addToCart">Add
					To cart</a></td>
			<%} %>
		</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>


