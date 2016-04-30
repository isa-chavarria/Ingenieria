/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.imageio.spi.ServiceRegistry;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import modelo.Album;
import modelo.Clase;
import modelo.Contacto;
import modelo.Encargado;
import modelo.Enfermedad;
import modelo.Especialidad;
import modelo.Factura;
import modelo.Familiar;
import modelo.Imagen;
import modelo.Informacion;
import modelo.InformacionNino;
import modelo.Kinder;
import modelo.Matricula;
import modelo.Mes;
import modelo.Nino;
import modelo.NivelModificar;
import modelo.Noticia;
import modelo.Pago;
import modelo.Profesor;
import modelo.Requerimiento;
import modelo.SuperMatricula;
import modelo.Usuario;
import modelo.UsuarioM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AlbumService;
import service.ContactoService;
import service.ClaseService;
import service.EncargadoService;
import service.EnfermedadService;
import service.EspecialidadService;
import service.FacturaService;
import service.FamiliarService;
import service.InformacionService;
import service.MatriculaService;
import service.MesService;
import service.NinoService;
import service.NoticiaService;
import service.ProfesorService;
import service.RequerimientoService;
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
    RequerimientoService requerimientoService;

    @Autowired
    NinoService ninoService;

    @Autowired
    ClaseService claseService;

    @Autowired
    AlbumService albumService;

    @Autowired
    FamiliarService familiarService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    MesService mesService;

    @Autowired
    FacturaService facturaService;
    @Autowired
    NoticiaService NoticiaService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    InformacionService informacionService;

    @Autowired
    EnfermedadService enfermedadService;

    @Autowired
    EspecialidadService especialidadService;

    @RequestMapping(value = {"/prueba"}, method = RequestMethod.GET)
    public String loadPrueba(ModelMap model) {

        //Usuario user = usuarioService.findbyId("402270021");
//        model.addAttribute("user", user);
//        String nombre = user.getEncargado().iterator().next().getNombre();
//        model.addAttribute("nombre", nombre);
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

    @RequestMapping(value = {"/galeriaImagenes"}, method = RequestMethod.GET)
    public String loadGaleriaImagenes(ModelMap model, HttpServletRequest request) {
        Album al = albumService.findbyId("Galeria");

        Set<Imagen> imagenes = al.getImagenes();

        model.addAttribute("imagenes", imagenes);
        return "galeriaAdminstrador";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String loadIndex(ModelMap model, HttpServletRequest request) {

        HttpSession sesion = request.getSession(true);

        //Cerrar sesion
        sesion.invalidate();
        Album al = albumService.findbyId("Inicio");
        if (al.getImagenes().size() > 0) {
            Imagen first = al.getImagenes().iterator().next();
            model.addAttribute("primera", first);
        }

        model.addAttribute("imagenes", al.getImagenes());

        //  sesion.removeAttribute("user");
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        model.addAttribute("fallo", false);
        return "index";
    }

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
        String password = "0000";
        String imagen = "resources/img/default.png";
        String enfermedad = persona.getEnfermedad();
        String medicamento = persona.getMedicamento();
        String sexo = persona.getSexo();

        if (this.usuarioService.isIdUnique(id) == false || this.usuarioService.isEmailUnique(email) == false) {
            Usuario user = new Usuario();
            model.addAttribute("user", user);
            model.addAttribute("fallo", false);
            return "ErrorMatricula";
        }

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
        encargado.setSexo(sexo);
        encargado.setRuta_imagen(imagen);
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
        padre.setNumeroTrabajo(telefonoTrabajoPadre);
        padre.setNumeroPersonal(telefonoPersonalPadre);
        //---------Madre
        Familiar madre = new Familiar();
        madre.setNombre(nombreMadre);
        madre.setEdad(edadMadre);
        madre.setId(cedulaMadre);
        madre.setOcupacion(ocupacionMadre);
        madre.setLugarTrabajo(lugarTrabajoMadre);
        madre.setParentesco("Madre");
        madre.setNumeroTrabajo(telefonoTrabajoMadre);
        madre.setNumeroPersonal(telefonoPersonalMadre);
        //------FamiliarEncargado
        Familiar enc = new Familiar();
        enc.setNombre(nombreEncargado);
        enc.setId(cedulaEncargado);
        enc.setParentesco("Encargado");
        enc.setNumeroPersonal(telefonoEncargado);

//---------------------MATRICULA--------------------------------------
        Matricula matricula = new Matricula();
        matricula.setCompeta(completa);
        matricula.setConstanciaNacimiento(constanciaNacimeinto);
        matricula.setCarnet(carnetVacunas);
        matricula.setFotos(fotos);
        matricula.setCursolectivo(curso);
        matricula.setMatricula(monto);
        matricula.setRealizadoPor(per);

//--------------ENFERMEDAD----------------------------------
        Enfermedad enferme = new Enfermedad();
        enferme.setDescripcion(enfermedad);

//--------------MEDICAMENTOS----------------------------------
        Informacion medicame = new Informacion();
        medicame.setDescripcion(medicamento);

//---------------GRUPO--------------------------------------------------
        Clase g = claseService.findbyId(this.calcular(nivel));

        //-----Uniendo-------------
        padre.setNino(n);
        madre.setNino(n);
        enc.setNino(n);

        if (g != null) {
            n.setClase(g);
            g.getNinos().add(n);
        }

        String idpa = padre.getId();
        String idma = madre.getId();
        String idenc = enc.getId();

        usuarioService.save(u);
        encargadoService.save(encargado);
        ninoService.save(n);
        encargado.getUsuario().add(u);
        encargado.getNino().add(n);
        encargadoService.UpdateEncargado(encargado);
        matricula.setNino(n);
        this.matriculaService.save(matricula);
        if (!enfermedad.equals("")) {
            enferme.setNino(n);
            this.enfermedadService.save(enferme);
        }
        if (!medicamento.equals("")) {
            medicame.setNino(n);
            this.informacionService.save(medicame);
        }

        if (!padre.getId().equals("")) {
            padre.setNino(n);
            familiarService.save(padre);
        }
        if (!madre.getId().equals("")) {
            madre.setNino(n);
            familiarService.save(madre);
        }
        if (!enc.getId().equals("")) {
            enc.setNino(n);
            familiarService.save(enc);
        }

        //        n.getEncargado().add(encargado);
        //        ninoService.UpdateNino(n);
        //        u.getEncargado().add(encargado);
        //        usuarioService.UpdateUsuario(u);
        //------GUARDANDO---------------------------
        //-------FIN------------------------------------------------------------
        Usuario user = new Usuario();
        model.addAttribute("user", user);
        model.addAttribute("fallo", false);
        return "MatriculaCorrecta";
    }

    @RequestMapping(value = {"/correcta"}, method = RequestMethod.GET)
    public String loadMatriculaCorrecta(ModelMap model) {
        return "MatriculaCorrecta";
    }

    @RequestMapping(value = {"/Login"}, method = RequestMethod.POST)
    public String realizarLoging(@Valid Usuario user, BindingResult result,
            ModelMap model, HttpServletRequest request) {

        String password = user.getContrasena();
        String email = user.getEmail();
        Usuario usu = usuarioService.findByLogin(email, password);
        if (usu != null) {

            if (usu.isAdministrador()) {
                // model.addAttribute("nombre", nombre);
                request.getSession().setAttribute("user", usu);
                return loadAdministracion(model);
            }
            if (usu.isEncargado()) {
                //  model.addAttribute("nombre", nombre);
                request.getSession().setAttribute("user", usu);
                return loadEncargado(model);
            }
        }
        Usuario u = new Usuario();
        model.addAttribute("user", u);
        model.addAttribute("fallo", true);
        Album al = albumService.findbyId("Inicio");
        if (al.getImagenes().size() > 0) {
            Imagen first = al.getImagenes().iterator().next();
            model.addAttribute("primera", first);
        }

        model.addAttribute("imagenes", al.getImagenes());

        return "index";

    }

    @RequestMapping(value = {"/encargado"}, method = RequestMethod.GET)
    public String loadEncargado(ModelMap model) {
        Album al = albumService.findbyId("Sistema");

        Set<Imagen> imagenes = al.getImagenes();
        if (al.getImagenes().size() > 0) {
            Imagen first = al.getImagenes().iterator().next();

            model.addAttribute("primera", first);
        }
        model.addAttribute("imagenes", imagenes);
        return "Encargado";
    }

    @RequestMapping(value = {"/administracion"}, method = RequestMethod.GET)
    public String loadAdministracion(ModelMap model) {
        Album al = albumService.findbyId("Sistema");

        Set<Imagen> imagenes = al.getImagenes();
        if (al.getImagenes().size() > 0) {
            Imagen first = al.getImagenes().iterator().next();
            model.addAttribute("primera", first);
        }
        model.addAttribute("imagenes", imagenes);
        return "Administracion";
    }

    @RequestMapping(value = {"/contacto"}, method = RequestMethod.GET)
    public String loadContacto(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");

        List<Contacto> contactos = this.contactoService.findAll();
        model.addAttribute("contactos", contactos);

        return "contacto";
    }

    @RequestMapping(value = {"/contactoAdministrador"}, method = RequestMethod.GET)
    public String loadContactoAdmin(ModelMap model) {
        Contacto contacto = new Contacto();
        model.addAttribute("contacto", contacto);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");

        List<Contacto> contactos = this.contactoService.findAll();
        model.addAttribute("contactos", contactos);
//        if (kinder != null) {
//            model.addAttribute("kinder", kinder);
//
//        } else {
//            model.addAttribute("kinder", new Kinder());
//        }
        return "contactoAdministrador";
    }

    @RequestMapping(value = {"/contactoAdministrador"}, method = RequestMethod.POST)
    public String removeContacto(@Valid Contacto contacto, BindingResult result, ModelMap model) {
        System.out.println(contacto.toString());

        Contacto contacto1 = contactoService.findbyCodigo(contacto.getCodigo());
        if (contacto1 != null) {
            contactoService.DeletebyCodigo(contacto1.getCodigo());
            model.addAttribute("msg", "Se elimino el contacto con éxito");
        } else {
            model.addAttribute("msg", "No se elimino el contacto con éxito");
        }
        Kinder kinder = kinderService.findbyName("Kinder Lulu");

        List<Contacto> contactos = this.contactoService.findAll();
        model.addAttribute("contactos", contactos);
//        if (kinder != null) {
//            model.addAttribute("kinder", kinder);
//
//        } else {
//            model.addAttribute("kinder", new Kinder());
//        }
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

        Contacto con = contactoService.findbyCodigo(contacto.getCodigo());
        con.setTitulo(contacto.getTitulo());
        con.setDescripcion(contacto.getDescripcion());
        contactoService.UpdateContacto(con);

        model.addAttribute("msg", "Se Modificó el contacto con éxito");
        return "agregarContacto";
    }

    @RequestMapping(value = {"/noticias"}, method = RequestMethod.GET)
    public String loadNoticia(ModelMap model) {
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        List<Noticia> lista = NoticiaService.findAll();
        if (kinder != null) {
            model.addAttribute("kinder", kinder);
            model.addAttribute("noticias", lista);
        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "noticias";
    }

    @RequestMapping(value = {"/noticiasAdministrador"}, method = RequestMethod.GET)
    public String loadNoticiasAdmin(ModelMap model) {
        Noticia noticia = new Noticia();
        model.addAttribute("noticia", noticia);
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        System.out.println(kinder.getNoticias());
        List<Noticia> lista = NoticiaService.findAll();
        if (kinder != null) {
            model.addAttribute("kinder", kinder);
            model.addAttribute("noticias", lista);

        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "noticiasAdministrador";
    }

    @RequestMapping(value = {"/noticiasAdministrador"}, method = RequestMethod.POST)
    public String removeNoticias(@Valid Noticia noticia, BindingResult result, ModelMap model) {
        System.out.println(noticia.toString());

        Noticia noticia1 = NoticiaService.findbyCodigo(noticia.getCodigo());
        if (noticia1 != null) {
            NoticiaService.DeletebyCodigo(noticia1.getCodigo());
            model.addAttribute("msg", "Se elimino la noticia con éxito");
        }
        model.addAttribute("msg", "No se elimino la noticia con éxito");
        Kinder kinder = kinderService.findbyName("Kinder Lulu");
        List<Noticia> lista = NoticiaService.findAll();
        if (kinder != null) {
            model.addAttribute("kinder", kinder);
            model.addAttribute("noticias", lista);
        } else {
            model.addAttribute("kinder", new Kinder());
        }
        return "noticiasAdministrador";
    }

    @RequestMapping(value = {"/ModificarNoticias"}, method = RequestMethod.POST)
    public String updateNoticias(@Valid Noticia noticia, BindingResult result, ModelMap model) {
        System.out.println(noticia.toString());
        Noticia noti = new Noticia();
        model.addAttribute("noticia", noticia);

        //      model.addAttribute("noticiaBase", noticia);
        return "ActualizarNoticia";
    }

    @RequestMapping(value = {"/ModificarNoticiaModicado"}, method = RequestMethod.POST)
    public String updateContacto2(@Valid Noticia noticia, BindingResult result, ModelMap model) {
        System.out.println(noticia.toString());

        Noticia noti = NoticiaService.findbyCodigo(noticia.getCodigo());
        noti.setTitulo(noticia.getTitulo());
        noti.setDescripcion(noticia.getDescripcion());
        NoticiaService.UpdateNoticia(noti);
        model.addAttribute("noticia", noti);
        model.addAttribute("msg", "Se Modificó la noticia con éxito");
        return "ActualizarNoticia";
    }

    @RequestMapping(value = {"/informacionFamiliares"}, method = RequestMethod.GET)
    public String loadInformacionFamiliares(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();
        Nino n = enc.getNino().iterator().next();
        Familiar f = new Familiar();

        Set<Familiar> familiares = n.getFamiliares();
        model.addAttribute("enc", enc);
        model.addAttribute("familiares", familiares);
        model.addAttribute("familiar", f);
        return "InformacionFamiliares";
    }

    @RequestMapping(value = {"/agregarFamiliares"}, method = RequestMethod.GET)
    public String loadAgregarFamiliares(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();
        model.addAttribute("enc", enc);
        Familiar f = new Familiar();
        model.addAttribute("familiar", f);
        return "AgregarFamiliar";
    }

    @RequestMapping(value = {"/agregarFamiliares"}, method = RequestMethod.POST)
    public String AgregarFamiliares(@Valid Familiar familiar, ModelMap model, BindingResult result, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();
        Nino n = enc.getNino().iterator().next();
        n.getFamiliares().add(familiar);
        familiar.setNino(n);
        String id = n.getId();
        familiarService.save(familiar);
        Familiar f = new Familiar();
        Set<Familiar> familiares = n.getFamiliares();
        model.addAttribute("enc", enc);
        model.addAttribute("familiares", familiares);
        model.addAttribute("familiar", f);
        return "InformacionFamiliares";
    }

    @RequestMapping(value = {"/editarFamiliares-{codigo}"}, method = RequestMethod.GET)
    public String loadEditarFamiliares(@PathVariable Long codigo, ModelMap model, HttpServletRequest request) {
        Long c = codigo;
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();
        model.addAttribute("enc", enc);
        Familiar fam = this.familiarService.findbyCodigo(codigo);
        model.addAttribute("familiar", fam);
        return "EditarInformacionFamiliar";
    }

    @RequestMapping(value = {"/EditarFamiliares"}, method = RequestMethod.POST)
    public String EditarFamiliares(@Valid Familiar familiar, ModelMap model, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {

        }

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();

        Nino n = enc.getNino().iterator().next();

        familiar.setNino(n);
        familiarService.UpdateFamiliar(familiar);

        //   this.ninoService.UpdateNino(n);
        Nino nuevo = ninoService.findbyId(n.getId());

        Set<Familiar> familiares = nuevo.getFamiliares();
        model.addAttribute("enc", enc);
        model.addAttribute("familiares", familiares);
        return "InformacionFamiliares";

    }

    @RequestMapping(value = {"/EliminarFamiliares"}, method = RequestMethod.POST)
    public String EliminarFamiliar(@Valid Familiar familiar, ModelMap model, BindingResult result, HttpServletRequest request) {

        Long c = familiar.getCodigo();

        if (result.hasErrors()) {

        }

        Familiar aux = familiarService.findbyCodigo(c);

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = usu.getEncargado().iterator().next();

        Nino n = enc.getNino().iterator().next();

        aux.setNino(null);
        familiarService.UpdateFamiliar(aux);
        familiarService.DeletebyCodigo(aux.getCodigo());
        Nino nuevo = ninoService.findbyId(n.getId());

        Set<Familiar> familiares = nuevo.getFamiliares();
        model.addAttribute("enc", enc);
        model.addAttribute("familiares", familiares);
        return "InformacionFamiliares";
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

    @RequestMapping(value = {"/pagosSeleccionar"}, method = RequestMethod.GET)
    public String loadPagoSelecionar(ModelMap model) {
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(new Long(1));
        model.addAttribute("grupito", c);
        return "PagosSeleccionar";
    }

    @RequestMapping(value = {"/perfil"}, method = RequestMethod.GET)
    public String loadPerfil(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        String nivel = enc.getNino().iterator().next().getClase().getNivel();
        model.addAttribute("nivel", nivel);
        return "perfil";
    }

    @RequestMapping(value = {"/perfilAdministrador"}, method = RequestMethod.GET)
    public String loadPerfilAdministrador(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);

        return "PerfilAdministrador";
    }

    @RequestMapping(value = {"/perfilCuenta"}, method = RequestMethod.GET)
    public String loadperfilCuenta(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        UsuarioM u = new UsuarioM();
        u.setId(usu.getId());
        u.setEmail(usu.getEmail());
        u.setRoleSeccion(usu.getRoleSeccion());
        String pass = usu.getContrasena();
        u.setPassAnt(pass);
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        model.addAttribute("usuario", u);
        return "PerfilCuenta";
    }

    @RequestMapping(value = {"/perfilCuentaUsuario"}, method = RequestMethod.GET)
    public String loadperfilCuentaUsuario(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        UsuarioM u = new UsuarioM();
        u.setId(usu.getId());
        u.setEmail(usu.getEmail());
        u.setRoleSeccion(usu.getRoleSeccion());
        String pass = usu.getContrasena();
        u.setPassAnt(pass);
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        model.addAttribute("usuario", u);
        return "PerfilCuentaUsuario";
    }

    @RequestMapping(value = {"/editarInformacionPerfil"}, method = RequestMethod.GET)
    public String loadEditarPerfilAdministrador(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        String id = enc.getId();
        model.addAttribute("encargado", enc);
        return "editarInformacionPerfil";
    }

    @RequestMapping(value = {"/editarInformacionUsuario"}, method = RequestMethod.GET)
    public String loadEditarPerfilUsuario(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        String id = enc.getId();
        model.addAttribute("enc", enc);
        String nivel = enc.getNino().iterator().next().getClase().getNivel();
        model.addAttribute("nivel", nivel);
        return "editarInformacionUsuario";
    }

    //-------------------------------------------------------------------------------------
    @RequestMapping(value = {"/modificarPerfilAdministrador"}, method = RequestMethod.POST)
    public String modificarPerfilAdministrador(@Valid Encargado enc, BindingResult result, ModelMap model, HttpServletRequest request) {
        String msg = "";

        String id = enc.getId();

        Usuario u = this.usuarioService.findbyId(id);

        enc.getUsuario().add(u);

        if (result.hasErrors()) {
            msg = "La Información no pudo modificarse";
        } else {
            msg = "Información modificada correctamente";
            encargadoService.UpdateEncargado(enc);
        }

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado en = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", en);
        model.addAttribute("msg", msg);

        //       model.addAttribute("msg", "Su información se modifico correctamente");
        return "PerfilAdministrador";
    }

    @RequestMapping(value = {"/modificarPerfilUsuario"}, method = RequestMethod.POST)
    public String modificarPerfilUsuario(@Valid Encargado enc, BindingResult result, ModelMap model, HttpServletRequest request) {
        String msg = "";

        String id = enc.getId();

        Usuario u = this.usuarioService.findbyId(id);

        enc.getUsuario().add(u);

        Nino aux = ninoService.findbyId(id);

        enc.getNino().add(aux);

        if (result.hasErrors()) {
            msg = "La Información no pudo modificarse";
        } else {
            msg = "Información modificada correctamente";
            encargadoService.UpdateEncargado(enc);
        }

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado en = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", en);
        model.addAttribute("msg", msg);

        String nivel = enc.getNino().iterator().next().getClase().getNivel();
        model.addAttribute("nivel", nivel);

        //       model.addAttribute("msg", "Su información se modifico correctamente");
        return "perfil";
    }

    //-------------------------------------------------------------------------------
    @RequestMapping(value = {"/modificarCuentaAdministrador"}, method = RequestMethod.POST)
    public String modificarCuentaAdministrador(@Valid UsuarioM u, BindingResult result, ModelMap model, HttpServletRequest request) {
        String msg = "";
        Usuario modificado = new Usuario();

        modificado.setContrasena(u.getContrasena());
        modificado.setId(u.getId());
        modificado.setEmail(u.getEmail());
        modificado.setRoleSeccion(u.getRoleSeccion());

        Encargado encar = encargadoService.findbyId(u.getId());

        modificado.getEncargado().add(encar);

        if (result.hasErrors()) {
            msg = "<div class=\"alert alert-warning\" role=\"alert\">La contraseña no pudo modificarse</div>";
        } else {

            msg = "<div class=\"alert alert-success\" role=\"alert\">La contraseña se modificó correctamente</div>";

            usuarioService.UpdateUsuario(modificado);
            u.actualizar();
        }

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        model.addAttribute("usuario", u);
        model.addAttribute("msg", msg);

        //       model.addAttribute("msg", "Su información se modifico correctamente");
        return "PerfilCuenta";
    }

    @RequestMapping(value = {"/modificarCuentaUsuario"}, method = RequestMethod.POST)
    public String modificarCuentaUsuario(@Valid UsuarioM u, BindingResult result, ModelMap model, HttpServletRequest request) {
        String msg = "";

        Usuario modificado = new Usuario();

        modificado.setContrasena(u.getContrasena());
        modificado.setId(u.getId());
        modificado.setEmail(u.getEmail());
        modificado.setRoleSeccion(u.getRoleSeccion());

        Encargado encar = encargadoService.findbyId(u.getId());

        modificado.getEncargado().add(encar);

        if (result.hasErrors()) {
            msg = "<div class=\"alert alert-warning\" role=\"alert\">La contraseña no pudo modificarse</div>";
        } else {
            msg = "<div class=\"alert alert-success\" role=\"alert\">La contraseña se modificó correctamente</div>";
            usuarioService.UpdateUsuario(modificado);
            u.actualizar();

        }

        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        model.addAttribute("enc", enc);
        model.addAttribute("usuario", u);
        model.addAttribute("msg", msg);

        //       model.addAttribute("msg", "Su información se modifico correctamente");
        return "PerfilCuentaUsuario";
    }

    @RequestMapping(value = {"/enfermedadesEstudiante"}, method = RequestMethod.GET)
    public String loadPadecimientos(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        Enfermedad enfer = new Enfermedad();
        Informacion inf = new Informacion();
        model.addAttribute("enc", enc);
        Nino n = enc.getNino().iterator().next();
        int size1 = n.getEnfermedad().size();
        int size2 = n.getInformacion().size();
        if (size1 > 0) {
            enfer = n.getEnfermedad().iterator().next();
        }
        if (size1 > 0) {
            inf = n.getInformacion().iterator().next();
        }

        model.addAttribute("enfermedad", enfer);

        model.addAttribute("medicamento", inf);

        return "EnfermedadesEstudiante";
    }

    @RequestMapping(value = {"/editarEnfermedades"}, method = RequestMethod.GET)
    public String EditarEnfermedades(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Encargado enc = encargadoService.findbyId(usu.getId());
        Enfermedad enfer = new Enfermedad();
        Informacion inf = new Informacion();
        model.addAttribute("enc", enc);
        InformacionNino informacion = new InformacionNino();
        Nino n = enc.getNino().iterator().next();
        int size1 = n.getEnfermedad().size();
        int size2 = n.getInformacion().size();
        if (size1 > 0) {
            enfer = n.getEnfermedad().iterator().next();
            informacion.setEnfermedades(enfer.getDescripcion());
            informacion.setMed(enfer.getCodigo());
            informacion.setExiste1("Si");
        } else {
            informacion.setExiste1("No");
        }
        if (size1 > 0) {
            inf = n.getInformacion().iterator().next();
            informacion.setMedicamentos(inf.getDescripcion());
            informacion.setEnf(inf.getCodigo());
            informacion.setExiste2("Si");
        } else {
            informacion.setExiste2("No");
        }

        informacion.setId(n.getId());

        model.addAttribute("informacion", informacion);
        return "EditarEnfermedadesEstudiante";
    }

    @RequestMapping(value = {"/editarEnfermedadesGuardar"}, method = RequestMethod.POST)
    public String EditarEnfermedadesGuardar(@Valid InformacionNino info, ModelMap model, HttpServletRequest request) {
        Informacion inf = new Informacion();
        Enfermedad enfer = new Enfermedad();
        Nino n = ninoService.findbyId(info.getId());

        if (info.getExiste1().equals("Si")) {
            enfer = enfermedadService.findbyCodigo(info.getEnf());
            enfer.setDescripcion(info.getEnfermedades());
            enfermedadService.UpdateEnfermedad(enfer);

        } else {
            enfer.setCodigo(info.getEnf());
            enfer.setDescripcion(info.getEnfermedades());
            enfer.setNino(n);
            enfermedadService.save(enfer);
        }

        //-------------------------------------------------------------------------------------------
        if (info.getExiste2().equals("Si")) {
            inf = informacionService.findbyCodigo(info.getEnf());
            inf.setDescripcion(info.getMedicamentos());
            informacionService.UpdateInformacion(inf);
        } else {
            inf.setCodigo(info.getMed());
            inf.setDescripcion(info.getMedicamentos());
            inf.setNino(n);
            informacionService.save(inf);
        }
        return loadPadecimientos(model, request);
    }

    ///-----------------------------------------------------------------------------------------
    @RequestMapping(value = {"/requerimientos"}, method = RequestMethod.GET)
    public String loadRequerimientos(ModelMap model) {

        List<Requerimiento> reqs = this.requerimientoService.findAll();
        model.addAttribute("requerimientos", reqs);
        return "requerimientos";
    }

    //-------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"/requerimientosAdmin"}, method = RequestMethod.GET)
    public String loadRequerimientosAdministracion(ModelMap model) {

        List<Requerimiento> reqs = this.requerimientoService.findAll();
        model.addAttribute("requerimientos", reqs);
        return "requerimientosAdministracion";
    }

    @RequestMapping(value = {"/Visualizar-Pagos"}, method = RequestMethod.GET)
    public String loadVisualizarPagos(ModelMap model) {
        return "visualizarPagos";
    }

    @RequestMapping(value = {"/Estudiantes"}, method = RequestMethod.GET)
    public String loadEstudiantes(ModelMap model) {
        Usuario u = new Usuario();
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(new Long(1));
        model.addAttribute("grupito", c);
        model.addAttribute("estudiante", u);
        return "Estudiantes";
    }

    @RequestMapping(value = {"/EstudiantesInactivos"}, method = RequestMethod.GET)
    public String loadEstudiantesInactivos(ModelMap model) {
        Usuario u = new Usuario();
        Clase g = new Clase();
        model.addAttribute("estudiante", u);
        model.addAttribute("estudiantes", purga());
        return "EstudiantesInactivos";
    }

    @RequestMapping(value = {"/CambiarEstado"}, method = RequestMethod.POST)
    public String CambiarEstado(@Valid Usuario u, BindingResult result, ModelMap model) {
        Nino n = ninoService.findbyId(u.getId());
        n.setEstado(false);
        ninoService.UpdateNino(n);
        return loadEstudiantes(model);
    }

    @RequestMapping(value = {"/CambiarActivo"}, method = RequestMethod.POST)
    public String CambiarActivo(@Valid Usuario u, BindingResult result, ModelMap model) {
        Nino n = ninoService.findbyId(u.getId());
        n.setEstado(true);
        ninoService.UpdateNino(n);
        return loadEstudiantesInactivos(model);
    }

    @RequestMapping(value = {"/EliminarEstudiante"}, method = RequestMethod.POST)
    public String Eliminarestudiante(@Valid Usuario u, BindingResult result, ModelMap model) {

        String id = u.getId();

        Nino n = ninoService.findbyId(id);
        n.setClase(null);

        //-------------------------------------------------------------
        int size1;
        size1 = n.getInformacion().size();
        if (size1 > 0) {
            Informacion inf = n.getInformacion().iterator().next();
            inf.setNino(null);
            informacionService.UpdateInformacion(inf);
            informacionService.DeletebyCodigo(inf.getCodigo());
        }
        //---------------------------------------------------------------------

        int size2;
        size2 = n.getEnfermedad().size();
        if (size2 > 0) {
            Enfermedad enf = n.getEnfermedad().iterator().next();
            enf.setNino(null);
            enfermedadService.UpdateEnfermedad(enf);
            enfermedadService.DeletebyCodigo(enf.getCodigo());
        }
        //-------------
        Set<Familiar> lista = n.getFamiliares();

        for (Familiar f : lista) {
            f.setNino(null);
            familiarService.UpdateFamiliar(f);
            familiarService.DeletebyCodigo(f.getCodigo());
        }
        n.setFamiliares(null);

        //-------------
        Set<Factura> facturas = n.getFacturas();

        for (Factura f : facturas) {
            f.setNino(null);
            f.setMes(null);
            facturaService.UpdateFactura(f);
            facturaService.DeletebyCodigo(f.getCodigo());
        }
        n.setFacturas(null);

        //-----------------------------------------------------------------------
        Matricula m = n.getMatricula().iterator().next();
        m.setNino(null);
        matriculaService.UpdateMatricula(m);
        matriculaService.DeletebyCodigo(m.getCodigo());

        //------------------------------------------------------------
        Usuario usu = usuarioService.findbyId(id);
        usuarioService.DeletebyId(usu.getId());
        Encargado e = encargadoService.findbyId(id);
        encargadoService.DeletebyId(e.getId());

        ninoService.UpdateNino(n);
        ninoService.DeletebyId(n.getId());

        return loadEstudiantesInactivos(model);
    }

    @RequestMapping(value = {"/verEstudiante-{id}"}, method = RequestMethod.GET)
    public String loadVerNinoAdinistrador(@PathVariable String id, ModelMap model) {
        Informacion medicamentos = new Informacion();
        Enfermedad enfermedad = new Enfermedad();
        Encargado en = encargadoService.findbyId(id);
        model.addAttribute("enc", en);
        Nino n = en.getNino().iterator().next();
        Clase c = n.getClase();
        String nivel = c.getNivel();
        model.addAttribute("nivel", nivel);
        int size1 = n.getEnfermedad().size();
        int size2 = n.getInformacion().size();

        if (size1 > 0) {
            enfermedad = n.getEnfermedad().iterator().next();
        }

        if (size2 > 0) {
            medicamentos = n.getInformacion().iterator().next();
        }
        SuperMatricula ma = new SuperMatricula();
        ma.setId(id);
        ma.setNivel(nivel);
        model.addAttribute("objeto", ma);
        model.addAttribute("enfermedad", enfermedad);
        model.addAttribute("medicamento", medicamentos);

        return "VerNinoAdministracion";
    }

    @RequestMapping(value = {"/CambiarNivel"}, method = RequestMethod.POST)
    public String cambiarNivel(@Valid SuperMatricula persona, ModelMap model) {
        Nino n = ninoService.findbyId(persona.getId());

        Clase c = claseService.findbyId(this.calcular(persona.getNivel()));
        n.setClase(c);
        ninoService.UpdateNino(n);

        return loadVerNinoAdinistrador(persona.getId(), model);

    }

    @RequestMapping(value = {"/verFamiliares-{id}"}, method = RequestMethod.GET)
    public String loadFamiliaresAdministracion(@PathVariable String id, ModelMap model) {
        Encargado enc = encargadoService.findbyId(id);
        Nino n = ninoService.findbyId(id);
        Set<Familiar> familiares = n.getFamiliares();
        model.addAttribute("familiares", familiares);
        model.addAttribute("enc", enc);

        return "InformacionFamiliarAdministracion";
    }

    @RequestMapping(value = {"/detallesMatricula-{id}"}, method = RequestMethod.GET)
    public String loadDetallesMatricula(@PathVariable String id, ModelMap model) {
        Encargado enc = encargadoService.findbyId(id);
        Nino n = ninoService.findbyId(id);
        Matricula m = n.getMatricula().iterator().next();
        model.addAttribute("matricula", m);
        model.addAttribute("enc", enc);

        return "InformacionMatricula";
    }

    @RequestMapping(value = {"/EditardetallesMatricula-{id}"}, method = RequestMethod.GET)
    public String loadEditarDetallesMatricula(@PathVariable String id, ModelMap model) {
        Encargado enc = encargadoService.findbyId(id);
        Nino n = ninoService.findbyId(id);
        Matricula m = n.getMatricula().iterator().next();
        SuperMatricula objeto = new SuperMatricula();
        objeto.setInfoCompleta(m.Completa());
        objeto.setVacunas(m.Carnet());
        objeto.setConsNacimiento(m.ConstanciaNacimiento());
        objeto.setTieneFotos(m.Fotos());
        objeto.setMonto(m.getMatricula());
        objeto.setCurso(m.getCursolectivo());
        objeto.setId(id);

        model.addAttribute("enc", enc);
        model.addAttribute("objeto", objeto);

        return "EditarDetallesMatricula";
    }

    @RequestMapping(value = {"/EditarDetallesMatriculaCambiar"}, method = RequestMethod.POST)
    public String loadEditarDetallesMatriculaCambiar(@Valid SuperMatricula persona, ModelMap model) {
        Nino n = ninoService.findbyId(persona.getId());
        String id = n.getId();
        Matricula m = n.getMatricula().iterator().next();
        m.setCompeta(persona.EstaCompleta());
        m.setCarnet(persona.EstaVacunas());
        m.setConstanciaNacimiento(persona.EstaConstancia());
        m.setFotos(persona.EstaFotos());
        m.setMatricula(persona.getMonto());
        m.setCursolectivo(persona.getCurso());
        matriculaService.UpdateMatricula(m);
        return loadDetallesMatricula(id, model);
    }

    @RequestMapping(value = {"/seleccionar"}, method = RequestMethod.POST)
    public void seleccionar(@Valid Clase clase, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AQUIIIIIII");
        String nivel = (String) request.getParameter("nombre");
        // String nivel = clase.getNivel();
        PrintWriter out = response.getWriter();
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(this.calcular(nivel));
        //      model.addAttribute("grupito", c);
        out.println(c.tablaEstudiantes());
    }
//------------------------PAGOOOOOOOOOOOOOOOOOOOOOOOSS--------------------------------------------

    @RequestMapping(value = {"/pagos-user-{id}"}, method = RequestMethod.GET)
    public String loadPagos(@PathVariable String id, ModelMap model, HttpServletRequest request) {
        Nino n = ninoService.findbyId(id);
        Pago p = new Pago();
        p.setId(n.getId());
        request.getSession().setAttribute("select", n);
        String nombre = n.getEncargado().iterator().next().getNombre();
        String apellido = n.getEncargado().iterator().next().getApellido1();
        String apellido2 = n.getEncargado().iterator().next().getApellido2();
        String nombreCompleto = nombre + " " + apellido + " " + apellido2;
        p.setNombre(nombreCompleto);
        model.addAttribute("factura", p);
        return "pagos";
    }

    @RequestMapping(value = {"/seleccionarPagos"}, method = RequestMethod.POST)
    public void seleccionarPagos(@Valid Clase clase, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AQUIIIIIII");
        String nivel = (String) request.getParameter("nombre");
        // String nivel = clase.getNivel();
        PrintWriter out = response.getWriter();
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(this.calcular(nivel));
        //      model.addAttribute("grupito", c);
        out.println(c.tablaEstudiantesPagos());
    }

    @RequestMapping(value = {"/RealizarPago"}, method = RequestMethod.POST)
    public String realizarPago(@Valid Pago fact, BindingResult result, ModelMap model, HttpServletRequest request) {
        //    System.out.println(contacto.toString());
        Nino n = (Nino) request.getSession().getAttribute("select");
        String id = n.getId();
        Nino nino = ninoService.findbyId(id);
        Long mes = fact.getMes();
        String monto = fact.getMonto();
        Mes m = mesService.findbyId(mes);
        Factura f = new Factura();

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());

        f.setFecha(formattedDate);
        f.setComprobante(fact.getComprobante());
        f.setFactura(fact.getFactura());
        f.setTipo_pago(fact.getTipo_pago());
        f.setMes(m);
        f.setMonto(fact.getMonto());
        f.setNino(nino);
        facturaService.save(f);
        model.addAttribute("id", nino.getId());
        return "PagoCorrecto";
    }

    //-------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------
    //-----------------PROFESORES-------------------------------------------
    @RequestMapping(value = {"/Profesores"}, method = RequestMethod.GET)
    public String loadProfesores(ModelMap model) {
        Profesor p = new Profesor();
        List<Profesor> profesores = profesorService.findAll();
        model.addAttribute("profesores", profesores);
        model.addAttribute("profesor", p);
        return "Profesores";
    }

    @RequestMapping(value = {"/AgregarProfesor"}, method = RequestMethod.POST)
    public String AgregarProfesor(@Valid Profesor profe, BindingResult result, ModelMap model) {

        if (this.profesorService.isIdUnique(profe.getId()) == false || result.hasErrors()) {
            model.addAttribute("error", "profesor existente en el sistema");
            return loadProfesores(model);
        }
        profesorService.save(profe);

        model.addAttribute("correcto", "profesor agregado correctamente");
        return loadProfesores(model);
    }

    @RequestMapping(value = {"/EliminarProfesor"}, method = RequestMethod.POST)
    public String EliminarProfesor(@Valid Profesor profe, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("error", "El profesor no se pudo eliminar");
            return loadProfesores(model);
        }

        Profesor p = profesorService.findbyId(profe.getId());

        Set<Clase> clases = p.getGrupo();

        for (Clase c : clases) {
            c.setProfesor(null);
            claseService.UpdateClase(c);
        }

        Set<Especialidad> especiali = p.getEspecialidad();

        for (Especialidad c : especiali) {
            c.setProfesor(null);
            especialidadService.UpdateEspecialidad(c);
        }
        profesorService.DeletebyId(p.getId());

        model.addAttribute("correcto", "profesor eliminado correctamente");
        return loadProfesores(model);
    }

    @RequestMapping(value = {"/EditarProfesor-{id}"}, method = RequestMethod.GET)
    public String EditarProfesor(@PathVariable String id, ModelMap model, HttpServletRequest request) {
        Profesor p = profesorService.findbyId(id);
        model.addAttribute("profesor", p);

        return "EditarProfesor";
    }

    @RequestMapping(value = {"/EditarProfesor"}, method = RequestMethod.POST)
    public String EditarProfesorCambio(@Valid Profesor profe, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "profesor no modificado correctamente");
            return loadProfesores(model);
        }

        profesorService.UpdateProfesor(profe);
        model.addAttribute("correcto", "profesor modificado correctamente");
        return loadProfesores(model);

    }

    //-------NIVELES---------------------
    @RequestMapping(value = {"/NivelesKinder"}, method = RequestMethod.GET)
    public String loadNiveles(ModelMap model) {
        Clase c = new Clase();
        NivelModificar g = new NivelModificar();
        List<Clase> niveles = claseService.findAll();
        model.addAttribute("niveles", niveles);
        model.addAttribute("grupo", g);
        model.addAttribute("clase", c);

        return "Niveles";
    }

    @RequestMapping(value = {"/EditarNivel"}, method = RequestMethod.POST)
    public String EditarNivel(@Valid NivelModificar nivel, BindingResult result, ModelMap model) {
        Clase n = claseService.findbyId(Long.parseLong(nivel.getId()));
        Profesor f = profesorService.findbyId(buscar(nivel.getProfesor()));
        if (!nivel.getNivel().equals("")) {
            n.setNivel(nivel.getNivel());
        }
        n.setProfesor(f);
        claseService.UpdateClase(n);
        model.addAttribute("correcto", "nivel modificado correctamente");
        return loadNiveles(model);
    }

    @RequestMapping(value = {"/AgregarNivel"}, method = RequestMethod.POST)
    public String AgregarNivel(@Valid NivelModificar nivel, BindingResult result, ModelMap model) {
        Clase n = new Clase();
        Profesor f = profesorService.findbyId(buscar(nivel.getProfesor()));

        n.setNivel(nivel.getNivel());
        n.setProfesor(f);
        claseService.save(n);
        model.addAttribute("correcto", "nivel agregado correctamente");
        return loadNiveles(model);
    }

    @RequestMapping(value = {"/EliminarNivel"}, method = RequestMethod.POST)
    public String EliminarNivel(@Valid Clase nivel, BindingResult result, ModelMap model) {
        Clase n = claseService.findbyId(nivel.getId());
        n.setProfesor(null);

        Set<Nino> ninos = n.getNinos();
        for (Nino ni : ninos) {
            ni.setClase(null);
            ninoService.UpdateNino(ni);
        }
        claseService.UpdateClase(n);
        claseService.DeletebyId(n.getId());
        model.addAttribute("correcto", "nivel eliminado correctamente");
        return loadNiveles(model);
    }

    @RequestMapping(value = {"/EstudiantesNivel-{id}"}, method = RequestMethod.GET)
    public String EstudiantesNivel(@PathVariable Long id, ModelMap model, HttpServletRequest request) {
        Clase c = claseService.findbyId(id);
        model.addAttribute("grupito", c);
        return "EstudiantesNivel";
    }

    //------------NIVELES--------------------------------------
    @RequestMapping(value = {"/CursosKinder"}, method = RequestMethod.GET)
    public String loadCursos(ModelMap model) {
        Especialidad c = new Especialidad();
        NivelModificar g = new NivelModificar();
        List<Especialidad> niveles = especialidadService.findAll();
        model.addAttribute("cursos", niveles);
        model.addAttribute("grupo", g);
        model.addAttribute("clase", c);

        return "Especialidades";
    }

    @RequestMapping(value = {"/AgregarCurso"}, method = RequestMethod.POST)
    public String AgregarCurso(@Valid NivelModificar nivel, BindingResult result, ModelMap model) {
        Especialidad n = new Especialidad();
        Profesor f = profesorService.findbyId(buscar(nivel.getProfesor()));

        n.setNombre(nivel.getNivel());
        n.setProfesor(f);
        especialidadService.save(n);
        model.addAttribute("correcto", "curso agregado correctamente");
        return loadCursos(model);
    }

    @RequestMapping(value = {"/EditarCurso"}, method = RequestMethod.POST)
    public String EditarCurso(@Valid NivelModificar nivel, BindingResult result, ModelMap model) {
        Especialidad n = especialidadService.findbyId(Long.parseLong(nivel.getId()));
        Profesor f = profesorService.findbyId(buscar(nivel.getProfesor()));
        if (!nivel.getNivel().equals("")) {
            n.setNombre(nivel.getNivel());
        }
        n.setProfesor(f);
        especialidadService.UpdateEspecialidad(n);
        model.addAttribute("correcto", "curso modificado correctamente");
        return loadCursos(model);
    }

    @RequestMapping(value = {"/EliminarCurso"}, method = RequestMethod.POST)
    public String EliminarCurso(@Valid Especialidad nivel, BindingResult result, ModelMap model) {
        Especialidad n = especialidadService.findbyId(nivel.getId());
        n.setProfesor(null);

        especialidadService.UpdateEspecialidad(n);
        especialidadService.DeletebyId(n.getId());
        model.addAttribute("correcto", "curso eliminado correctamente");
        return loadCursos(model);
    }

