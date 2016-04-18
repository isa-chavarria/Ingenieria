/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Enfermedad;

/**
 *
 * @author david
 */
public interface EnfermedadService {

    Enfermedad findbyCodigo(Long codigo);

    void save(Enfermedad matricula);

    void DeletebyCodigo(Long codigo);

    List<Enfermedad> findAll();

    void UpdateEnfermedad(Enfermedad matricula);
}
