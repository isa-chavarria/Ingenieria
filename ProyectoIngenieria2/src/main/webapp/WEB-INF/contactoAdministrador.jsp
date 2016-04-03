
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");

    if (user != null && user.isAdministrador()) {

    } else {
        response.sendRedirect("index");
    }
%>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Kinder Lulú</title>

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

            <h3 id="Titulo">CONTACTENOS</h3>



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

                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="administracion">Regresar al menú</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="row">

                <div style="margin-bottom: 5%;" class="col-lg-12">
                    <h2 class="intro-text text-center">Contactos
                        <button type="button" class="btn btn-default" aria-label="Left Align">
                            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true" onclick="location.href = 'AgregarContacto.html';"></span>
                        </button>
                    </h2>


                    <hr>
                </div>
                <div style=" overflow: scroll ; height: 400px " class="box">


                    <div class="text-left">

                        <table class="table table-bordered table-hover">
                            <tbody class="cuerpoTabla">
                            <c:forEach items="${kinder.contactos}" var="contacto1">
                                <tr class="active"><td><c:out value="${contacto1.titulo}"></c:out> </td><td><c:out value="${contacto1.descripcion}"></c:out></td>

                                            <td><form:form method="POST"  modelAttribute="contacto" action="ModificarContacto">
                                            <form:hidden path="codigo" value="${contacto1.codigo}"/>
                                            <form:hidden path="titulo" value="${contacto1.titulo}"/>
                                            <form:hidden path="descripcion" value="${contacto1.descripcion}"/>
                                            <form:hidden path="kinder" value="${contacto1.kinder}"/>
                                            <button type="submit" class="btn btn-default" aria-label="Left Align">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </button></form:form></td>

                                        <td><form:form method="POST"  modelAttribute="contacto">
                                            <form:hidden path="codigo" value="${contacto1.codigo}"/>
                                            <button type="submit" class="btn btn-default" aria-label="Left Align">
                                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                            </button></form:form></td>

                                    </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="clearfix"></div>

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
