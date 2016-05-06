<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Encargado"%>
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

        <!-- Bootstrap Core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="resources/css/business-casual.css" rel="stylesheet">
        <link href="resources/css/sb-admin.css" rel="stylesheet">
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/validarForm.js"></script>
        <script src="resources/js/jquery.maskedinput.js" type="text/javascript"></script>
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


            <h3 id="Titulo">PERFIL</h3>

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
                                    <a href="perfil"><i class="fa fa-fw fa-user"></i> Perfil</a>
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
                            <a href="encargado">Regresar al menú</a>
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
                    <div class="leftImage">


                        <img class="img-circle" src=" ${enc.getRuta_imagen2()} " width="50%" height="150px" alt="">
                    </div>

                    <div class="rightImage"  >

                        <hr>
                        <h2 class="intro-text text-center" style=" color: #ffffff;" >${enc.nombre} ${enc.apellido1} ${enc.apellido2} </h2>
                        <hr>



                    </div>

                    <div class="dec">  </div>

                </div>

            </div>




            <div class="row">
                <div class="col-lg-3 text-center">
                    <div class="panel panel-default">
                        <div class="panel-body">


                            <div class="sidebar-nav">
                                <div role="navigation">
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                        <span class="visible-xs navbar-brand">Sidebar menu</span>
                                    </div>
                                    <div class="navbar-collapse collapse sidebar-navbar-collapse" >
                                         <ul class="nav navbar-nav">
                                            <li class="active"><a style="font-size: small;" href="#">Información</a></li>

                                            <li><a style="font-size: small;" href="perfilCuentaUsuario">cuenta</a></li>

                                            <li><a style="font-size: small;" href="informacionFamiliares">Familiares</a></li>

                                            <li><a style="font-size: small;" href="#">Padecimientos</a></li>
                                        </ul>
                                    </div><!--/.nav-collapse -->
                                </div>
                            </div>



                        </div>
                    </div>
                </div>

                <div class="col-lg-9 text-center">
                    <div class="panel panel-default">
                        <div class="panel-body" style="font-family: 'Josefin Slab','Helvetica Neue',Helvetica,Arial,sans-serif; ">
                            <form:form method="POST" action="agregarFamiliares"  modelAttribute="familiar" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                                <form:input type="hidden" path="codigo" id="codigo"/>
                                

                                <h4 style="color:red">Agregar nuevo familiar</h4>
                                <table class="tableInvisivle">

                                    <tr>
                                        <td><strong>Nombre:</strong></td>
                                        <td><form:input path="nombre" type="text" class="form-control col-lg-3" id="nombre"
                                                    placeholder="Nombre" onkeydown="return validarLetras(event)"/></td>
                                        <td><strong>Edad:</strong></td>
                                        <td><form:input path="edad" type="number" class="form-control col-lg-3" id="edad"
                                                    placeholder="edad" /></td>

                                    </tr>
                                    <tr>
                                        <td><strong>Ocupación:</strong></td>
                                        <td><form:input path="ocupacion" type="text" class="form-control col-lg-3" id="ocupacion"
                                                    placeholder="ocupacion" /></td>
                                        <td><strong>Telefono personal:</strong> </td>
                                        <td><form:input path="numeroPersonal" type="text" class="form-control col-lg-3"  name="telefono" id="telefono"/></td>

                                    </tr>
                                    <tr>
                                        <td><strong>Lugar de trabajo:</strong></td>
                                        <td><form:input path="lugarTrabajo" type="text" class="form-control col-lg-3" id="lugarTrabajo"/></td>
                                        <td><strong>Numero de trabajo:</strong></td>
                                        <td><form:input path="numeroTrabajo" type="text" class="form-control col-lg-3" name="telefonoTrabajoPadre" id="telefonoTrabajoPadre"/></td>

                                    </tr>
                                    <tr>
                                        <td><strong>Relación:</strong></td>
                                        <td><form:input path="parentesco" type="text" class="form-control col-lg-3" id="parentesco"/></td>
                                        <td><strong>Cédula:</strong></td>
                                        <td><form:input path="id" id="cedula" type="text" class="form-control col-lg-3" placeholder="#-####-####"/></td>
                                    </tr>
                                    <tr>
                                        <td><strong></strong></td>
                                        <td></td>
                                        <td><button type="submit" class="btn btn-success">Guardar</button></td>
                                        <td></td>
                                    </tr>

                                </table>
                            </form:form>
                        </div>
                    </div>
                </div>

            </div>

           






            <div class="clearfix"></div>




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

