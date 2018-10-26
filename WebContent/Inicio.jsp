<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String idUser=request.getParameter("idUser");%>
<%String visitas=request.getParameter("visitas");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	Bienvenido <%=idUser%>
	
	<form action="Secundario" method="post">
	<input type="radio" name="genero" value="hombre"> Hombre
  	<input type="radio" name="genero" value="mujer"> Mujer<br/>
  	<input type="radio" name="genero" value="hombre"> Hombre<br/>
  	<input type="submit" value="Logout">
	</form>
	
	Nº de visitas --> 
</body>
</html>