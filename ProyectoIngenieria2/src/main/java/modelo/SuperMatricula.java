/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author josvr_000
 */
public class SuperMatricula {

    String nombre;
    String apellido1;
    String apellido2;
    String email;
    String id;
    String fechaNacimiento;
    String password;
    String telefono;
    String enfermedad;
    String medicamento;
    String sexo;
    //------------PADRE--------------------------
    String nombrePadre;
    String edadPadre;
    String cedulaPadre;
    String ocupacionPadre;
    String lugarTrabajoPadre;
    String telefonoTrabajoPadre;
    String telefonoPersonalPadre;
    //------------PADRE--------------------------
    String nombreMadre;
    String edadMadre;
    String cedulaMadre;
    String ocupacionMadre;
    String lugarTrabajoMadre;
    String telefonoTrabajoMadre;
    String telefonoPersonalMadre;
    //------PERSONA ENCARGADA---------------
    String nombreEncargado;
    String telefonoEncargado;
    String cedulaEncargado;
    //-----------INFORMACION MATRICULA----------------------------------
    String nivel;
    String infoCompleta;
    String consNacimiento;
    String vacunas;
    String tieneFotos;
    String monto;
    String curso;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    

    public String getCedulaEncargado() {
        return cedulaEncargado;
    }

    public void setCedulaEncargado(String cedulaEncargado) {
        this.cedulaEncargado = cedulaEncargado;
    }
    

    public String getInfoCompleta() {
        return infoCompleta;
    }

    public void setInfoCompleta(String infoCompleta) {
        this.infoCompleta = infoCompleta;
    }

    public String getConsNacimiento() {
        return consNacimiento;
    }

    public void setConsNacimiento(String consNacimiento) {
        this.consNacimiento = consNacimiento;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public String getTieneFotos() {
        return tieneFotos;
    }

    public void setTieneFotos(String tieneFotos) {
        this.tieneFotos = tieneFotos;
    }
    String persona;

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getEdadPadre() {
        return edadPadre;
    }

    public void setEdadPadre(String edadPadre) {
        this.edadPadre = edadPadre;
    }

    public String getCedulaPadre() {
        return cedulaPadre;
    }

    public void setCedulaPadre(String cedulaPadre) {
        this.cedulaPadre = cedulaPadre;
    }

    public String getOcupacionPadre() {
        return ocupacionPadre;
    }

    public void setOcupacionPadre(String ocupacionPadre) {
        this.ocupacionPadre = ocupacionPadre;
    }

    public String getLugarTrabajoPadre() {
        return lugarTrabajoPadre;
    }

    public void setLugarTrabajoPadre(String lugarTrabajoPadre) {
        this.lugarTrabajoPadre = lugarTrabajoPadre;
    }

    public String getTelefonoTrabajoPadre() {
        return telefonoTrabajoPadre;
    }

    public void setTelefonoTrabajoPadre(String telefonoTrabajoPadre) {
        this.telefonoTrabajoPadre = telefonoTrabajoPadre;
    }

    public String getTelefonoPersonalPadre() {
        return telefonoPersonalPadre;
    }

    public void setTelefonoPersonalPadre(String telefonoPersonalPadre) {
        this.telefonoPersonalPadre = telefonoPersonalPadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getEdadMadre() {
        return edadMadre;
    }

    public void setEdadMadre(String edadMadre) {
        this.edadMadre = edadMadre;
    }

    public String getCedulaMadre() {
        return cedulaMadre;
    }

    public void setCedulaMadre(String cedulaMadre) {
        this.cedulaMadre = cedulaMadre;
    }

    public String getOcupacionMadre() {
        return ocupacionMadre;
    }

    public void setOcupacionMadre(String ocupacionMadre) {
        this.ocupacionMadre = ocupacionMadre;
    }

    public String getLugarTrabajoMadre() {
        return lugarTrabajoMadre;
    }

    public void setLugarTrabajoMadre(String lugarTrabajoMadre) {
        this.lugarTrabajoMadre = lugarTrabajoMadre;
    }

    public String getTelefonoTrabajoMadre() {
        return telefonoTrabajoMadre;
    }

    public void setTelefonoTrabajoMadre(String telefonoTrabajoMadre) {
        this.telefonoTrabajoMadre = telefonoTrabajoMadre;
    }

    public String getTelefonoPersonalMadre() {
        return telefonoPersonalMadre;
    }

    public void setTelefonoPersonalMadre(String telefonoPersonalMadre) {
        this.telefonoPersonalMadre = telefonoPersonalMadre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    String direccion;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean EstaCompleta() {
        return this.infoCompleta.equals("Si");
    }

    public boolean EstaConstancia() {
        return this.consNacimiento.equals("Si");
    }

    public boolean EstaVacunas() {
        return this.vacunas.equals("Si");
    }

    public boolean EstaFotos() {
        return this.tieneFotos.equals("Si");
    }

}
