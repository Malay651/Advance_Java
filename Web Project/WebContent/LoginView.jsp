<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	
    <%  
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
    %>
	<div align="center">
       <h1>login</h1>
	   <%  
	         if(success != null) {
	    %>
	   <h3>  
	         <font color="green"><%=success%></font>
	   </h3>
	   <%
	         }
	   %>
	   <%
	         if(error != null) {
	   %>
	   <h3>
	        <font color="red"><%=error%></font>
	   </h3>
	   <%
	         }
	   %>
		<form action="LoginCtl" method="post">
			<table>
				<tr>
					<th>LoginId:</th>
					<td><input type="text" name="loginId"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signIn" name="operation">
					<input type="submit" name="operation" value="signUp">
               </tr>

			</table>
		</form>
	</div>
</body>
</html>