<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--  
<%Persona persona = (Persona)session.getAttribute("persona");%>

<br/>
Usuario: <%=persona.getUsuario()%>
<br/>
email: <%=persona.getEmail()%>
<br/>
Edad: <%=persona.getEdad()%>
<br/>
 --%>
 
<br/>
Usuario: ${sessionScope.persona.usuario}
<br/>
email: ${sessionScope.persona.email}
<br/>
Edad: ${sessionScope.persona.edad}
<br/>


 
<a href='preferencias.html'>Volver</a>
<br/>
<a href='Cierre'>Cerrar</a>

</body>
</html>