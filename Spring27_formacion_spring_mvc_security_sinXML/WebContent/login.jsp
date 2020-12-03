<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body class="w3-blue-grey">
	
	<div class="w3-auto">
		<h1>Login</h1>
	<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
	<form action="security_check" method="post" class="w3-auto">
		<table>
		<tr>
		<td>Introduce Usuario:</td><td><input type="text" name="j_username" /></td>
		</tr>
		<tr>
		<td>Introduce Contraseña:</td><td><input type="password" name="j_password"></td>
		</tr>
		</table>
		<br/>
		<input type="submit" value="Entrar" />
	</form>

</div>
</div>
</body>
</html>
