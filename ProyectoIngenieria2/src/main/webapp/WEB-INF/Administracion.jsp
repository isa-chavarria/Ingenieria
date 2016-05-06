<%-- 
    Document   : Administracion
    Created on : 04/02/2016, 05:07:38 PM
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
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="resources/css/business-casual.css" rel="stylesheet">
        <link href="resources/css/sb-admin.css" rel="stylesheet">

        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
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


            <h3 id="Titulo">Administración </h3>


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

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Perfil <%=user.getEncargadoOriginal().getNombre()%> <b class="caret"></b></a>
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

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-money"></i> Pagos <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="pagosSeleccionar"><i class="fa fa-money"></i> Registrar pago de mensualidad</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="FacurasSeleccionar"><i class="fa fa-search"></i> Verificar Pagos mensuales</a>
                                </li>   
                                <li class="divider"></li>
                                <li>
                                    <a href="morosos"><i class="fa fa-money"></i> Lista de morosos</a>
                                </li>  
                                <li class="divider"></li>
                                <li>
                                    <a href=" pagosConfiguracion"><i class="fa fa-search"></i> Configurar información de pagos</a>
                                </li>  

                            </ul>
                        </li>
                        <li>
                            <a href="matricula"><i class="fa fa-archive"></i> Matrícula</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-university"></i> Población<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <!--li>
                                    <a href="galeria"><i class="fa fa-picture-o"></i> Galeria</a>
                                </li>
                                <li class="divider"></li-->

                                <li>
                                    <a href="Estudiantes"><i class="fa fa-users"></i> Estudiantes</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="Profesores"><i class="fa fa-graduation-cap"></i> Profesores</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="administradores"><i class="fa fa-user"></i> Administradores sistema</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="EstudiantesInactivos"><i class="fa fa-graduation-cap"></i> Estudiantes inactivos</a>
                                </li>


                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i> Configuración <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="Cal_encargado.jsp"><i class="fa fa-calendar"></i> Calendario</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="galeria"><i class="fa fa-picture-o"></i> Galeria</a>
                                </li>
                                <li class="divider"></li>

                                <li>
                                    <a href="quienesAdministrador"><i class="fa fa-university"></i> ¿Quiénes Somos?</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="contactoAdministrador"><i class="fa fa-phone"></i> Contactos</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="noticiasAdministrador"><i class="fa fa-bell"></i> Noticias</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="NivelesKinder"><i class="fa fa-line-chart"></i> Niveles</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="CursosKinder"><i class="fa fa-language"></i> Cursos especiales</a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="requerimientosAdmin"><i class="fa fa-book"></i> Requerimientos de matrícula</a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="row">
                <div class="box" id="ContenedorCarousel">
                    <div class="col-lg-12 text-center">
                        <div id="carousel-example-generic" class="carousel slide">
                            <!-- Indicators -->
                            <ol class="carousel-indicators hidden-xs">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="img-full img-responsive" src="data:image/gif;base64,${primera.imagen}" alt="">
                                </div>
                                <c:forEach items="${imagenes}" var="imagen">
                                    <div class="item">
                                        <img class="img-full img-responsive" src="data:image/gif;base64,${imagen.imagen}" alt="">
                                    </div>
                                </c:forEach>
                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="icon-prev"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="icon-next"></span>
                            </a>
                        </div>
                        <h2 class="brand-before">
                            <small>Bienvenido</small>
                        </h2>

                        <hr class="tagline-divider">

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
