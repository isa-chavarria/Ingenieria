/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo = null;

    @Size(max = 50)
    @Column(name = "fecha_actual")
    private String fecha = "";

    @Size(max = 50)
    @Column(name = "monto_final")
    private String monto = "";

    @Size(max = 50)
    @Column(name = "tipo_pago")
    private String tipo_pago = "";

    @Size(max = 50)
    @Column(name = "comprobante")
    private String comprobante = "";

    @Size(max = 50)
    @Column(name = "factura")
    private String factura = "";

    @JoinColumn(name = "id_nino", referencedColumnName = "id")
    @ManyToOne
    private Nino nino;

    @JoinColumn(name = "id_mes", referencedColumnName = "codigo")
    @ManyToOne
    private Mes mes;

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public float calcularMontoMora(String m) {
        float m1 = Float.parseFloat(m);
        if (!monto.equals("")) {

            float monto = Float.parseFloat(this.monto);
            return (m1 - monto);
        }
        return m1;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

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

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public void actualizarMonto(String m) {
        float v1 = Float.parseFloat(m);
        float v2 = Float.parseFloat(this.monto);
        float res = v1 + v2;

        monto = "" + res;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ codigo=" + codigo + " ]";
    }

}
