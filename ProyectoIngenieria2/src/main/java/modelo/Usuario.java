/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Isa
 */
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", unique = true)
    private String email;
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 50)
    @Column(name = "rol")
    private String roleSeccion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usu_enc",
            joinColumns = {
                @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "enc_id")})
    private Set<Encargado> encargado = new HashSet<Encargado>();

    public Set<Encargado> getEncargado() {
        return encargado;
    }

    public void setEncargado(Set<Encargado> encargado) {
        this.encargado = encargado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdministrador() {
        return roleSeccion.equals("Administrador");
    }

    public boolean isEncargado() {
        return roleSeccion.equals("Encargado");
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRoleSeccion() {
        return roleSeccion;
    }

    public void setRoleSeccion(String roleSeccion) {
        this.roleSeccion = roleSeccion;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ id=" + id + " ]";
    }

}
