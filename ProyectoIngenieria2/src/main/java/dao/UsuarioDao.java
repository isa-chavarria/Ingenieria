/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Kinder;
import modelo.Usuario;

/**
 *
 * @author Isa
 */
public interface UsuarioDao {

    Usuario findbyId(String id);

    void save(Usuario nino);

    void DeletebyId(String id);

    List< Usuario> findAll();

    Usuario findbyLogin(String email, String password);

    boolean isIdUnique(String id);

    boolean isEmailUnique(String email);

}
