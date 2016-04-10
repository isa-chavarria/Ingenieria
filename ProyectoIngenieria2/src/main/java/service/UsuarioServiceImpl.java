/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDao;
import java.util.List;
import javax.transaction.Transactional;
import modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Isa
 */
@Service("UsuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao Usuario;

    @Override
    public Usuario findbyId(String id) {
        return Usuario.findbyId(id);
    }

    @Override
    public void save(Usuario usuario) {
        this.Usuario.save(usuario);
    }

    @Override
    public void DeletebyId(String id) {
        this.Usuario.DeletebyId(id);
    }

    @Override
    public List<Usuario> findAll() {
        return Usuario.findAll();
    }

    @Override
    public void UpdateUsuario(Usuario usuario) {
        Usuario usua = this.Usuario.findbyId(usuario.getId());
        if (usua != null) {
            usua.setContrasena(usuario.getContrasena());
            usua.setId(usuario.getId());
            usua.setRoleSeccion(usuario.getRoleSeccion());
            usua.setEmail(usuario.getEmail());
            usua.setEncargado(usuario.getEncargado());
        }
    }

    @Override
    public Usuario findByLogin(String email, String password) {
        return Usuario.findbyLogin(email, password);
    }
    
    @Override
    public boolean isIdUnique(String id) {
        return Usuario.isIdUnique(id);
    }
}
