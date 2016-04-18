<%-- 
    Document   : MatriculaCorrecta
    Created on : 14/03/2016, 07:15:20 AM
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
            <div class="alert alert-danger lead">
                Error: La  cédula del niño o el email ya son utilizados en el sistema.
            </div>

            <span class="well floatRight">
                <a href="<c:url value='/matricula' />">Continuar</a>
            </span>
        </div>
    </body>

</html>