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

import service.kinderService;

@Controller
//Esto puede ser cualquier nombre
@RequestMapping("ModificaQuienes.html")
public class ModificarQuienesController {

    @Autowired
    kinderService kinderService;

    //Usar siempre get aca
    @RequestMapping(method = RequestMethod.GET)
    public String newQuienes(ModelMap model) {
        Kinder kinder = new Kinder();
        model.addAttribute("kinder", kinder);
        return "ActualizarQuienes";
    }

}
