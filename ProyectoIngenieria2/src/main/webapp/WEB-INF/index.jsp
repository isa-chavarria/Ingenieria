<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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


        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.resources/js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div  id="arriba" class="row">
            <div class="col-sm-4">


                <img style="height: 35%; width: 35%; " src="resources/img/escudo.png" alt="">


            </div>


            <div class="col-sm-8" style="  padding: 1%">
                <div id="tituloGRANDE"class="brand">Kinder Lulú</div>
            </div>


        </div>


        <div style="text-align: center;" id="second"  class="row">

            <c:if test="${fallo}">
                <div  class="alert alert-danger">
                    <p style="color:#ff3333;">Usuario inválido.</p>
                </div>
            </c:if>


            <form:form method="POST" action="Login" modelAttribute="user" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-inline" role="form">
                <form:input type="hidden" path="id" id="id"/>
                <div class="input-group input-sm">
                    <label style="  box-shadow: 0px 0px 20px   rgba(0,0,0,0.2)" class="input-group-addon" for="username"><i class="fa fa-user"></i></label>

                    <form:input style="  z-index: 0; box-shadow: 0px 0px 20px   rgba(0,0,0,0.2)" type="text" class="form-control" path="email" id="email"
                                placeholder="USUARIO"/>

                </div>
                <div class="input-group input-sm">
                    <label style=" box-shadow: 0px 0px 20px   rgba(0,0,0,0.2)" class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 

                    <form:input style="   z-index: 0; box-shadow: 0px 0px 20px   rgba(0,0,0,0.2)" type="password" class="form-control" path="contrasena" id="contrasena" 
                                placeholder="CONTRASENA" />

                </div>

                <button type="submit" style=" box-shadow: 0px 0px 20px   rgba(0,0,0,0.2);text-transform:uppercase; margin-right: 5%;" class="btn btn-info">Iniciar sesión</button>

                <a href='administracion' class="btn btn-default custom-width">¿Olvido su constraseña?</a>
                <form:input type="hidden"  class="form-control" path="id" id="id"/>

            </form:form>



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
                            <a href="quienes"><i class="fa fa-university"></i> ¿Quiénes Somos?</a>
                        </li>

                        <li>
                            <a href="requerimientos"><i class="fa fa-book"></i> Requerimientos de matrícula</a>
                        </li>
                        <li>
                            <a href="contacto"><i class="fa fa-phone"></i> Contáctenos</a>
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
                                    <img class="img-full img-responsive" src="data:image/gif;base64,${primera.imagen}"  alt="">
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
                            <small>Bienvenidos al sitio web del</small>
                        </h2>
                        <h1 class="brand-name">Kinder Lulú</h1>
                        <hr class="tagline-divider">
                        <h2>

                        </h2>
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
            });
        </script>

    </body>
</html>
