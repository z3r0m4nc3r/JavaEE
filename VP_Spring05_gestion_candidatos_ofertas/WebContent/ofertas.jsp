<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FrontController?option=doAltaInscripcion" method="post" >	
		Empresa: <input type="text" name="empresa" placeholder="Introduce tu nombre" required="required"></br></br>
		Posicion: <input type="text" name="posicion" placeholder="Introduce tu edad" required="required"></br></br>
		Salario: <input type="text" name="salario" placeholder="Introduce tu puesto" required="required"></br></br>
		Candidato:<select name="idCandidato">
			<%List<Candidato> candidatos=(List<Candidato>)request.getAttribute("candidatos");
			for(Candidato candidato:candidatos){%>
			<option value="<%=candidato.getIdCandidato()%>"><%=candidato.getNombre()%></option>
			<%} %>
		</select>
		<input type="submit" value="Guardar">	
	</form>
</body>
</html>