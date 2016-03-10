/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import modelo.Contacto;
import modelo.Kinder;
import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EncargadoService;
import service.UsuarioService;
import service.kinderService;

/**
 *
 * @author Isa
 */
@Controller
@RequestMapping("/")
public class AppController extends HttpServlet {

    @Autowired
    kinderService kinderService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EncargadoService encargadoService;

    @RequestMapping(value = {"/prueba"}, method = RequestMethod.GET)
    public String loadPrueba(ModelMap model) {

        Usuario user = usuarioService.findbyId("402270021");
        model.addAttribute("user", user);

        return "prueba";
    }

    @RequestMapping(value = {"/quienes"}, method = RequestMethod.GET)
    public String listKinder(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);
        }
        return "quienes";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String loadIndex(ModelMap model) {
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        model.addAttribute("fallo", false);
        return "index";
    }

    /* @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
     public String loadIndexAllTheTimes(ModelMap model) {

     Usuario user = new Usuario();
     model.addAttribute("user", user);
     model.addAttribute("fallo", false);
     return "index";
     }
     */
    @RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
    public String realizarLoging(@Valid Usuario user, BindingResult result,
            ModelMap model, HttpServletRequest request) {

        String password = user.getContrasena();
        String email = user.getEmail();
        Usuario usu = usuarioService.findByLogin(email, password);
        if (usu != null) {
            if (usu.isAdministrador()) {

                request.getSession().setAttribute("user", usu);
                return "Administracion";
            }
            if (usu.isEncargado()) {
                request.getSession().setAttribute("user", usu);
                return "Encargado";
            }
        }
        Usuario u = new Usuario();
        model.addAttribute("user", u);
        model.addAttribute("fallo", true);
        return "index";
    }

    @RequestMapping(value = {"/LI"}, method = RequestMethod.GET)
    public String loadQuienes(ModelMap model) {
        return "quienes";
    }

    @RequestMapping(value = {"/encargado"}, method = RequestMethod.GET)
    public String loadEncargado(ModelMap model) {
        return "Encargado";
    }

    @RequestMapping(value = {"/administracion"}, method = RequestMethod.GET)
    public String loadAdministracion(ModelMap model) {
        return "Administracion";
    }

    @RequestMapping(value = {"/contacto"}, method = RequestMethod.GET)
    public String loadContacto(ModelMap model) {
        return "contacto";
    }

    @RequestMapping(value = {"/galeria"}, method = RequestMethod.GET)
    public String loadGaleria(ModelMap model) {
        return "galeria";
    }

    @RequestMapping(value = {"/informacion-nino"}, method = RequestMethod.GET)
    public String loadInformacionNino(ModelMap model) {
        return "informacionNino";
    }

    @RequestMapping(value = {"/matricula"}, method = RequestMethod.GET)
    public String loadMatricula(ModelMap model) {
        return "matricula";
    }

    @RequestMapping(value = {"/mensajes"}, method = RequestMethod.GET)
    public String loadMensajes(ModelMap model) {
        return "mensajes";
    }

    @RequestMapping(value = {"/pagos"}, method = RequestMethod.GET)
    public String loadPagos(ModelMap model) {
        return "pagos";
    }

    @RequestMapping(value = {"/perfil"}, method = RequestMethod.GET)
    public String loadPerfil(ModelMap model) {
        return "perfl";
    }

    @RequestMapping(value = {"/requerimientos"}, method = RequestMethod.GET)
    public String loadRequerimientos(ModelMap model) {
        return "requerimientos";
    }

    @RequestMapping(value = {"/Visualizar-Pagos"}, method = RequestMethod.GET)
    public String loadVisualizarPagos(ModelMap model) {
        return "visualizarPagos";
    }

}
