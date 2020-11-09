<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Candidato,java.util.List"%>
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
<title>Insert title here</title>
</head>
<body>
<%HttpSession sesion = request.getSession();
List <Candidato> listaCandidatos =(List<Candidato>) sesion.getAttribute("listaCandidatos");%>
<%if(!listaCandidatos.isEmpty()){ %>
<div align="center">
<h1>Lista de Candidatos</h1>
<table class="table table-striped table-bordered">
<tr>
<th>NOMBRE</th>
<th>EDAD</th>
<th>PUESTO</th>
<th>ELIMINAR CANDIDATO?</th>
</tr>
<%for (int fila=0;fila<listaCandidatos.size();fila++){ %>
<tr>
<td>
<%=listaCandidatos.get(fila).getNombre()%>
</td>
<td>
<%=listaCandidatos.get(fila).getEdad()%>
</td>
<td>
<%=listaCandidatos.get(fila).getPuesto()%>
</td>
<td>

<a href="Eliminar?indice=<%=fila%>">Eliminar</a>
</td>
</tr>
<%} %>
</table>


</div>
<%}else{%>
<h2>No hay candidatos</h2>
<%} %>
<section style="text-align:center"><a href="index.html"><input type="submit" value="Volver"/></a></section>
</body>
</html>