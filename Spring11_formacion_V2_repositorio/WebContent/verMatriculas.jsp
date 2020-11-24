<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<meta charset="ISO-8859-1">
<title>Matriculas por fecha</title>
</head>
<body>
<fieldset>
<form action="FrontController?option=doVerMatriculas" method="post">
	<label for="ffecha">Fecha de Inicio</label><br>
			<input type="date" name="fechaInicio" required="required"><br><br>
	<label for="ffecha">Fecha de Fin</label><br>
			<input type="date" name="fechaFin" required="required"><br><br>
	<input type="submit" value="Ver Cursos">
	<input type="reset">

</form>
<br/>
</fieldset>
<div class="container-fluid" align="center">
<c:if test="${!empty requestScope.cursosFecha}">
	<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursosFecha"); %>
		<table border="1">
			<tr><th>Curso</th><th>Alumno</th><th>Fecha</th></tr>
			<%for(Curso curso:cursos){ %>
				<%List<Alumno> alumnos = (List<Alumno>) curso.getAlumnos(); %>
				<%for(Alumno alumno:alumnos){ %>
					<tr>
						<td><%=curso.getNombre() %></td><td><%=alumno.getNombre() %></td><td><%=curso.getFechaInicio() %></td>
					</tr>
			<%}
				}%>
			
		</table>
		<br/><br/>
		<a href="FrontController?option=toMenu">Volver</a>
	
</c:if>
</div>

</body>
</html>