<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="w3-blue-grey">
	<div class="w3-container">


		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
			<h1>Alumnos</h1>


			<table class="w3-table-all">
				<tr>
					<th>Nombre</th>
					<th>Usuario</th>
				</tr>

				<c:forEach var="alumno" items="${requestScope.alumnoscurso}">
					<tr>
						<td>${alumno.nombre}</td>
						<td>${alumno.usuario}</td>
					</tr>
				</c:forEach>

			</table>
			<br />
			<br /> <a href="FrontController?option=toMenu">Volver</a>
		</div>
	</div>
</body>
</html>