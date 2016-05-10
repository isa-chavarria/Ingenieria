<%-- 
    Document   : PagoCorrecto
    Created on : 14/03/2016, 03:11:44 PM
    Author     : josvr_000
--%>

<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

    Usuario user = (Usuario) session.getAttribute("user");

    if (user != null && user.isAdministrador()) {
        
    } else {
        response.sendRedirect("index");
    }
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="resources/css/app.css" rel="stylesheet">
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="resources/css/sb-admin.css" rel="stylesheet">
</head>
<body>
<div class="generic-container">
	<div class="alert alert-success lead">
              Pago registrado correctamente
	</div>
	
	<span class="well floatRight">
		 <a href="<c:url value='/morosos' />">Continuar</a>
	</span>
</div>
</body>

</html>