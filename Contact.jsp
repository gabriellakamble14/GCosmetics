<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Middle Section Start  -->
	<div class="enquiry1 grid_8">

		<form action="td.html" method="POSt">

			<table>
				<caption>
					<h2>&emsp;&emsp; REGISTER CONTACT</h2>
				</caption>
				<tr>
					<td>Name:&nbsp;&nbsp; <input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>Mobile: <input type="text" name="contact">
					</td>
				</tr>
				<tr>
					<td>Email:&nbsp;&nbsp; <input type="text" name="email">
					</td>
				</tr>

				<td>
					<p>
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input
							style="border-radius: 12px; background-color: pink; color: white"
							type="button" value="SUBMIT" onclick="click1()">
					</p>
				</td>
				</tr>
				<tr>
					<td><br> Contact: +91 9540284571 <br>
						&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;+91 9540278451 <br>
					<br> <span class="footer_headtext"> Email:</span> <a
						style="color: pink; text-decoration: none;"
						href="mailto:gcosmetics@gmail.com">gcosmetics@gmail.com </a></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- Footer start -->
	<div class="footer grid_20">
		<h2>
			<span style="color: pink;">GCosmetics</span>
		</h2>

		<br>
		<br> <span class="footer_headtext">Quick Links:</span> <br>

		<a href="Home.jsp">HOME</a> &nbsp;| &nbsp; <a
			href="CosmeticsServlet.jsp">COSMETICS</a>&nbsp;| &nbsp; <a
			href="Login.jsp">LOGIN</a> &nbsp;| &nbsp; <a href="AddCustomer">REGISTER</a>
		&nbsp;| &nbsp; <a href="Contact.jsp">CONTACT</a> <br> Copyright
		&copy; 2021 GABRIELLA KAMBLE
	</div>
</body>
</html>