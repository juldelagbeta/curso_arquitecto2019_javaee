<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Persona persona = (Persona)request.getAttribute("persona");%>
<h1>Bienvenido <%=request.getParameter("user")%> a mi página</h1>
<br/>
Usuario: <%=persona.getUsuario()%>
<br/>
email: <%=persona.getEmail()%>
<br/>
Edad: <%=persona.getEdad()%>
<br/>
<a href='formulario.html'>volver</a>

</body>
</html>