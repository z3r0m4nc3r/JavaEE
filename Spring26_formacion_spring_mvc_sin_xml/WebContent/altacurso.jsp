<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Registro de Cursos</title>
</head>
<body class="w3-blue-grey">
	
	<div class="w3-auto">
		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
	<fieldset>
	<legend>Datos Curso</legend>
		<form action="doAltaCurso" method="post">
			<label for="fnombre">Nombre</label><br>
			<input type="text" name="nombre" required="required"><br>
			<label for="fduracion">Duracion</label><br>
			<input type="text" name="duracion" required="required"><br>
			<label for="ffecha">Fecha</label><br>
			<input type="date" name="fecha" required="required"><br><br>
			<input type="submit" value="Guardar">
			<input type="reset">
		</form>
	</fieldset>
	</div>
	</div>
	<p align="right"><a href="toMenu">Volver</a></p>
</body>
</html>