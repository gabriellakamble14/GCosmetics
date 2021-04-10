<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.GCosmetics.pojo.cosmetics"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div style="color: red; font-size: 20px;">
		<%cosmetics c= (cosmetics)session.getAttribute("cosmeticstoupdate");
String status = (String)request.getAttribute("failure");
if(status!=null)
	out.print(status);
%>
	</div>

	<form action="CosmeticsServlet" method="post">
		<input type="hidden" name="operation" value="Updatecosmetics">
		<input type="hidden" name="CosmeticsId" value=<%=c.getCosmeticsId()%>>
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="CosmeticsName"
					value=<%=c.getCosmeticsName()%>></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="CosmeticsCategory"
					value=<%=c.getCosmeticsCategory()%>></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="CosmeticsPrize"
					value=<%=c.getCosmeticsPrice()%>></td>
			</tr>
			<tr>
				<td><input type="text" name="submit" value="Update"></td>
				<td><input type="text" name="Reset" value="Cancel"></td>
			</tr>

		</table>
	</form>

</body>
</html>