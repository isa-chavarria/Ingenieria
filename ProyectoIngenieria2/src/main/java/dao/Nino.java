/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Isa
 */
@Entity
@Table(name = "nino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nino.findAll", query = "SELECT n FROM Nino n"),
    @NamedQuery(name = "Nino.findById", query = "SELECT n FROM Nino n WHERE n.id = :id"),
    @NamedQuery(name = "Nino.findByNombre", query = "SELECT n FROM Nino n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Nino.findByApellido1", query = "SELECT n FROM Nino n WHERE n.apellido1 = :apellido1"),
    @NamedQuery(name = "Nino.findByApellido2", query = "SELECT n FROM Nino n WHERE n.apellido2 = :apellido2"),
    @NamedQuery(name = "Nino.findByFechanacimiento", query = "SELECT n FROM Nino n WHERE n.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Nino.findByDireccion", query = "SELECT n FROM Nino n WHERE n.direccion = :direccion"),
    @NamedQuery(name = "Nino.findByRutaImagen", query = "SELECT n FROM Nino n WHERE n.rutaImagen = :rutaImagen")})
public class Nino implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 50)
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 1000)
    @Column(name = "ruta_imagen")
    private String rutaImagen;

    public Nino() {
    }

    public Nino(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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
        if (!(object instanceof Nino)) {
            return false;
        }
        Nino other = (Nino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Nino[ id=" + id + " ]";
    }
    
}
