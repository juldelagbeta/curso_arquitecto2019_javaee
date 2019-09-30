<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Carrito"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Carrito listaProductos = (Carrito)session.getAttribute("carrito");
for (int i=0; i<listaProductos.size(); i++) { %>
    <br/><%=listaProductos.get(i).getNombre;%>
    <br/><%=listaProductos.get(i).getUnidades;%>
    <br/><%=listaProductos.get(i).getPrecio;%>
<%} %>

</body>
</html>