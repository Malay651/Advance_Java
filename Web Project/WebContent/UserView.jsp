<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<div align="center">
		<h1>
			<%=(bean != null && bean.getId() > 0) ? "Update User" : "Add User"%>
		</h1>

		<%
			if (success != null) {
		%>
		<h3>
			<font color="green"><%=success%></font>
		</h3>
		<%
			}
		%>

		<%
			if (error != null) {
		%>
		<h3>
			<font color="red"><%=error%></font>
		</h3>
		<%
			}
		%>

		<form action="UserCtl" method="post">
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null) ? bean.getFirstName() : ""%>" /></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=(bean != null) ? bean.getLastName() : ""%>" /></td>
				</tr>
				<tr>
					<th>Login ID:</th>
					<td><input type="text" name="loginId"
						value="<%=(bean != null) ? bean.getLoginId() : ""%>" /></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"
						value="<%=(bean != null) ? bean.getPassword() : ""%>" /></td>
				</tr>
				<tr>
					<th>Date of Birth:</th>
					<td><input type="date" name="dob"
						value="<%=(bean != null) ? bean.getDob() : ""%>" /></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"
						value="<%=(bean != null) ? bean.getAddress() : ""%>" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation"
						value="<%=(bean != null && bean.getId() > 0) ? "Update" : "Save"%>" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
