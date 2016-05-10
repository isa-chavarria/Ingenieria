<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Encargado"%>
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
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <!-- Custom CSS -->
        <link href="resources/css/business-casual.css" rel="stylesheet">
        <link href="resources/css/sb-admin.css" rel="stylesheet">
        <!-- Fonts -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/validarForm.js"></script>
        <script src="resources/js/jquery.maskedinput.js" type="text/javascript"></script>
        <style type="text/css">
            .bs-example{
                margin: 20px;
            }
        </style>

        <style>
            .vis{
                display:block;

            }

            .inv{
                display:none;

            }
        </style>
        <script>

            function Cambiar() {



                var formulario = document.getElementById('2');
                var formulario1 = document.getElementById('1');
                var div = document.getElementById("notificacion");

                if (formulario.className == "inv") {
                    formulario.className = 'vis';
                    formulario1.className = 'inv';
                    div.innerHTML = "";
                } else {
                    formulario.className = 'inv';
                    formulario1.className = 'btn btn-success btn-block';

                }

            }

        </script>



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


        <div id="second"  class="row">


            <h3 id="Titulo">Configuración de la cuenta</h3>

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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Perfil <%=user.getEncargadoOriginal().getNombre()%> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="perfilAdministrador"><i class="fa fa-fw fa-user"></i> Perfil</a>
                                </li>
                                <li>
                                    <a href="listaMensajesKinder"><i class="fa fa-fw fa-envelope"></i> Mensajes</a>
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
                <div class="box">
                    <div class="leftImage">



                      <img class="img-circle" src="${enc.getRuta_imagen2()}" style="height:150px; width:50%; " alt="">
                        
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
                                            <li class="active"><a style="font-size: small;" href="perfilAdministrador">Información</a></li>

                                            <li><a style="font-size: small;" href="perfilCuenta">cuenta</a></li>


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
                            <table class="tableInvisivle">
                                <tr>
                                    <td><strong>Nombre completo:</strong></td>
                                    <td>${enc.nombre} ${enc.apellido1} ${enc.apellido2}</td>
                                </tr>
                                <tr>
                                    <td><strong>Correo electrónico:</strong></td>
                                    <td>${enc.email} </td>
                                </tr>

                            </table>

                            <button type="button"  id="1" onclick='Cambiar();' class="btn btn-success btn-block">Editar contraseña</button>

                            <div id='2' class="inv"  style='background: #F2F2F2; border:solid 2px #0066ff ;border-radius: 2px; margin-bottom:3%;   padding: 2%'>
                                <form:form method="POST" action="modificarCuentaAdministrador"  modelAttribute="usuario" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;'class="form-horizontal" onsubmit="return validar()" role="form">
                                    <form:input type="hidden" path="id" id="id"/>
                                    <form:input type="hidden" path="email" id="email"/>
                                    <form:input type="hidden" path="roleSeccion" id="roleSeccion"/>
                                    <form:input type="hidden" path="passAnt" id="passAnt"/>

                                    <table class="tableInvisivle">

                                        <tr>
                                            <td><strong>Contraseña anterior:</strong></td>
                                            <td><form:input type="password"  path="contrasenaA" id="passwordA" required ="true" class="form-control input-sm" onchange="validarContrasenaAnterior()" /></td>
                                            <td><p  style=" font-size: small; color: red;" id="errorAnterior" ></td>
                                        </tr>
                                        <tr>
                                            <td><strong>Contraseña nueva:</strong></td>
                                            <td><form:input type="password"  path="contrasena" id="password" required ="true" class="form-control input-sm"  /></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td><strong>Repetir contraseña nueva:</strong></td>
                                            <td><form:input type="password"  path="" id="passwordC" required ="true" class="form-control input-sm" onchange="validarContrasena()" /></td>
                                            <td><p  style=" font-size: small; color: red;" id="error"></td>
                                        </tr>

                                        <tr>
                                            <td></td>
                                            <td><button type="submit" class="btn btn-success">Guardar</button>        <button type="button"  class="btn btn-danger" onclick='Cambiar();'  data-toggle="collapse" data-target="#demo">Cancelar</button></td>
                                            <td></td>
                                        </tr>


                                    </table>

                                </form:form>
                            </div>

                            <div style="margin-top: 2%" id ='notificacion'>${msg}</div>

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

