<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String error=(String)request.getAttribute("loginError"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
<%if(error!=null){%>
.error{
color:red;
}
<%}%>
</style>
</head>
<body>
	<%if(error!=null){%>
	<h4 class="error"><%=error %></h4>
	<%}%>
	<form action="Principal" method="post">
		Usuario <input type="text" name="idUser"><br/>
		Contraseña <input type="password" name="contra"><br/>
		<input type="submit" value="Login">
	</form>
</body>
</html>