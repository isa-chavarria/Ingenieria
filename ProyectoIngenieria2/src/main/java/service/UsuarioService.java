/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Isa
 */
public interface UsuarioService {
    Usuario findbyId(String id);

    void save(Usuario usuario);

    void DeletebyId(String id);

    List<Usuario> findAll();

    void UpdateUsuario(Usuario usuario);
}
