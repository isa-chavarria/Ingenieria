/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Profesor;

/**
 *
 * @author Isa
 */
public interface ProfesorService {
    Profesor findbyId(String id);
    void save(Profesor profesor);
    void DeletebyId(String id);
    List<Profesor> findAll();
    void UpdateProfesor(Profesor profesor);
}
