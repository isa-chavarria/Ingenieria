
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
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Kinder Lul�</title>

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
                <div id="tituloGRANDE"class="brand">Kinder Lul�</div>
            </div>


        </div>


        <div id="second"  class="row">


            <h3 id="Titulo">IMAGENES DEL KINDER</h3>


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
                            <a href="index">Inicio</a>
                        </li>
                        <li>
                            <a href="quienes">�Qui�nes Somos?</a>
                        </li>
                        <li>
                            <a href="requerimientos">Requerimientos de matricula</a>
                        </li>
                        <li>
                            <a href="contacto">Contactenos</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="col-lg-12">
                <hr>
                <h2 class="intro-text text-center">Nuestros
                    Estudiantes
                </h2>
                <hr>
            </div>
            <div class="imagenes" >
                <div class="row"  >
                    <div style=" overflow: scroll ; height: 400px " class="box">

                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/aa.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/graduacion.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/profesiones.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/equipo.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>

                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/dos.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/ll.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/n.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/ninos.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>

                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/parq.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/pintar.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/tres.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                            <a class="thumbnail" href="#">
                                <img class="img-responsive" src="resources/img/arreglada3.jpg" style="height: 300%; width: 400%;">
                            </a>
                        </div>

                    </div>

                </div>

                <div class="row">

                    <div class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">Nuestro
                            <strong>Equipo</strong>
                        </h2>
                        <hr>
                    </div>
                    <div class="col-sm-4 text-center">
                        <img class="img-responsive" src="resources/img/rosi.jpg" alt="">
                        <h3>Rosibeth Garcia

                        </h3>
                    </div>
                    <div class="col-sm-4 text-center">
                        <img class="img-responsive" src="resources/img/mari.jpg" alt="">
                        <h3>Maria Solano

                        </h3>
                    </div>
                    <div class="col-sm-4 text-center">
                        <img class="img-responsive" src="resources/img/equipo.jpg" alt="">
                        <h3>Maestras

                        </h3>
                    </div>
                    <div class="clearfix"></div>

                </div>


            </div>


        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <p>Administraci�n del Kinder. Copyright 2016</p>
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