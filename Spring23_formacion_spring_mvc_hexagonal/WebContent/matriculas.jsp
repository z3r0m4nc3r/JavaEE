<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/stylesheet.css">
</head>
<body>
	<h1>Matrículas</h1>
	Seleccione las fechas de búsqueda para cursos que inicien:
	<form action="doConsultarMatriculas" method="Post">
	Fecha inicio<input type="date" name="fecha1"/>
	Fecha Fin <input type="date" name="fecha2"/>
		<br><br>
		<input type="submit" value="Consultar"/>	
		</form>
	
		
		<c:if test="${! empty requestScope.matriculas}">
		
			<p>Estas son las Matrículas:</p>
			<br>
			<div class="divTable">
				<div class="div-table-row">
					<div class="div-table-title-col" align=center>Curso</div>
					<div class="div-table-title-col" align=center>Fecha de inicio</div>
					<div class="div-table-title-col-large" align=center>Alumno inscrito</div>
				</div>
			</div>
			
			<c:forEach var="matricula" items="${requestScope.matriculas}">
				
					<div class="divTable">
						<div class="div-table-row">
							<div class="div-table-col" align=center>${matricula.curso.nombre}</div>
							<div class="div-table-col" align=center>${matricula.curso.fechaInicio}</div>
							<div class="div-table-col-large" align=center>${matricula.alumno.nombre}</div>
						</div>
					</div>
			
			
			</c:forEach>
			
			
		
		</c:if>
		

		
</body>
</html>