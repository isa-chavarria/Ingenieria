<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="brand">KINDER LULU</div>
            </div>


        </div>


        <div id="second"  class="row">

            <h1 id="Titulo">MATRICULA</h1>



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

                    <div class="col-lg-12 text-center">

                        <h2 class="intro-text text-center">Matricula
                        </h2>


                        <hr>
                    </div>


                    <form style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;'class="form-horizontal" role="form">
                        <div  class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Nombre del niño:</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="ejemplo_email_3"
                                       placeholder="Nombre del niño">
                            </div>
                        </div>
                        <div  class="form-group">
                            <label for="ejemplo_password_3" class="col-lg-2 control-label">Apellidos del niño:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="ejemplo_password_3" 
                                       placeholder="Apellidos del niño"   >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Cedula del niño:</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="ejemplo_email_3"
                                       placeholder="#-####-####-####">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_password_3" class="col-lg-2 control-label">Fecha de nacimiento:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="ejemplo_password_3" 
                                       placeholder="Fecha de nacimiento del niño"  >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Padecimientos:</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="ejemplo_email_3"
                                       placeholder="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_password_3" class="col-lg-2 control-label">Nombre Encargado:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="ejemplo_password_3" 
                                       placeholder="Nombre del Encargado" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Cedula Encargado:</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="ejemplo_email_3"
                                       placeholder="#-####-####">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_password_3" class="col-lg-2 control-label">Telefono:</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="ejemplo_password_3" 
                                       placeholder="####-####" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ejemplo_email_3" class="col-lg-2 control-label">Direccion:</label>
                            <div class="col-lg-10">
                                <input type="email" class="form-control" id="ejemplo_email_3"
                                       placeholder="Direccion">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button type="submit" class="btn btn-info">Matricular</button>
                            </div>
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