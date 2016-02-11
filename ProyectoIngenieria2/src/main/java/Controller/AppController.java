/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import modelo.Encargado;
import modelo.Kinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EncargadoService;
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

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listKinder(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if(kinder != null)
            model.addAttribute("kinder", kinder);
        return "quienes";
    }
    
        @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listEncargado(ModelMap model) {
        Encargado Encargado = EncargadoService.findbyName("David");
       // for (int i = 0; i < Encargado.size(); i++) {
            if (Encargado != null){
            //    model.addAttribute("encargado", Encargado.get(i).getNombre()+" "+Encargado.get(i).getApellido1()+" "+Encargado.get(i).getApellido2()+" "+Encargado.get(i).getId()+ " "+Encargado.get(i).getFechaNacimiento()+ " "+Encargado.get(i).getEmail()+" "+Encargado.get(i).getDireccion()+" "+Encargado.get(i).getTelefono());
          //  }
          model.addAttribute("encargado",Encargado);
        }
        return "quienes";
    }
}
