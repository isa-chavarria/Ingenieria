/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarError(mensaje) {
    contenido = document.getElementById("error");
    contenido.innerHTML += mensaje + "<br/>";
}

var numeros = "0123456789";

function tiene_numeros(texto) {
    for (i = 0; i < texto.length; i++) {
        if (numeros.indexOf(texto.charAt(i), 0) !== -1) {
            return 1;
        }
    }
    return 0;
}


var letras = "abcdefghyjklmnñopqrstuvwxyz";

function tiene_letras(texto) {
    texto = texto.toLowerCase();
    for (i = 0; i < texto.length; i++) {
        if (letras.indexOf(texto.charAt(i), 0) !== -1) {
            return 1;
        }
    }
    return 0;
}

var letras = "abcdefghyjklmnñopqrstuvwxyz";

function tiene_minusculas(texto) {
    for (i = 0; i < texto.length; i++) {
        if (letras.indexOf(texto.charAt(i), 0) !== -1) {
            return 1;
        }
    }
    return 0;
}

var letras_mayusculas = "ABCDEFGHYJKLMNÑOPQRSTUVWXYZ";

function tiene_mayusculas(texto) {
    for (i = 0; i < texto.length; i++) {
        if (letras_mayusculas.indexOf(texto.charAt(i), 0) !== -1) {
            return 1;
        }
    }
    return 0;
}

function muestra_seguridad_clave(clave, formulario) {
    seguridad = seguridad_clave(clave);
    formulario.seguridad.value = seguridad + "%";
}


function seguridad_clave(clave) {
    var seguridad = 0;
    if (clave.length !== 0) {
        if (tiene_numeros(clave) && tiene_letras(clave)) {
            seguridad += 30;
        }
        if (tiene_minusculas(clave) && tiene_mayusculas(clave)) {
            seguridad += 30;
        }
        if (clave.length >= 4 && clave.length <= 5) {
            seguridad += 10;
        } else {
            if (clave.length >= 6 && clave.length <= 8) {
                seguridad += 30;
            } else {
                if (clave.length > 8) {
                    seguridad += 40;
                }
            }
        }
    }
    return seguridad;
}

/*function validarLetras(e) {
 
 re = /^([A-Za-z\s]+)$/;
 var x = re.test(e);
 if (!x) {
 
 return false;
 }
 else {
 
 return true;
 }
 }
 */
function validarNombre(nom) {

    if (nom.length === 0) {
        mostrarError("Debe ingresar su nombre.");
        return false;
    }
    if (nom.length > 0) {
        if (validarLetras(nom)) {
            mostrarError("Debe ingresar solo letras en el campo de nombre.");
            return false;
        }
        else {
            return true;
        }
    }

}

function validarApellidos(ap) {
    if (ap.length === 0) {
        mostrarError("Debe ingresar su apellido.");
        return false;
    }
    if (ap.length > 0) {
        if (validarLetras(ap)) {
            mostrarError("Debe ingresar solo letras en el campo de apellido.");
            return false;
        }
        else {
            return true;
        }
    }
}

function validarEmail(email) {
    if (email.length === 0) {
        mostrarError("Debe ingresar su correo electrónico.");
        return false;
    }
    else if (email.length > 0) {
        var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        var x = re.test(email);
        if (!x) {
            mostrarError("Formato de email invalido");
            return false;
        }
        else {
            return true;
        }
    }

}

function validarFecha(date) {
    // re = /^((0[1-9]|1[012])[- /.]0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$/i;
    re = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;

    if (date.length === 0) {
        mostrarError("Debe ingresar su fecha de nacimiento.");
        return false;
    }
    else if (date.length > 0) {
        var x = re.test(date);
        if (!x) {
            mostrarError("Formato de fecha invalido");
            return false;
        }
        else {
            return true;
        }

    }

}

jQuery(function ($) {
    $("#telefono").mask("(999) 9999-9999");
});
jQuery(function ($) {
    $("#telefonoTrabajoPadre").mask("(999) 9999-9999");
});
jQuery(function ($) {
    $("#telefonoPersonalPadre").mask("(999) 9999-9999");
});
jQuery(function ($) {
    $("#telefonoTrabajoMadre").mask("(999) 9999-9999");
});

