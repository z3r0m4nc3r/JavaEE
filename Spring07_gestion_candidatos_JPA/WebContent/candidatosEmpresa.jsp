<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato,model.Inscripciones,service.CandidatosServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table,tr,th,td {
		border:1px solid pink;
	}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<meta charset="ISO-8859-1">
<title>Lista de candidatos por empresa</title>
</head>
<body>
<div class="container-fluid" align="center">
<h1>Lista de Candidatos por Empresa</h1>
</div><br/>
<div class="container-fluid" align="left">
<h2>Seleccione Empresa</h2>
<form action="FrontController?option=doDatosInscripcion" method="post">
<select id="empresa" name="empresa">
<c:forEach var="empresa" items="${applicationScope.nombresEmpresas}">
	<option value="${empresa}">${empresa}</option>
</c:forEach>

</select>
<input type="submit" class="btn btn-default" value="Ver Candidatos" />

</form>
</div><br/>
<div class="container-fluid" align="center">
<c:if test="${!empty sessionScope.empresaSeleccionada}">
<h3>${sessionScope.empresaSeleccionada.get(0).getEmpresa()}</h3>
<table>
	<tr>
		<th>Candidato</th>
		<th>Posicion</th>
		
	</tr>
	
	<c:forEach var="inscripcion" items="${sessionScope.empresaSeleccionada}">
	<tr><td>
						${inscripcion.getCandidato().getNombre()}
					</td>
					<td>
						${inscripcion.getPosicion()}
					</td>
					</tr>
	
	</c:forEach>
</table>
</c:if>
</div>
<a href="FrontController?option=toMenu">Volver al menu</a>
</body>
</html>