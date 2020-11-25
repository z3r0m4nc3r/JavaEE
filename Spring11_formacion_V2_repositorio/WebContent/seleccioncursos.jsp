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
	<div class="w3-auto">


		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
			<h1>Cursos</h1>
			<form action="FrontController?option=doAlumnosCurso" method="Post">

				Curso: <select name="idCurso">

					<c:forEach var="curso" items="${requestScope.cursos}">
						<option value="${curso.idCurso}">${curso.nombre}</option>
					</c:forEach>
				</select> <br /> <input type="submit" value="Buscar alumnos" class="w3-btn w3-black w3-ripple w3-round-large" />
			</form>
			<br />
			<br />

		</div>
	</div>
</body>
</html>