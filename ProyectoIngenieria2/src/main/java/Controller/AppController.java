/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Collection;
import modelo.Contacto;
import modelo.Encargado;
import modelo.Kinder;
import modelo.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
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
}