//------------------------FACTURAS----------------------------------------------------------------------------------
    @RequestMapping(value = {"/FacurasSeleccionar"}, method = RequestMethod.GET)
    public String loadFacturasSelecionar(ModelMap model) {
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(new Long(1));
        model.addAttribute("grupito", c);
        return "SeleccionarEstudianteFacturas";

    }

    @RequestMapping(value = {"/seleccionarFacturas"}, method = RequestMethod.POST)
    public void seleccionarFacturas(@Valid Clase clase, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AQUIIIIIII");
        String nivel = (String) request.getParameter("nombre");
        // String nivel = clase.getNivel();
        PrintWriter out = response.getWriter();
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        Clase c = claseService.findbyId(this.calcular(nivel));
        //      model.addAttribute("grupito", c);
        out.println(c.tablaEstudiantesFacturas());
    }

    @RequestMapping(value = {"/facturasAdministracion-{id}"}, method = RequestMethod.GET)
    public String FacturasEstudianteAdministracion(@PathVariable String id, ModelMap model, HttpServletRequest request) {
        Nino n = ninoService.findbyId(id);

        Factura f = new Factura();

        List<Mes> meses = mesService.findAll();
        model.addAttribute("tabla", n.TablaFacturas(meses));
        model.addAttribute("factura", f);
        return "FacturasEstudianteAdministracion";
    }

    @RequestMapping(value = {"/facturasEstudiante"}, method = RequestMethod.GET)
    public String FacturasEstudiante(ModelMap model, HttpServletRequest request) {
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Nino n = ninoService.findbyId(usu.getId());
        List<Mes> meses = mesService.findAll();
        model.addAttribute("tabla", n.TablaFacturas2(meses));

        return "FacturasUsuario";
    }

    @RequestMapping(value = {"/FacurasPorMes"}, method = RequestMethod.GET)
    public String loadFacturasPorMes(ModelMap model) {
        Mes m = mesService.findbyId(new Long(2));
        Clase g = new Clase();
        model.addAttribute("grupo", g);
        model.addAttribute("tabla", this.TablaFacturasMeses(m));
        return "FacturasMes";

    }

    @RequestMapping(value = {"/seleccionarMes"}, method = RequestMethod.POST)
    public void seleccionarMes(@Valid Clase clase, BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("AQUIIIIIII");
        String nivel = (String) request.getParameter("nombre");
        Long val = Long.parseLong(nivel);
        Mes m = mesService.findbyId(new Long(val));
        // String nivel = clase.getNivel();
        PrintWriter out = response.getWriter();

        //      model.addAttribute("grupito", c);
        out.println(this.TablaFacturasMeses(m));
    }

    @RequestMapping(value = {"/editar-factura-{id}"}, method = RequestMethod.GET)
    public String loadPagos(@PathVariable Long id, ModelMap model, HttpServletRequest request) {
        Factura f = facturaService.findbyCodigo(id);
        Encargado n = encargadoService.findbyId(f.getNino().getId());
        model.addAttribute("id", n.getId());
        Pago p = new Pago();
        p.setId(f.getNino().getId());
        String nombre = n.getNombre();
        String apellido = n.getApellido1();
        String apellido2 = n.getApellido2();
        String nombreCompleto = nombre + " " + apellido + " " + apellido2;
        p.setNombre(nombreCompleto);
        p.setFactura(f.getFactura());
        p.setMonto(f.getMonto());
        p.setTipo_pago(f.getTipo_pago());
        p.setComprobante(f.getComprobante());
        p.setMes(f.getMes().getCodigo());
        p.setFecha_actual(f.getFecha());
        p.setCodigo(f.getCodigo());
        model.addAttribute("factura", p);
        return "EditarFactura";
    }

    @RequestMapping(value = {"/EditarLaFactura"}, method = RequestMethod.POST)
    public String EditarLaFactura(@Valid Pago fact, BindingResult result, ModelMap model, HttpServletRequest request) {
        Factura f = facturaService.findbyCodigo(fact.getCodigo());
        Nino n = ninoService.findbyId(fact.getId());
        Long mes = fact.getMes();

        if (result.hasErrors()) {
            model.addAttribute("error", "Error al modificar factura");
            return FacturasEstudianteAdministracion(fact.getId(), model, request);
        }

        f.setTipo_pago(fact.getTipo_pago());

        if (fact.getTipo_pago().equalsIgnoreCase("Efectivo")) {
            f.setComprobante("");
            f.setFactura("");
        } else {
            f.setComprobante(fact.getComprobante());
            f.setFactura(fact.getFactura());
        }
        f.setFecha(fact.getFecha_actual());
        f.setMonto(fact.getMonto());

        facturaService.UpdateFactura(f);

        model.addAttribute("correcto", "Factura modificada correctamente");

        return FacturasEstudianteAdministracion(fact.getId(), model, request);
    }

    @RequestMapping(value = {"/EliminarFactura"}, method = RequestMethod.POST)
    public String EliminarFactura(@Valid Factura fact, BindingResult result, ModelMap model, HttpServletRequest request) {
        Factura f = facturaService.findbyCodigo(fact.getCodigo());
        String id = f.getNino().getId();
        if (result.hasErrors()) {
            model.addAttribute("error", "Error al eliminar factura");
            return FacturasEstudianteAdministracion(id, model, request);
        }

        f.setNino(null);
        f.setMes(null);
        facturaService.UpdateFactura(f);
        facturaService.DeletebyCodigo(f.getCodigo());
        model.addAttribute("correcto", "Factura eliminada correctamente");
        return FacturasEstudianteAdministracion(id, model, request);
    }

    //--------------------------------------------------------------
    private String buscar(String profesor) {
        List<Profesor> profesores = profesorService.findAll();

        for (Profesor c : profesores) {
            if (c.getNombre().equals(profesor)) {
                return c.getId();
            }
        }

        return "";
    }

    //--------------------------------------------------------------------------------------
    @RequestMapping(value = {"/administradores"}, method = RequestMethod.GET)
    public String loadAdministradores(ModelMap model, HttpServletRequest request) {
        Encargado e = new Encargado();

        model.addAttribute("administradores", this.tablaAdministradores(request));
        model.addAttribute("administrador", e);
        return "Administradores";
    }

    @RequestMapping(value = {"/EliminarAdministrador"}, method = RequestMethod.POST)
    public String EliminarAdministrador(@Valid Encargado enc, BindingResult result, ModelMap model, HttpServletRequest request) {

        String id = enc.getId();
        if (result.hasErrors()) {
            model.addAttribute("error", "El administrador no se pudo eliminar");
            return loadAdministradores(model, request);
        }

        Usuario s = usuarioService.findbyId(enc.getId());
        s.setEncargado(null);
        usuarioService.UpdateUsuario(s);
        usuarioService.DeletebyId(s.getId());

        encargadoService.DeletebyId(enc.getId());

        model.addAttribute("correcto", "administrador eliminado correctamente");
        return loadAdministradores(model, request);
    }

    @RequestMapping(value = {"/agregarAdministrador"}, method = RequestMethod.POST)
    public String AgregarAdministrador(@Valid Encargado enc, BindingResult result, ModelMap model, HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("error", "El administrador no se pudo agregar");
            return loadAdministradores(model, request);
        }

        Usuario u = new Usuario();

        u.setId(enc.getId());
        u.setEmail(enc.getEmail());
        u.setContrasena("admin");
        u.serAdministrador();

        usuarioService.save(u);
        enc.getUsuario().add(u);
        encargadoService.save(enc);

        model.addAttribute("correcto", "administrador agregado correctamente");
        return loadAdministradores(model, request);
    }
