<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!--%

    Usuario user = (Usuario) session.getAttribute("user");
    
    if (user != null && user.isAdministrador()) {

    } else {
        response.sendRedirect("index");
    }
%-->
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
        <script src="resources/js/jquery.js"></script>
        <script src="resources/js/validarForm.js"></script>
        <script src="resources/js/jquery.maskedinput.js" type="text/javascript"></script>

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

            <h3 id="Titulo">Matrícula</h3>



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

                    <div class="col-lg-12 text-center" >

                        <h2 class="intro-text text-center">Boleta de matrícula  
                        </h2>


                        <hr>
                    </div>

                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>




                    <form:form method="POST" action="Matricular"  modelAttribute="persona" style='font-family: "Josefin Slab","Helvetica Neue",Helvetica,Arial,sans-serif;' class="form-horizontal" onsubmit="return validarContrasena()" role="form">
                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>
                            <div  class="form-group">
                                <label for="nombre" class="col-lg-2 control-label">Nombre del alumno:</label>
                                <div class="col-lg-8">
                                    <form:input path="nombre" type="text" class="form-control" id="nombre"
                                                placeholder="Nombre del niño" onkeydown="return validarLetras(event)"/>
                                </div>
                            </div>
                            <div style='margin-bottom: 7%'  class="form-inline">
                                <label for="primerApellido" class="col-lg-2 control-label">Primero apellido:</label>
                                <div class="col-lg-4">
                                    <form:input path="apellido1" type="text" class="form-control" id="primerApellido" 
                                                placeholder="Apellidos del niño" onkeydown="return validarLetras(event)" />
                                </div>
                                <label for="segundoApellido" class="col-lg-2 control-label">Segundo apellido:</label>
                                <div class="col-lg-4">
                                    <form:input path="apellido2" type="text" class="form-control" id="segundoApellido" 
                                                placeholder="Apellidos del niño" onkeydown="return validarLetras(event)" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="cedula" class="col-lg-2 control-label">Cédula del alumno:</label>
                                <div class="col-lg-8">
                                    <form:input path="id" type="text" class="form-control" id="cedula"
                                                placeholder="#-####-####" required="true" />
                                </div>
                            </div>
                            <div style='margin-bottom: 7%' class="form-inline">
                                <label for="fechaN" class="col-lg-2 control-label">Fecha de nacimiento:</label>
                                <div class="col-lg-4">
                                    <form:input path="fechaNacimiento" type="Date" class="form-control" id="fechaN" 
                                                placeholder="dd/mm/yyyy"  />
                                </div>
                                <label for="telefono" class="col-lg-2 control-label">Teléfono del domicilio:</label>
                                <div class="col-lg-4">
                                    <form:input path="telefono" type="text" class="form-control" name="telefono" id="telefono" 
                                                placeholder="Teléfono" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="direccion" class="col-lg-2 control-label">Dirección exacta del domicilio:</label>
                                <div class="col-lg-8">
                                    <form:input path="direccion" type="text" class="form-control" id="direccion"
                                                placeholder="Dirección del hogar"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-lg-2 control-label">Correo electrónico para crear perfil:</label>
                                <div class="col-lg-8">
                                    <form:input path="email" type="email" class="form-control" id="email"
                                                placeholder="ejemplo@gmail.com" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="col-lg-2 control-label">Contraseña:</label>
                                <div class="col-lg-8">
                                    <form:input path="password" type="password" class="form-control" id="password"
                                                name="password"    placeholder="Contraseña" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="passwordC" class="col-lg-2 control-label">Confirmar contraseña:</label>
                                <div class="col-lg-8">
                                    <form:input path="" type="password" class="form-control" id="passwordC"
                                                name="passwordC"    placeholder="Contraseña" onchange="validarContrasena()" required="true"/>
                                </div>
                                <div id="seccionError">
                                    <p style="color: red;" id="error">
                                </div>
                            </div>


                        </div>

                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>
                            <div  class="form-group">
                                <label for="nombrePadre" class="col-lg-2 control-label">Nombre del padre:</label>
                                <div class="col-lg-8">
                                    <form:input path="nombrePadre" type="text" class="form-control" id="nombrePadre"
                                                placeholder="Nombre del padre" onkeydown="return validarLetras(event)"/>
                                </div>
                            </div>
                            <div style='margin-bottom: 7%'  class="form-inline">
                                <label for="edadPadre" class="col-lg-2 control-label">Edad:</label>
                                <div class="col-lg-4">
                                    <form:input path="edadPadre" type="text" class="form-control" id="edadPadre" 
                                                placeholder="Edad del padre"  />
                                </div>
                                <label for="cedulaPadre" class="col-lg-2 control-label">Cédula:</label>
                                <div class="col-lg-4">
                                    <form:input path="cedulaPadre" type="text" class="form-control" id="cedulaPadre" 
                                                placeholder="#-####-####"  />
                                </div>
                            </div>



                            <div style='margin-bottom: 12%' class="form-inline">
                                <label for="telefonoTrabajoPadre" class="col-lg-2 control-label">Teléfono del trabajo:</label>
                                <div class="col-lg-4">
                                    <form:input path="telefonoTrabajoPadre" type="text" class="form-control" id="telefonoTrabajoPadre" 
                                                placeholder="Teléfono"  />
                                </div>
                                <label for="telefonoPersonalPadre" class="col-lg-2 control-label">Teléfono personal:</label>
                                <div class="col-lg-4">
                                    <form:input path="telefonoPersonalPadre" type="text" class="form-control" id="telefonoPersonalPadre" 
                                                placeholder="Teléfono"  />
                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="ocupacionPadre" class="col-lg-2 control-label">Ocupación:</label>
                                <div class="col-lg-8">
                                    <form:input path="ocupacionPadre" type="text" class="form-control" id="ocupacionPadre"
                                                placeholder="Ocupación del padre"/>
                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="lugarTrabajoPadre" class="col-lg-2 control-label">Lugar de trabajo:</label>
                                <div class="col-lg-8">
                                    <form:input path="lugarTrabajoPadre" type="text" class="form-control" id="lugarTrabajoPadre"
                                                placeholder="Lugar de trabajo"/>
                                </div>
                            </div>
                        </div>


                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>
                            <div  class="form-group">
                                <label for="nombreMadre" class="col-lg-2 control-label">Nombre de la madre</label>
                                <div class="col-lg-8">
                                    <form:input path="nombreMadre" type="text" class="form-control" id="nombreMadre"
                                                placeholder="Nombre del la madre" onkeydown="return validarLetras(event)"/>
                                </div>
                            </div>
                            <div style='margin-bottom: 7%'  class="form-inline">
                                <label for="edadMadre" class="col-lg-2 control-label">Edad:</label>
                                <div class="col-lg-4">
                                    <form:input path="edadMadre" type="text" class="form-control" id="edadMadre" 
                                                placeholder="Edad"  />
                                </div>
                                <label for="cedulaMadre" class="col-lg-2 control-label">Cédula:</label>
                                <div class="col-lg-4">
                                    <form:input path="cedulaMadre" type="text" class="form-control" id="cedulaMadre" 
                                                placeholder="#-####-####"  />
                                </div>
                            </div>



                            <div style='margin-bottom: 12%' class="form-inline">
                                <label for="telefonoTrabajoMadre" class="col-lg-2 control-label">Teléfono del trabajo:</label>
                                <div class="col-lg-4">
                                    <form:input path="telefonoTrabajoMadre" type="text" class="form-control" id="telefonoTrabajoMadre" 
                                                placeholder="Teléfono del trabajo"  />
                                </div>
                                <label for="telefonoPersonalMadre" class="col-lg-2 control-label">Teléfono personal:</label>
                                <div class="col-lg-4">
                                    <form:input path="telefonoPersonalMadre" type="text" class="form-control" id="telefonoPersonalMadre" 
                                                placeholder="Teléfono personal"  />
                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="ocupacionMadre" class="col-lg-2 control-label">Ocupación:</label>
                                <div class="col-lg-8">
                                    <form:input path="ocupacionMadre" type="text" class="form-control" id="ocupacionMadre"
                                                placeholder="Ocupación de la madre"/>
                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="lugarTrabajoMadre" class="col-lg-2 control-label">Lugar de trabajo:</label>
                                <div class="col-lg-8">
                                    <form:input path="lugarTrabajoMadre" type="text" class="form-control" id="lugarTrabajoMadre"
                                                placeholder="Lugar de trabajo"/>
                                </div>
                            </div>
                        </div>

                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>

                            <div  class="form-group">
                                <label for="nombreEncargado" class="col-lg-2 control-label">Nombre de persona encargada(caso de emergencia):</label>
                                <div class="col-lg-8">
                                    <form:input path="nombreEncargado" type="text" class="form-control" id="nombreEncargado"
                                                placeholder="Nombre del encargado" onkeydown="return validarLetras(event)"/>
                                </div>
                            </div>

                            <div  class="form-group">
                                <label for="cedulaEncargado" class="col-lg-2 control-label">Cédula:</label>
                                <div class="col-lg-8">
                                    <form:input path="cedulaEncargado" type="text" class="form-control" id="cedulaEncargado"
                                                placeholder="Cédula del encargado"/>
                                </div>
                            </div>

                            <div  class="form-group">
                                <label for="telefonoEncargado" class="col-lg-2 control-label">Teléfono:</label>
                                <div class="col-lg-8">
                                    <form:input path="telefonoEncargado" type="text" class="form-control" id="telefonoEncargado"
                                                placeholder="Teléfono "/>
                                </div>
                            </div>
                        </div>
                        <h2 class="brand-before">
                            <small>Información del niño </small>
                        </h2>

                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>
                            <div  class="form-group">
                                <label for="enfermedad" class="col-lg-2 control-label">¿Ha padecido de alguna enfermedad?:</label>
                                <div class="col-lg-8">
                                    <form:textarea path="enfermedad" rows="3" class="form-control" id="enfermedad"
                                                   placeholder="Cite el nombre"/>
                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="medicamento" class="col-lg-2 control-label">¿Usa algún  Medicamentó?:</label>
                                <div class="col-lg-8">
                                    <form:textarea path="medicamento" rows="3" class="form-control" id="medicamento"
                                                   placeholder="Cite el nombre"/>
                                </div>
                            </div>

                        </div>

                        <h2 class="brand-before">
                            <small>Exclusivo de la institución  </small>
                        </h2>

                        <div id='wrapper' style=' border: solid 1px #cccccc; border-radius: 5px; margin-bottom: 3%; padding: 2%'>
                            <div  class="form-group">
                                <label for="nivel" class="col-lg-2 control-label">El estudiante Cursará: el nivel de:</label>
                                <div class="col-lg-4">
                                    <form:select path="nivel" items="${niveles}" class="form-control input-sm" id="nivel" required="true" />

                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="completa" class="col-lg-2 control-label">Documentación completa:</label>
                                <div class="col-lg-4">
                                    <form:select path="infoCompleta" items="${opciones}" class="form-control input-sm" id="completa" required="true" />

                                </div>
                            </div>

                            <div  class="form-group">
                                <label for="constanciaNacimeinto" class="col-lg-2 control-label">Constancia de nacimiento:</label>
                                <div class="col-lg-4">
                                    <form:select path="consNacimiento" items="${opciones}" class="form-control input-sm" id="constanciaNacimeinto" required="true" />

                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="carnetVacunas" class="col-lg-2 control-label">Carné de vacunas:</label>
                                <div class="col-lg-4">
                                    <form:select path="vacunas" items="${opciones}" class="form-control input-sm" id="carnetVacunas" required="true" />

                                </div>
                            </div>
                            <div  class="form-group">
                                <label for="fotos" class="col-lg-2 control-label">Fotos:</label>
                                <div class="col-lg-4">
                                    <form:select path="tieneFotos" items="${opciones}" class="form-control input-sm" id="fotos" required="true" />

                                </div>
                            </div>

                            <div style='margin-bottom: 7%'  class="form-inline">
                                <label for="monto" class="col-lg-2 control-label">Canceló matrícula ¢;</label>
                                <div class="col-lg-4">
                                    <form:input path="monto" type="text" class="form-control" id="monto" 
                                                placeholder="monto" required="true" />
                                </div>
                                <label for="curso" class="col-lg-2 control-label">Curso:</label>
                                <div class="col-lg-4">
                                    <form:input path="curso" type="text" class="form-control" id="curso" 
                                                placeholder="2016" required="true"  />
                                </div>
                            </div>

                            <div  class="form-group">
                                <label for="persona" class="col-lg-2 control-label">Matrícula realizada por:</label>
                                <div class="col-lg-8">
                                    <form:input path="persona" type="text" class="form-control" id="persona"
                                                placeholder="Nombre persona que realizo la matrícula " onkeydown="return validarLetras(event)"/>
                                </div>
                            </div>

                        </div>


                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-8">
                                <button type="submit" class="btn btn-info">Matricular</button>
                            </div>
                        </div>

                        <div id="seccionError">
                            <p style="color: red;" id="error">
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
        <script type="text/javascript">
            $('.carousel').carousel({
                interval: 5000 //changes the speed
            });


        </script>

    </body>
</html>