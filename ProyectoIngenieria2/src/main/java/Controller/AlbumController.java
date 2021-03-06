/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.AlbumService;
import service.ImagenService;
import service.kinderService;

@Controller
public class AlbumController {

    @Autowired
    kinderService kinderService;
    @Autowired
    AlbumService albumService;
    @Autowired
    ImagenService imagenService;

    @RequestMapping(value = {"/galeria"}, method = RequestMethod.GET)
    public String loadGaleria(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        ///  System.out.println(kinder.toString());
        if (kinder != null) {
            model.addAttribute("albums", kinder.getAlbums());
        } else {
            model.addAttribute("albums", new Kinder().getAlbums());
        }
        Album album = new Album();
        model.addAttribute("album", album);
        Imagen imagen = new Imagen();
        model.addAttribute("imagen", imagen);
        return "galeria";
    }

    @RequestMapping(value = {"/galeria"}, method = RequestMethod.POST)
    public String addGaleria(@Valid Album album, BindingResult result, ModelMap model) {
        //  System.out.println(album.toString());
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (result.hasErrors()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se la imágen éxito");

            if (kinder != null) {
                model.addAttribute("albums", kinder.getAlbums());
            } else {
                model.addAttribute("albums", new Kinder().getAlbums());
            }
            Album al = new Album();
            model.addAttribute("album", al);
            Imagen imagen = new Imagen();
            model.addAttribute("imagen", imagen);
            return "galeria";
        }

        album.setKinder(kinder);
        albumService.save(album);
        kinder.getAlbums().add(album);

        model.addAttribute("msg", "Se agrego el álbum con éxito");

        model.addAttribute("albums", kinder.getAlbums());
        Album al = new Album();
        model.addAttribute("album", al);
        Imagen imagen = new Imagen();
        model.addAttribute("imagen", imagen);

        return "galeria";
    }

    @RequestMapping(value = {"/eliminarAlbum"}, method = RequestMethod.POST)
    public String removeAlbum(@Valid Album album, BindingResult result, ModelMap model) {

        Album album2 = albumService.findbyId(album.getNombre());
        if (album2 != null) {
            albumService.DeletebyId(album.getNombre());
            model.addAttribute("msg", "Se elimino el álbum con éxito");
        } else {
            model.addAttribute("msg", "No se elimino el álbum con éxito");
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
        Imagen imagen = new Imagen();
        model.addAttribute("imagen", imagen);
        return "galeria";
    }

    @RequestMapping(value = {"/agregarImagen"}, method = RequestMethod.POST)
    public String agregarImagen(@Valid Album album, BindingResult result, ModelMap model) {
        Imagen imagen = new Imagen();
        imagen.setAlbum(album);
        model.addAttribute("imagen", imagen);
        return "agregarImagen";
    }

    @RequestMapping(value = {"/agregarImagenForm"}, method = RequestMethod.POST)
    public String addImagen(@RequestParam MultipartFile file,
            @RequestParam String album,
            ModelMap model) {
        System.out.println(file);
        System.out.println(album);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (file.isEmpty()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego la imágen con exito");

            if (kinder != null) {
                model.addAttribute("albums", kinder.getAlbums());
            } else {
                model.addAttribute("albums", new Kinder().getAlbums());
            }
            Album al = new Album();
            model.addAttribute("album", al);
            Imagen imagen = new Imagen();
            model.addAttribute("imagen", imagen);
            return "galeria";
        }
        Album alb = albumService.findbyId(album);
        Imagen imagen = new Imagen();
        imagen.setAlbum(alb);
        try {
            imagen.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException ex) {
            Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagenService.save(imagen);
        alb.getImagenes().add(imagen);

        kinder = kinderService.findbyName("Kinder Lulu");

        model.addAttribute("msg", "Se agrego la imágen con éxito");

        model.addAttribute("albums", kinder.getAlbums());
        Album al = new Album();
        model.addAttribute("album", al);
        Imagen imag = new Imagen();
        model.addAttribute("imagen", imag);

        return "galeria";
    }

    @RequestMapping(value = {"/eliminarImagen"}, method = RequestMethod.POST)
    public String removeImagen(@Valid Imagen imagen, BindingResult result, ModelMap model) {

        Imagen imagen2 = imagenService.findbyId(imagen.getCodigo());
        if (imagen2 != null) {
            imagenService.DeletebyId(imagen.getCodigo());
            model.addAttribute("msg", "Se elimino la imágen con éxito");
        } else {
            model.addAttribute("msg", "No se elimino la imágen con éxito");
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
        Imagen imagen3 = new Imagen();
        model.addAttribute("imagen", imagen3);
        return "galeria";
    }

    @RequestMapping(value = {"/galeriaEncargado"}, method = RequestMethod.GET)
    public String loadGaleriaEncargado(ModelMap model) {

        Album al = albumService.findbyId("Galeria");
        model.addAttribute("al", al);
        Album album = new Album();
        model.addAttribute("album", album);
        Imagen imagen = new Imagen();
        model.addAttribute("imagen", imagen);
        return "EditarGaleria";
    }

    @RequestMapping(value = {"/eliminarImagenEncarado"}, method = RequestMethod.POST)
    public String removeImagenEncargado(@Valid Imagen imagen, BindingResult result, ModelMap model) {

        Imagen imagen2 = imagenService.findbyId(imagen.getCodigo());
        if (imagen2 != null) {
            imagenService.DeletebyId(imagen.getCodigo());
            model.addAttribute("msg", "Se elimino la imágen con éxito");
        } else {
            model.addAttribute("msg", "No se elimino la imágen con éxito");
        }

        return loadGaleriaEncargado(model);
    }
    
    
    @RequestMapping(value = {"/agregarImagenForm2"}, method = RequestMethod.POST)
    public String addImagen2(@RequestParam MultipartFile file,
            @RequestParam String album,
            ModelMap model) {
        System.out.println(file);
        System.out.println(album);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (file.isEmpty()) {
            System.out.println("has errors");
            model.addAttribute("msg", "No se agrego la imágen con exito");

            if (kinder != null) {
                model.addAttribute("albums", kinder.getAlbums());
            } else {
                model.addAttribute("albums", new Kinder().getAlbums());
            }
            Album al = new Album();
            model.addAttribute("album", al);
            Imagen imagen = new Imagen();
            model.addAttribute("imagen", imagen);
            return "galeria";
        }
        Album alb = albumService.findbyId(album);
        Imagen imagen = new Imagen();
        imagen.setAlbum(alb);
        try {
            imagen.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException ex) {
            Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagenService.save(imagen);
        alb.getImagenes().add(imagen);

        kinder = kinderService.findbyName("Kinder Lulu");

        model.addAttribute("msg", "Se agrego la imágen con éxito");

       

        return loadGaleriaEncargado(model) ;
    }
}
