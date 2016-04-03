<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Encargado"%>
<!DOCTYPE html>
<%

    Usuario user = (Usuario) session.getAttribute("user");
    Encargado enc = (Encargado) session.getAttribute("enc");

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


                        <img class="img-circle" src="  <% out.print(enc.getRuta_imagen()); %> " width="50%" height="150px" alt="">
                    </div>

                    <div class="rightImage"  >

                        <hr>
                        <h2 class="intro-text text-center" style=" color: #ffffff;" ><%  out.print(enc.getNombre() + " " + enc.getApellido1() + " " + enc.getApellido2());%> </h2>
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

                                            <li><a style="font-size: small;" href="#">cuenta</a></li>

                                          
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

                            <div id='wrapper' style=' border-bottom: solid 1px #cccccc; border-radius: 2px; margin-bottom:3%;   padding: 2%'>
                                <label for="ejemplo_email_3" class="col-lg-4 control-label">Nombre completo:  </label>

                                <div class="col-lg-8">
                                    <p class="col-lg-2">   </p>
                                    <p class="col-lg-6"><% out.print(enc.getNombre() + " " + enc.getApellido1() + " " + enc.getApellido2());%> </p>
                                </div>
                                </br>

                            </div>

                            <div id='wrapper' style=' border-bottom: solid 1px #cccccc; border-radius: 2px; margin-bottom:3%;   padding: 2%'>

                                <label for="ejemplo_email_3" class="col-lg-4 control-label">Cédula:  </label>

                                <div class="col-lg-8">
                                    <p class="col-lg-2">   </p>
                                    <p class="col-lg-6"><% out.print(enc.getId());%> </p>
                                </div>
                                </br>
                            </div>

                            <div id='wrapper' style=' border-bottom: solid 1px #cccccc; border-radius: 2px; margin-bottom:3%;   padding: 2%'>
                                <label for="ejemplo_email_3" class="col-lg-4 control-label">Fecha de nacimiento:  </label>

                                <div class="col-lg-8">
                                    <p class="col-lg-2">   </p>
                                    <p class="col-lg-6"><% out.print(enc.getFechaNacimiento());%> </p>
                                </div>
                                </br>
                            </div>

                            <div id='wrapper' style=' border-bottom: solid 1px #cccccc; border-radius: 2px; margin-bottom:3%;   padding: 2%'>
                                <label for="ejemplo_email_3" class="col-lg-4 control-label">teléfono:  </label>

                                <div class="col-lg-8">
                                    <p class="col-lg-2">   </p>
                                    <p class="col-lg-6"><% out.print(enc.getTelefono());%> </p>
                                </div>
                                </br>
                            </div>

                            <div id='wrapper' style=' border-bottom: solid 1px #cccccc; border-radius: 2px; margin-bottom:3%;   padding: 2%'>
                                <label for="ejemplo_email_3" class="col-lg-4 control-label">Dirección  </label>

                                <div class="col-lg-8">
                                    <p class="col-lg-2">   </p>
                                    <p class="col-lg-6"><%out.print(enc.getDireccion());%> </p>
                                </div>
                                </br>
                            </div>



                            <a href='administracion' class="btn btn-success custom-width">Editar</a>

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