jQuery(function ($) {
    $("#telefonoPersonalMadre").mask("(999) 9999-9999");
});
jQuery(function ($) {
    $("#telefonoEncargado").mask("(999) 9999-9999");
});
jQuery(function ($) {
    $("#cedula").mask("9-9999-9999");
});
jQuery(function ($) {
    $("#cedulaPadre").mask("9-9999-9999");
});
jQuery(function ($) {
    $("#cedulaMadre").mask("9-9999-9999");
});
jQuery(function ($) {
    $("#cedulaEncargado").mask("9-9999-9999");
});


function validarContrasena() {
    document.getElementById("error").innerHTML = "";
    var c1 = document.getElementById("password").value;
    var c2 = document.getElementById("passwordC").value;
    if (c1 !== c2) {
        mostrarError("Las contrasenas deben de ser iguales.");
        return false;
    }
    return true;
}

function checkForm() {

    var correcto = true;
    document.getElementById("error").innerHTML = "";
    var nom = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var ap1 = document.getElementById("primerAp").value;
    var ap2 = document.getElementById("segundoAp").value;
    var fN = document.getElementById("fechaN").value;
    var c1 = document.getElementById("password").value;
    var c2 = document.getElementById("password2").value;

    if (!validarNombre(nom)) {
        // alert("aquiiii");
        correcto = false;
    }

    if (!validarApellidos(ap1)) {
        correcto = false;
    }
    if (!validarApellidos(ap2)) {
        correcto = false;
    }
    if (!validarEmail(email)) {
        correcto = false;
    }

    if (!(validarContrasena(c1, c2))) {

        correcto = false;
    }

//    if(!(validarFecha(fN))){
//        correcto = false;
//    }

    if (c1.length === 0) {
        mostrarError("Debe ingresar una contraseña.");
        correcto = false;
    }

    return correcto;


//    if (correcto === true) {
//        document.getElementById("success").innerHTML = "Registrado Correctamente";
//        form.reset();
//        form.reset();
//        //registrar persona
//    }


}

function validarNombre2(nom) {



    if (nom.length > 0 && !validarLetras(nom)) {
        mostrarError("Debe ingresar solo letras en el campo de nombre.");
        return false;
    }
    else {
        return true;
    }


}

function validarApellidos2(ap) {


    if (ap.length > 0 && !validarLetras(ap)) {
        mostrarError("Debe ingresar solo letras en el campo de apellido.");
        return false;
    }
    else {
        return true;
    }

}






function checkForm2() {
    var correcto = true;

    var nom = document.getElementById("nombreM").value;

    var ap1 = document.getElementById("primerApM").value;
    var ap2 = document.getElementById("segundoApM").value;
    var fN = document.getElementById("fechaM").value;
    var c1 = document.getElementById("passwordM").value;
    var c2 = document.getElementById("passwordM2").value;


    if (!validarNombre(nom)) {
        correcto = false;
    }

    if (!validarApellidos(ap1)) {
        correcto = false;
    }
    if (!validarApellidos(ap2)) {
        correcto = false;
    }

    if (!(validarContrasena(c1, c2))) {

        correcto = false;
    }

    return correcto;

//    if (correcto === true) {
//        document.getElementById("success").innerHTML = "Modificado Correctamente";
//        form.reset();
//    }

}


function validarLetras(e) {

    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla === 8)
        return true; // backspace
    if (tecla === 32)
        return true; // espacio
    if (e.ctrlKey && tecla === 86) {
        return true;
    } //Ctrl v
    if (e.ctrlKey && tecla === 67) {
        return true;
    } //Ctrl c
    if (e.ctrlKey && tecla === 88) {
        return true;
    } //Ctrl x
    if (tecla === 9 || tecla === 13)
        return true;
    else {

        if (tecla >= 96 && tecla <= 105) {
            return false;
        }

        patron = /[a-zA-Z]/; //patron

        te = String.fromCharCode(tecla);
        return patron.test(te); // prueba de patron

    }



}



function fecha() {

    $('#fechaN').datetimepicker({
        dateFormat: 'yy-mm-dd',
        maxDate: '+1970/01/01'
    });


}

function fecha2() {

    $('#fechaM').datetimepicker({
        dateFormat: 'yy-mm-dd',
        maxDate: '+1970/01/01'
    });


}

//$('#fechaM').datetimepicker({
//    lang: 'en',
//    timepicker: false,
//    format: 'd/m/Y',
//    formatDate: 'Y/m/d',
//    maxDate: '+1970/01/01'
//});
//$('#fechaN').datetimepicker({
//    lang: 'en',
//    timepicker: false,
//    format: 'd/m/Y',
//    formatDate: 'Y/m/d',
//    maxDate: '+1970/01/01'
//});