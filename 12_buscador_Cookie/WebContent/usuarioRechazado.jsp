<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login rechazado</title>
</head>
<body>

	<%String usuario = request.getParameter("usuario");
	String password = request.getParameter("contraseña");%>
	<h3>Usuario <%=usuario%> con contraseña <%=password%> no reconocido</h3>
	<a href="login.html"><input type="submit" value="Volver"/></a>
</body>
</html>