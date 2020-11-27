<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="w3-blue-grey">
	<div class="w3-auto">


		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
		<h1>Cursos</h1>
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursosalumno"); %>
		<table border="1">
			<tr><th>Curso</th><th>Duracion</th></tr>
			<%for(Curso curso:cursos){ %>
				<tr>
					<td><%=curso.getNombre() %></td><td><%=curso.getDuracion() %></td>
				</tr>
			<%} %>
			
		</table>
		<br/><br/>
		<a href="toMenu">Volver</a>
	</div>
	</div>
</body>
</html>