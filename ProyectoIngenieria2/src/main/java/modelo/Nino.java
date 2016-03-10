package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enc_nino",
            joinColumns = {
                @JoinColumn(name = "nino_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "enc_id")})
    private Set<Encargado> encargado = new HashSet<Encargado>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idnino")
    private Collection<Informacion> informacion;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idnino")
    private Collection<Familiar> familiares;

    
  @JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne
    private Clase clase;
  
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nino")
    private Collection<Matricula> matricula;

    public Collection<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(Collection<Matricula> matricula) {
        this.matricula = matricula;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
   

    public Collection<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(Collection<Familiar> familiares) {
        this.familiares = familiares;
    }

   

    public Collection<Familiar> getFamiliar() {
        return familiares;
    }

    public void setFamiliar(Collection<Familiar> familiar) {
        this.familiares = familiar;
    }

    public Collection<Informacion> getInformacion() {
        return informacion;
    }

    public void setInformacion(Collection<Informacion> informacion) {
        this.informacion = informacion;
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
