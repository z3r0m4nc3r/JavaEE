<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Matriculas</title>

</head>
<body class="w3-blue-grey">
	
	<div class="w3-auto">
		
	<h1>Matrículas</h1>
	<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
	Seleccione las fechas de búsqueda para cursos que inicien:
	<form action="doConsultarMatriculas" method="Post">
	Fecha inicio<input type="date" name="fecha1"/>
	Fecha Fin <input type="date" name="fecha2"/>
		<br><br>
		<input type="submit" value="Consultar"/>	
		</form>
	
		<div class="w3-responsive">
		<c:if test="${! empty requestScope.matriculas}">
		
			<h3>Estas son las Matrículas:</h3>
			
			<table class="w3-table-all">
						<tr>
							<th>Curso</th>
							<th>Alumno</th>
							<th>Fecha</th>
						</tr>
			
			<c:forEach var="unCurso" items="${requestScope.matriculas}">
				<c:forEach var="unAlumno" items="${unCurso.alumnos}">
					<tr>
									<td>${unCurso.nombre}</td>
									<td>${unAlumno.nombre}</td>
									<td>${unCurso.fechaInicio}</td>
								</tr>
				</c:forEach>
			
			</c:forEach>
			
			
		
		</c:if>
		
</div>
</div>
		
</body>
</html>