<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Item"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado de la Busqueda</title>
</head>
<body>

	<%HttpSession sesion=request.getSession();
	String usuario = (String)sesion.getAttribute("usuario");
	List<Item> items = (List<Item>)request.getAttribute("listaItems");
	String tema = request.getParameter("tematica");%>
	<%@ include file="comun.dsd" %>
	
	<%for (Item i : items) {

		for (String t : i.getSeo()) {

			if (t.equalsIgnoreCase(tema)) {
	%>
	<h3>
		<a href="<%=i.getUrl()%>"><%=i.getTitulo()%></a>
	</h3>
	<%=i.getDescripcion()%><br />
	<a href="<%=i.getUrl()%>"><%=i.getUrl()%></a>
	<%
		}

	}
	}
	%>
	<section style="text-align:center"><a href="buscador.jsp"><input type="submit" value="Volver"/></a></section>
</body>
</html>