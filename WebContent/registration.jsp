<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Form</h1>
	<div class="example">
		<form action="/Form-Prepopulate/RegistrationController" method="post">
			<table style="with: 50%">
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" value=${employee.fullname} /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName" value=${employee.username} /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" value=${employee.address} /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" value=${employee.age}/></td>
				</tr>
				
			</table>
			<input type="submit" value="Register" />
		</form>
		<br>
	</div>
</body>
</html>