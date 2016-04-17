/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Especialidad;

/**
 *
 * @author Isa
 */
public interface EspecialidadService {

    Especialidad findbyId(Long id);

    void save(Especialidad clase);

    void DeletebyId(Long id);

    List<Especialidad> findAll();

    void UpdateEspecialidad(Especialidad clase);
}
