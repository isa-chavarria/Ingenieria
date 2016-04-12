/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.validation.Valid;
import modelo.Album;
import modelo.Imagen;
import modelo.Kinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AlbumService;
import service.kinderService;

@Controller
public class AlbumController {

    @Autowired
    kinderService kinderService;
    @Autowired
    AlbumService albumService;

    @RequestMapping(value = {"/galeria"}, method = RequestMethod.GET)
    public String loadGaleria(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        System.out.println(kinder.toString());
        if (kinder != null) {
            model.addAttribute("albums", kinder.getAlbums());
        } else {
            model.addAttribute("albums", new Kinder().getAlbums());
        }
        Album album = new Album();
        model.addAttribute("album", album);
        return "galeria";
    }

    @RequestMapping(value = {"/galeria"}, method = RequestMethod.POST)
    public String addGaleria(@Valid Album album, BindingResult result, ModelMap model) {
        //  System.out.println(album.toString());
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (result.hasErrors()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego el contacto con exito");

            if (kinder != null) {
                model.addAttribute("albums", kinder.getAlbums());
            } else {
                model.addAttribute("albums", new Kinder().getAlbums());
            }
            Album al = new Album();
            model.addAttribute("album", al);
            return "galeria";
        }

        album.setKinder(kinder);
        albumService.save(album);
        kinder.getAlbums().add(album);

        model.addAttribute("msg", "Se agrego el contacto con exito");
        
        model.addAttribute("albums", kinder.getAlbums());
        Album al = new Album();
        model.addAttribute("album", al);
        
        return "galeria";
    }
    
    @RequestMapping(value = {"/eliminarAlbum"}, method = RequestMethod.POST)
    public String removeContacto(@Valid Album album, BindingResult result, ModelMap model) {

        Album album2 = albumService.findbyId(album.getNombre());
        if (album2 != null) {
            albumService.DeletebyId(album.getNombre());
            model.addAttribute("msg", "Se elimino el album con exito");
        }
        else{
            model.addAttribute("msg", "No se elimino el album con exito");
        }
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        System.out.println(kinder.toString());
        if (kinder != null) {
            model.addAttribute("albums", kinder.getAlbums());
        } else {
            model.addAttribute("albums", new Kinder().getAlbums());
        }
        Album al = new Album();
        model.addAttribute("album", al);
        return "galeria";
    }
    
    @RequestMapping(value = {"/agregarImagen"}, method = RequestMethod.POST)
    public String agregarImagen(@Valid Album album, BindingResult result, ModelMap model) {
        Imagen imagen = new Imagen();
        model.addAttribute("imagen", imagen);
        model.addAttribute("album", album);
        return "agregarImagen";
    }
    
    @RequestMapping(value = {"/agregarImagenForm"}, method = RequestMethod.POST)
    public String addImagen(@Valid Album album, BindingResult result, ModelMap model) {
        //  System.out.println(album.toString());
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (result.hasErrors()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego el contacto con exito");

            if (kinder != null) {
                model.addAttribute("albums", kinder.getAlbums());
            } else {
                model.addAttribute("albums", new Kinder().getAlbums());
            }
            Album al = new Album();
            model.addAttribute("album", al);
            return "galeria";
        }

        album.setKinder(kinder);
        albumService.save(album);
        kinder.getAlbums().add(album);

        model.addAttribute("msg", "Se agrego el contacto con exito");
        
        model.addAttribute("albums", kinder.getAlbums());
        Album al = new Album();
        model.addAttribute("album", al);
        
        return "galeria";
    }
}
