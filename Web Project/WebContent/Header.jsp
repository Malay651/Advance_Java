<%@page import="in.co.rays.bean.UserBean"%>
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
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		Hi,
		<%=user.getFirstName()%></h3>
	<a href="UserCtl"><b>Add User</b></a>
	<b>|</b>
	<a href="UserListCtl"><b>User List</b></a>
	<b>|</b>
	<a href="LoginCtl?operation=Logout"><b>Logout</b></a>
	<%
		} else {
	%>

	<h3>hi,Guest</h3>
	<a href="WelcomeCtl"><b>welcome</b></a>
	<b>|</b>
	<a href="LoginCtl"> <b> login </b></a>
	<%
		}
	%>
	<hr>
</body>
</html>