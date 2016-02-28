/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import javax.validation.Valid;
import modelo.Contacto;
import modelo.Encargado;
import modelo.Kinder;
import modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EncargadoService;
import service.NinoService;
import service.ProfesorService;
import service.kinderService;

/**
 *
 * @author Isa
 */
@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    kinderService kinderService;

    @Autowired
    EncargadoService EncargadoService;
    
    @Autowired
    ProfesorService ProfesorService;
    
    @Autowired
    NinoService ninoService;
    
    @RequestMapping(value = {"/quienes"}, method = RequestMethod.GET)
    public String listKinder(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);
            Collection<Contacto> l = kinder.getContactos();
            if(l!=null && l.size() > 0)
                model.addAttribute("contactos", ((Contacto)l.toArray()[0]).getDescripcion());
        }
        return "quienes";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String loadIndex(ModelMap model) {
        return "index";
    }
        @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String loadIndexAllTheTimes(ModelMap model) {
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
    
    @RequestMapping(value = {"/quienes-ejemplo-encargado"}, method = RequestMethod.GET)
    public String listEncargado(ModelMap model) {
        Encargado en = EncargadoService.findbyId("90110010");
        if (en != null) {

            model.addAttribute("encargado", en);
        }
        return "quienes";
    }  
    
    @RequestMapping(value = {"ProfesorEjemplo"}, method = RequestMethod.GET)
    public String listProfesor(ModelMap model) {
        Profesor profesor = ProfesorService.findbyId("116130203");
        if (profesor != null) {
            model.addAttribute("profesor", profesor);
        }
        return "quienes";
    }
    
    @RequestMapping(value = {"/AgregarContactoKinder"}, method = RequestMethod.GET)
    public String newContacto(ModelMap model) {
        SecureRandom random = new SecureRandom();
        Contacto contacto = new Contacto();
        contacto.setCodigo(new BigInteger(130, random).toString(32));
        model.addAttribute("contacto", contacto);
        return "agregarContacto";
    }
    
    @RequestMapping(value = {"/AgregarContactosKinder"}, method = RequestMethod.POST)
    public String addContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());
        if(result.hasErrors()) {
            System.out.println("has errors");            
            model.addAttribute("msg", "No se agrego el contacto con exito");
            return "agregarContacto";
        }
        
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        kinder.getContactos().add(contacto);
        kinderService.UpdateKinder(kinder);
        model.addAttribute("msg", "Se agrego el contacto con exito");
        return "agregarContacto";
    }
}
