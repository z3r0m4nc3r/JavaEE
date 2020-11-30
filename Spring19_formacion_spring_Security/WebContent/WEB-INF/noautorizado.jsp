<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>::NO AUTORIZADO::</title>
</head>
<body>
<body class="w3-blue-grey">
	<div class="w3-auto w3-container">
	
	<h1>USUARIO <%=request.getUserPrincipal().getName()%> NO AUTORIZADO A ACCEDER</h1>
	<p align="left"><a href="toMenu">Volver</a></p>
	</div>
</body>
</html>