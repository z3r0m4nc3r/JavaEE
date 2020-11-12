<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato,service.CandidatosService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table,tr,th,td {
		border:1px solid pink;
	}
</style>
</head>
<body>
	<table>
	<tr>
		<th>Nombre</th>
		<th>Edad</th>
		<th>Puesto</th>
		<th>Foto</th>
		<th>Email</th>
		<th></th>
	</tr>
		
			<%CandidatosService service=new CandidatosService();
			List<Candidato> empleados= service.recuperarCandidatos();
				for(int i=0;i<empleados.size();i++){ %>
					<tr><td>
						<%=empleados.get(i).getNombre()%>
					</td>
					<td>
						<%=empleados.get(i).getEdad()%>
					</td>	
					<td>
						<%=empleados.get(i).getPuesto()%>					
					</td>
					<td>
						<%=empleados.get(i).getEmail()%>
						
					</td>
					<td>
						<img alt="" height="50px" width="70px" src="<%=empleados.get(i).getFoto()%>">
					
					</td>
					<td><a href="EliminarCandidato?idCandidato=<%=empleados.get(i).getIdCandidato()%>">Eliminar</a></td>
					</tr>
				<%}%>
	
	</table>
	<a href="menu.html">Volver al menu</a>
</body>
</html>
