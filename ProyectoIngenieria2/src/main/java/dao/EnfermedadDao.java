/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Enfermedad;
import modelo.Matricula;

/**
 *
 * @author Isa
 */
public interface EnfermedadDao {

    Enfermedad findbyCodigo(Long codigo);

    void save(Enfermedad matricula);

    void DeletebyCodigo(Long codigo);

    List<Enfermedad> findAll();
}
