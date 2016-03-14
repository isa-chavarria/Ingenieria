/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author josvr_000
 */
@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Column(name = "completa")
    private Boolean competa;
    @Column(name = "constanciaNac")
    private Boolean constanciaNacimiento;
    @Column(name = "carnetvac")
    private Boolean carnet;
    @Column(name = "fotos")
    private Boolean fotos;
    @Size(max = 1000)
    @Column(name = "matricula")
    private String matricula;

    @Size(max = 50)
    @Column(name = "cursolectivo")
    private String cursolectivo;

    @Size(max = 50)
    @Column(name = "realizadoPor")
    private String realizadoPor;

    @JoinColumn(name = "id_nino", referencedColumnName = "id")
    @ManyToOne
    private Nino nino;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCompeta() {
        return competa;
    }

    public void setCompeta(Boolean competa) {
        this.competa = competa;
    }

    public Boolean getConstanciaNacimiento() {
        return constanciaNacimiento;
    }

    public void setConstanciaNacimiento(Boolean constanciaNacimiento) {
        this.constanciaNacimiento = constanciaNacimiento;
    }

    public Boolean getCarnet() {
        return carnet;
    }

    public void setCarnet(Boolean carnet) {
        this.carnet = carnet;
    }

    public Boolean getFotos() {
        return fotos;
    }

    public void setFotos(Boolean fotos) {
        this.fotos = fotos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCursolectivo() {
        return cursolectivo;
    }

    public void setCursolectivo(String cursolectivo) {
        this.cursolectivo = cursolectivo;
    }

    public String getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.clase[ id=" + id + " ]";
    }

}
