/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Clase;

/**
 *
 * @author Isa
 */
public interface ClaseDao {

    Clase findbyId(Long id);

    void save(Clase clase);

    void DeletebyId(Long id);

    List< Clase> findAll();
}
