<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato,service.CandidatosServiceImpl"%>
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
<title>Introducir datos del candidato</title>
</head>
<body>


<div class="container">
<h2>Datos de la Inscripcion</h2>
<form action="FrontController?Option=doInscribir" method="post" class="form-horizontal">
<select id="candidato" name="candidato">
<c:forEach var="candidato" items="${requestScope.candidatos}">
	<option value="${candidato}">${candidato}</option>
</c:forEach>

</select>

</form>
</div>
</body>
</html>