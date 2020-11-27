<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<meta charset="ISO-8859-1">
<title>Matriculas por fecha</title>
</head>
<body class="w3-blue-grey">
	<div class="w3-auto">


		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
			<fieldset>
				<form action="doVerMatriculas" method="post">
					<label for="ffecha">Fecha de Inicio</label><br> <input
						type="date" name="fecha1" required="required"><br>
					<br> <label for="ffecha">Fecha de Fin</label><br> <input
						type="date" name="fecha2" required="required"><br>
					<br> <input type="submit" value="Ver Cursos" class="w3-btn w3-black w3-ripple w3-round-large"> 

				</form>
				<br />
			</fieldset>
			<div class="w3-responsive">
				<c:if test="${!empty requestScope.matriculas}">

					<table class="w3-table-all">
						<tr>
							<th>Curso</th>
							<th>Alumno</th>
							<th>Fecha</th>
						</tr>
						<c:forEach var="curso" items="${requestScope.matriculas}">

							<c:forEach var="alumno" items="${curso.alumnos}">
								<tr>
									<td>${curso.nombre}</td>
									<td>${alumno.nombre}</td>
									<td>${curso.fechaInicio}</td>
								</tr>
							</c:forEach>
						</c:forEach>

					</table>
					<br />
					<br />
					<a href="toMenu">Volver</a>

				</c:if>
			</div>
		</div>
	</div>
</body>
</html>