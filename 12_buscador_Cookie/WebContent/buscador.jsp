<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscador</title>
</head>
<body>
<body>
	<%HttpSession sesion=request.getSession();
	String usuario = (String)sesion.getAttribute("usuario");%>
	
	<%@ include file="comun.dsd" %>
	<section style="text-align:center">
		<h2>Buscador</h2>
		<form action="Buscador" method="post">
		Introduce Tematica:<input type="text" name="tematica"/><br/>
		<br/>
		<input type="submit" value="Buscar"/>
		</form>
	</section>


</body>
</body>
</html>