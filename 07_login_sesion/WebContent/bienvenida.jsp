<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Persona persona = (Persona)session.getAttribute("persona");%>

<br/>
Usuario: <%=persona.getUsuario()%>
<br/>
email: <%=persona.getEmail()%>
<br/>
Edad: <%=persona.getEdad()%>
<br/>

<a href='preferencias.html'>volver</a>

</body>
</html>