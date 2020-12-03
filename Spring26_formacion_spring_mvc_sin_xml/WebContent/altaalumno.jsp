<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Registro de Alumnos</title>
</head>
<body class="w3-blue-grey">
	
	<div class="w3-auto">
		<div class="w3-responsive w3-light-grey w3-opacity w3-round-large">
	<fieldset>
	<legend>Datos personales</legend>
	
		<form action="doAltaAlumno" method="post">
			<label for="fusuario">Usuario</label><br>
			<input type="text" name="usuario" required="required"><br>
			<label for="fpassword">Contraseña</label><br>
			<input type="password" name="password" required="required"><br>
			<label for="fnombre">Nombre</label><br>
			<input type="text" name="nombre" required="required"><br>
			<label for="femail">Email</label><br>
			<input type="text" name="email" required="required"><br>
			<label for="fedad">Edad</label><br>
			<input type="number" name="edad" required="required"><br><br>
			<input type="submit" value="Guardar">
			<input type="reset">
		</form>
	</fieldset>
	</div>
	</div>
	<p align="right"><a href="toMenu">Volver</a></p>
</body>
</html>