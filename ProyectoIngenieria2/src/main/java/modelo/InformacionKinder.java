/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Isa
 */
@Entity
@Table(name = "InformacionKinder")

public class InformacionKinder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;

    @Size(max = 50)
    @Column(name = "fecha")
    private String fecha;

    @Size(max = 50)
    @Column(name = "monto")
    private String monto;

    @Size(max = 50)
    @Column(name = "montoMatricula")
    private String montoMatricula;

    @ManyToOne
    @JoinColumn(name = "kinder")
    private Kinder kinder;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMontoMatricula() {
        return montoMatricula;
    }

    public void setMontoMatricula(String montoMatricula) {
        this.montoMatricula = montoMatricula;
    }

    public Kinder getKinder() {
        return kinder;
    }

    public void setKinder(Kinder kinder) {
        this.kinder = kinder;
    }

    public InformacionKinder() {
    }

    public boolean esFechaDePago(int dia) {
        int d = Integer.parseInt(fecha);
        return dia >= d;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionKinder)) {
            return false;
        }
        InformacionKinder other = (InformacionKinder) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Contacto[ codigo=" + codigo + " ]";
    }

}
