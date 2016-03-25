/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 50)
    @Column(name = "nivel")
    private String nivel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo")
    private Collection<Nino> ninos = new ArrayList<Nino>();

    @JoinColumn(name = "profesor", referencedColumnName = "id")
    @ManyToOne
    private Profesor profesor;

    public Collection<Nino> getNinos() {
        return ninos;
    }

    public void setNinos(Collection<Nino> ninos) {
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

    public String getId() {
        return id;
    }

    public Collection<Encargado> purga() {
        Collection<Encargado> purga = new ArrayList<Encargado>();
        int valor = 0;
        for (Nino n : this.ninos) {
            if (!purga.contains(n.getEncargado().iterator().next())) {
                purga.add(n.getEncargado().iterator().next());
                valor = 0;
            }
            valor++;
        }
        return purga;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String tablaEstudiantesPagos() {
        Collection<Encargado> lista = this.purga();

        StringBuilder s = new StringBuilder();
        s.append("<h4>Estudiantes de " + nivel + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box

        s.append("<table style='font-family: \"Josefin Slab\",\"Helvetica Neue\",Helvetica,Arial,sans-serif;' class=\"table\">");// abrir table

        s.append("<thead>");
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

        s.append("<tbody>");

        for (Encargado e : lista) {
            s.append("<tr>");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td>" + e.getFechaNacimiento() + "</td>");
            s.append("<td><a href='pagos-user-"+e.getId()+"' class=\"btn btn-success custom-width\">Realizar pago</a></td>");

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

        s.append("<table style='font-family: \"Josefin Slab\",\"Helvetica Neue\",Helvetica,Arial,sans-serif;' class=\"table\">");// abrir table

        s.append("<thead>");
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

        s.append("<tbody>");

        for (Encargado e : lista) {
            s.append("<tr>");
            s.append("<td>" + e.getId() + "</td>");
            s.append("<td>" + e.getNombre() + "</td>");
            s.append("<td>" + e.getApellido1() + "</td>");
            s.append("<td>" + e.getApellido2() + "</td>");
            s.append("<td>" + e.getFechaNacimiento() + "</td>");
            s.append("<td><a href=\"<c:url value='" + e.getId() + "' />\" class=\"btn btn-success custom-width\">Editar</a></td>");
            s.append("<td><a href=\"<c:url value='" + e.getId() + "' />\" class=\"btn btn-danger custom-width\">Eliminar</a></td>");
            s.append("</tr>");
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
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