//-------------------------------------------------------------------------------------------------------------------------

    @ModelAttribute("niveles")
    public List<String> initializeProfiles() {
        List<Clase> lista = claseService.findAll();

        List<String> valores = new ArrayList<String>();
        for (Clase c : lista) {
            valores.add(c.getNivel());
        }
        Collections.sort(valores);

        return valores;
    }

    @ModelAttribute("opciones")
    public ArrayList<String> initializeOpciones() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("Si");
        l.add("No");
        return l;
    }

    @ModelAttribute("genero")
    public ArrayList<String> initializeGenero() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("Masculino");
        l.add("Femenino");
        return l;
    }

    @ModelAttribute("profesores")
    public ArrayList<String> initializeProfesores() {
        List<Profesor> profesores = profesorService.findAll();
        ArrayList<String> l = new ArrayList<String>();
        for (Profesor c : profesores) {
            l.add(c.getNombre());
        }
        return l;
    }

    @ModelAttribute("Meses")
    public List<Mes> initializeMese() {
        return mesService.findAll();
    }

    @ModelAttribute("TiposPago")
    public List<String> initializeTiposPago() {
        ArrayList<String> l = new ArrayList<String>();
        l.add("Efectivo");
        l.add("Tarjeta");
        l.add("Deposito");

        return l;
    }

    public Long calcular(String ni) {
        List<Clase> lista = claseService.findAll();
        for (Clase c : lista) {
            if (c.getNivel().equals(ni)) {
                return c.getId();
            }

        }
        return null;

    }

    //----------------TABLA FACTURAS MESES------------------------------------
    private String TablaFacturasMeses(Mes m) {
        List<Nino> ninos = ninoService.findAll();
        StringBuilder s = new StringBuilder();
        s.append("<h4>Registro de sus facturas</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>Estudiante</th>");
        s.append("<th>Fecha</th>");
        s.append("<th>Monto mensualiad</th>");
        s.append("<th>Monto mora</th>");
        s.append("<th>Nº comprobante</th>");
        s.append("<th>Nº factura</th>");
        s.append("<th>Tipo pago</th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");

        for (Nino n : ninos) {

            if (n.getEstado()) {
                if (n.buscarFactura(m).getCodigo() != null) {
                    s.append("<tr class=\"success\">");
                } else {
                    s.append("<tr class=\"danger\">");
                }

                s.append("<td>" + n.getId() + "</td>");
                s.append("<td>" + n.getEncargadoReal().getNombre() + " " + n.getEncargadoReal().getApellido1() + " " + n.getEncargadoReal().getApellido2() + "</td>");
                s.append("<td>" + n.buscarFactura(m).getFecha() + "</td>");
                s.append("<td>" + n.buscarFactura(m).getMonto() + "</td>");
                s.append("<td>" + n.buscarFactura(m).calcularMontoMora() + "</td>");
                s.append("<td>" + n.buscarFactura(m).getComprobante() + "</td>");
                s.append("<td>" + n.buscarFactura(m).getFactura() + "</td>");
                if (n.buscarFactura(m).getCodigo() != null) {
                    s.append("<td>" + n.buscarFactura(m).getTipo_pago() + "</td>");
                } else {
                    s.append("<td>Pendiente</td>");
                }

                s.append("</tr>");
            }

        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public Collection<Encargado> purga() {
        Collection<Encargado> purga = new ArrayList<Encargado>();
        List<Nino> ninos = ninoService.findAll();
        for (Nino n : ninos) {
            if (!n.getEstado()) {
                purga.add(n.getEncargado().iterator().next());
            }

        }
        return purga;
    }

    public Collection<Encargado> administraores() {
        Collection<Encargado> administradores = new ArrayList<Encargado>();
        List<Usuario> encargados = usuarioService.findAll();
        for (Usuario n : encargados) {
            if (n.isAdministrador()) {
                administradores.add(n.getEncargado().iterator().next());
            }

        }
        return administradores;
    }

    public String tablaAdministradores(HttpServletRequest request) {
        StringBuilder s = new StringBuilder();
        Usuario usu = (Usuario) request.getSession().getAttribute("user");
        Collection<Encargado> admins = administraores();
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>Nombre</th>");
        s.append("<th>Email</th>");
        s.append("<th>TELEFONO</th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");

        for (Encargado n : admins) {

            if (n.getId().equals(usu.getId())) {
                s.append("<tr class=\"success\">");
            } else {
                s.append("<tr class=\"active\">");
            }

            s.append("<td>" + n.getId() + "</td>");
            s.append("<td>" + n.getNombre() + " " + n.getApellido1() + " " + n.getApellido2() + "</td>");
            s.append("<td>" + n.getEmail() + "</td>");
            s.append("<td>" + n.getTelefono() + "</td>");
            if (n.getId().equals(usu.getId())) {
                s.append("<td></td>");
            } else {
                s.append("<td><button type=\"button\" id='" + n.getId() + "' class=\"btn btn-danger custom-width\" onclick=\"eliminar(this.id)\" data-toggle=\"modal\" data-target=\"#myModal\">Eliminar</button></td>");
            }

            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

}
