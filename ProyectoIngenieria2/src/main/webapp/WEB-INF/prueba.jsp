<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Users List</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="resources/css/app.css" rel="stylesheet">
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="resources/css/business-casual.css" rel="stylesheet">
    </head>

    <body>
        <div class="generic-container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Users </span></div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>rol</th>
                            <th>nombre</th>
                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td>${user.roleSeccion}</td>
                            <td>${nombre}</td>
                            <td><a href="" class="btn btn-success custom-width">edit</a></td>
                            <td><a href="" class="btn btn-danger custom-width">delete</a></td>


                        </tr>

                    </tbody>
                </table>
            </div>
            <div class="well">
                <a href="<c:url value='/newuser' />">Add New User</a>
            </div>
        </div>
    </body>
</html>