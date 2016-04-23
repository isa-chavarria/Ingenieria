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
        <link href="resources/css/sb-admin.css" rel="stylesheet">
        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
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

                    <ul class="nav navbar-right top-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                            <ul class="dropdown-menu message-dropdown">
                                <li class="message-preview">
                                    <a href="#">
                                        <div class="media">
                                            <span class="pull-left">
                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                            </span>
                                            <div class="media-body">
                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                </h5>
                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="message-preview">
                                    <a href="#">
                                        <div class="media">
                                            <span class="pull-left">
                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                            </span>
                                            <div class="media-body">
                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                </h5>
                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="message-preview">
                                    <a href="#">
                                        <div class="media">
                                            <span class="pull-left">
                                                <img class="media-object" src="http://placehold.it/50x50" alt="">
                                            </span>
                                            <div class="media-body">
                                                <h5 class="media-heading"><strong>John Smith</strong>
                                                </h5>
                                                <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                                <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="message-footer">
                                    <a href="#">Read All New Messages</a>
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=user.getEncargadoOriginal().getNombre()%> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="perfilAdministrador"><i class="fa fa-fw fa-user"></i> Perfil</a>
                                </li>
                                <li>
                                    <a href="mensajes"><i class="fa fa-fw fa-envelope"></i> Mensajes</a>
                                </li>

                                <li class="divider"></li>
                                <li>
                                    <a href="index"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                                </li>
                            </ul>
                        </li>
                    </ul>


                    <ul class="nav navbar-nav">
                        <li>
                            <a href="Estudiantes">Regresar al menú</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="row">
                <div class="box">

                    <div class="col-lg-3 text-center">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="navbar-collapse collapse sidebar-navbar-collapse" >
                                    <ul class="nav navbar-nav">
                                        <li class="active"><a style="font-size: small;" href="verEstudiante-${enc.id}">Información niño</a></li>
                                        <li class="active"><a style="font-size: small;" href="detallesMatricula-${enc.id}">Información matrícula</a></li>
                                        <li class="active"><a style="font-size: small;" href="verFamiliares-${enc.id}">Información familiares</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="col-lg-9 text-center">

                        <div class="panel panel-default">
                            <div class="panel-body" style="font-family: 'Josefin Slab','Helvetica Neue',Helvetica,Arial,sans-serif; ">
                                <div class="media-body">
                                    <h4 class="media-heading">${enc.nombre} ${enc.apellido1} ${enc.apellido2}</h4>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-body" style="font-family: 'Josefin Slab','Helvetica Neue',Helvetica,Arial,sans-serif; ">
                                <h4>Detalles de la matrícula</h4>
                                <form:form method="POST" action="EditarDetallesMatriculaCambiar"  modelAttribute="objeto" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                                    <form:input type="hidden" path="id"  id="id"/>
                                    <table class="tableInvisivle">
                                        <tr><td><strong>Documentación completa</strong></td>
                                            <td><form:select path="infoCompleta" items="${opciones}" class="form-control input-sm" id="completa"/></td></tr>
                                        <tr><td><strong>Presento carné de vacunas</strong></td>
                                            <td><form:select path="vacunas" items="${opciones}" class="form-control input-sm" id="carnetVacunas"/></td></tr>
                                        <tr><td><strong>Presento constancia de nacimiento</strong></td>
                                            <td> <form:select path="consNacimiento" items="${opciones}" class="form-control input-sm" id="constanciaNacimeinto"/></td></tr>
                                        <tr><td><strong>Presento Fotos</strong></td>
                                            <td> <form:select path="tieneFotos" items="${opciones}" class="form-control input-sm" id="fotos" required="true" /></td></tr>
                                        <tr><td><strong>Total del Pago ¢</strong></td>
                                            <td><form:input path="monto" type="number" class="form-control" id="monto"
                                                placeholder="monto" required="true" /></td></tr>
                                       
                                        <tr><td><strong>Curso lectivo</strong></td>
                                            <td><form:input path="curso" type="number" class="form-control" id="curso"
                                                placeholder="2016"/></td></tr>
                                       
                                    </table>
                                    <br/>
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-8">
                                            <button type="submit" class="btn btn-info">Guardar</button>
                                        </div>
                                    </div>

                                </form:form>

                            </div>
                        </div>
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

    <script>
        $(document).ready(function () {
            $('#nivel').change(function (event) {
                var nombreVar = $('#nivel').val();
                // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                $.post('seleccionar', {
                    nombre: nombreVar
                }, function (responseText) {
                    $('#tablita').html(responseText);
                });
            });
        });
    </script>
</html>
