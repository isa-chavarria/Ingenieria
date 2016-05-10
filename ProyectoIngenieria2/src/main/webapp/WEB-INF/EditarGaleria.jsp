<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%

    Usuario user = (Usuario) session.getAttribute("user");

    if (user != null && user.isEncargado()) {

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
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <!-- Bootstrap Core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/sb-admin.css" rel="stylesheet">
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


        <script>

            function eliminar(id) {


                var element = document.getElementById("album");

                element.value = id;

            }

        </script>

    </head>
    <body>
        <div  id="arriba" class="row">
            <div class="col-sm-4">


               <img style="height: 35%; width: 35%; " src="resources/img/escudo.png" alt="">


            </div>


            <div class="col-sm-8" style="  padding: 1%">
                <div id="tituloGRANDE" class="brand">Kinder Lul�</div>
            </div>


        </div>


        <div id="second"  class="row">


            <h3 id="Titulo">IM�GENES DEL KINDER</h3>


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

                    <ul class="nav navbar-right top-nav">
                    
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Perfil <%=user.getEncargadoOriginal().getNombre()%> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="perfil"><i class="fa fa-fw fa-user"></i> Perfil</a>
                                </li>
                                <li>
                                    <a href="listaMensajes"><i class="fa fa-fw fa-envelope"></i> Mensajes</a>
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
                            <a href="encargado">Regresar al men�</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">

            <h5>${msg}</h5>

            <p></p>
            <div class="col-lg-12">
                <h1 class="intro-text text-center">Im�genes ${al.nombre}
                    <button type="button" id="${al.nombre}" class="btn btn-info custom-width" onclick="eliminar(this.id)" data-toggle="modal" data-target="#myModal">Agregar im�gen</button>
                </h1>

            </div>
            <br/>
            <br/>
            <div style='margin-top: 3%;' class="imagenes" >
                <div class="row"  >

                    <div style=" overflow: scroll ; height: 400px " class="box">
                        <c:forEach items="${al.imagenes}" var="imag">
                            <div class="col-lg-2 col-md-2 col-xs-2">
                                <form:form method="POST"  modelAttribute="imagen" action="eliminarImagenEncarado">
                                    <form:hidden id="cod" path="codigo" value="${imag.codigo}"/>
                                    <button type="submit" class="btn btn-default" aria-label="Left Align">
                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                    </button>
                                </form:form>
                                <a class="thumbnail" href="#">
                                    <img class="img-responsive" src="data:image/gif;base64,${imag.imagen}">
                                </a>

                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>


        </div>

        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Agregar Im�gen</h4>
                    </div>

                    <form method="POST" action="agregarImagenForm2" enctype="multipart/form-data" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                        <div  class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Im�gen</label>
                            <div class="col-lg-10">
                                <input type="file" name="file" class="form-control">
                                <input type="hidden" name="album" id="album">
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success" >Agregar</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        </div>
                    </form> 
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