/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Isa
 */
@Entity
@Table(name="kinder")
public class Kinder implements Serializable{

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @Size(max = 50)
    private String direccion;
    @Size(max = 50)
    private String telefono;
    @Size(max = 5000)
    private String historia;
    @Size(max = 5000)
    private String mision;
    @Size(max = 5000)
    private String vision;

    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="kinder")
    Collection<Contacto> contactos;
     @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="kinder")
    Collection<Album> albums;
      @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="kinder")
    Collection<Factura> facturas;

    public Collection<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Collection<Album> albums) {
        this.albums = albums;
    }

    public Collection<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Collection<Factura> facturas) {
        this.facturas = facturas;
    }

      
    public Collection<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(Collection<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kinder)) {
            return false;
        }
        Kinder other = (Kinder) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Kinder[ nombre=" + nombre + " ]";
    }
    
}
