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
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/validarForm.js"></script>
        <script src="resources/js/jquery.maskedinput.js" type="text/javascript"></script>

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

        </script>

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


            <h3 id="Titulo">Profesores </h3>


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
                <div class="form-group">
                    <!--div class="col-lg-offset-2 col-lg-8"-->
                    <button style=" font-family: 'Josefin Slab','Helvetica Neue',Helvetica,Arial,sans-serif;" type="button" id="" class="btn btn-info custom-width" data-toggle="modal" data-target="#myModal">Agregar profesor</button>

                    <!--/div-->
                </div>

                <div id="tablita">

                    <div style=" overflow: scroll ; height: 300px " class="box">




                        <table class="table table-bordered table-hover">
                            <thead class="titulosTabla">
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>EMAIL</th>
                                    <th>TELEFONO</th>
                                    <th>ESPECIALIDAD</th>
                                    <th>SALARIO</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="cuerpoTabla">
                                <c:forEach items="${profesores}" var="profe">
                                    <tr class="active">
                                        <td>${profe.id}</td>
                                        <td>${profe.nombre}</td>
                                        <td>${profe.email}</td>
                                        <td>${profe.telefono}</td>
                                        <td>${profe.rol}</td>
                                        <td>${profe.salario}</td>
                                        <td><a href="EditarProfesor-${profe.id}" class="btn btn-success custom-width">Editar</a></td>
                                        <td><button type="button" id="${profe.id}" class="btn btn-danger custom-width" onclick="eliminar(this.id)" data-toggle="modal" data-target="#myModal2">Eliminar</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>


                </div>

                <h5 style='color:red'>${error}</h5>
                <h5 style='color:green'>${correcto}</h5>
            </div>


        </div>


        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Agregar nuevo profesor</h4>
                    </div>

                    <form:form method="POST" action="AgregarProfesor"  modelAttribute="profesor" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">

                        <div class="modal-footer">
                            <table class="tableInvisivle">
                                <tr><td><strong>cédula</strong></td><td><form:input path="id" type="text" class="form-control" id="cedula"
                                            placeholder="#-###-###" required="true" /></td></tr>
                                <tr><td><strong>Nombre</strong></td><td><form:input path="nombre" type="text" class="form-control" id="nombre"
                                            placeholder="Nombre del profesor" onkeydown="return validarLetras(event)" /></td></tr>
                                <tr><td><strong>Correo electrónico</strong></td><td><form:input path="email" type="email" class="form-control" id="email"
                                            placeholder="ejemplo@gmail.com" /></td></tr>
                                <tr><td><strong>Teléfono</strong></td><td><form:input path="telefono" type="text" class="form-control" id="telefono"
                                            placeholder="####-####" /></td></tr>
                                <tr><td><strong>Salario</strong></td><td><form:input path="salario" type="number" class="form-control" id="salerio"
                                            placeholder="" /></td></tr>
                                <tr><td><strong>Especialidad</strong></td><td><form:input path="rol" type="text" class="form-control" id="especialidad"
                                            placeholder="" onkeydown="return validarLetras(event)" /></td></tr>
                            </table>
                            <br/>
                            <button type="submit" class="btn btn-success" >Guardar</button>
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
                        <h4 class="modal-title">¿Seguro que desea eliminarlo?</h4>
                    </div>

                    <form:form method="POST" action="EliminarProfesor"  modelAttribute="profesor" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                        <form:input type="hidden" path="id"  id="valor"/>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger" >Eliminar</button>
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
