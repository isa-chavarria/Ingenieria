/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Encargado;

/**
 *
 * @author Isa
 */
public interface EncargadoDao {

    Encargado findbyId(String id);

    void save(Encargado encargado);

    void DeletebyId(String id);

    List< Encargado> findAll();
}
