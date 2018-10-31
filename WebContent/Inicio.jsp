<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%String idUser=(String)request.getAttribute("idUser");%>
<%String visitas=(String)request.getAttribute("visitas");%>
<%String genero=(String)request.getAttribute("genero");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	Bienvenido <%=idUser%>
	
	<form action="Secundario" method="post">
	<%if(genero==null || genero.equals("hombre")) {%>
			<input type="radio" name="genero" value="hombre" checked> Hombre<br/>
  			<input type="radio" name="genero" value="mujer"> Mujer<br/>
  			<input type="radio" name="genero" value="otro"> Otro
  	<%}else if(genero.equals("mujer")) {%>
			<input type="radio" name="genero" value="hombre"> Hombre<br/>
  			<input type="radio" name="genero" value="mujer" checked> Mujer<br>
  			<input type="radio" name="genero" value="otro"> Otro
  	<%}else if(genero.equals("otro")) {%>
			<input type="radio" name="genero" value="hombre" checked> Hombre<br/>
  			<input type="radio" name="genero" value="mujer"> Mujer<br>
  			<input type="radio" name="genero" value="otro" checked> Otro
  	<%} %>
  	<input type="hidden" id="visitas" name="visitas" value="<%=visitas%>">
  	<input type="hidden" id="visitas" name="idUser" value="<%=idUser%>">
  	<input type="submit" value="Logout">
	</form>
	
	Nº de visitas --> <%=visitas%>
</body>
</html>