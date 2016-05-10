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
            var e2 = document.getElementById("1");
            var element = document.getElementById("tipo_pago");

            var val = element.value;
            if (val == "Tarjeta" || val == "Deposito") {

                e2.className = "vis";
            } else {

                e2.className = "inv";
                }
            }



        </script>

    </head>
    <body onload="Cambiar()">
        <div  id="arriba" class="row">
            <div class="col-sm-4">


                <img style="height: 35%; width: 35%; " src="resources/img/escudo.png" alt="">


            </div>


            <div class="col-sm-8" style="  padding: 1%">
                <div id="tituloGRANDE"class="brand">Kinder Lulú</div>
            </div>


        </div>


        <div id="second"  class="row">


            <h3 id="Titulo">Editar factura</h3>


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
                            <a href="facturasAdministracion-${id}">Regresar al menú</a>
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


                    <form:form method="POST" action="EditarLaFactura"  modelAttribute="factura" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;'class="form-horizontal" onsubmit="return validarContrasena()" role="form">
                        <form:input type="hidden" path="codigo"  id="id"/>
                        <form:input type="hidden" path="fecha_actual"  id="fecha"/>
                        <form:input type="hidden" path="id"  id="id"/>
                        <form:input type="hidden" path="mes"  id="id"/>
                        <div class="form-group">

                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre Completo:</label>

                            <div class="col-lg-10">
                                <form:input type="text" path="nombre" id="nombre" class="form-control input-sm" disabled="true"/>
                            </div>

                        </div>

                        <div class="form-group">

                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Cédula:  </label>

                            <div class="col-lg-10">
                                <form:input type="text" path="id" id="id" itemValue="id" class="form-control input-sm" disabled="true"/>
                            </div>

                        </div>



                        <div class="form-group">
                            <label for="monto" class="col-lg-2 control-label">Monto a pagar:</label>
                            <div class="col-lg-10">
                                <form:input path="monto" type="number" class="form-control" id="nombre"
                                            placeholder="monto" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="monto" class="col-lg-2 control-label">Tipo de pago:</label>
                            <div class="col-lg-10">
                                <form:select path="tipo_pago" items="${TiposPago}" onchange="Cambiar()"  class="form-control input-sm" id="tipo_pago" required="true" />
                            </div>
                        </div>


                        <div id="1" class="inv">
                            <div id="1" class="form-group">
                                <label for="monto" class="col-lg-2 control-label">Numero de comprobante:</label>
                                <div class="col-lg-10">
                                    <form:input path="comprobante" type="number" class="form-control" id="comprobante"
                                                placeholder="comprobante" />
                                </div>

                            </div>

                            <div id="2" class="form-group">
                                <label for="monto" class="col-lg-2 control-label">Numero de factura:</label>
                                <div class="col-lg-10">
                                    <form:input path="factura" type="number" class="form-control" id="factura"
                                                placeholder="factura" />
                                </div>

                            </div>
                        </div>

                        <div  class="form-group">
                            <label for="nivel" class="col-lg-2 control-label">Seleccione el mes:</label>
                            <div class="col-lg-4">
                                <form:select path="mes" items="${Meses}" itemValue="codigo" itemLabel="mes" class="form-control input-sm" id="nivel" disabled="true" />

                            </div>
                        </div>



                        <div class="form-group">



                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-8">
                                    <button type="submit" class="btn btn-info">Guardar</button>
                                </div>
                            </div>



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
