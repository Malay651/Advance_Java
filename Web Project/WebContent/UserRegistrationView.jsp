<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration</title>
</head>
<body>
    <div align="center">
        <h1>User Registration</h1>
        <form action="UserRegistrationCtl" method="post">
            <table>
                <tr>
                    <th>First Name</th>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <th>Last Name</th>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <th>Login ID</th>
                    <td><input type="text" name="loginId"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <th>Date of Birth</th>
                    <td><input type="date" name="dob" ></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><input type="text" name="adddress"></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input type="submit" value="Sign Up"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
