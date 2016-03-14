<%-- 
    Document   : MatriculaCorrecta
    Created on : 14/03/2016, 07:15:20 AM
    Author     : josvr_000
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="resources/css/app.css" rel="stylesheet">
        <link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="generic-container">
	<div class="alert alert-success lead">
              Matr�cula Completa correctamente
	</div>
	
	<span class="well floatRight">
		Go to <a href="<c:url value='/administracion' />">Continuar</a>
	</span>
</div>
</body>

</html>