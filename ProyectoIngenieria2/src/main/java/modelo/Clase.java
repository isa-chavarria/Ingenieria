/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Isa
 */
@Entity
@Table(name = "clase")
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "nivel")
    private String nivel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo")
    private Set<Nino> ninos = new HashSet<>();
    ;

    @JoinColumn(name = "profesor", referencedColumnName = "id")
    @ManyToOne
    private Profesor profesor;

    public Set<Nino> getNinos() {
        return ninos;
    }

    public void setNinos(Set<Nino> ninos) {
        this.ninos = ninos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public Collection<Encargado> purga() {
        Collection<Encargado> purga = new ArrayList<Encargado>();
        for (Nino n : this.ninos) {
            if (n.getEstado()) {
                purga.add(n.getEncargado().iterator().next());
            }

        }
        return purga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String tablaEstudiantesFacturas() {
        Collection<Encargado> lista = this.purga();

        StringBuilder s = new StringBuilder();
        s.append("<h4>Estudiantes de " + nivel + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box

        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>NOMBRE</th>");
        s.append("<th>PRIMER APELLIDO</th>");
        s.append("<th>SEGUNDO APELLIDO</th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");

        for (Encargado e : lista) {
            s.append("<tr class=\"active\">");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td><a href='facturasAdministracion-" + e.getId() + "' class=\"btn btn-success custom-width\">Ver Facturas</a></td>");

            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public String tablaEstudiantesPagos() {
        Collection<Encargado> lista = this.purga();

        StringBuilder s = new StringBuilder();
        s.append("<h4>Estudiantes de " + nivel + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box

        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>NOMBRE</th>");
        s.append("<th>PRIMER APELLIDO</th>");
        s.append("<th>SEGUNDO APELLIDO</th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");

        for (Encargado e : lista) {
            s.append("<tr class=\"active\">");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td><a href='pagos-user-" + e.getId() + "' class=\"btn btn-success custom-width\">Registrar pago</a></td>");

            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public String tablaEstudiantes() {

        Collection<Encargado> lista = this.purga();

        StringBuilder s = new StringBuilder();
        s.append("<h4>Estudiantes de " + nivel + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box

        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>NOMBRE</th>");
        s.append("<th>PRIMER APELLIDO</th>");
        s.append("<th>SEGUNDO APELLIDO</th>");
        s.append("<th>FECHA DE NACIMIENTO</th>");
        s.append("<th></th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody  class=\"cuerpoTabla\">");

        for (Encargado e : lista) {
            s.append("<tr class=\"active\">");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td>" + e.getFechaNacimiento() + "</td>");
            s.append("<td><a href='verEstudiante-" + e.getId() + "' class=\"btn btn-success custom-width\">Editar</a></td>");
            s.append("<td><button type=\"button\" id='" + e.getId() + "' class=\"btn btn-danger custom-width\" onclick=\"eliminar(this.id)\" data-toggle=\"modal\" data-target=\"#myModal\">Marcar como inactivo</button></td>");

            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }
    
    
    public String tablaEstudiantesMensajes() {
        Collection<Encargado> lista = this.purga();

        StringBuilder s = new StringBuilder();
        s.append("<h4>Estudiantes de " + nivel + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box

        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>ID</th>");
        s.append("<th>NOMBRE</th>");
        s.append("<th>PRIMER APELLIDO</th>");
        s.append("<th>SEGUNDO APELLIDO</th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");

        for (Encargado e : lista) {
            s.append("<tr class=\"active\">");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td><a href='mensajesKinder-" + e.getId() + "' class=\"btn btn-success custom-width\">Enviar mensaje</a></td>");

            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public String getProfesorNombre() {

        return (profesor != null) ? profesor.getNombre() : "NA";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Clase[ id=" + id + " ]";
    }
}
