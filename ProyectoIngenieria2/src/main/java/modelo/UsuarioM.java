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
public class UsuarioM {

    private String id;
    private String email;
    private String contrasena;
    private String roleSeccion;
    public String contrasenaA;
    public String passAnt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRoleSeccion() {
        return roleSeccion;
    }

    public void setRoleSeccion(String roleSeccion) {
        this.roleSeccion = roleSeccion;
    }

    public String getContrasenaA() {
        return contrasenaA;
    }

    public void setContrasenaA(String contrasenaA) {
        this.contrasenaA = contrasenaA;
    }

    public String getPassAnt() {
        return passAnt;
    }

    public void setPassAnt(String passAnt) {
        this.passAnt = passAnt;
    }

    public void actualizar() {
        this.passAnt = this.contrasena;
        this.contrasena = null;
        this.contrasenaA = null;
    }

}
