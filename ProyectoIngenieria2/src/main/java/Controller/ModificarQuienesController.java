/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.validation.Valid;

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
//@RequestMapping("ModificaQuienes.html")
public class ModificarQuienesController {

    @Autowired
    kinderService kinderService;
    @RequestMapping(value = {"/ModificaQuienes"}, method = RequestMethod.POST)
    public String updateQuienes(@Valid Kinder kinder, BindingResult result, ModelMap model) {
        System.out.println(kinder.getVision());
        
        model.addAttribute("kinder", kinder);
     

        return "ActualizarQuienes";
    }
        @RequestMapping(value = {"/ModificarQuienesModicado"}, method = RequestMethod.POST)
    public String updateQuienes2(@Valid Kinder kinder, BindingResult result, ModelMap model) {
        Kinder kin = kinderService.findbyName("Kinder Lulu");
        kin.setHistoria(kinder.getHistoria());
        kin.setMision(kinder.getMision());
        kin.setVision(kinder.getVision());
        kinderService.UpdateKinder(kin);
        model.addAttribute("kinder", kin);
        return "quienesAdministrador";
    }
      @RequestMapping(value = {"/quienesAdministrador"}, method = RequestMethod.GET)
    public String loadQuienesAdmin(ModelMap model) {
        Kinder kin = new Kinder();
        model.addAttribute("kinder", kin);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);

        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "quienesAdministrador";
    }

}
