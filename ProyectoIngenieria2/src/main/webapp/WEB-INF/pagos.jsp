<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div id="tituloGRANDE"class="brand">Kinder Lulú</div>
            </div>


        </div>


        <div id="second"  class="row">


            <h3 id="Titulo">PAGOS</h3>


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
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="Encargado">Regresar al menú</a>
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

                    <form  style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="nombre" class="col-lg-2 control-label">Nombre:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="nombre" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="apellidos" class="col-lg-2 control-label">Apellidos:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="apellidos" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="cedula" class="col-lg-2 control-label">Cédula:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="cedula" >
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="grupo" class="col-lg-2 control-label">Grupo:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="grupo" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="montop" class="col-lg-2 control-label">Monto a pagar:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="montop" >
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="montoc" class="col-lg-2 control-label">Monto a cobrar:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="montoc" >
                            </div>
                        </div>


                        <div class="form-group">

                            <table style="margin-left: 20%;"> 
                                <tr> 
                                    <td colspan="2"></td>
                                    <td style="left:inherit;" > 
                                        <div class="form-group">

                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button display="line" type="submit" class="btn btn-default">Pagar</button>
                                            </div>

                                        </div>
                                    </td> 
                                    <td style="right:inherit;">  
                                        <div class="form-group">

                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button display="line" type="submit" class="btn btn-default" href="index">Cancelar</button>
                                            </div>

                                        </div>
                                    </td> 
                                </tr> 
                            </table>

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
