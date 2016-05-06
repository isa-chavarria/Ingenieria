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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
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

    @Size(max = 1000)
    @Column(name = "realizadoPor")
    private String realizadoPor;

    @JoinColumn(name = "id_nino", referencedColumnName = "id")
    @ManyToOne
    private Nino nino;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String Completa() {
        return (this.competa == true) ? "Si" : "No";
    }

    public String ConstanciaNacimiento() {
        return (this.constanciaNacimiento == true) ? "Si" : "No";
    }

    public String Carnet() {
        return (this.carnet == true) ? "Si" : "No";
    }

    public String Fotos() {
        return (this.fotos == true) ? "Si" : "No";
    }

    public float calcularMora(String matri) {
        float monto = Float.parseFloat(matricula);
        float m = Float.parseFloat(matri);
        return m - monto;
    }

    public void actualizarMonto(String m) {
        float v1 = Float.parseFloat(m);
        float v2 = Float.parseFloat(this.matricula);
        float res = v1 + v2;

        matricula = "" + res;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.clase[ id=" + codigo + " ]";
    }

    public String getTabla(String matric) {

        StringBuilder s = new StringBuilder();
        s.append(" <tr><td><strong>Documentación completa</strong></td><td>" + Completa() + "</td></tr>");
        s.append(" <tr><td><strong>Presento carné de vacunas</strong></td><td>" + Carnet() + "</td></tr>");
        s.append(" <tr><td><strong>Presento constancia de nacimiento</strong></td><td>" + ConstanciaNacimiento() + "</td></tr>");
        s.append("<tr><td><strong>Presento Fotos</strong></td><td>" + Fotos() + "</td></tr>");
        s.append("<tr><td><strong>Total del Pago ¢</strong></td><td>" + matricula + "</td></tr>");
        s.append("<tr><td><strong>Monto de Mora ¢</strong></td><td>" + calcularMora(matric) + "</td></tr>");
        s.append("<tr><td><strong>Curso lectivo</strong></td><td>" + cursolectivo + "</td></tr>");
        s.append("<tr><td><strong>Matrícula realizada por</strong></td><td>" + realizadoPor + "</td></tr>");

        return s.toString();
    }

}
