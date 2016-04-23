package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

public class Nino implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Column(name = "estado")
    private Boolean estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "enc_nino",
            joinColumns = {
                @JoinColumn(name = "nino_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "enc_id")})
    private Set<Encargado> encargado = new HashSet<Encargado>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idnino")
    private Set<Informacion> informacion = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_nino")
    private Set<Enfermedad> enfermedad = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idnino")
    private Set<Familiar> familiares = new HashSet<>();

    @JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne
    private Clase clase;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_nino")
    private Set<Factura> facturas = new HashSet<>();
    ;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_nino")
    private Set<Matricula> matricula = new HashSet<>();

    public Set<Informacion> getInformacion() {
        return informacion;
    }

    public void setInformacion(Set<Informacion> informacion) {
        this.informacion = informacion;
    }

    public Set<Enfermedad> getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Set<Enfermedad> enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public Set<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(Set<Matricula> matricula) {
        this.matricula = matricula;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Set<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(Set<Familiar> familiares) {
        this.familiares = familiares;
    }

    public Set<Encargado> getEncargado() {
        return encargado;
    }

    public void setEncargado(Set<Encargado> encargado) {
        this.encargado = encargado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Encargado getEncargadoReal() {
        return encargado.iterator().next();
    }

    public String TablaFacturas(List<Mes> meses) {

        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        StringBuilder s = new StringBuilder();
        s.append("<h4>" + getEncargadoReal().getNombre() + " " + getEncargadoReal().getApellido1() + " " + getEncargadoReal().getApellido2() + "</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>" + formattedDate + "</th>");
        s.append("<th>Fecha</th>");
        s.append("<th>Monto mensualiad</th>");
        s.append("<th>Monto mora</th>");
        s.append("<th>Tipo pago</th>");
        s.append("<th>Nº comprobante</th>");
        s.append("<th>Nº factura</th>");
        s.append("<th></th>");
        s.append("<th></th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");
        for (Mes m : meses) {

            if (buscarFactura(m).getCodigo() != null) {
                s.append("<tr class=\"success\">");
            } else {
                s.append("<tr class=\"danger\">");
            }

            s.append("<th>" + m.getMes() + "</th>");
            s.append("<td>" + this.buscarFactura(m).getFecha() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getMonto() + "</td>");
            s.append("<td>" + this.buscarFactura(m).calcularMontoMora() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getTipo_pago() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getComprobante() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getFactura() + "</td>");
            if (buscarFactura(m).getCodigo() != null) {
                s.append("<td><a href='editar-factura-" + buscarFactura(m).getCodigo() + "' class=\"btn btn-success custom-width\">Editar</a></td>");
                s.append("<td><button type=\"button\" id='" + buscarFactura(m).getCodigo() + "' class=\"btn btn-danger custom-width\" onclick=\"eliminar(this.id)\" data-toggle=\"modal\" data-target=\"#myModal\">Eliminar</button></td>");
            } else {
                s.append("<td></td>");
                s.append("<td></td>");
            }
            s.append("</tr>");
        }
        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public String TablaFacturas2(List<Mes> meses) {

        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        StringBuilder s = new StringBuilder();
        s.append("<h4>Registro de sus facturas</h4>");
        s.append("<div style=\" overflow: scroll ; height: 500px \" class=\"box\">");// abrir box
        s.append("<table class=\"table table-bordered table-hover\">");// abrir table

        s.append("<thead class=\"titulosTabla\">");
        s.append("<tr>");
        s.append("<th>" + formattedDate + "</th>");
        s.append("<th>Fecha</th>");
        s.append("<th>Monto mensualiad</th>");
        s.append("<th>Monto mora</th>");
        s.append("<th>Tipo pago</th>");
        s.append("<th>Nº comprobante</th>");
        s.append("<th>Nº factura</th>");
        s.append("</tr>");
        s.append("</thead>");

        s.append("<tbody class=\"cuerpoTabla\">");
        for (Mes m : meses) {

            if (buscarFactura(m).getCodigo() != null) {
                s.append("<tr class=\"success\">");
            } else {
                s.append("<tr class=\"danger\">");
            }

            s.append("<th>" + m.getMes() + "</th>");
            s.append("<td>" + this.buscarFactura(m).getFecha() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getMonto() + "</td>");
            s.append("<td>" + this.buscarFactura(m).calcularMontoMora() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getTipo_pago() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getComprobante() + "</td>");
            s.append("<td>" + this.buscarFactura(m).getFactura() + "</td>");
            s.append("</tr>");
        }
        s.append("</tbody>");

        s.append("</table>");// cerrar table

        s.append("</div>");// cerrar box

        return s.toString();
    }

    public Factura buscarFactura(Mes mes) {
        for (Factura f : facturas) {


            if (f.getMes().getMes().equalsIgnoreCase(mes.getMes())) {
                return f;
            }
        }

        return new Factura();
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
        return "modelo.Nino[ id=" + id + " ]";
    }

}
