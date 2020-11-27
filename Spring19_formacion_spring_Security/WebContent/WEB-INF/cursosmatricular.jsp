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
		<form action="doMatricular" method="Post">
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursosmatricular"); %>
		Curso: <select name="idCurso">
			
			<%for(Curso curso:cursos){ %>
				<option value="<%=curso.getIdCurso() %>">
					<%=curso.getNombre() %>
				</option>
			<%} %>
			</select>
		<br/>
		<input type="submit" value="Matricular"/>	
		</form>
		<br/><br/>
		
	</div>
	</div>
</body>
</html>