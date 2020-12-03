<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Alumnos</title>
</head>
<body class="w3-blue-grey">
	
	<div class="w3-auto">
		
		<h1>Alumnos</h1>
		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
		<form action="doCursosAlumno" method="Post">
		<%List<Alumno> alumnos=(List<Alumno>)request.getAttribute("alumnos"); %>
		Alumno: <select name="usuario">
			
			<%for(Alumno alumno:alumnos){ %>
				<option value="<%=alumno.getUsuario() %>">
					<%=alumno.getNombre() %>
				</option>
			<%} %>
			</select>
		<br/>
		<input type="submit" value="Buscar cursos"/>	
		</form>
		<br/><br/>
		
	</div>
	</div>
	
</body>
</html>