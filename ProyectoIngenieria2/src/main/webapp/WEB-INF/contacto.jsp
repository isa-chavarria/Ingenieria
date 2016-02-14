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
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/business-casual.css" rel="stylesheet">

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
        <div   id="arriba" class="row">
            <div class="col-sm-4">


                <img style="height: 50%; width: 50%; " src="img/escudo.png" alt="">


            </div>


            <div  class="col-sm-8" style=" padding: 1%">

                <div class="brand">Contactenos</div>
            </div>
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
                    <a class="navbar-brand" href="index.html">Business Casual</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="index.jsp">Inicio</a>
                        </li>
                        <li>
                            <a href="quienes.jsp">Quienes Somos</a>
                        </li>
                        <li>
                            <a href="galeria.jsp">Galeria</a>
                        </li>

                        <li>
                            <a href="requerimientos.jsp">Requerimientos de matricula</a>
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
                    <div style="margin-bottom: 5%;" class="col-lg-12">
                        <hr>
                        <h2 class="intro-text text-center">Contacto
                        </h2>
                        <hr>
                    </div>

                    <div class="text-center">
                        <table style="margin-left: 30%; ">
                            <tr style="border-bottom: solid 1px"><td style="padding:  4%; text-align: left">Teléfono: </td><td style="padding:  4%; text-align: left">2227-3171.</td></tr>
                            <tr style="border-bottom: solid 1px"><td  style="padding:  4%; text-align: left">Facebook:</td><td  style="padding:  4%; text-align: left"><strong><a href="http://facebook.com/kinderlulu1986">Kinder Lulu Facebook.</a></strong></td></tr>
                            <tr style="border-bottom: solid 1px"><td style="padding:  4%; text-align: left">Dirección:</td><td style="padding:  4%; text-align: left">San Sebastian Calle tres, 100 m este y 250 m sur.</td></tr>
                            <tr style="border-bottom: solid 1px"><td style="padding:  4%; text-align: left">Correo electrónico: </td><td style="padding:  4%; text-align: left">kinderlulu1986@hotmail.com.</td></tr>
                        </table>
                    </div>
                    <div class="clearfix"></div>

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
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Script to Activate the Carousel -->
        <script>
            $('.carousel').carousel({
                interval: 5000 //changes the speed
            })
        </script>

    </body>
</html>
