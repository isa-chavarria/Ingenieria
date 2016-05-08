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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;

    @Size(max = 200)
    @Column(name = "asunto")
    private String asunto;

    @Size(max = 5000)
    @Column(name = "mensaje")
    private String mensaje;
    
    @Size(max = 100)
    @Column(name = "tipo")
    private String type;
    
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "persona")
    private Encargado persona;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = false)
    private byte[] content;

    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "kin")
    private Boolean kin;
    
    @Column(name = "usu")
    private Boolean usu;
    
    

    public Mensaje() {
    }

    public Mensaje(Long codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public Boolean getKin() {
        return kin;
    }

    public void setKin(Boolean kin) {
        this.kin = kin;
    }

    public Boolean getUsu() {
        return usu;
    }

    public void setUsu(Boolean usu) {
        this.usu = usu;
    }

    
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Encargado getPersona() {
        return persona;
    }

    public void setPersona(Encargado persona) {
        this.persona = persona;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombrePersona() {     
        return persona.getNombre() + " " + persona.getApellido1();
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
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
