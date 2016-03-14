/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import modelo.Clase;
import modelo.Contacto;
import modelo.Encargado;
import modelo.Familiar;
import modelo.Kinder;
import modelo.Nino;
import modelo.Profesor;
import modelo.SuperMatricula;
import modelo.Telefono;
import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ContactoService;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.ClaseService;
import service.EncargadoService;
import service.FamiliarService;
import service.NinoService;
import service.ProfesorService;
import service.TelefonoService;
import service.UsuarioService;
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
    UsuarioService usuarioService;

    @Autowired
    EncargadoService encargadoService;

    @Autowired
    ContactoService contactoService;

    @Autowired
    NinoService ninoService;

    @Autowired
    ClaseService claseService;

    @Autowired
    FamiliarService familiarService;

    @Autowired
    TelefonoService telefonoService;

    @Autowired
    ProfesorService profesorService;

    @RequestMapping(value = {"/prueba"}, method = RequestMethod.GET)
    public String loadPrueba(ModelMap model) {

        Usuario user = usuarioService.findbyId("402270021");
        model.addAttribute("user", user);
        String nombre = user.getEncargado().iterator().next().getNombre();
        model.addAttribute("nombre", nombre);

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
    public String loadIndex(ModelMap model, HttpServletRequest request) {

        HttpSession sesion = request.getSession(true);

        //Cerrar sesion
        sesion.invalidate();
        //  sesion.removeAttribute("user");
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
    /**
     *
     * @param persona
     * @param result
     * @return
     */
    @RequestMapping(value = {"/Matricular"}, method = RequestMethod.POST)
    public String matricular(@Valid SuperMatricula persona, BindingResult result, ModelMap model) {
        String nombre = persona.getNombre();
        String apellido1 = persona.getApellido1();
        String apellido2 = persona.getApellido2();
        String email = persona.getEmail();
        String id = persona.getId();
        String telefono = persona.getTelefono();
        String direccion = persona.getDireccion();
        String fecha = persona.getFechaNacimiento();
        String password = persona.getPassword();
        String enfermedad = persona.getEnfermedad();
        String medicamento = persona.getMedicamento();
        //------------PADRE--------------------------
        String nombrePadre = persona.getNombrePadre();
        String edadPadre = persona.getEdadPadre();
        String cedulaPadre = persona.getCedulaPadre();
        String ocupacionPadre = persona.getOcupacionPadre();
        String lugarTrabajoPadre = persona.getLugarTrabajoPadre();
        String telefonoTrabajoPadre = persona.getTelefonoTrabajoPadre();
        String telefonoPersonalPadre = persona.getTelefonoPersonalPadre();
        //------------Madre--------------------------
        String nombreMadre = persona.getNombreMadre();
        String edadMadre = persona.getEdadMadre();
        String cedulaMadre = persona.getCedulaMadre();
        String ocupacionMadre = persona.getOcupacionMadre();
        String lugarTrabajoMadre = persona.getLugarTrabajoMadre();
        String telefonoTrabajoMadre = persona.getTelefonoTrabajoMadre();
        String telefonoPersonalMadre = persona.getTelefonoPersonalMadre();
        //------PERSONA ENCARGADA---------------
        String nombreEncargado = persona.getNombreEncargado();
        String telefonoEncargado = persona.getTelefonoEncargado();
        String cedulaEncargado = persona.getCedulaEncargado();
        //-----------INFORMACION MATRICULA
        String nivel = persona.getNivel();
        boolean completa = persona.EstaCompleta();
        boolean constanciaNacimeinto = persona.EstaConstancia();
        boolean carnetVacunas = persona.EstaVacunas();
        boolean fotos = persona.EstaFotos();
        String monto = persona.getMonto();
        String curso = persona.getCurso();
        String per = persona.getPersona();

        ///--------------------USUARIO----------------------------------------
        Usuario u = new Usuario();
        u.setId(id);
        u.setEmail(email);
        u.setContrasena(password);
        u.serEncargado();
        //--------------- Encargado------------------------------------
        Encargado encargado = new Encargado();
        encargado.setNombre(nombre);
        encargado.setApellido1(apellido1);
        encargado.setApellido2(apellido2);
        encargado.setId(id);
        encargado.setEmail(email);
        encargado.setDireccion(direccion);
        encargado.setTelefono(telefono);
        encargado.setFechaNacimiento(fecha);
        //-----------Nino-------------
        Nino n = new Nino();
        n.setId(id);
        n.setEstado(true);
        //---------Familiares-------------------
        //---------Padre
        Familiar padre = new Familiar();
        padre.setNombre(nombrePadre);
        padre.setEdad(edadPadre);
        padre.setId(cedulaPadre);
        padre.setOcupacion(ocupacionPadre);
        padre.setLugarTrabajo(lugarTrabajoPadre);
        padre.setParentesco("Padre");
        //---------Madre
        Familiar madre = new Familiar();
        madre.setNombre(nombreMadre);
        madre.setEdad(edadMadre);
        madre.setId(cedulaMadre);
        madre.setOcupacion(ocupacionMadre);
        madre.setLugarTrabajo(lugarTrabajoMadre);
        madre.setParentesco("Madre");
        //------FamiliarEncargado
        Familiar enc = new Familiar();
        enc.setNombre(nombreEncargado);
        enc.setId(cedulaEncargado);
        enc.setParentesco("Encargado");

        //----------TELEFONOS-------------------
        //--telefonos padre
        Telefono trabajoP = new Telefono();
        trabajoP.setNumero(telefonoTrabajoPadre);

        //---
        Telefono personalP = new Telefono();
        personalP.setNumero(telefonoPersonalPadre);

        //--telefonos madre
        Telefono trabajoM = new Telefono();
        trabajoM.setNumero(telefonoTrabajoMadre);

        //---
        Telefono personalM = new Telefono();
        personalM.setNumero(telefonoPersonalMadre);

        //--telefonos familiar encargado
        Telefono telefonoEnc = new Telefono();
        telefonoEnc.setNumero(telefonoEncargado);
//------------PAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE-----------------------------------------------
        //---------GRUPO---------------
        Clase g = claseService.findbyId(this.calcularCodigo(nivel));
        String prueba = g.getNivel();

        //-----Uniendo-------------
        trabajoP.setFamiliar(padre);
        personalP.setFamiliar(padre);

        trabajoM.setFamiliar(madre);
        personalM.setFamiliar(madre);

        telefonoEnc.setFamiliar(enc);

        padre.getTelefonos().add(trabajoP);
        padre.getTelefonos().add(personalP);

        madre.getTelefonos().add(trabajoM);
        madre.getTelefonos().add(personalM);

        enc.getTelefonos().add(telefonoEnc);

        padre.setNino(n);
        madre.setNino(n);
        enc.setNino(n);

        n.setClase(g);
        g.getNinos().add(n);

        n.getFamiliares().add(padre);
        n.getFamiliares().add(madre);
        n.getFamiliares().add(enc);

        usuarioService.save(u);
        encargadoService.save(encargado);
        ninoService.save(n);
        encargado.getUsuario().add(u);
        encargado.getNino().add(n);
        encargadoService.UpdateEncargado(encargado);
        n.getEncargado().add(encargado);
        ninoService.UpdateNino(n);
        u.getEncargado().add(encargado);
        usuarioService.UpdateUsuario(u);

        //------GUARDANDO---------------------------
        //------UPDATES-----------------------------------
        /*this.telefonoService.UpdateTelefono(trabajoP);
         this.telefonoService.UpdateTelefono(personalP);

         this.telefonoService.UpdateTelefono(trabajoM);
         this.telefonoService.UpdateTelefono(personalM);

         this.telefonoService.UpdateTelefono(telefonoEnc);

         this.familiarService.UpdateFamiliar(padre);
         this.familiarService.UpdateFamiliar(madre);
         this.familiarService.UpdateFamiliar(enc);

         this.ninoService.UpdateNino(n);

         this.claseService.UpdateClase(g);

         this.encargadoService.UpdateEncargado(encargado);

         this.usuarioService.UpdateUsuario(u);
         */
        //-------FIN------------------------------------------------------------
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        model.addAttribute("fallo", false);
        return "index";
    }

    @RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
    public String realizarLoging(@Valid Usuario user, BindingResult result,
            ModelMap model, HttpServletRequest request) {

        String password = user.getContrasena();
        String email = user.getEmail();
        Usuario usu = usuarioService.findByLogin(email, password);
        if (usu != null) {
            String nombre = usu.getEncargado().iterator().next().getNombre();

            if (usu.isAdministrador()) {
                model.addAttribute("nombre", nombre);
                request.getSession().setAttribute("user", usu);
                return "Administracion";
            }
            if (usu.isEncargado()) {
                model.addAttribute("nombre", nombre);
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
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);

        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "contacto";
    }

    @RequestMapping(value = {"/contactoAdministrador"}, method = RequestMethod.GET)
    public String loadContactoAdmin(ModelMap model) {
        Contacto contacto = new Contacto();
        model.addAttribute("contacto", contacto);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);

        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "contactoAdministrador";
    }

    @RequestMapping(value = {"/contactoAdministrador"}, method = RequestMethod.POST)
    public String removeContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());

        Contacto contacto1 = contactoService.findbyCodigo(contacto.getCodigo());
        if (contacto1 != null) {
            contactoService.DeletebyCodigo(contacto1.getCodigo());
            model.addAttribute("msg", "Se elimino el contacto con exito");
        }
        model.addAttribute("msg", "No se elimino el contacto con exito");
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        if (kinder != null) {
            model.addAttribute("kinder", kinder);

        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "contactoAdministrador";
    }

    @RequestMapping(value = {"/ModificarContacto"}, method = RequestMethod.POST)
    public String updateContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());
        Contacto cont = new Contacto();
        model.addAttribute("contacto", cont);

        model.addAttribute("contactoBase", contacto);

        return "ActualizarContacto";
    }

    @RequestMapping(value = {"/ModificarContactoModicado"}, method = RequestMethod.POST)
    public String updateContacto2(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());
        /* if (result.hasErrors()) {
         System.out.println("has errors");
         model.addAttribute("msg", "No se agrego el contacto con exito");
         return "agregarContacto";
         }*/
        Contacto con = contactoService.findbyCodigo(contacto.getCodigo());
        con.setTitulo(contacto.getTitulo());
        con.setDescripcion(contacto.getDescripcion());
        contactoService.UpdateContacto(con);

        model.addAttribute("msg", "Se agrego el contacto con exito");
        return "agregarContacto";
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
        SuperMatricula persona = new SuperMatricula();

        model.addAttribute("persona", persona);
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
    public String loadPerfil(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        request.getSession().setAttribute("enc", enc);
        return "perfil";
    }

    @RequestMapping(value = {"/requerimientos"}, method = RequestMethod.GET)
    public String loadRequerimientos(ModelMap model) {
        return "requerimientos";
    }

    @RequestMapping(value = {"/Visualizar-Pagos"}, method = RequestMethod.GET)
    public String loadVisualizarPagos(ModelMap model) {
        return "visualizarPagos";
    }

    @ModelAttribute("niveles")
    public ArrayList<String> initializeProfiles() {
        ArrayList<String> l = new ArrayList<>();
        l.add("Materno");
        l.add("Prekinder");
        l.add("Kinder");
        l.add("Preparatoria");
        return l;
    }

    @ModelAttribute("opciones")
    public ArrayList<String> initializeOpciones() {
        ArrayList<String> l = new ArrayList<>();
        l.add("Si");
        l.add("No");
        return l;
    }

    public String calcularCodigo(String nivel) {
        if (nivel.equalsIgnoreCase("Materno")) {
            return "1";
        }

        if (nivel.equalsIgnoreCase("Prekinder")) {
            return "2";
        }
        if (nivel.equalsIgnoreCase("kinder")) {
            return "3";
        }
        if (nivel.equalsIgnoreCase("Preparatoria")) {
            return "4";
        }

        return "0";
    }

}
