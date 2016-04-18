/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Especialidad;

/**
 *
 * @author Isa
 */
public interface EspecialidadDao {

    Especialidad findbyId(Long id);

    void save(Especialidad clase);

    void DeletebyId(Long id);

    List< Especialidad> findAll();
}
