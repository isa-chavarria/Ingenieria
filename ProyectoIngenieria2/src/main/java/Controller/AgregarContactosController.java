/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.validation.Valid;
import modelo.Contacto;
import modelo.Kinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ContactoService;
import service.kinderService;

@Controller
//Esto puede ser cualquier nombre
@RequestMapping("AgregarContacto.html")
public class AgregarContactosController {

    @Autowired
    kinderService kinderService;

    @Autowired
    ContactoService contactoService;

    //Usar siempre get aca
    @RequestMapping(method = RequestMethod.GET)
    public String newContacto(ModelMap model) {
        Contacto contacto = new Contacto();
        model.addAttribute("contacto", contacto);
        return "agregarContacto";
    }

    //Usar siempre post aca
    @RequestMapping(method = RequestMethod.POST)
    public String addContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());
        if (result.hasErrors()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego el contacto con exito");
            return "agregarContacto";
        }

        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        contacto.setKinder(kinder);
        contactoService.save(contacto);
        kinder.getContactos().add(contacto);

        model.addAttribute("msg", "Se agrego el contacto con exito");
        return "agregarContacto";
    }

}
