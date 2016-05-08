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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Isa
 */
@Entity
@Table(name = "encargado")
public class Encargado implements Serializable {

    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Size(max = 50)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 50)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 1000)
    @Column(name = "email")
    private String email;
    @Size(max = 1000)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "ruta_imagen")
    private String ruta_imagen;

    @Size(max = 50)
    @Column(name = "sexo")
    private String sexo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usu_enc",
            joinColumns = {
                @JoinColumn(name = "enc_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "user_id")})
    private Set<Usuario> usuario = new HashSet<Usuario>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "enc_nino",
            joinColumns = {
                @JoinColumn(name = "enc_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "nino_id")})
    private Set<Nino> nino = new HashSet<Nino>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "persona")
    Set<Mensaje> recibidos;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "persona")
    Set<MensajeKinder> enviados;

    public Set<MensajeKinder> getEnviados() {
        return enviados;
    }

    public void setEnviados(Set<MensajeKinder> enviados) {
        this.enviados = enviados;
    }

    public Set<Mensaje> getRecibidos() {
        return recibidos;
    }

    public void setRecibidos(Set<Mensaje> recibidos) {
        this.recibidos = recibidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Set<Nino> getNino() {
        return nino;
    }

    public void setNino(Set<Nino> nino) {
        this.nino = nino;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public String getRuta_imagen2() {
        if (ruta_imagen.length() > 30) {
            return "data:image/gif;base64," + ruta_imagen;

        }
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Encargado)) {
            return false;
        }
        Encargado other = (Encargado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Encargado[ id=" + id + " ]";
    }

    public String tablaMensajesRecibidos() {

        StringBuilder s = new StringBuilder();
        s.append("<h4>Bandeja de entrada</h4>");
        s.append("<div style=\" overflow: scroll ; height: 300px \" class=\"box\">");// abrir box
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table
        s.append("<tbody class=\"cuerpoTabla\">");

        for (Mensaje m : recibidos) {
            if (m.getUsu()) {

                if (m.getEstado()) {
                    s.append("<tr style='background: #E6F0FF;'>");
                    s.append("<td><strong>De:    Kinder Lulú</strong></td>");
                    s.append("<td><strong>" + m.getAsunto() + "</strong></td>");

                } else {
                    s.append("<tr class=\"active\">");
                    s.append("<td>De:    Kinder Lulú</td>");
                    s.append("<td>" + m.getAsunto() + "</td>");
                }

                s.append("<td><a href='verMensaje-" + m.getCodigo() + "' class=\"btn btn-success custom-width\">Ver</a></td>");
                s.append("<td><button type=\"button\" id='" + m.getCodigo() + "' class=\"btn btn-danger custom-width\" onclick=\"eliminar(this.id)\" data-toggle=\"modal\" data-target=\"#myModal\">Eliminar</button></td>");

                s.append("</tr>");
            }
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box
        return s.toString();
    }

    public String tablaMensajesEnviadas() {

        StringBuilder s = new StringBuilder();
        s.append("<h4>Mensajes enviados al kinder</h4>");
        s.append("<div style=\" overflow: scroll ; height: 300px \" class=\"box\">");// abrir box
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table
        s.append("<tbody class=\"cuerpoTabla\">");

        for (MensajeKinder m : enviados) {
            if (m.getUsu()) {
                s.append("<tr class=\"active\">");
                s.append("<td>Para:    Kinder Lulú</td>");
                s.append("<td>" + m.getAsunto() + "</td>");

                s.append("<td><a href='verMensajeEnviado-" + m.getCodigo() + "' class=\"btn btn-success custom-width\">Ver</a></td>");
                s.append("<td><button type=\"button\" id='" + m.getCodigo() + "' class=\"btn btn-danger custom-width\" onclick=\"eliminar(this.id)\" data-toggle=\"modal\" data-target=\"#myModal\">Eliminar</button></td>");

                s.append("</tr>");
            }
        }

        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box
        return s.toString();
    }

    public List<Mensaje> mensajes() {

        List<Mensaje> lista2 = new ArrayList<>();

        for (Mensaje m : recibidos) {
            if (m.getEstado()) {
                lista2.add(m);
            }
        }

        return lista2;

    }

}
