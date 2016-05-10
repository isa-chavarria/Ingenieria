<%-- 
    Document   : javaplanner
    Created on : 12/04/2016, 10:33:27 PM
    Author     : Kenneth
--%>

<%@page import="modelo.Usuario"%>
<%@page import="com.dhtmlx.planner.controls.DHXLocalization"%>
<%@page import="java.util.Calendar"%>

<%

    Usuario user = (Usuario) session.getAttribute("user");

    if (user != null && user.isAdministrador()) {

    } else {
        response.sendRedirect("index");
    }
%>
<html>
    <body>

        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
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
            <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        </head>
        
            <div  id="arriba" class="row">
                <div class="col-sm-4">
                   
                </div>
                <div class="col-sm-8" style="  padding: 1%">
                    <div id="tituloGRANDE"class="brand">Kinder Lulú</div>
                </div>
            </div>
            <div id="second"  class="row">
                <h3 id="Titulo">Actividades</h3>
            </div>
            <!-- Navigation -->
            <nav class="navbar navbar-default" role="navigation">
                <div class="c">
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
                                        <a href="perfil"><i class="fa fa-fw fa-user"></i> Perfil</a>
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
            <div class="planner" id="planner"><%= getPlanner()%></div>
        
        <%@ page import="com.dhtmlx.planner.*,com.dhtmlx.planner.data.*" %>
        <%!
            String getPlanner() throws Exception {
                DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
                s.setWidth(1125);
                Calendar cal = Calendar.getInstance();
                s.setInitialDate(cal);

                s.localizations.set(DHXLocalization.Spanish);
                s.load("events.jsp", DHXDataFormat.JSON);
                s.data.dataprocessor.setURL("events.jsp");
                return s.render();
            }
        %>
        
                </div>
            </div>
            </div>
        <footer>
            <div class="c">
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


