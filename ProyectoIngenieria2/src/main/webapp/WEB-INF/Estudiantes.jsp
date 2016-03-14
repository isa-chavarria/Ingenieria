<%--
    Document   : Estudiantes
    Created on : 14/03/2016, 12:29:37 AM
    Author     : josvr_000
--%>

<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--%

    Usuario user = (Usuario) session.getAttribute("user");

    if (user != null && user.isAdministrador()) {

    } else {
        response.sendRedirect("index");
    }
%-->
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Kinder Lulú</title>

        <!--link href="resources/css/app.css" rel="stylesheet"-->
        <link href="resources/css/bootstrap.css" rel="stylesheet">

        <!-- Bootstrap Core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="resources/css/business-casual.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div  id="arriba" class="row">
            <div class="col-sm-4">


                <img style="height: 50%; width: 50%; " src="resources/img/escudo.png" alt="">


            </div>


            <div class="col-sm-8" style="  padding: 1%">
                <div id="tituloGRANDE"class="brand">Kinder Lulú</div>
            </div>


        </div>


        <div id="second"  class="row">


            <h3 id="Titulo">Estudiantes </h3>


        </div>

        <!-- Navigation -->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                    <a class="navbar-brand" href="index">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="encargado">Regresar al menú</a>
                            </li>
                        </ul>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="row">
                <div style=" overflow: scroll ; height: 600px " class="box">
                    <form:form method="POST" action="seleccionar"  modelAttribute="grupo" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;'class="form-horizontal" role="form">

                        <div   class="form-inline">
                            <label for="nivel" class="col-lg-2 control-label">Seleccione el nivel:</label>
                            <div class="col-lg-4">
                                <form:select path="nivel" items="${niveles}" class="form-control input-sm" id="nivel" required="true" />

                            </div>
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-8">
                                    <button type="submit" class="btn btn-info">Buscar</button>
                                </div>
                            </div>
                        </div>
                    </form:form>

                    <br/>
                    <br/>
                    <br/>

                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading"><span class="lead">Estudiantes ${grupito.nivel}</span></div>
                        <table class="table table-hover" style="boder: solid 2px gray;">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDOS</th>
                                    <th>FECHA NACIMIENTO</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${grupito.purga()}" var="stu">
                                    <tr>
                                        <td style="boder: solid 2px gray;">${stu.id}</td>
                                        <td style="boder: solid 2px gray;">${stu.nombre}</td>
                                        <td style="boder: solid 2px gray;">${stu.apellido1} ${stu.apellido2}</td>
                                        <td style="boder: solid 2px gray;">${stu.fechaNacimiento}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>



                </div>
            </div>


        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <p>Administración del Kinder. Copyright 2016</p>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="resources/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="resources/js/bootstrap.min.js"></script>

        <!-- Script to Activate the Carousel -->
        <script>
            $('.carousel').carousel({
                interval: 5000 //changes the speed
            })
        </script>

    </body>
</html>
