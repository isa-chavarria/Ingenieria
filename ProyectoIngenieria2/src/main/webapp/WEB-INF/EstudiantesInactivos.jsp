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

        <title>Kinder Lul�</title>

        <!-- Bootstrap Core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <script src="resources/js/validarForm.js"></script>

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

        <script>

            function eliminar(id) {


                var element = document.getElementById("valor");

                element.value = id;

            }
            
             function eliminar2(id) {


                var element = document.getElementById("valor2");

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
                <div id="tituloGRANDE"class="brand">Kinder Lul�</div>
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
                            <a href="administracion">Regresar al men�</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <div class="container">


            <div class="row">


                <div id="tablita">
                    <h4>Estudiantes inactivos</h4>

                    <div style=" overflow: scroll ; height: 500px " class="box">




                        <table class="table table-bordered table-hover">
                            <thead class="titulosTabla">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>PRIMER APELLIDO</th>
                                    <th>SEGUNDO APELLIDO</th>
                                    <th>FECHA DE NACIMIENTO</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="cuerpoTabla">
                                <c:forEach items="${estudiantes}" var="stu">
                                    <tr class="active">
                                        <td>${stu.id}</td>
                                        <td>${stu.nombre}</td>
                                        <td>${stu.apellido1}</td>
                                        <td>${stu.apellido2}</td>
                                        <td>${stu.fechaNacimiento}</td>
                                        <td><button type="button" id="${stu.id}" class="btn btn-danger custom-width" onclick="eliminar(this.id)" data-toggle="modal" data-target="#myModal">Eliminar</button></td>
                                        <td><button type="button" id="${stu.id}" class="btn btn-success custom-width" onclick="eliminar2(this.id)" data-toggle="modal" data-target="#myModal2">Marcar activo</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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
                        <h4 class="modal-title">�Seguro que desea eliminarlo?</h4>
                    </div>

                    <form:form method="POST" action="EliminarEstudiante"  modelAttribute="estudiante" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                        <form:input type="hidden" path="id"  id="valor"/>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger" >Eliminar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>

                    </form:form>


                </div>

            </div>
        </div>


        <div id="myModal2" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">�Marcar estudiante como activo?</h4>
                    </div>

                    <form:form method="POST" action="CambiarActivo"  modelAttribute="estudiante" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                        <form:input type="hidden" path="id"  id="valor2"/>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success" >Aceptar</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>

                    </form:form>


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
