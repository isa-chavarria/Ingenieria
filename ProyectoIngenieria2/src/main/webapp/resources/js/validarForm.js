/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarError(mensaje, id) {
    contenido = document.getElementById(id);
    contenido.innerHTML += mensaje + "<br/>";
}




function fecha() {

    $('#fechaN').datetimepicker({
        dateFormat: 'yy-mm-dd',
        maxDate: '+1970/01/01'
    });


}




jQuery(function ($) {
    $("#telefono").mask("9999-9999");
});
jQuery(function ($) {
    $("#telefonoTrabajoPadre").mask("9999-9999");
});
jQuery(function ($) {
    $("#telefonoPersonalPadre").mask("9999-9999");
});
jQuery(function ($) {
    $("#telefonoTrabajoMadre").mask("9999-9999");
});

jQuery(function ($) {
    $("#telefonoPersonalMadre").mask("9999-9999");
});
jQuery(function ($) {
    $("#telefonoEncargado").mask("9999-9999");
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
        mostrarError("Las contraseñas no coinciden", "error");
        return false;
    }
    return true;
}


function validar() {

    var b1 = validarContrasena();

    var b2 = validarContrasenaAnterior();

    return b1 && b2;
}


function validarContrasenaAnterior() {
    document.getElementById("errorAnterior").innerHTML = "";
    var c1 = document.getElementById("passAnt").value;
    var c2 = document.getElementById("passwordA").value;
    if (c1 !== c2) {
        mostrarError("La contraseña no es correcta", "errorAnterior");
        return false;
    }
    return true;
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


