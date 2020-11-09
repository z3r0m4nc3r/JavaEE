<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>No hay resultados</title>
</head>
<body>
	<%HttpSession sesion=request.getSession();
	String usuario = (String)sesion.getAttribute("usuario");
	String tematica = request.getParameter("tematica");%>
	<%@ include file="comun.dsd" %>
	<h2>No existen entradas de la tematica <%=tematica%></h2>
	<section style="text-align:center"><a href="buscador.jsp"><input type="submit" value="Volver"/></a></section>
</body>
</html>