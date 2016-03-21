/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Isa
 */


import javax.validation.Valid;
import modelo.Noticia;
import modelo.Kinder;
import modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.NoticiaService;
import service.kinderService;

@Controller
//Esto puede ser cualquier nombre
//@RequestMapping("AgregarNoticias.html")
public class  AgregarNoticiasController  {

    @Autowired
    kinderService kinderService;

    @Autowired
    NoticiaService noticiaService;

    //Usar siempre get aca
     @RequestMapping(value ={"/AgregarNoticias"}, method = RequestMethod.GET)
    public String newNoticia(ModelMap model) {
        Noticia noticia = new Noticia();
        model.addAttribute("noticia", noticia);
        return "agregarNoticia";
    }

    @RequestMapping(value ={"/AgregarNoticias"}, method = RequestMethod.POST)
    public String addNoticia(@Valid Noticia noticia, BindingResult result, ModelMap model) {
        System.out.println(noticia.toString());
        if (result.hasErrors()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego el noticia con exito");
            return "agregarNoticia";
        }

        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        noticia.setKinder(kinder);
        noticiaService.save(noticia);
        kinder.getNoticias().add(noticia);
        System.out.println(kinder.getNoticias() +"caca de gato");
                
        model.addAttribute("msg", "Se agrego el noticia con exito");
        return "agregarNoticia";
    }


}
